package cn.wjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.wjs")
public class NacosMybatisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosMybatisDemoApplication.class, args);
    }
}
