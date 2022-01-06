package com.fleta.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정하겠다
                .antMatchers("/api/user/signup").permitAll() // 이 주소에 대한 요청은 인증없이 접근을 허용하겠다
                .antMatchers("/api/user/login").permitAll() // 이 주소에 대한 요청은 인증없이 접근을 허용하겠다
                .antMatchers("/api/user/**").hasRole("USER")
                .antMatchers("/api/manager/**").hasRole("MANAGER")
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated(); // 나머지 요청들에 대해서는 인증이 필요하다
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
