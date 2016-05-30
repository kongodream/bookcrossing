package com.bookcrossing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@Import(value = {WebAppConfig.class, OAuth2SecurityConfig.class})
@ComponentScan(basePackages = {"com.bookcrossing", "com.bookcrossing.config", "com.bookcrossing.dataLayer.dao",
        "com.bookcrossing.serviceLayer.service", "com.bookcrossing.dataLayer.entity"})
public class ConfigurationClass {
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

