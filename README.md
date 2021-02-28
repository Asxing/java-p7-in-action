# java-p7-in-action

### 设计原则

- [SOLID 设计原则](https://github.com/HoldDie/java-p7-in-action/tree/master/design-principle)
- [23 种设计模式](https://github.com/HoldDie/java-p7-in-action/tree/master/design-pattern)

### Netty 模块

- [Java BIO/NIO/AIO 基本操作](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-io)
- [Netty 实现一个简易 Tomcat](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-tomcat)
- [Netty 实现一个简易 RPC 框架](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-rpc)
- [Netty 实现一个 IM 聊天室](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-chat)
- [Netty 实现一个完整的业务流程](https://github.com/HoldDie/java-p7-in-action/tree/master/netty-order)

### 1. JVM

从Classloader到模块化，动态加载的插件机制。[文章阅读](https://91p7.com/81/)

1. 10-使用自定义Classloader机制，实现xlass的加载：xlass是作业材料。[代码实现](./jvm-base/classloader-base/src/main/java/com/holddie/jvm/classloader/v1/AXClassLoader.java)
2. 20-实现xlass打包的xar（类似class文件打包的jar）的加载：xar里是xlass。[代码实现](./jvm-base/classloader-base/src/main/java/com/holddie/jvm/classloader/v2/AXClassLoader.java)
3. 30-基于自定义Classloader实现类的动态加载和卸载：需要设计加载和卸载。[代码实现](./jvm-base/classloader-base/src/main/java/com/holddie/jvm/classloader/v3/AXClassLoader.java)
4. 30-基于自定义Classloader实现模块化机制：需要设计模块化机制。[代码实现](./jvm-base/modularization)
5. 30-使用xar作为模块，实现xar动态加载和卸载：综合应用前面的内容。[代码实现](./jvm-base/modularization/multi-server)

### 2. NIO

实现一个http 文件服务器和一个ftp文件服务器。
1. 10-实现文件列表展示：http直接网页展示列表即可。ftp支持cd、ls命令。
2. 20-实现文件上传下载：http上传不需要支持multi-part，直接post文件内容即可。ftp只需要支持主动模式或被动模式的一种。
3. 30-支持断点续传：http下载需要实现range，上传需要自己设计服务器端的分片方式并记录。ftp需要实现retr，stor，rest命令。
4. 30-实现多线程文件上传下载：基于断点续传，需考虑客户端分片方式，多线程调度。
5. 30-实现爬虫爬取前面实现的服务器上所有文件：需要考虑html解析，记录多个文件的传输进度，位置等。

### 3. 并发

#### 3.1-侧重集合：

1. 10-基于基本类型和数组，实现ArrayList/LinkedList，支持自动扩容和迭代器
2. 20-基于基本类型和数组和List，HashMap/LinkedHashMap功能，处理hash冲突和扩容
3. 30-考虑List和Map的并发安全问题，基于读写锁改进安全问题
4. 30-考虑List和Map的并发安全问题，基于AQS改进安全问题
5. 30-编写测试代码比较它们与java-util/JUC集合类的性能和并发安全性

#### 3.2-侧重应用：

1. 10-根据课程提供的场景，实现一个订单处理Service，模拟处理100万订单：后面提供模拟数据
2. 20-使用多线程方法优化订单处理，对比处理性能
3. 30-使用并发工具和集合类改进订单Service，对比处理性能
4. 30-使用分布式集群+分库分表方式处理拆分订单，对比处理性能：第6模块讲解分库分表
5. 30-使用读写分离和分布式缓存优化订单的读性能：第6、8模块讲解读写分离和缓存

### 4. 框架

#### 4.1 Spring AOP

1. 10-讲网关的frontend/backend/filter/router/线程池都改造成Spring配置方式
2. 20-基于AOP改造Netty网关，filter和router使用AOP方式实现
3. 30-基于前述改造，将网关请求前后端分离，中级使用JMS传递消息
4. 30-尝试使用ByteBuddy实现一个简单的基于类的AOP
5. 30-尝试使用ByteBuddy与Instrument实现一个简单JavaAgent实现无侵入下的AOP

#### 4.2 Spring ORM

1. 基于AOP和自定义注解，实现@MyCache(60)对于指定方法返回值缓存60秒
2. 自定义实现一个数据库连接池，并整合Hibernate/Mybatis/Spring/SpringBoot
3. 基于MyBatis实现一个简单的分库分表+读写分离+分布式ID生成方案

### 5. 数据库与性能

1. 模拟1000万订单数据，测试不同方式下导入导出（数据备份还原）MySQL的速度，包括jdbc程序处理和命令行处理，思考和实践，如何提升处理效率
2. 对MySQL配置不同的数据库连接池（DBCP、C3P0、Druid、Hikari），测试增删改查100万次，对比性能，生成报告
3. 尝试自己做一个ID生成器（可以模拟Seq或Snowflake）
4. 尝试实现或改造一个非精确分页的组件，思考是否可以用于改造自己的业务系统
5. 基于必做作业2.0版本，实现读写分离-数据库中间件版本3.0

### 6. 分库分表

1. 思考总结常用的数据拆分和数据迁移同步方案，以及它们的优势劣势，适用场景，考虑是否可以引入到自己的工作中
2. 设计实现一个简单的XA分布式事务框架demo，只需要能管理和调用2个MySQL的本地事务即可，不需要考虑全局事务的持久化和恢复、高可用等
3. 设计实现一个TCC分布式事务框架的简单Demo，需要实现事务管理器，不需要实现全局事务的持久化和恢复、高可用等
4. 设计实现一个AT分布式事务框架的简单Demo，仅需要支持根据主键id进行的单个删改操作的SQL或插入操作的事务

### 7. RPC与分布式服务化

#### 7.1 RPC与Dubbo

1. 升级作业中的自定义RPC程序：
- 尝试使用压测并分析优化RPC性能
- 尝试使用Netty+TCP作为两端传输方式
- 尝试自定义二进制序列化或者使用kyro/fst等
- 尝试压测改进后的RPC并分析优化，有问题欢迎群里讨论
- 尝试将fastjson改成xstream
- 尝试使用字节码生成方式代替服务端反射

2. 尝试扩展Dubbo
- 基于上次作业的自定义序列化，实现Dubbo的序列化扩展；
- 基于上次作业的自定义RPC，实现Dubbo的RPC扩展；
- 在Dubbo的filter机制上，实现REST权限控制，可参考dubbox；
- 实现自定义Dubbo的Cluster/Loadbalance扩展，如果一分钟内调用某个服务/提供者超过10次，则拒绝提供服务直到下一分钟；
- 整合Dubbo+Sentinel，实现限流功能；
- 整合Dubbo与Skywalking，实现全链路性能监控。

#### 7.2 自定义RPC

1. rpcfx1.1: 给自定义RPC实现简单的分组(group)和版本(version)。

2. rpcfx2.0: 给自定义RPC实现：
- 基于zookeeper的注册中心，消费者和生产者可以根据注册中心查找可用服务进行调用(直接选择列表里的最后一个)。
- 当有生产者启动或者下线时，通过zookeeper通知并更新各个消费者，使得各个消费者可以调用新生产者或者不调用下线生产者。

3. 在2.0的基础上继续增强rpcfx实现：
- 3.0: 实现基于zookeeper的配置中心，消费者和生产者可以根据配置中心配置参数（分组，版本，线程池大小等）。
- 3.1：实现基于zookeeper的元数据中心，将服务描述元数据保存到元数据中心。
- 3.2：实现基于etcd/nacos/apollo等基座的配置/注册/元数据中心。

4. 在3.2的基础上继续增强rpcfx实现：
- 4.0：实现基于tag的简单路由；
- 4.1：实现基于Weight/ConsistentHash的负载均衡;
- 4.2：实现基于IP黑名单的简单流控；
- 4.3：完善RPC框架里的超时处理，增加重试参数；

5. 在4.3的基础上继续增强rpcfx实现：
- 5.0：实现利用HTTP头跨进程传递Context参数（隐式传参）；
- 5.1：实现消费端mock一个指定对象的功能（Mock功能）；
- 5.2：实现消费端可以通过一个泛化接口调用不同服务（泛化调用）；
- 5.3：实现基于Weight/ConsistentHash的负载均衡;
- 5.4：实现基于单位时间调用次数的流控，可以基于令牌桶等算法；

6. 实现最终版本6.0：压测并分析调优5.4版本。

### 8. 分布式缓存

1. 基于其他各类场景，设计并在示例代码中实现简单demo：
- 实现分数排名或者排行榜；
- 实现全局ID生成；
- 基于Bitmap实现id去重；
- 基于HLL实现点击量计数。
- 以redis作为数据库，模拟使用lua脚本实现前面课程的外汇交易事务。

2. 升级改造项目：
- 实现guava cache的spring cache适配；
- 替换jackson序列化为fastjson或者fst，kryo；
- 对项目进行分析和性能调优。

3. 以redis作为基础实现上个模块的自定义rpc的注册中心；
4. 练习redission的各种功能；
5. 练习hazelcast的各种功能；
6. 搭建hazelcast 3节点集群，写入100万数据到一个map，模拟和演示高可用，测试一下性能。

### 9. 分布式消息

#### 9.1 消息队列原理与应用

1. 基于数据库的订单表，模拟消息队列处理订单：
- 一个程序往表里写新订单，标记状态为未处理(status=0);
- 另一个程序每隔100ms定时从表里读取所有status=0的订单，打印一下订单数据，然后改成完成status=1；
- 考虑失败重试策略，考虑多个消费程序如何协作；
- 将上述订单处理场景，改成使用ActiveMQ发送消息处理模式；
- 使用java代码，创建一个ActiveMQ Broker Server，并测试它；

2. ActiveMQ/RabbitMQ作业
- 搭建ActiveMQ的network集群和master-slave主从结构；
- 基于ActiveMQ的MQTT实现简单的聊天功能或者Android消息推送；
- 创建一个RabbitMQ，用Java代码实现简单的AMQP协议操作；
- 搭建RabbitMQ集群，重新实现前面的订单处理；
- 使用Apache Camel打通上述ActiveMQ集群和RabbitMQ集群，实现所有写入到ActiveMQ上的一个队列q24的消息，自动转发到RabbitMQ；
- 压测ActiveMQ和RabbitMQ的性能；

3. 演练本课提及的各种生产者和消费者特性。

4. Kafka金融领域实战：在证券或者外汇、数字货币类金融核心交易系统里，对于订单的处理，大概可以分为收单、定序、撮合、清算等步骤。其中我们一般可以用mq来实现订单定序，然后将订单发送给撮合模块。
- 收单：请实现一个订单的rest接口，能够接收一个订单Order对象；
- 定序：将Order对象写入到kafka集群的order.usd2cny队列，要求数据有序并且不丢失；
- 撮合：模拟撮合程序（不需要实现撮合逻辑），从kafka获取order数据，并打印订单信息，要求可重放, 顺序消费, 消息仅处理一次。

#### 9.2 自定义消息中间件

1. v1.0-内存队列：基于内存Queue实现生产和消费API（示例代码已经完成）
- 创建内存BlockingQueue，作为底层消息存储
- 定义Topic，支持多个Topic
- 定义Producer，支持Send消息
- 定义Consumer，支持Poll消息

2. v2.0-自定义队列：去掉内存Queue，设计自定义Queue，实现消息确认和消费offset
- 自定义内存Message数组模拟Queue。
- 使用指针记录当前消息写入位置。
- 对于每个命名消费者，用指针记录消费位置。

3. v3.0-基于SpringMVC实现MQServer：拆分broker和client(包括producer和consumer)，从单机走向服务器模式。
- 将Queue保存到web server端
- 设计消息读写API接口，确认接口，提交offset接口
- producer和consumer通过httpclient访问Queue
- 实现消息确认，offset提交
- 实现consumer从offset增量拉取

4. v4.0-功能全面：增加多种策略（各条之间没有关系，可以任意选择实现），基于TCP实现server->client，从而实现 PUSH模式
- 考虑实现消息过期，消息重试，消息定时投递等策略
- 考虑批量操作，包括读写，可以打包和压缩
- 考虑消息清理策略，包括定时清理，按容量清理、LRU等
- 考虑消息持久化，存入数据库，或WAL日志文件，或BookKeeper
- 考虑将spring mvc替换成netty下的tcp传输协议，rsocket/websocket

5. v5.0-优化完善：对接各种技术（各条之间没有关系，可以任意选择实现）
- 考虑封装 JMS 1.1 接口规范
- 考虑实现 STOMP 消息规范
- 考虑实现消息事务机制与事务管理器
- 对接Spring
- 对接Camel或Spring Integration
- 优化内存和磁盘的使用
