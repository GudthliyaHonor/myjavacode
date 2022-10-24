# DotK project
一点知识学习平台Java工程

推荐使用DDD模式开发

## 应用分层
至少需要包含如下的结构，将业务和流程分开，应用服务专注用例调度，反应用户故事；

领域对象/服务专注核心业务。整个模块通用的放到基础设施层，资源库和外部服务实现也放到基础设施层，屏蔽实现细节。

以下是具体目录层次结构：

### api 向外提供接口
controller 提供接口服务
dto 用来封装复杂的数据对象，多用来给需要多个实体组合时提供数据传输

### app 负责用例调度，事务控制
service 应用服务，事务控制、流程调度

impl 实现

assembler dto组装器

### domain 领域对象和领域服务，专注核心业务
entity 表的体现，能简单自治（限制长度，限制主键等等）

service 封装领域内复杂的业务逻辑

repository 资源库接口，提供数据资源的操作方法，简单的增删改查和redis的增删查改

vo 值对象，封装没有实体但是又会在领域内用的数据

### infra 基础设施，保持数据的持久化、防腐层、第三方库、消息等
mapper 接口

repository.impl repository的实现，业务不能入侵到这里

## 打包
执行maven projects下的`ydzs-java-dotk`的`package`命令进行打包。

## 运行
运行
```
dotk-com.dotk.web\src\main\java\com\dotk\DotkWebApplication.java
```
