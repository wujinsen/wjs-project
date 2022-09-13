package com.moli.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySources({
        @NacosPropertySource(dataId = "nacos-demo", autoRefreshed = true),
        @NacosPropertySource(dataId = "user-center.yml", autoRefreshed = true)}
)
public class NacosDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }
}
