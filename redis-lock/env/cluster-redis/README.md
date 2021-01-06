# Redis Cluster 集群搭建

## 思路

- 一共启动 6 个实例，三个 master，三个从节点；
- 断掉其中一个 master 实例，查看从节点情况；

## 配置

```yml
# 修改端口
port xxx
pidfile xxx
cluster-enable yes
cluster-config-file nodes-xxx.conf
cluster-node-timeout 15000
```

## 节点日志

### Redis-6400

![image-20210106133556240](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106133556.png)

命令执行情况

![image-20210106134049804](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134049.png)

### Redis-6401

![image-20210106134117755](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134117.png)

### Redis-6402

![image-20210106134314480](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134314.png)

命令执行

![image-20210106134338717](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134338.png)

### Redis-6403

![image-20210106134359547](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134359.png)

### Redis-6404

![image-20210106134417016](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134417.png)

### Redis-6405

![image-20210106134439483](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134439.png)

## 构建集群

![image-20210106134647030](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134647.png)

### 查看集群状况

![image-20210106134747377](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134747.png)

## 添加从节点（非集群从节点）

![image-20210106134859788](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134859.png)

命令行

![image-20210106134931875](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106134931.png)

## 总结

1. 构建 Redis-Cluster 的所有节点都必须启动集群配置，设置自己node.conf 路径；
2. Cluster 集群是通过命令行的形式构建，构建成功之后我们可以使用 cluster nodes 查看节点情况；
3. 对于集群中被设置为集群从节点，是不能从中读取数据的，好的办法就是再启动一个无关的 redis 实例去做备份，然后可以读取数据；
4. 即使我们可以读取数据，我们只能读取到对应 solt 的节点的数据，其他主节点的数据我们还是读取不到，此时我们可以每个主节点下边再挂一层从节点，对数据可以做聚合操作；

