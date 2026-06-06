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

import org.apache.seatunnel.api.configuration.Option;
import org.apache.seatunnel.api.configuration.ReadonlyConfig;
import org.apache.seatunnel.connectors.seatunnel.file.config.HadoopConf;

import org.apache.hadoop.fs.aliyun.oss.Constants;

import java.util.HashMap;

public class OssHadoopConf extends HadoopConf {
    private static final String HDFS_IMPL = "org.apache.hadoop.fs.aliyun.oss.AliyunOSSFileSystem";
    private static final String SCHEMA = "oss";
    public static final String ROLE_NAME_KEY = "fs.oss.roleName";
    private static final String ENV_CREDENTIALS_PROVIDER =
            "com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider";
    private static final String ROLE_CREDENTIALS_PROVIDER =
            "org.apache.seatunnel.connectors.seatunnel.file.oss.config.OssRoleCredentialsProvider";

    @Override
    public String getFsHdfsImpl() {
        return HDFS_IMPL;
    }

    @Override
    public String getSchema() {
        return SCHEMA;
    }

    public OssHadoopConf(String hdfsNameKey) {
        super(hdfsNameKey);
    }

    public static HadoopConf buildWithConfig(ReadonlyConfig config) {
        HadoopConf hadoopConf = new OssHadoopConf(config.get(OssFileBaseOptions.BUCKET));
        HashMap<String, String> ossOptions = new HashMap<>();
        switch (config.get(OssFileBaseOptions.AUTH_MODE)) {
            case ENV:
                ossOptions.put(Constants.CREDENTIALS_PROVIDER_KEY, ENV_CREDENTIALS_PROVIDER);
                break;
            case ROLE:
                ossOptions.put(Constants.CREDENTIALS_PROVIDER_KEY, ROLE_CREDENTIALS_PROVIDER);
                config.getOptional(OssFileBaseOptions.ROLE_NAME)
                        .map(String::trim)
                        .filter(roleName -> !roleName.isEmpty())
                        .ifPresent(roleName -> ossOptions.put(ROLE_NAME_KEY, roleName));
                break;
            case STS_TOKEN:
                putAccessKeyAndSecret(config, ossOptions);
                ossOptions.put(Constants.SECURITY_TOKEN, getSecurityToken(config));
                break;
            case SIMPLE:
            default:
                putAccessKeyAndSecret(config, ossOptions);
                break;
        }
        ossOptions.put(Constants.ENDPOINT_KEY, config.get(OssFileBaseOptions.ENDPOINT));
        hadoopConf.setExtraOptions(ossOptions);
        return hadoopConf;
    }

    private static void putAccessKeyAndSecret(
            ReadonlyConfig config, HashMap<String, String> ossOptions) {
        ossOptions.put(
                Constants.ACCESS_KEY_ID, getRequiredOption(config, OssFileBaseOptions.ACCESS_KEY));
        ossOptions.put(
                Constants.ACCESS_KEY_SECRET,
                getRequiredOption(config, OssFileBaseOptions.ACCESS_SECRET));
    }

    private static String getRequiredOption(ReadonlyConfig config, Option<String> option) {
        return config.getOptional(option)
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        String.format(
                                                "OSS auth_mode %s requires %s to be configured.",
                                                config.get(OssFileBaseOptions.AUTH_MODE),
                                                option.key())));
    }

    private static String getSecurityToken(ReadonlyConfig config) {
        return getRequiredOption(config, OssFileBaseOptions.STS_TOKEN);
    }
}
