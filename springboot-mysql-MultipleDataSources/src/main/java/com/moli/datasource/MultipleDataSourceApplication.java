package com.moli.datasource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moli.datasource.mapper")
public class MultipleDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourceApplication.class, args);
    }
}
