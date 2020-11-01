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

## Release Notes
- [Spring Boot 2.0 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes)
- [Spring Boot 2.1 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes)
- [Spring Boot 2.2 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.2-Release-Notes)
- [Spring Boot 2.4 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.4-Release-Notes)
