package com.javakun.cafisspringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private CustomAuthenticationProvider customAuthProvider;
    @Autowired
    private BasicAuthFilter basicAuthFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(customAuthProvider)
                .authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.addFilterBefore(basicAuthFilter, UsernamePasswordAuthenticationFilter.class);
        http.httpBasic(withDefaults());
        http.csrf().disable();
        return http.build();
    }
}
