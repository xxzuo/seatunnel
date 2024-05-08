# SeaTunnel 错误快速参考手册

本文档记录了 SeaTunnel 的一些常见错误代码及其相应的解决方案，旨在帮助用户快速解决遇到的问题。

## SeaTunnel API 错误代码

|  错误代码  |   描述    |                          解决方案                           |
|--------|---------|---------------------------------------------------------|
| API-01 | 配置项验证失败 | 当用户遇到此错误代码时，通常是由于用户配置的连接器参数存在问题，请检查连接器文档并修改参数。          |
| API-02 | 选项验证失败  | -                                                       |
| API-03 | 目录初始化失败 | 当用户遇到此错误代码时，通常是因为连接器初始化目录失败，请检查连接器选项是否正确                |
| API-04 | 数据库不存在  | 当用户遇到此错误代码时，通常是因为您想要访问的数据库不存在，请再次确认数据库是否存在              |
| API-05 | 表不存在    | 当用户遇到此错误代码时，通常是因为您想要访问的表不存在，请再次确认表是否存在                  |
| API-06 | 工厂初始化失败 | 当用户遇到此错误代码时，通常是因为 jar 包依赖存在问题，请检查您的本地 SeaTunnel 安装包是否完整 |
| API-07 | 数据库已存在  | 当用户遇到此错误代码时，意味着您想要创建的数据库已经存在，请删除数据库后重试                  |
| API-08 | 表已存在    | 当用户遇到此错误代码时，意味着您想要创建的表已经存在，请删除表后重试                      |

## SeaTunnel 常见错误代码

|   错误代码    |                描述                |                                  解决方案                                   |
|-----------|----------------------------------|-------------------------------------------------------------------------|
| COMMON-01 | 文件操作失败，例如（读取、列出、写入、移动、复制、同步）等... | 当用户遇到此错误代码时，通常是文件操作存在问题，请检查文件是否正常                                       |
| COMMON-02 | JSON 转换/解析 失败                    | 当用户遇到此错误代码时，通常是 JSON 格式转换或解析存在问题，请检查 JSON 格式是否正确                        |
| COMMON-03 | 反射类操作失败                          | 当用户遇到此错误代码时，通常是类反射操作存在问题，请检查 classpath 中是否存在依赖的 jar                     |
| COMMON-04 | 序列化类操作失败                         | 当用户遇到此错误代码时，通常是类序列化操作存在问题，请检查 Java 环境                                   |
| COMMON-05 | 不支持的操作                           | 当用户遇到此错误代码时，可能是触发了不支持的操作，例如启用了一些不支持的功能                                  |
| COMMON-06 | 非法参数                             | 当用户遇到此错误代码时，可能是用户配置的参数不合法，请根据提示进行修改                                     |
| COMMON-07 | 不支持的数据类型                         | 当用户遇到此错误代码时，可能是连接器不支持这个数据类型                                             |
| COMMON-08 | SQL 操作失败，例如（执行、添加批处理、关闭）等...     | 用户遇到此错误代码时，通常是 SQL 执行过程中存在问题，请检查 SQL 是否正确                               |
| COMMON-09 | 从上游数据获取表结构失败                     | 当用户遇到此错误代码时，可能是 SeaTunnel 尝试从连接器源数据获取 表结构时失败，请检查您的配置是否正确，连接器是否正常工作      |
| COMMON-10 | 在 Sink 连接器中刷新数据操作失败              | 当用户遇到此错误代码时，可能是 SeaTunnel 尝试批量刷新数据到 Sink 连接器字段时失败，请检查您的配置是否正确，连接器是否正常工作 |
| COMMON-11 | Sink 写入失败, 例如（打开、关闭）等...         | 当用户遇到此错误代码时，可能是某些文件（如 Parquet、Orc、IceBerg）无法写入，您需要检查相应的文件或资源是否具有读写权限    |
| COMMON-12 | Source 读取失败， 例如（打开、关闭）等...       | 当用户遇到此错误代码时，可能是某些文件（如 Parquet、Orc、IceBerg）无法读取，您需要检查相应的文件或资源是否具有读写权限    |
| COMMON-13 | HTTP 操作失败，例如（打开、关闭、响应）等...       | 当用户遇到此错误代码时，可能是某些 HTTP 请求失败，请检查您的网络环境                                   |
| COMMON-14 | Kerberos 授权失败                    | 当用户遇到此错误代码时，可能是 Kerberos 授权配置错误                                         |
| COMMON-15 | 类加载失败                            | 当用户遇到此错误代码时，可能是相应的 jar 不存在，或者类型不受支持                                     |

## ASSERT 连接器错误代码

|   错误代码    |   描述   |          解决方案           |
|-----------|--------|-------------------------|
| ASSERT-01 | 规则验证失败 | 当用户遇到此错误代码时，表示上游数据不符合规则 |

## Cassandra 连接器错误代码

|     错误代码     |           描述           |                             解决方案                             |
|--------------|------------------------|--------------------------------------------------------------|
| CASSANDRA-01 | 目标表中不存在该字段             | 当用户遇到此错误代码时，意味着上游数据的字段与目标 Cassandra 表不匹配，请检查目标 Cassandra 表结构 |
| CASSANDRA-02 | 批量插入 SeaTunnelRow 数据失败 | 当用户遇到此错误代码时，意味着 Cassandra 存在一些问题，请检查它是否正常工作                  |
| CASSANDRA-03 | 关闭 Cassandra 的CQL会话失败  | 当用户遇到此错误代码时，意味着 Cassandra 存在一些问题，请检查它是否正常工作                  |
| CASSANDRA-04 | 源表中没有数据                | 当用户遇到此错误代码时，意味着源 Cassandra 表中没有数据，请检查它                       |
| CASSANDRA-05 | 从字符串解析 IP 地址失败         | 当用户遇到此错误代码时，意味着上游数据不符合 IP 地址格式，请检查它                          |

## Slack 连接器错误代码

|   错误代码   |       描述       |                   解决方案                   |
|----------|----------------|------------------------------------------|
| SLACK-01 | 无法在频道中找到对话     | 当用户遇到此错误代码时，意味着在 Slack 工作区中不存在该频道，请检查确认。 |
| SLACK-02 | 向 Slack 频道写入失败 | 当用户遇到此错误代码时，意味着 Slack 存在一些问题，请检查它是否正常工作。 |

## MyHours 连接器错误代码

|    错误代码    |         描述          |                   解决方案                   |
|------------|---------------------|------------------------------------------|
| MYHOURS-01 | 获取 MyHours token 失败 | 当用户遇到此错误代码时，意味着登录 MyHours 失败，请检查您的网络并重试。 |

## Rabbitmq 连接器错误代码

|     错误代码      |         描述          |                    解决方案                     |
|-------------|---------------------|---------------------------------------------|
| RABBITMQ-01 | 处理队列消费者关闭信号失败       | 当用户遇到此错误代码时，意味着作业存在一些问题，请检查作业是否正常工作。        |
| RABBITMQ-02 | 创建 RabbitMQ 客户端失败   | 当用户遇到此错误代码时，意味着 RabbitMQ 存在一些问题，请检查它是否正常工作。 |
| RABBITMQ-03 | 关闭连接失败              | 当用户遇到此错误代码时，意味着 RabbitMQ 存在一些问题，请检查它是否正常工作。 |
| RABBITMQ-04 | 发送消息失败              | 当用户遇到此错误代码时，意味着 RabbitMQ 存在一些问题，请检查它是否正常工作。 |
| RABBITMQ-05 | 在检查点创建期间无法确认消息      | 当用户遇到此错误代码时，意味着作业存在一些问题，请检查作业是否运行良好。        |
| RABBITMQ-06 | 使用basicReject无法确认消息 | 当用户遇到此错误代码时，意味着作业存在一些问题，请检查作业是否运行良好。        |
| RABBITMQ-07 | 解析URI失败             | 当用户遇到此错误代码时，意味着RabbitMQ连接URI不正确，请检查它。       |
| RABBITMQ-08 | 初始化SSL上下文失败         | 当用户遇到此错误代码时，意味着RabbitMQ存在一些问题，请检查它是否正常工作。   |
| RABBITMQ-09 | 设置SSL工厂失败           | 当用户遇到此错误代码时，意味着RabbitMQ存在一些问题，请检查它是否正常工作。   |

## Socket 连接器错误代码

|    错误代码    | 描述                 |                                                           解决方案                                                            |
|------------|--------------------|--------------------------------------------------------------------------------------------------------------------------------|
| SOCKET-01 | 不能连接到 socket 服务器   | 当用户遇到此错误代码时，意味着连接地址可能不匹配，请检查                                                                 |
| SOCKET-02 | 向 socket 服务器发送消息失败 | 当用户遇到此错误代码时，意味着在发送数据时存在问题且未启用重试，请检查                                                   |
| SOCKET-03 | 无法写入；在尝试其他操作时被中断   | 当用户遇到此错误代码时，意味着数据写入异常中断，请检查                                                                   |

## TableStore 连接器错误代码

|     错误代码      |           描述           |                                                             解决方案                                                             |
|---------------|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| TABLESTORE-01 | 发送这些行数据失败       | 当用户遇到此错误代码时，意味着未能写入这些行数据，请检查未能导入的行                                                   |

## Hive 连接器错误代码

|  错误代码  | 描述                               | 解决方案                                              |
|--------|----------------------------------|---------------------------------------------------|
| HIVE-01 | 从表位置获取 namenode host 失败          | 当用户遇到此错误代码时，意味着 metastore 信息存在一些问题，请检查            |
| HIVE-02 | 初始化 Hive metastore 客户端失败         | 当用户遇到此错误代码时，意味着连接到 Hive metastore 服务失败，请检查服务是否工作  |
| HIVE-03 | 从 Hive metastore 服务获取 Hive 表信息失败 | 当用户遇到此错误代码时，意味着 Hive metastore 服务存在一些问题，请检查服务是否工作 |

## Elasticsearch 连接器错误代码

|        错误代码         | 描述                        | 解决方案                                           |
|-------------------|---------------------------|------------------------------------------------|
| ELASTICSEARCH-01 | 批量 Elasticsearch 响应错误     | 当用户遇到此错误代码时，意味着连接被中止，请检查 Elasticsearch 是否工作正常  |
| ELASTICSEARCH-02 | 获取 Elasticsearch 版本失败     | 当用户遇到此错误代码时，意味着连接被中止，请检查 Elasticsearch 是否工作正常  |
| ELASTICSEARCH-03 | 滚动请求失败                    | 当用户遇到此错误代码时，意味着连接被中止，请检查 Elasticsearch 是否工作正常  |
| ELASTICSEARCH-04 | 获取 Elasticsearch 文档索引计数失败 | 当用户遇到此错误代码时，意味着 Elasticsearch 索引可能错误或连接被中止，请检查 Elasticsearch 是否工作正常 |

## Kafka Connector 连接器错误代码

|   code   |                                       description                                       |                                                             solution                                                              |
|----------|-----------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| KAFKA-01 | Incompatible KafkaProducer version                                                      | When users encounter this error code, it means that KafkaProducer version is incompatible, please check it                        |
| KAFKA-02 | Get transactionManager in KafkaProducer exception                                       | When users encounter this error code, it means that can not get transactionManager in KafkaProducer, please check it              |
| KAFKA-03 | Add the split checkpoint state to reader failed                                         | When users encounter this error code, it means that add the split checkpoint state to reader failed, please retry it              |
| KAFKA-04 | Add a split back to the split enumerator,it will only happen when a SourceReader failed | When users encounter this error code, it means that add a split back to the split enumerator failed, please check it              |
| KAFKA-05 | Error occurred when the kafka consumer thread was running                               | When users encounter this error code, it means that an error occurred when the kafka consumer thread was running, please check it |
| KAFKA-06 | Kafka failed to consume data                                                            | When users encounter this error code, it means that Kafka failed to consume data, please check config and retry it                |
| KAFKA-07 | Kafka failed to close consumer                                                          | When users encounter this error code, it means that Kafka failed to close consumer                                                |


|   错误代码   | 描述                                      | 解决方案                                                         |
|----------|-----------------------------------------|--------------------------------------------------------------|
| KAFKA-01 | KafkaProducer 版本不兼容                     | 当用户遇到此错误代码时，意味着 KafkaProducer 版本不兼容，请检查                      |
| KAFKA-02 | KafkaProducer 中获取 transactionManager 异常 | 当用户遇到此错误代码时，意味着在 KafkaProducer 中无法获取 transactionManager ，请检查 |
| KAFKA-03 | 向读取器添加分割检查点状态失败                         | 当用户遇到此错误代码时，意味着向读取器添加分割检查点状态失败，请重试                           |
| KAFKA-04 | 将分割添加回分割枚举器，这只会在使用SourceReader失败时发生     | 当用户遇到此错误代码时，意味着将分割添加回分割枚举器失败，请检查                             |
| KAFKA-05 | Kafka消费者线程运行时发生错误                       | 当用户遇到此错误代码时，意味着Kafka消费者线程运行时发生错误，请检查                         |
| KAFKA-06 | Kafka消费数据失败                             | 当用户遇到此错误代码时，意味着Kafka消费数据失败，请检查配置并重试                          |
| KAFKA-07 | Kafka关闭消费者失败                            | 当用户遇到此错误代码时，意味着Kafka关闭消费者失败                                  |


## InfluxDB 连接器错误代码

|    code     |                           description                            |                                                  solution                                                   |
|-------------|------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| INFLUXDB-01 | Connect influxdb failed, due to influxdb version info is unknown | When the user encounters this error code, it indicates that the connection to influxdb failed. Please check |
| INFLUXDB-02 | Get column index of query result exception                       | When the user encounters this error code, it indicates that obtaining the column index failed. Please check |

## Kudu 连接器错误代码

|  code   |                       description                        |                                                                                            solution                                                                                            |
|---------|----------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---|
| KUDU-01 | Get the Kuduscan object for each splice failed           | When users encounter this error code, it is usually there are some problems with getting the KuduScan Object for each splice, please check your configuration whether correct and Kudu is work |
| KUDU-02 | Close Kudu client failed                                 | When users encounter this error code, it is usually there are some problems with closing the Kudu client, please check the Kudu is work                                                        |   |
| KUDU-03 | Value type does not match column type                    | When users encounter this error code, it is usually there are some problems on matching the Type between value type and colum type, please check if the data type is supported                 |
| KUDU-04 | Upsert data to Kudu failed                               | When users encounter this error code, it means that Kudu has some problems, please check it whether is work                                                                                    |
| KUDU-05 | Insert data to Kudu failed                               | When users encounter this error code, it means that Kudu has some problems, please check it whether is work                                                                                    |
| KUDU-06 | Initialize the Kudu client failed                        | When users encounter this error code, it is usually there are some problems with initializing the Kudu client, please check your configuration whether correct and connector is work           |
| KUDU-07 | Generate Kudu Parameters in the preparation phase failed | When users encounter this error code, it means that there are some problems on Kudu parameters generation, please check your configuration                                                     |

## IotDB 连接器错误代码

|   code   |          description           |                                                  solution                                                  |
|----------|--------------------------------|------------------------------------------------------------------------------------------------------------|
| IOTDB-01 | Close IoTDB session failed     | When the user encounters this error code, it indicates that closing the session failed. Please check       |
| IOTDB-02 | Initialize IoTDB client failed | When the user encounters this error code, it indicates that the client initialization failed. Please check |
| IOTDB-03 | Close IoTDB client failed      | When the user encounters this error code, it indicates that closing the client failed. Please check        |

## File 连接器错误代码

|  code   |         description         |                                                                             solution                                                                             |
|---------|-----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| FILE-01 | File type is invalid        | When users encounter this error code, it means that the this file is not the format that user assigned, please check it                                          |
| FILE-02 | Data deserialization failed | When users encounter this error code, it means that data from files not satisfied the schema that user assigned, please check data from files whether is correct |
| FILE-03 | Get file list failed        | When users encounter this error code, it means that connector try to traverse the path and get file list failed, please check file system whether is work        |
| FILE-04 | File list is empty          | When users encounter this error code, it means that the path user want to sync is empty, please check file path                                                  |

## Doris 连接器错误代码

|   code   |     description     |                                                             solution                                                              |
|----------|---------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Doris-01 | stream load error.  | When users encounter this error code, it means that stream load to Doris failed, please check data from files whether is correct. |
| Doris-02 | commit error.       | When users encounter this error code, it means that commit to Doris failed, please check network.                                 |
| Doris-03 | rest service error. | When users encounter this error code, it means that rest service failed, please check network and config.                         |

## SelectDB 连接器错误代码

|    code     |         description         |                                                                 solution                                                                  |
|-------------|-----------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| SelectDB-01 | stage load file error       | When users encounter this error code, it means that stage load file to SelectDB Cloud failed, please check the configuration and network. |
| SelectDB-02 | commit copy into sql failed | When users encounter this error code, it means that commit copy into sql to SelectDB Cloud failed, please check the configuration.        |

## Clickhouse 连接器错误代码

|     code      |                                description                                |                                                                                solution                                                                                 |
|---------------|---------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| CLICKHOUSE-01 | Field is not existed in target table                                      | When users encounter this error code, it means that the fields of upstream data don't meet with target clickhouse table, please check target clickhouse table structure |
| CLICKHOUSE-02 | Can’t find password of shard node                                         | When users encounter this error code, it means that no password is configured for each node, please check                                                               |
| CLICKHOUSE-03 | Can’t delete directory                                                    | When users encounter this error code, it means that the directory does not exist or does not have permission, please check                                              |
| CLICKHOUSE-04 | Ssh operation failed, such as (login,connect,authentication,close) etc... | When users encounter this error code, it means that the ssh request failed, please check your network environment                                                       |
| CLICKHOUSE-05 | Get cluster list from clickhouse failed                                   | When users encounter this error code, it means that the clickhouse cluster is not configured correctly, please check                                                    |
| CLICKHOUSE-06 | Shard key not found in table                                              | When users encounter this error code, it means that the shard key of the distributed table is not configured, please check                                              |

## Jdbc 连接器错误代码

|  code   |                          description                           |                                                                                                  solution                                                                                                   |
|---------|----------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| JDBC-01 | Fail to create driver of class                                 | When users encounter this error code, it means that driver package may not be added. Check whether the driver exists                                                                                        |
| JDBC-02 | No suitable driver found                                       | When users encounter this error code, it means that no password is configured for each node, please check                                                                                                   |
| JDBC-03 | Xa operation failed, such as (commit, rollback) etc..          | When users encounter this error code, it means that if a distributed sql transaction fails, check the transaction execution of the corresponding database to determine the cause of the transaction failure |
| JDBC-04 | Connector database failed                                      | When users encounter this error code, it means that database connection failure, check whether the url is correct or whether the corresponding service is normal                                            |
| JDBC-05 | transaction operation failed, such as (commit, rollback) etc.. | When users encounter this error code, it means that if a sql transaction fails, check the transaction execution of the corresponding database to determine the cause of the transaction failure             |
| JDBC-06 | No suitable dialect factory found                              | When users encounter this error code, it means that may be an unsupported dialect type                                                                                                                      |
| JDBC-07 | The jdbc type don't support sink                               | When users encounter this error code, it means that jdbc type don't support sink                                                                                                                            |
| JDBC-08 | Kerberos authentication failed                                 | When users encounter this error code, it means that database connection Kerberos authentication failed                                                                                                      |

## Pulsar 连接器错误代码

|   code    |                   description                    |                                                       solution                                                        |
|-----------|--------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| PULSAR-01 | Open pulsar admin failed                         | When users encounter this error code, it means that open pulsar admin failed, please check it                         |
| PULSAR-02 | Open pulsar client failed                        | When users encounter this error code, it means that open pulsar client failed, please check it                        |
| PULSAR-03 | Pulsar authentication failed                     | When users encounter this error code, it means that Pulsar Authentication failed, please check it                     |
| PULSAR-04 | Subscribe topic from pulsar failed               | When users encounter this error code, it means that Subscribe topic from pulsar failed, please check it               |
| PULSAR-05 | Get last cursor of pulsar topic failed           | When users encounter this error code, it means that get last cursor of pulsar topic failed, please check it           |
| PULSAR-06 | Get partition information of pulsar topic failed | When users encounter this error code, it means that Get partition information of pulsar topic failed, please check it |
| PULSAR-07 | Pulsar consumer acknowledgeCumulative failed     | When users encounter this error code, it means that Pulsar consumer acknowledgeCumulative failed                      |
| PULSAR-08 | Pulsar create producer failed                    | When users encounter this error code, it means that create producer failed, please check it                           |
| PULSAR-09 | Pulsar create transaction failed                 | When users encounter this error code, it means that Pulsar create transaction failed, please check it                 |
| PULSAR-10 | Pulsar send message failed                       | When users encounter this error code, it means that Pulsar sned message failed, please check it                       |

## StarRocks 连接器错误代码

|     code     |                description                |                                                                 solution                                                                 |
|--------------|-------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| STARROCKS-01 | Flush batch data to sink connector failed | When users encounter this error code, it means that flush batch data to sink connector failed, please check it                           |
| STARROCKS-02 | Writing records to StarRocks failed       | When users encounter this error code, it means that writing records to StarRocks failed, please check data from files whether is correct |
| STARROCKS-03 | Close StarRocks BE reader failed.         | it means that StarRocks has some problems, please check it whether is work                                                               |
| STARROCKS-04 | Create StarRocks BE reader failed.        | it means that StarRocks has some problems, please check it whether is work                                                               |
| STARROCKS-05 | Scan data from StarRocks BE failed.       | When users encounter this error code, it means that scan data from StarRocks failed, please check it                                     |
| STARROCKS-06 | Request query Plan failed.                | When users encounter this error code, it means that scan data from StarRocks failed, please check it                                     |
| STARROCKS-07 | Read Arrow data failed.                   | When users encounter this error code, it means that that job has some problems, please check it whether is work well                     |

## DingTalk 连接器错误代码

|    code     |               description               |                                                       solution                                                       |
|-------------|-----------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| DINGTALK-01 | Send response to DinkTalk server failed | When users encounter this error code, it means that send response message to DinkTalk server failed, please check it |
| DINGTALK-02 | Get sign from DinkTalk server failed    | When users encounter this error code, it means that get signature from DinkTalk server failed , please check it      |

## Iceberg 连接器错误代码

|    code    |          description           |                                                 solution                                                 |
|------------|--------------------------------|----------------------------------------------------------------------------------------------------------|
| ICEBERG-01 | File Scan Split failed         | When users encounter this error code, it means that the file scanning and splitting failed. Please check |
| ICEBERG-02 | Invalid starting record offset | When users encounter this error code, it means that the starting record offset is invalid. Please check  |

## Email 连接器错误代码

|   code   |    description    |                                                                              solution                                                                               |
|----------|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EMAIL-01 | Send email failed | When users encounter this error code, it means that send email to target server failed, please adjust the network environment according to the abnormal information |

## S3Redshift 连接器错误代码

|     code      |        description        |                                                                                                   solution                                                                                                   |
|---------------|---------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| S3RedShift-01 | Aggregate committer error | S3Redshift Sink Connector will write data to s3 and then move file to the target s3 path. And then use `Copy` action copy the data to Redshift. Please check the error log and find out the specific reason. |

## Google Firestore 连接器错误代码

|     code     |          description          |                                                                     solution                                                                      |
|--------------|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| FIRESTORE-01 | Close Firestore client failed | When users encounter this error code, it is usually there are some problems with closing the Firestore client, please check the Firestore is work |

## FilterFieldTransform 连接器错误代码

|           code            |      description       |        solution         |
|---------------------------|------------------------|-------------------------|
| FILTER_FIELD_TRANSFORM-01 | filter field not found | filter field not found. |

## RocketMq 连接器错误代码

|    code     |                                           description                                           |                                                           solution                                                            |
|-------------|-------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| ROCKETMQ-01 | Add a split back to the split enumerator failed, it will only happen when a SourceReader failed | When users encounter this error code, it means that add a split back to the split enumerator failed, please check it.         |
| ROCKETMQ-02 | Add the split checkpoint state to reader failed                                                 | When users encounter this error code, it means that add the split checkpoint state to reader failed, please check it.         |
| ROCKETMQ-03 | Rocketmq failed to consume data                                                                 | When users encounter this error code, it means that rocketmq failed to consume data, please check it., please check it.       |
| ROCKETMQ-04 | Error occurred when the rocketmq consumer thread was running                                    | When the user encounters this error code, it means that an error occurred while running the Rocketmq consumer thread          |
| ROCKETMQ-05 | Rocketmq producer failed to send message                                                        | When users encounter this error code, it means that Rocketmq producer failed to send message, please check it.                |
| ROCKETMQ-06 | Rocketmq producer failed to start                                                               | When users encounter this error code, it means that Rocketmq producer failed to start, please check it.                       |
| ROCKETMQ-07 | Rocketmq consumer failed to start                                                               | When users encounter this error code, it means that Rocketmq consumer failed to start, please check it.                       |
| ROCKETMQ-08 | Unsupported start mode                                                                          | When users encounter this error code, it means that the configured start mode is not supported, please check it.              |
| ROCKETMQ-09 | Failed to get the offsets of the current consumer group                                         | When users encounter this error code, it means that failed to get the offsets of the current consumer group, please check it. |
| ROCKETMQ-10 | Failed to search offset through timestamp                                                       | When users encounter this error code, it means that failed to search offset through timestamp, please check it.               |
| ROCKETMQ-11 | Failed to get topic min and max topic                                                           | When users encounter this error code, it means that failed to get topic min and max topic, please check it.                   |

