# fofa-java

[![GitHub (pre-)release](https://img.shields.io/github/release/0nise/fofa-java/all.svg)](https://github.com/0nise/fofa-java/releases)
[![stars](https://img.shields.io/github/stars/0nise/fofa-java.svg)](https://github.com/0nise/fofa-java/stargazers)
[![license](https://img.shields.io/github/license/0nise/fofa-java.svg)](https://github.com/0nise/fofa-java/blob/master/LICENSE)

[中文文档](https://github.com/0nise/fofa-java/blob/master/README_zh.md)

## FOFA Pro API
[`FOFA Pro API`](https://fofa.info/api) is an asset search engine [`FOFA Pro`](https://fofa.info) provides a `RESTful API` interface for developers, allowing developers to integrate [`FOFA Pro`](https://fofa.info) functionality into their projects.
## FOFA SDK
A `Java` version of the `SDK`, based on the [`FOFA Pro API`](https://fofa.info/api), makes it easy for Java developers to quickly integrate [`FOFA Pro`](https://fofa.info) into their projects.

## Apache Maven

```java
<dependency>
  <groupId>com.r4v3zn.fofa</groupId>
  <artifactId>fofa-core</artifactId>
  <version>1.0.7.RELEASE</version>
</dependency>
```

## USE

|field|description|
|:---------:|:-----------------:|
| `email` |User login [`FOFA Pro`](https://fofa.info) mailbox `Email`|
|`key`| Please go to the [`personal center`](https://fofa.info/user/users/info) to view `API Key`|

### User info

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

### Search all

#### Code

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

#### Response

```java
FofaData{mode='extended', page=1, size=74, totalPage=1, query='host="fofa.info"', results=[www.fofa.info, fofa.info, static.fofa.info, https://static.fofa.info, https://fofa.info, api.fofa.info, api.jw.fofa.info:7088, api.g.fofa.info:88, api.jw.fofa.info:88, api.g.fofa.info:8084, api.jw.fofa.info:84, api.jw.fofa.info:81, api.jw.fofa.info:8003, api.g.fofa.info:8083, api.g.fofa.info:7088, api.g.fofa.info:808, https://g.fofa.info, api.jw.fofa.info:8181, https://jw.fofa.info, api.g.fofa.info:8003, api.jw.fofa.info:8083, https://img.gamma.fofa.info, api.g.fofa.info:81, api.g.fofa.info:7070, api.jw.fofa.info:8084, api.jw.fofa.info:808, api.g.fofa.info:8181, api.jw.fofa.info:7070, img.gamma.fofa.info, jw.fofa.info, g.fofa.info, api.g.fofa.info:84, https://35.81.36.22:443, 47.93.92.246:88, https://140.249.61.184:443, 47.93.92.246:808, 47.93.92.246:8003, 47.93.92.246:81, https://106.75.10.35:443, 106.75.10.35:80, 47.93.92.246:7088, 47.93.92.246:84, 140.249.61.184:80, 47.93.92.246:8181, 47.93.92.246:8084, 47.93.92.246:88, 47.93.92.246:7070, 47.93.92.246:81, 47.93.92.246:7070, 47.93.92.246:84, 47.93.92.246:8084, 47.93.92.246:8003, 47.93.92.246:8083, 106.75.10.35:80, 47.93.92.246:808, 47.93.92.246:8083, 47.93.92.246:8181, 47.93.92.246:7088, https://gamma.fofa.info, https://api.gamma.fofa.info, gamma.fofa.info, api.gamma.fofa.info, 1.71.148.8:80, https://1.71.148.8:443, https://79.168.42.251:443, 122.143.5.67:80, https://api.fofa.info, 81.150.11.126:22, www.fofa.info:6443, 117.50.16.112:80, 150.138.167.141:6443, 117.50.16.112:80, https://117.50.16.112:443, https://117.50.16.112:443]}
```

### Search Next

#### Code

```java
public static void main(String[] args) throws Exception {
    String email = "";
    String key = "";
    String next = "";
    do {
        NextSearchData nextSearchData = fofaSearch.next(query, 10, next);
        next = nextSearchData.getNext();
        System.out.println(nextSearchData);
    }while (!next.equals(""));
}
```

#### Response

```java
NextSearchData{id='', next='bNai42Yutz9aDvtcJZNINJtNTnjQMomzzEw7jRfUpyUnp2DhrzjSvQ==', mode='extended', size=95, query='host="fofa.info"', results=[[https://en.fofa.info], [https://static.fofa.info], [https://fofa.info], [www.fofa.info], [https://www.fofa.info], [static.fofa.info], [https://fofa.info], [https.fofa.info.com:2095], [fofa.info.w.cdngslb.com], [https://fofa.info.com]]}
NextSearchData{id='bNai42Yutz9aDvtcJZNINJtNTnjQMomzzEw7jRfUpyUnp2DhrzjSvQ==', next='s62gnkaSJ4XNO0hAkm8tid681t3rklCsQ5Gg0RyuZQiMM+NK/tTm6L5kUW4gFjle', mode='extended', size=95, query='host="fofa.info"', results=[[fofa.info.com], [www.fofa.info.com], [https://hub.fofa.info], [fofa.info], [store.fofa.info], [https://store.fofa.info], [g.fofa.info.com], [https.fofa.info.com:8080], [https.www.fofa.info.com:8080], [https.g.fofa.info.com:8080]]}
NextSearchData{id='s62gnkaSJ4XNO0hAkm8tid681t3rklCsQ5Gg0RyuZQiMM+NK/tTm6L5kUW4gFjle', next='etvYNZ6GjvEt+dYAdTeG2Pa0Ps23B19+', mode='extended', size=95, query='host="fofa.info"', results=[[hub.fofa.info], [https://xgbeta.fofa.info], [https://staticbeta1.fofa.info], [https://apibeta1.fofa.info], [https://static.beta.fofa.info], [jingyong.fofa.info.w.kunlunaq.com], [sywx7xh5at8jwbjd2314.fofa.info:22703], [octra.fofa.info], [https://octra.fofa.info], [fofa.info]]}
NextSearchData{id='etvYNZ6GjvEt+dYAdTeG2Pa0Ps23B19+', next='2BKdnOmtGdsRW629/r/pEUGQTD5VCnoj7rBM4ldM++U=', mode='extended', size=95, query='host="fofa.info"', results=[[img.gamma.fofa.info.w.kunlunaq.com], [fofa.info.com:8443], [www.fofa.info.ucloud.com.cn], [https://www.fofa.info.ucloud.com.cn], [hub-beta.fofa.info], [www.fofa.info.com:2052], [www.fofa.info.com:2082], [www.fofa.info.com:2082], [www.fofa.info.com:2052], [gamma.fofa.info]]}
NextSearchData{id='2BKdnOmtGdsRW629/r/pEUGQTD5VCnoj7rBM4ldM++U=', next='XdYO3aCmd4rNIFHKpukZ0UWiVlk+88BlNQd3XwODAn81qP9TZJRKvw==', mode='extended', size=95, query='host="fofa.info"', results=[[api.fofa.info], [https://api.fofa.info], [static.fofa.info.ucloud.com.cn], [static.fofa.info.ugslb.net], [https://api.gamma.fofa.info], [api.gamma.fofa.info], [https://gamma.fofa.info], [test.fofa.info], [https://enstatic.fofa.info], [g.static.fofa.info]]}
NextSearchData{id='XdYO3aCmd4rNIFHKpukZ0UWiVlk+88BlNQd3XwODAn81qP9TZJRKvw==', next='vM1eHkV9QcVrETNs1jVOKnxyDvgaAZU+aW27pA2phhMWv5NsAAbAlQ==', mode='extended', size=95, query='host="fofa.info"', results=[[https://jw.fofa.info], [g.fofa.info], [bas.dev.fofa.info], [https://g.fofa.info], [en.fofa.info], [pay.fofa.info], [https://s.fofa.info], [amap.fofa.info], [https://pay.fofa.info], [https://api.jw.fofa.info]]}
NextSearchData{id='vM1eHkV9QcVrETNs1jVOKnxyDvgaAZU+aW27pA2phhMWv5NsAAbAlQ==', next='/VdyKmYDCDzEtgaweqfHrfaxjX+VkxT+aHhwUphDovw=', mode='extended', size=95, query='host="fofa.info"', results=[[api.g.fofa.info], [https://hub-beta.fofa.info], [test.fofa.info], [www.fofa.info.com:8080], [g.fofa.info.com:8080], [s.fofa.info], [https://static.fofa.info.ugslb.net], [api.jw.fofa.info], [https://static.fofa.info.ucloud.com.cn], [https://s.fofa.info]]}
NextSearchData{id='/VdyKmYDCDzEtgaweqfHrfaxjX+VkxT+aHhwUphDovw=', next='F7TClzEIX5lAp3cm+N4Pcw8BZA94H/EDNntF4Fs4yU5sXPcf41OTYg==', mode='extended', size=95, query='host="fofa.info"', results=[[https://apibeta.fofa.info], [https://enbeta.fofa.info], [https://staticbeta.fofa.info], [https://enstaticbeta.fofa.info], [https://beta.fofa.info], [fofa.info.storage.googleapis.com], [https://fofa.info.storage.googleapis.com], [https://download.fofa.info], [download.fofa.info], [https://bas.dev.fofa.info]]}
NextSearchData{id='F7TClzEIX5lAp3cm+N4Pcw8BZA94H/EDNntF4Fs4yU5sXPcf41OTYg==', next='dlxsxU9fT/o/3y+SrKJ5K6mXZQ6AsfjXrj30r9CdgGMoOmsE66wiAwg5ZuAOCa6e', mode='extended', size=95, query='host="fofa.info"', results=[[img.gamma.fofa.info], [https://img.gamma.fofa.info], [https://api.g.fofa.info], [https://zh.fofa.info], [zh.fofa.info], [https://zhstatic.fofa.info], [zhstatic.fofa.info], [jw.fofa.info], [https://amap.fofa.info], [https://g.static.fofa.info]]}
NextSearchData{id='dlxsxU9fT/o/3y+SrKJ5K6mXZQ6AsfjXrj30r9CdgGMoOmsE66wiAwg5ZuAOCa6e', next='', mode='extended', size=95, query='host="fofa.info"', results=[[enstatic.fofa.info], [https://fofa.info.ucloud.com.cn], [fofa.info.ucloud.com.cn], [download.fofa.info], [https://download.fofa.info]]}
```

### Search stats agg

#### Code

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

#### Response

```java
StatsData{distinct={ip=16}, aggs={countries=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJDTiI=, count=71, name=China, name_code=CN, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IkJlaWppbmci, count=41, name=Beijing}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IiI=, count=27, name=Unknown}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249Ikd1YW5nZG9uZyI=, count=2, name=Guangdong}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IkppbGluIg==, count=1, name=Jilin}]}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJHQiI=, count=1, name=United Kingdom of Great Britain and Northern Ireland, name_code=GB, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249IiI=, count=1, name=Unknown}]}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJQVCI=, count=1, name=Portugal, name_code=PT, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249Ikxpc2JvbiI=, count=1, name=Lisbon}]}, {code=aG9zdD0iZm9mYS5pbmZvIiAmJiBjb3VudHJ5PSJVUyI=, count=1, name=United States of America, name_code=US, regions=[{code=aG9zdD0iZm9mYS5pbmZvIiAmJiByZWdpb249Ik9yZWdvbiI=, count=1, name=Oregon}]}]}}
```

### Host Agg

#### Code

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

#### Response

```
HostData{host='fofa.info', ip='124.239.250.54', asn=58539, org='null', countryName='China', countryCode='CN', protocol=[http, https, ssh], port=[443, 22, 8080, 9527, 8069, 8089, 80], category=null, product=null}
```

## Update Log

2023-08-27

```
- add search after api
```

2022-05-29

```
- add search stats api
- add host api
- add search fields
- Update jackson version
- fix bug
```

2022-01-27

    - update fofa

2021-07-26

    - Update jackson version

2020-04-27

    - Fixing security holes

2020-01-04

    - Fixing security holes

2019-06-12

    - Add Chinese document

2019-06-11

    - change developer
    - delete hutool