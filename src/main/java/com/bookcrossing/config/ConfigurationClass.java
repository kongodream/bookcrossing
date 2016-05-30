package com.bookcrossing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import(value = {WebAppConfig.class, OAuth2SecurityConfig.class})
@ComponentScan(basePackages = {"com.bookcrossing", "com.bookcrossing.dataLayer.dao",
        "com.bookcrossing.serviceLayer.service", "com.bookcrossing.dataLayer.entity"})
public class ConfigurationClass {
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}