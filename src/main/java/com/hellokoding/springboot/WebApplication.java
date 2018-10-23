package com.hellokoding.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    @Bean
    @ConditionalOnProperty(prefix = "config.prefix", name = "name", value = "SOMEVALUE", matchIfMissing = true)
    public BeanOne beanOne() {
        System.out.println("ok");
        return new BeanOne();
    }
    @Bean
    @ConditionalOnProperty(prefix = "config.prefix", name = "name", value = "OTHERVALUE")
    public BeanTwo beanTwo() {
        System.out.println("ok");
        return new BeanTwo();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}

