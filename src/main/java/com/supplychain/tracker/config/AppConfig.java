package com.supplychain.tracker.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "myconfig.hikari", ignoreUnknownFields = false)
    public HikariConfig getHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public HikariDataSource getDataSource() {
        return new HikariDataSource(getHikariConfig());
    }

}
