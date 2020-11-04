# Spring Boot Session Redis
Use this example to integrate a user's session into a spring session to save it to a redis!.

## Session Redis

Add `spring-session-data-redis` and `lettuce-core`.
```groovy
implementation 'org.springframework.session:spring-session-data-redis'
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
```

Set the session store type to redis.
```properties
spring.redis.host=localhost
spring.redis.password=
spring.redis.port=6379

spring.session.store-type=redis
spring.session.redis.flush-mode=immediate
spring.session.redis.namespace=spring:session
spring.session.redis.save-mode=on_set_attribute
spring.session.redis.cleanup-cron=0 * * * * *
```


## Actuator Sessions Endpoint
We can retrieve session information for username.

Add `spring-boot-starter-actuator`.
```groovy 
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

Enable `Sessions` Endpoint and Exposure.
```properties
management.endpoint.sessions.enabled=true
management.endpoints.web.exposure.include=sessions
```

http://localhost:8080/actuator/sessions?username=user
```json
{
  "sessions": [
    {
      "id": "54b90ac3-d179-4bee-a15e-a8638b38e170",
      "attributeNames": [
        "SPRING_SECURITY_CONTEXT"
      ],
      "creationTime": "2020-11-04T14:08:05.133Z",
      "lastAccessedTime": "2020-11-04T14:20:30.079Z",
      "maxInactiveInterval": 1800,
      "expired": false
    },
    {
      "id": "d6ee1943-2cfe-4e87-911e-e7217b020bce",
      "attributeNames": [
        "SPRING_SECURITY_CONTEXT"
      ],
      "creationTime": "2020-11-04T14:03:33.029Z",
      "lastAccessedTime": "2020-11-04T14:05:46.963Z",
      "maxInactiveInterval": 1800,
      "expired": false
    }
  ]
}
```

