# fofa-java

[![GitHub (pre-)release](https://img.shields.io/github/release/0nise/fofa-java/all.svg)](https://github.com/0nise/fofa-java/releases)
[![stars](https://img.shields.io/github/stars/0nise/fofa-java.svg)](https://github.com/0nise/fofa-java/stargazers)
[![license](https://img.shields.io/github/license/0nise/fofa-java.svg)](https://github.com/0nise/fofa-java/blob/master/LICENSE)

[中文文档](https://github.com/0nise/fofa-java/blob/master/README_zh.md)

## FOFA Pro API
[`FOFA Pro API`](https://fofa.so/api) is an asset search engine [`FOFA Pro`](https://fofa.so) provides a `RESTful API` interface for developers, allowing developers to integrate [`FOFA Pro`](https://fofa.so) functionality into their projects.
## FOFA SDK
A `Java` version of the `SDK`, based on the [`FOFA Pro API`](https://fofa.so/api), makes it easy for Java developers to quickly integrate [`FOFA Pro`](https://fofa.so) into their projects.
## add dependency

### Apache Maven

```
<dependency>
  <groupId>com.r4v3zn.fofa</groupId>
  <artifactId>fofa-core</artifactId>
  <version>1.0.2.RELEASE</version>
</dependency>
```

### Gradle Groovy DSL

```java
implementation 'com.r4v3zn.fofa:fofa-core:1.0.2.RELEASE'
```

### Gradle Kotlin DSL

```java
implementation("com.r4v3zn.fofa:fofa-core:1.0.2.RELEASE")
```

### Scala SBT

```java
libraryDependencies += "com.r4v3zn.fofa" % "fofa-core" % "1.0.2.RELEASE"
```

### Apache Ivy

```java
<dependency org="com.r4v3zn.fofa" name="fofa-core" rev="1.0.2.RELEASE" />
```

### Groovy Grape

```java
@Grapes(
  @Grab(group='com.r4v3zn.fofa', module='fofa-core', version='1.0.2.RELEASE')
)
```

### Leiningen

```java
[com.r4v3zn.fofa/fofa-core "1.0.2.RELEASE"]
```

### Apache Buildr

```java
'com.r4v3zn.fofa:fofa-core:jar:1.0.2.RELEASE'
```

### Maven Central Badge

```java
[![Maven Central](https://img.shields.io/maven-central/v/com.r4v3zn.fofa/fofa-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.r4v3zn.fofa%22%20AND%20a:%22fofa-core%22)
```

### PURL

```java
pkg:maven/com.r4v3zn.fofa/fofa-core@1.0.2.RELEASE
```

### Bazel

```java
maven_jar(
    name = "fofa-core",
    artifact = "com.r4v3zn.fofa:fofa-core:1.0.2.RELEASE",
    sha1 = "669cac1d690068d60a8e9968d86340b8769810cb",
)
```

## USE

|field|description|
|:---------:|:-----------------:|
| `email` |User login [`FOFA Pro`](https://fofa.so) mailbox `Email`|
|`key`| Please go to the [`personal center`](https://fofa.so/user/users/info) to view `API Key`|

### get user info

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

### get data

#### Code

```java
public static void main(String[] args) throws Exception {
    // FOFA Pro email
    String email = "";
    // FOFA Pro key
    String key = "";
    String q = "app=\"Solr\"";
    FofaClient client = new FofaClient(email, key);
    System.out.println(client.getData(q));
}
```

#### Response

```java
FofaData{mode='extended', page=1, size=8578, totalPage=86, query='app="Solr"', results=[52.204.201.10:8080, 39.106.133.253:8081, 168.61.45.247:3000, 185.145.32.101:9090, 47.92.153.193:8083, https://54.177.198.16:9443, https://46.137.115.176, 109.202.145.150:9090, 18.229.36.175, https://52.65.18.222, 94.103.24.81, 128.119.168.198:8080, 45.56.107.121:8090, 159.65.33.96:8080, 165.28.246.132, 34.205.15.100:8080, 3.89.155.86, 101.200.142.15:8099, 45.56.91.166:8090, 107.21.102.229, 89.28.161.145:8083, 35.165.137.220, 162.243.2.73:32768, 3.82.255.95:8080, 52.22.6.26, 96.126.97.74:8090, https://solr.swoonery.com, 63.34.225.181:8083, 18.223.238.90:7777, 167.99.252.65:8081, 18.232.114.197, 96.126.104.116:8090, 52.17.255.254, 101.201.145.141:8888, 13.228.98.189, 52.66.197.212:8081, 34.226.45.218:9443, 36.111.196.193:8082, 52.80.87.182, 97.107.133.44:8090, 173.255.217.135:8080, 34.199.97.120:8081, 52.17.131.156, https://13.55.200.182:443, 23.23.104.210, 54.68.95.160, https://54.77.13.29:8082, 66.175.209.109:8090, 52.200.107.211:8080, 104.130.124.46:7777, 192.231.177.172:8090, 54.221.155.2, 203.135.191.199:8080, 218.93.127.8:9080, 101.251.241.194:8081, 115.79.204.120:8888, 39.106.23.13:8180, https://52.16.231.131:8080, 52.5.53.165:8080, 39.106.180.220:8180, 52.67.86.138, https://52.26.130.143, 52.37.105.68, 23.239.19.16:8090, 52.58.193.2, 168.218.15.134, 52.44.108.125:9443, 76.210.250.82:32768, 52.71.163.53, 92.243.20.10:8080, 157.249.39.129, www.marineparts.us:8983, 185.135.12.139:8080, 123.207.239.114:8082, 66.175.209.253:8090, 66.175.209.38:8090, 173.255.223.210:8090, 14.29.118.239:20000, 70.142.24.61:8080, 3.87.173.6:8001, 47.107.106.243:20000, 101.201.117.191, 118.190.215.162, 116.203.141.150:8080, 58.250.149.11:8085, 3.88.123.255, 173.255.216.58:8090, 14.139.13.78:8080, 54.149.94.198, 142.93.183.248:8082, 216.47.157.209:8090, 202.202.240.113:7777, 198.101.238.25:8080, 52.66.72.8:8888, 92.243.20.10:8081, 23.239.23.20:8090, 39.107.94.23:8888, 79.137.82.228:8083, 120.55.191.189:8010, 52.21.16.23:8080]}
```

## Update Log

2020-04-27

    - Fixing security holes

2020-01-04

    - Fixing security holes

2019-06-12

    - Add Chinese document

2019-06-11

    - change developer
    - delete hutool