package com.gemini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication
@MapperScan("com.gemini.common.dao.mapper")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class NecServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NecServerApplication.class, args);
    }
}
