# 试验携程配置中心apollo

一个小坑  
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