# 试验携程配置中心apollo

## 试验

目前用的配置
```
app.id=mr
```
启动参数中有
```
-Denv=DEV
```
配置中心配置好参数
```
hello = world
```
```TestController```中使用```hello```属性接着配置项```@Value("${hello}")```，访问[/printHello](http://localhost:8080/printHello)可见结果
```
来自配置中心的属性值，hello = world
```  
更新配置后可见日志输出
```
INFO 17524 --- [Apollo-Config-1] c.f.a.s.p.AutoUpdateConfigChangeListener : Auto update apollo changed value successfully, new value: world!!!, key: hello, beanName: testController, field: io.dracula.test.apollo.controller.TestController.hello
```

## 坑

访问前端页面是8070端口  
但是应用的meta用的是8080端口  
误配8070时报错
```
WARN 4750 --- [           main] c.c.f.a.i.AbstractConfigRepository       : Sync config failed, will retry. Repository class com.ctrip.framework.apollo.internals.RemoteConfigRepository, reason: Get config services failed from http://106.37.100.59:8070/services/config?appId=mr&ip=124.126.22.173 [Cause: Could not complete get operation [Cause: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $ [Cause: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $]]]
WARN 4750 --- [           main] c.c.f.a.i.LocalFileConfigRepository      : Sync config from upstream repository class com.ctrip.framework.apollo.internals.RemoteConfigRepository failed, reason: Get config services failed from http://106.37.100.59:8070/services/config?appId=mr&ip=124.126.22.173 [Cause: Could not complete get operation [Cause: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $ [Cause: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $]]]
WARN 4750 --- [ngPollService-1] c.c.f.a.i.RemoteConfigLongPollService    : Long polling failed, will retry in 1 seconds. appId: mr, cluster: default, namespaces: application, long polling url: null, reason: Get config services failed from http://106.37.100.59:8070/services/config?appId=mr&ip=124.126.22.173 [Cause: Could not complete get operation [Cause: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $ [Cause: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $]]]
WARN 4750 --- [           main] c.c.f.a.i.LocalFileConfigRepository      : Sync config from upstream repository class com.ctrip.framework.apollo.internals.RemoteConfigRepository failed, reason: Get config services failed from http://106.37.100.59:8070/services/config?appId=mr&ip=124.126.22.173 [Cause: Could not complete get operation [Cause: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $ [Cause: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $]]]
```

不需要```@EnableApolloConfig```  

windows下使用docker-compose方式，找不到正确地址；因为会访问docker容器的地址,17开头的，而又因为其在vm中，外边访问不到，最终导致报错。  

```@ConfigurationProperties```的方式，自动刷新不好使