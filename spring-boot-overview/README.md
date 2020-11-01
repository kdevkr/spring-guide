# Spring Boot Overview
Spring Boot 2 has many changes.  
First, Spring Boot 2 uses Spring 5! so, You need to learn about Spring 5 new features.

## System Requirements
- Java 1.8+
- Gradle 6.3+
- Undertow 2.0+ (or Tomcat 9.0+)

Spring Boot 2.1+ support [`Java 11`](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes#java-11-support). so, you should be uses Spring Boot 2.1+ to use JDK 11.

## Managing Dependencies
You can manage dependencies for your application using `io.spring.dependency-management ` plugin. 

```groovy 
plugins {
    id 'org.springframework.boot' version '2.3.5.RELEASE'
    id 'io.spring.dependency-management' version '1.0.10.RELEASE'
}
```

## Production Features

### Customizing Properties
you can customize application properties at run. 

The priority is as follows:
- JVM Options: `-Dspring.main.banner-mode=off`
- Environment Variables : `SPRING_MAIN_BANNERMODE=OFF`
- Program Arguments : `--spring.main.banner-mode=off`

read more details as [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config).

### Graceful Shutdown
Spring Boot 2.3+ support [graceful shutdown](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/html/spring-boot-features.html#boot-features-graceful-shutdown) for embedded web servers.

When enabled using server.shutdown=graceful, upon shutdown, the web server will no longer permit new requests and will wait for a grace period for active requests to complete.
```properties 
server.shutdown=graceful
spring.lifecycle.timeout-per-shutdown-phase=30s
```

### Spring Boot Actuator
Spring Boot 2.0+ rely on [micrometer.io](https://micrometer.io/). so, you can monitor metrics using `Prometheus`.

`spring-boot-starter-actuator` must be added to use the Spring Boot Actuator.
```groovy
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

### Application Availability
Spring Boot includes out-of-the box support for the commonly used `liveness` and `readiness` availability states.

Spring Boot provides Kubernetes HTTP probes for "Liveness" and "Readiness" with [Actuator Health Endpoints](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/html/production-ready-features.html#production-ready-kubernetes-probes).


## Release Notes
- [Spring Boot 2.0 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes)
- [Spring Boot 2.1 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes)
- [Spring Boot 2.2 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.2-Release-Notes)
- [Spring Boot 2.4 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.4-Release-Notes)
