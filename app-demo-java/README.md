
This project is a Java Spring Boot application. Tech stack includes :
- `JDK 11`
- `SpringBoot2.7`
- `JPA`
- `Elastic Apm Agent`

Before Launching the application, please install `JDK 11` in local in advance. And the Elastic APM, Mysql and Redis should be ready.

Launching command : 
```
./gradlew bootRun
```

It is success if you see the message regarding to connect to Elastic APM Server.
```
.ApmServerHealthChecker - Elastic APM server is available: {  "build_date": "2022-11-24T04:31:09Z",  "build_sha": "311a5edd33673721ad8be4c538635b4d22adeb88",  "publish_ready": true,  "version": "7.17.8"}
```