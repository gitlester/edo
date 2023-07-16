package com.itmy.edo;



import cn.licoy.encryptbody.annotation.EnableEncryptBody;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableEncryptBody
@SpringBootApplication
@EnableSwagger2WebMvc
@MapperScan("com.itmy.edo.dao.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
