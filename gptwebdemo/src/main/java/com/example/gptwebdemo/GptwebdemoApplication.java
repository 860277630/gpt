package com.example.gptwebdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.gptwebdemo.dao")//是mapper接口，而不是映射文件
public class GptwebdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GptwebdemoApplication.class, args);
    }

}
