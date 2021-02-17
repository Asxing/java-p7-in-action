# java-p7-in-action

## 设计原则

- [SOLID 设计原则](https://github.com/HoldDie/java-p7-in-action/tree/master/design-principle)
- [23 种设计模式](https://github.com/HoldDie/java-p7-in-action/tree/master/design-pattern)

## Java 相关

### Java 并发

一个简单的代码参考：[strong_end](https://github.com/kimmking/JavaCourseCodes/tree/main/03concurrency/0301/src/main/java/java0/conc0303/Homework03.java)

1. 把示例代码，运行一遍，思考课上相关的问题。也可以做一些比较。

2. 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？ 写出你的方法，越多越好，提交到 Github。

3. 列举常用的并发操作 API 和工具类，简单分析其使用场景和优缺点。

4. 请思考：什么是并发？什么是高并发？实现高并发高可用系统需要考虑哪些因素，对于这些你是怎么理解的？

5. 请思考：还有哪些跟并发类似有关的场景和问题，有哪些可以借鉴的解决办法。

6. 把多线程和并发相关知识带你梳理一遍，画一个脑图，截图上传到 Github 上。

### JVM 相关

1. 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

2. 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。[hello.xlass](./resources/Hello.xlass.zip)

3. 画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

4.  检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

5. 使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。[GCLogAnalysis.java](./resources/GCLogAnalysis.java.zip)

6. 使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。[gateway-server-0.0.1-SNAPSHOT.jar](./resources/gateway-server-0.0.1-SNAPSHOT.jar.zip)

7.  如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。

8.  根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 的总结，提交到 Github。

### Netty 模块

- [Java BIO/NIO/AIO 基本操作](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-io)
- [Netty 实现一个简易 Tomcat](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-tomcat)
- [Netty 实现一个简易 RPC 框架](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-rpc)
- [Netty 实现一个 IM 聊天室](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-chat)
- [Netty 实现一个完整的业务流程](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-order)

1. 运行课上的例子，以及 Netty 的例子，分析相关现象。

2. 写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801 ，代码提交到 Github。

基础代码可以 fork： https://github.com/kimmking/JavaCourseCodes 02nio/nio02 文件夹下实现以后，代码提交到 Github。

3. 整合你上次作业的 httpclient/okhttp；

4. 使用 netty 实现后端 http 访问（代替上一步骤）

5. 实现过滤器。

6. 实现路由。

## 框架相关

1.使 Java 里的动态代理，实现一个简单的 AOP。
2.（必做）写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 Github。
3.实现一个 Spring XML 自定义配置，配置一组 Bean，例如：Student/Klass/School。
4.（选做，会添加到高手附加题）
4.1 （挑战）讲网关的 frontend/backend/filter/router 线程池都改造成 Spring 配置方式；
4.2 （挑战）基于 AOP 改造 Netty 网关，filter 和 router 使用 AOP 方式实现；
4.3 （中级挑战）基于前述改造，将网关请求前后端分离，中级使用 JMS 传递消息；
4.4 （中级挑战）尝试使用 ByteBuddy 实现一个简单的基于类的 AOP；
4.5 （超级挑战）尝试使用 ByteBuddy 与 Instrument 实现一个简单 JavaAgent 实现无侵入下的 AOP。

1.总结一下，单例的各种写法，比较它们的优劣。
2.maven/spring 的 profile 机制，都有什么用法？
3.总结 Hibernate 与 MyBatis 的各方面异同点。
4.（必做）给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。
5.学习 MyBatis-generator 的用法和原理，学会自定义 TypeHandler 处理复杂类型。
6.（必做）研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：
1）使用 JDBC 原生接口，实现数据库的增删改查操作。
2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
3）配置 Hikari 连接池，改进上述操作。提交代码到 Github。

附加题（可以后面上完数据库的课再考虑做）：
(挑战) 基于 AOP 和自定义注解，实现 @MyCache(60) 对于指定方法返回值缓存 60 秒。
(挑战) 自定义实现一个数据库连接池，并整合 Hibernate/Mybatis/Spring/SpringBoot。
(挑战) 基于 MyBatis 实现一个简单的分库分表 + 读写分离 + 分布式 ID 生成方案。

1.尝试使用 Lambda/Stream/Guava 优化之前作业的代码。

2.尝试使用 Lambda/Stream/Guava 优化工作中编码的代码。

3.根据课上提供的材料，系统性学习一遍设计模式，并在工作学习中思考如何用设计模式解决问题。

4.根据课上提供的材料，深入了解 Google 和 Alibaba 编码规范，并根据这些规范，检查自己写代码是否符合规范，有什么可以改进的。

1.基于课程中的设计原则和最佳实践，分析是否可以将自己负责的业务系统进行数据库设计或是数据库服务器方面的优化

2.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github（后面 2 周的作业依然要是用到这个表结构）。

3.尽可能多的从“常见关系数据库”中列的清单，安装运行，并使用上一题的 SQL 测试简单的增删改查。

4.基于上一题，尝试对各个数据库测试 100 万订单数据的增删改查性能。

5.尝试对 MySQL 不同引擎下测试 100 万订单数据的增删改查性能。

6.模拟 1000 万订单数据，测试不同方式下导入导出（数据备份还原）MySQL 的速度，包括 jdbc 程序处理和命令行处理。思考和实践，如何提升处理效率。

7.对 MySQL 配置不同的数据库连接池（DBCP、C3P0、Druid、Hikari），测试增删改查 100 万次，对比性能，生成报告。

## 分库分表

1.用今天课上学习的知识，分析自己系统的 SQL 和表结构
2.（必做）按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率
3.按自己设计的表结构，插入 1000 万订单模拟数据，测试不同方式的插入效
4.使用不同的索引或组合，测试不同方式查询效率
5.调整测试数据，使得数据尽量均匀，模拟 1 年时间内的交易，计算一年的销售报表：销售总额，订单数，客单价，每月销售量，前十的商品等等（可以自己设计更多指标）
6.尝试自己做一个 ID 生成器（可以模拟 Seq 或 Snowflake）
7.尝试实现或改造一个非精确分页的程序

Week07 作业题目（周六）：
1.配置一遍异步复制，半同步复制、组复制
2.（必做）读写分离 - 动态切换数据源版本 1.0
3.（必做）读写分离 - 数据库框架版本 2.0
4.读写分离 - 数据库中间件版本 3.0
5.配置 MHA，模拟 master 宕机
6.配置 MGR，模拟 master 宕机
7.配置 Orchestrator，模拟 master 宕机，演练 UI 调整拓扑结构

1.分析前面作业设计的表，是否可以做垂直拆分。
2.（必做）设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。
3.模拟 1000 万的订单单表数据，迁移到上面作业 2 的分库分表中。
4.重新搭建一套 4 个库各 64 个表的分库分表，将作业 2 中的数据迁移到新分库。

Week08 作业题目（周六）：
1.列举常见的分布式事务，简单分析其使用场景和优缺点。
2.（必做）基于 hmily TCC 或 ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo（二选一），提交到 Github。
3.基于 ShardingSphere narayana XA 实现一个简单的分布式事务 demo。
4.基于 seata 框架实现 TCC 或 AT 模式的分布式事务 demo。
5.（选做☆）设计实现一个简单的 XA 分布式事务框架 demo，只需要能管理和调用 2 个 MySQL 的本地事务即可，不需要考虑全局事务的持久化和恢复、高可用等。
6.（选做☆）设计实现一个 TCC 分布式事务框架的简单 Demo，需要实现事务管理器，不需要实现全局事务的持久化和恢复、高可用等。
7.（选做☆）设计实现一个 AT 分布式事务框架的简单 Demo，仅需要支持根据主键 id 进行的单个删改操作的 SQL 或插入操作的事务。

## 分布式事务

1.实现简单的 Protocol Buffer/Thrift/gRPC(选任一个) 远程调用 demo。
2.实现简单的 WebService-Axis2/CXF 远程调用 demo。
3.（必做）改造自定义 RPC 的程序，提交到 GitHub：

尝试将服务端写死查找接口实现类变成泛型和反射；
尝试将客户端动态代理改成 AOP，添加异常处理；
尝试使用 Netty+HTTP 作为 client 端传输方式。
4.（选做☆☆））升级自定义 RPC 的程序：

尝试使用压测并分析优化 RPC 性能；
尝试使用 Netty+TCP 作为两端传输方式；
尝试自定义二进制序列化；
尝试压测改进后的 RPC 并分析优化，有问题欢迎群里讨论；
尝试将 fastjson 改成 xstream；
尝试使用字节码生成方式代替服务端反射。
Week09 作业题目（周六）：
1.按课程第二部分练习各个技术点的应用。
2.按 dubbo-samples 项目的各个 demo 学习具体功能使用。
3.（必做）结合 dubbo+hmily，实现一个 TCC 外汇交易处理，代码提交到 GitHub:

用户 A 的美元账户和人民币账户都在 A 库，使用 1 美元兑换 7 人民币 ;
用户 B 的美元账户和人民币账户都在 B 库，使用 7 人民币兑换 1 美元 ;
设计账户表，冻结资产表，实现上述两个本地事务的分布式事务。
4.（挑战☆☆）尝试扩展 Dubbo

基于上次作业的自定义序列化，实现 Dubbo 的序列化扩展 ;
基于上次作业的自定义 RPC，实现 Dubbo 的 RPC 扩展 ;
在 Dubbo 的 filter 机制上，实现 REST 权限控制，可参考 dubbox;
实现一个自定义 Dubbo 的 Cluster/Loadbalance 扩展，如果一分钟内调用某个服务 / 提供者超过 10 次，则拒绝提供服务直到下一分钟 ;
整合 Dubbo+Sentinel，实现限流功能 ;
整合 Dubbo 与 Skywalking，实现全链路性能监控。

## 分布式缓存

1.命令行下练习操作 Redis 的各种基本数据结构和命令。

2.分别基于 jedis，RedisTemplate，Lettuce，Redission 实现 redis 基本操作的 demo，可以使用 spring-boot 集成上述工具。

3.spring 集成练习:

实现 update 方法，配合 @CachePut
实现 delete 方法，配合 @CacheEvict
将示例中的 spring 集成 Lettuce 改成 jedis 或 redisson
4.（必做）基于 Redis 封装分布式数据操作：

在 Java 中实现一个简单的分布式锁；
在 Java 中实现一个分布式计数器，模拟减库存。
5.（必做）基于 Redis 的 PubSub 实现订单异步处理

1.（挑战☆）基于其他各类场景，设计并在示例代码中实现简单 demo：

实现分数排名或者排行榜；
实现全局 ID 生成；
基于 Bitmap 实现 id 去重；
基于 HLL 实现点击量计数；
以 redis 作为数据库，模拟使用 lua 脚本实现前面课程的外汇交易事务。
2.（挑战☆☆）升级改造项目：

实现 guava cache 的 spring cache 适配；
替换 jackson 序列化为 fastjson 或者 fst，kryo；
对项目进行分析和性能调优。
3.（挑战☆☆☆）以 redis 作为基础实现上个模块的自定义 rpc 的注册中心。

1.（必做）配置 redis 的主从复制，sentinel 高可用，Cluster 集群。

2.练习示例代码里下列类中的作业题:
08cache/redis/src/main/java/io/kimmking/cache/RedisApplication.java

3.（选做☆）练习 redission 的各种功能。

4.（选做☆☆）练习 hazelcast 的各种功能。

5.（选做☆☆☆）搭建 hazelcast 3 节点集群，写入 100 万数据到一个 map，模拟和演 示高可用。


## 分布式消息

1. 搭建 ActiveMQ 服务，基于 JMS，写代码分别实现对于 queue 和 topic 的消息生产和消费，代码提交到 github。[ :e-mail: ](../)

2. (挑战☆)基于数据库的订单表，模拟消息队列处理订单： 
    - 一个程序往表里写新订单，标记状态为未处理 (status=0);
    - 另一个程序每隔 100ms 定时从表里读取所有 status=0 的订单，打印一下订单数据，然后改成完成 status=1； 
    - 考虑失败重试策略，考虑多个消费程序如何协作。

3. 将上述订单处理场景，改成使用 ActiveMQ 发送消息处理模式。
   
4. 使用 java 代码，创建一个 ActiveMQ Broker Server，并测试它。
   
5. 搭建 ActiveMQ 的 network 集群和 master-slave 主从结构。 

6. (☆☆☆)基于 ActiveMQ 的 MQTT 实现简单的聊天功能或者 Android 消息推送。

7. (挑战☆)创建一个 RabbitMQ，用 Java 代码实现简单的 AMQP 协议操作。

8. (挑战☆☆)搭建 RabbitMQ 集群，重新实现前面的订单处理。

9. (挑战☆☆☆)使用 Apache Camel 打通上述 ActiveMQ 集群和 RabbitMQ 集群，实现所有写入到 ActiveMQ 上的一个队列 q24 的消息，自动转发到 RabbitMQ。

10. (挑战☆☆☆)压测 ActiveMQ 和 RabbitMQ 的性能。

1. 搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。

2. 安装 kafka-manager 工具，监控 kafka 集群状态。

3. (挑战☆)演练本课提及的各种生产者和消费者特性。

4. (挑战☆☆☆)Kafka 金融领域实战：在证券或者外汇、数字货币类金融核心交易系统里，对于订单的处理，大概可以分为收单、定序、撮合、清算等步骤。其中我们一般可以用 mq 来实现订单定序，然后将订单发送给撮合模块。
   - 收单：请实现一个订单的 rest 接口，能够接收一个订单 Order 对象；
   - 定序：将 Order 对象写入到 kafka 集群的 order.usd2cny 队列，要求数据有序并且不丢失；
   - 撮合：模拟撮合程序（不需要实现撮合逻辑），从 kafka 获取 order 数据，并打印订单信息，要求可重放, 顺序消费, 消息仅处理一次。


1.自己安装和操作 RabbitMQ，RocketMQ，Pulsar，以及 Camel 和 Spring Integration。

2.（必做）思考和设计自定义 MQ 第二个版本或第三个版本，写代码实现其中至少一个功能点，把设计思路和实现代码，提交到 GitHub。

3.（挑战☆☆☆☆☆）完成所有其他版本的要求。期限一年。

1.思考一下自己负责的系统，或者做过的系统，能否描述清楚其架构。

2.考虑一下，如果让你做一个针对双十一，某东某宝半价抢 100 个 IPhone 的活动系统，你该如何考虑，从什么地方入手。

3.可以自行学习以下参考书的一两本。
推荐架构书籍：
《软件架构》Mourad Chabane Oussalah
《架构实战 - 软件架构设计的过程》Peter EeLes
《软件系统架构 - 使用视点和视角与利益相关者合作》Nick Rozanski
《企业 IT 架构转型之道》
《大型网站技术架构演进与性能优化》
《银行信息系统架构》
《商业银行分布式架构实践》

## 分布式系统架构

1.针对课上讲解的内容，自己动手设计一个高并发的秒杀系统，讲架构图， 设计文档等，提交到 GitHub。

2.针对自己工作的系统，或者自己思考的复杂场景，做系统性的架构设计。

周六作业：
1.学习《重构–改善既有代码的设计》这本书，写读书笔记。
2.对于目前自己维护的项目代码，思考如何改善设计和实现。