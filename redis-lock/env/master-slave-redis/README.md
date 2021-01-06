# 主从节点配置

## 1. 修改配置文件

1.1 使用的 redis 官网标准配置文件：<https://github.com/redis/redis/blob/6.0/redis.conf>

1.2 分别修改 master_6380 和 slave_6381 文件下的配置文件

主要包括修改文件启动句柄，修改端口号

redis_6380.conf
> port 6380
> pidfile /Users/zeyangg/SynologyDrive/ee/redis/master-slave-redis/master_6380/redis_6380.pid

redis_6381.cnf

> port 6381
> pidfile /Users/zeyangg/SynologyDrive/ee/redis/master-slave-redis/slave_6381/redis_6381.pid

## 分别启动两个实例

启动 6380 

```
xxx/redis/master-slave-redis/master_6380> redis-server redis_6380.conf
```

![image-20210106111100477](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106111101.png)

6380 对应命令行

![image-20210106111148946](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106111148.png)

启动 6381

```
sss/redis/master-slave-redis/slave_6381> redis-server redis_6381.conf
```

![image-20210106111213015](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106111213.png)

执行命令行

![image-20210106111250313](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106111250.png)

## 主从之间建立关系

登录 6381 执行命令

```shell
redis-cli -h 127.0.0.1 -p 6381

slaveof 127.0.0.1 6380
```

