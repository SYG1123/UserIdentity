package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// 明确指定实体类包
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan("com.example.entity")
public class UserIdentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserIdentityApplication.class, args);
    }

}
