package com.example.app.properties;

import org.springframework.boot.Banner;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.main")
public class SpringMainProperties {
    private boolean logStartupInfo;
    private Banner.Mode bannerMode;

    public void setBannerMode(Banner.Mode bannerMode) {
        this.bannerMode = bannerMode;
    }

    public Banner.Mode getBannerMode() {
        return bannerMode;
    }

    public void setLogStartupInfo(boolean logStartupInfo) {
        this.logStartupInfo = logStartupInfo;
    }

    public boolean isLogStartupInfo() {
        return logStartupInfo;
    }
}
