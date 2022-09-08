package com.moli.clickhouse;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moli.clickhouse.mapper")
public class ClickHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClickHouseApplication.class, args);
    }
}
