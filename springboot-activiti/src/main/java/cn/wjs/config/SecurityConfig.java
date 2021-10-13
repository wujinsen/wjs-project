package cn.wjs.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll().and().logout().permitAll()//配置不需要登录验证
                .and().headers().frameOptions().sameOrigin() // 解决  frame because it set 'X-Frame-Options' to 'deny'
                .and().csrf().disable(); //关闭跨站请求伪造
    }

}
