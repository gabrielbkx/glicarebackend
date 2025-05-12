package com.glicarebackend.glicare.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**","/teste").permitAll() // Libera o acesso ao H2 Console
                        .anyRequest().authenticated() // Mantém segurança para outras rotas
                )
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para o H2
                .headers(headers -> headers.frameOptions().disable()); // Permite frames

        return http.build();
    }


}
