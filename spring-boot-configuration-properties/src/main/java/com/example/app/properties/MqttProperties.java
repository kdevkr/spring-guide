package com.example.app.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Configuration Properties for Mosquitto
 */
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

    /**
     * Mosquitto Username and Password Authentication
     */
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
