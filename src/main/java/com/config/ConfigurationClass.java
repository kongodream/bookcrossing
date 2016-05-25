package com.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import(value = {WebAppConfig.class, OAuth2SecurityConfig.class})
@ComponentScan(basePackages = {"com", "com.dataLayer.dao", "com.serviceLayer.service", "com.dataLayer.entity"})
public class ConfigurationClass {
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

