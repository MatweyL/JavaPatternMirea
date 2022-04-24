package com.example.task18.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.task18.repo")
@EnableAspectJAutoProxy
@EnableAsync
public class Config {

//    @Bean
//    public JavaMailSenderImpl javaMailSender() {
//        return new JavaMailSenderImpl();
//    }

}