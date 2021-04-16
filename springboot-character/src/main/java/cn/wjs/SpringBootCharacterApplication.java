package cn.wjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan("cn.wjs.mapper")
@SpringBootApplication
public class SpringBootCharacterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCharacterApplication.class, args);
    }
}
