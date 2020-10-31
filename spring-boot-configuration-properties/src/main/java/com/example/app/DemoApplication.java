package com.example.app;

import com.example.app.properties.MqttProperties;
import com.example.app.properties.SpringMainProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "com.example.app.properties")
@SpringBootApplication
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

        SpringMainProperties springMainProperties = applicationContext.getBean(SpringMainProperties.class);
        Assert.notNull(springMainProperties, "Not found bean of SpringMainProperties");
        logger.info("Banner Mode : {}", springMainProperties.getBannerMode());

        MqttProperties mqttProperties = applicationContext.getBean(MqttProperties.class);
        Assert.notNull(mqttProperties, "Not found bean of MqttProperties");
        logger.info("MQTT Username : {}", mqttProperties.getHostname());
        logger.info("MQTT Port : {}", mqttProperties.getPort());
        logger.info("MQTT Auth : {}", mqttProperties.getAuth());
    }

}
