# Spring Boot Configuration Properties
Spring Boot Configuration Properties supports the ability to bind and use values for the properties of a property declared in an application property files.

```groovy build.gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-configuration-processor'
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
}
```

## Enable Configuration Properties
You can activate the Configuration Properties feature by declaring @EnableConfigurationProperties to the SpringApplication. However, you can use Configuration Properties without having to declare Spring Boot 2.2.

```java
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "com.example.app.properties")
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

You can also use @ConfigurationPropertiesScan to specify a package for registering ConfigurationProperties classes as components.

## Type-safe Configuration Properties

### JavaBean properties binding
JavaBean properties binding is only possible for Java standard properties, and cannot be bound for static properties.

You can also validate using `@validated` for properties.

```java
@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {
    @NotEmpty
    private final String hostname;
    @Min(-1)
    private final int port;
    @Valid
    private final Auth auth;

    public MqttProperties(@DefaultValue("172.0.0.1") String hostname, @DefaultValue("1883") int port, Auth auth) {
        this.hostname = hostname;
        this.port = port;
        this.auth = auth;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public Auth getAuth() {
        return auth;
    }

    public static class Auth {
        @NotEmpty
        private String username;
        @NotEmpty
        private String password;

        public Auth() {}

        public Auth(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return String.format("[Username: %s, Password: %s]", username, password);
        }
    }
}
```

If `mqtt.auth.password` is empty in Application Property Files, LoggingFailureAnalysisReporter is print bind error messages on startup.

```
Binding to target org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'mqtt' to com.example.app.properties.MqttProperties failed:

    Property: mqtt.auth.password
    Value: null
    Reason: 비어 있을 수 없습니다
```

### Constructor binding for immutable properties
JavaBean properties bindings uses Getter and Setter, so it has a mutable feature. So, Spring boot support immutable properties, which ensure that the building remains unchanged.

To configure ConfigurationProperties by declaring @ConstructorBinding, you must register ConfigurationProperties through @EnableConfigurationProperties or @ConfigurationPropertiesScans.

```java
@EnableConfigurationProperties({MqttProperties.class})
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

## Relaxed Binding
Spring Boot uses some [relaxed rules](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-relaxed-binding) for binding Environment properties to @ConfigurationProperties beans, so there does not need to be an exact match between the Environment property name and the bean property name.

### Binding from Environment Variables
Spring Boot’s relaxed binding rules are, as much as possible, designed to be compatible with these naming restrictions.

To convert a property name in the canonical-form to an environment variable name you can follow these rules:

- Replace dots (.) with underscores (_).
- Remove any dashes (-).
- Convert to uppercase.

For example, the configuration property `spring.main.log-startup-info` would be an environment variable named `SPRING_MAIN_LOGSTARTUPINFO`.

![](src/main/resources/images/binding-from-environment-variables.png)

## Properties Conversion

Spring Boot attempts to coerce the external application properties to the right type when it binds to the @ConfigurationProperties beans.
Spring Boot support bindings `java.time.Duration`, `java.time.Period`, `org.springframework.util.unit.DataSize`. If you need custom type conversion, you can provide a `ConversionService` or custom property editors or custom `Converters`.


You can find more detail for `Configuration Properties` from [official spring boot reference](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html).