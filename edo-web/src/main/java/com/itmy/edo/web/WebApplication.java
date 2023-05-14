package com.itmy.edo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.itmy.edo.web","com.itmy.edo.dao","com.itmy.edo.service"})
@MapperScan({"com.itmy.edo.dao.mapper"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
