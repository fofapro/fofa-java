# fofa-java

[![GitHub (pre-)release](https://img.shields.io/github/release/fofapro/fofa-java/all.svg)](https://github.com/0nise/fofa-java/releases)
[![stars](https://img.shields.io/github/stars/fofapro/fofa-java.svg)](https://github.com/0nise/fofa-java/stargazers)
[![license](https://img.shields.io/github/license/fofapro/fofa-java.svg)](https://github.com/0nise/fofa-java/blob/master/LICENSE)

[English document](https://github.com/0nise/fofa-java/blob/master/README.md)

## FOFA Pro API

[`FOFA Pro API`](https://fofa.so/api) 是资产搜索引擎 [`FOFA Pro`](https://fofa.so) 为开发者提供的 `RESTful API` 接口, 允许开发者在自己的项目中集成 [`FOFA Pro`](https://fofa.so) 的功能。

## FOFA SDK

基于 [`FOFA Pro API`](https://fofa.so/api) 编写的 `java` 版 `SDK`, 方便 java 开发者快速将 [`FOFA Pro`](https://fofa.so) 集成到自己的项目中。

## 添加依赖

### Apache Maven

```java
<dependency>
  <groupId>com.r4v3zn.fofa</groupId>
  <artifactId>fofa-core</artifactId>
  <version>1.0.6.RELEASE</version>
</dependency>
```

### Gradle Groovy DSL

```java
implementation 'com.r4v3zn.fofa:fofa-core:1.0.6.RELEASE'
```

### Gradle Kotlin DSL

```java
implementation("com.r4v3zn.fofa:fofa-core:1.0.6.RELEASE")
```

### Scala SBT

```java
libraryDependencies += "com.r4v3zn.fofa" % "fofa-core" % "1.0.6.RELEASE"
```

### Apache Ivy

```java
<dependency org="com.r4v3zn.fofa" name="fofa-core" rev="1.0.6.RELEASE" />
```

### Groovy Grape

```java
@Grapes(
  @Grab(group='com.r4v3zn.fofa', module='fofa-core', version='1.0.6.RELEASE')
)
```

### Leiningen

```java
[com.r4v3zn.fofa/fofa-core "1.0.6.RELEASE"]
```

### Apache Buildr

```java
'com.r4v3zn.fofa:fofa-core:jar:1.0.6.RELEASE'
```

### Maven Central Badge

```java
[![Maven Central](https://img.shields.io/maven-central/v/com.r4v3zn.fofa/fofa-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.r4v3zn.fofa%22%20AND%20a:%22fofa-core%22)
```

### PURL

```java
pkg:maven/com.r4v3zn.fofa/fofa-core@1.0.6.RELEASE
```

### Bazel

```java
maven_jar(
    name = "fofa-core",
    artifact = "com.r4v3zn.fofa:fofa-core:1.0.6.RELEASE",
    sha1 = "151fc5fe259ccad55c040ed46d40b9bc19dd6b32",
)
```

## 使用

|字段名称|描述|
|:---------:|:-----------------:|
| `email` |用户登陆 [`FOFA Pro`](https://fofa.so) 使用的 `Email`|
|`key`| 前往 [`个人中心`](https://fofa.so/user/users/info) 查看 `API Key`|

### 获取用户信息

```java
public static void main(String[] args) throws Exception {
    // FOFA Pro email
    String email = "";
    // FOFA Pro key
    String key = "";
    FofaClient client = new FofaClient(email, key);
    System.out.println(client.getUser());
}
```

### 查询所有

#### 代码

```java
public static void main(String[] args) throws Exception {
    // FOFA Pro email
    String email = "";
    // FOFA Pro key
    String key = "";
    BASE_URL = "https://fofa.info";
    FofaClient fofaClient = new FofaClient(email, key);
    FofaSearch fofaSearch = new FofaSearch(fofaClient);
    String query = "host=\"fofa.info\"";
    System.out.println(fofaSearch.all(query));
}
```

#### 响应

```java
FofaData{mode='extended', page=1, size=74, totalPage=1, query='host="fofa.info"', results=[www.fofa.info, fofa.info, static.fofa.info, https://static.fofa.info, https://fofa.info, api.fofa.info, api.jw.fofa.info:7088, api.g.fofa.info:88, api.jw.fofa.info:88, api.g.fofa.info:8084, api.jw.fofa.info:84, api.jw.fofa.info:81, api.jw.fofa.info:8003, api.g.fofa.info:8083, api.g.fofa.info:7088, api.g.fofa.info:808, https://g.fofa.info, api.jw.fofa.info:8181, https://jw.fofa.info, api.g.fofa.info:8003, api.jw.fofa.info:8083, https://img.gamma.fofa.info, api.g.fofa.info:81, api.g.fofa.info:7070, api.jw.fofa.info:8084, api.jw.fofa.info:808, api.g.fofa.info:8181, api.jw.fofa.info:7070, img.gamma.fofa.info, jw.fofa.info, g.fofa.info, api.g.fofa.info:84, https://35.81.36.22:443, 47.93.92.246:88, https://140.249.61.184:443, 47.93.92.246:808, 47.93.92.246:8003, 47.93.92.246:81, https://106.75.10.35:443, 106.75.10.35:80, 47.93.92.246:7088, 47.93.92.246:84, 140.249.61.184:80, 47.93.92.246:8181, 47.93.92.246:8084, 47.93.92.246:88, 47.93.92.246:7070, 47.93.92.246:81, 47.93.92.246:7070, 47.93.92.246:84, 47.93.92.246:8084, 47.93.92.246:8003, 47.93.92.246:8083, 106.75.10.35:80, 47.93.92.246:808, 47.93.92.246:8083, 47.93.92.246:8181, 47.93.92.246:7088, https://gamma.fofa.info, https://api.gamma.fofa.info, gamma.fofa.info, api.gamma.fofa.info, 1.71.148.8:80, https://1.71.148.8:443, https://79.168.42.251:443, 122.143.5.67:80, https://api.fofa.info, 81.150.11.126:22, www.fofa.info:6443, 117.50.16.112:80, 150.138.167.141:6443, 117.50.16.112:80, https://117.50.16.112:443, https://117.50.16.112:443]}
```

### 聚合统计

#### 代码

```java
public static void main(String[] args) throws Exception {
    // FOFA Pro email
    String email = "";
    // FOFA Pro key
    String key = "";
    BASE_URL = "https://fofa.info";
    FofaClient fofaClient = new FofaClient(email, key);
    FofaSearch fofaSearch = new FofaSearch(fofaClient);
    String query = "host=\"fofa.info\"";
    System.out.println(fofaSearch.stats(query));
}
```

#### 响应

````java
StatsData{distinct={ip=16}, aggs={countries=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJDTiI=, count=71, name=China, name_code=CN, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IkJlaWppbmci, count=41, name=Beijing}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IiI=, count=27, name=Unknown}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249Ikd1YW5nZG9uZyI=, count=2, name=Guangdong}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IkppbGluIg==, count=1, name=Jilin}]}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJHQiI=, count=1, name=United Kingdom of Great Britain and Northern Ireland, name_code=GB, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IiI=, count=1, name=Unknown}]}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJQVCI=, count=1, name=Portugal, name_code=PT, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249Ikxpc2JvbiI=, count=1, name=Lisbon}]}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJVUyI=, count=1, name=United States of America, name_code=US, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249Ik9yZWdvbiI=, count=1, name=Oregon}]}]}}
````

### Host 聚合

#### 代码

```java
public static void main(String[] args) throws Exception {
    // FOFA Pro email
    String email = "";
    // FOFA Pro key
    String key = "";
    BASE_URL = "https://fofa.info";
    FofaClient fofaClient = new FofaClient(email, key);
    FofaHost fofaHost = new FofaHost(fofaClient);
    String host = "fofa.info";
    System.out.println(fofaHost.host(host));
}
```

#### 响应

```
HostData{host='fofa.info', ip='124.239.250.54', asn=58539, org='null', countryName='China', countryCode='CN', protocol=[http, https, ssh], port=[443, 22, 8080, 9527, 8069, 8089, 80], category=null, product=null}
```

## 更新日志

2022-05-29

```
- 新增查询统计接口
- 新增host查询接口
- 新增自定义扩展查询字段
- 更新 jackson 版本
- 修复Bug
```

2022-01-27

    - 更新 FOFA

2021-07-26

    - 更新 jackson 版本

2020-04-27

    - 修复安全漏洞

2020-01-04

    - 修复安全漏洞

2019-06-12

    - 添加中文文档

2019-06-11

    - 修改开发者信息
    - 删除hutool-http依赖
