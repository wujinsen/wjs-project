package cn.wjs.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.wjs.mapper")
public class MybatisPlusConfig {
}
