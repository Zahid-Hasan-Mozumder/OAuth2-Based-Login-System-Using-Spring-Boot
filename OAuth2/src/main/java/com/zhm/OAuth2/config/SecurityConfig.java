package com.zhm.OAuth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .anyRequest().authenticated()
        ).formLogin(login -> login
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true)
        ).oauth2Login(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
        ).logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
        );

        return http.build();
    }
}
