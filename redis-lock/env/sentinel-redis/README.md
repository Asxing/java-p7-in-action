# redis 哨兵集群搭建

## 整体思路

- 首先搭建一个简单哨兵集群，一个哨兵实例，一个主节点，两个从节点，查看 info，以及各节点操作。
- 然后把主节点shutdown，之后观察哨兵行为，查看选举过程，之后再新的master节点上操作。
- 最后把最开始的那个 master 节点拉起来，观察数据日志同步。

## 搭建流程

修改每个文件的 port 和 pidfile 字段，分别启动的每个实例。

### Master  执行对应命令如下图所示

![image-20210106124015567](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124015.png)

对应命令如下：

![image-20210106124117794](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124117.png)



### 哨兵实例

![image-20210106124206555](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124206.png)

对应命令行为

![image-20210106124348181](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124348.png)

### 两个从节点

![image-20210106124423598](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124423.png)

命令行如下

![image-20210106124453214](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124453.png)

### 另一个从节点

![image-20210106124533813](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124533.png)

对应命令行

![image-20210106124559375](https://cdn.jsdelivr.net/gh/HoldDie/img/20210106124559.png)