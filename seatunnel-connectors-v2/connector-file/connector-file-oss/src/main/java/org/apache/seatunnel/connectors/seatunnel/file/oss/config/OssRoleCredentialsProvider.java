/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.file.oss.config;

import org.apache.hadoop.conf.Configuration;

import com.aliyun.oss.common.auth.Credentials;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.InstanceProfileCredentialsProvider;
import com.aliyun.oss.common.auth.InvalidCredentialsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/** Loads OSS credentials from the ECS RAM role configured by {@code role_name} or ECS metadata. */
public class OssRoleCredentialsProvider implements CredentialsProvider {

    private static final String ECS_RAM_ROLE_METADATA_URL =
            "http://100.100.100.200/latest/meta-data/ram/security-credentials/";
    private static final int METADATA_CONNECTION_TIMEOUT_MILLIS = 3000;
    private static final int METADATA_READ_TIMEOUT_MILLIS = 3000;

    private final String configuredRoleName;
    private volatile InstanceProfileCredentialsProvider delegate;

    public OssRoleCredentialsProvider(URI uri, Configuration configuration) {
        this.configuredRoleName = configuration.getTrimmed(OssHadoopConf.ROLE_NAME_KEY);
    }

    @Override
    public void setCredentials(Credentials creds) {
        InstanceProfileCredentialsProvider currentDelegate = delegate;
        if (currentDelegate != null) {
            currentDelegate.setCredentials(creds);
        }
    }

    @Override
    public Credentials getCredentials() {
        return getDelegate().getCredentials();
    }

    private InstanceProfileCredentialsProvider getDelegate() {
        InstanceProfileCredentialsProvider currentDelegate = delegate;
        if (currentDelegate == null) {
            synchronized (this) {
                currentDelegate = delegate;
                if (currentDelegate == null) {
                    currentDelegate = new InstanceProfileCredentialsProvider(getRoleName());
                    delegate = currentDelegate;
                }
            }
        }
        return currentDelegate;
    }

    private String getRoleName() {
        if (configuredRoleName != null && !configuredRoleName.isEmpty()) {
            return configuredRoleName;
        }
        try {
            return discoverRoleNameFromEcsMetadata();
        } catch (IOException e) {
            throw new InvalidCredentialsException(
                    "Failed to discover OSS RAM role name from ECS metadata service. "
                            + "Configure role_name explicitly or run on an ECS instance with a bound RAM role.",
                    e);
        }
    }

    private String discoverRoleNameFromEcsMetadata() throws IOException {
        HttpURLConnection connection =
                (HttpURLConnection) new URL(ECS_RAM_ROLE_METADATA_URL).openConnection();
        connection.setConnectTimeout(METADATA_CONNECTION_TIMEOUT_MILLIS);
        connection.setReadTimeout(METADATA_READ_TIMEOUT_MILLIS);
        connection.setRequestMethod("GET");

        try (BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String roleName = line.trim();
                if (!roleName.isEmpty()) {
                    return roleName;
                }
            }
        } finally {
            connection.disconnect();
        }

        throw new IOException("ECS metadata service returned an empty RAM role name.");
    }
}
