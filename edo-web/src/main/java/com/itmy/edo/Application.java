package com.itmy.edo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SpringBootApplication(scanBasePackages = {"com.itmy.edo.web","com.itmy.edo.dao","com.itmy.edo.service"})
@EnableSwagger2WebMvc
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
