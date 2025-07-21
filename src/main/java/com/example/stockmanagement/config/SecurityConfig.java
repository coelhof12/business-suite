package com.example.stockmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF for now
                .authorizeHttpRequests(auth -> auth
                        // Allow GET requests for Alerts to both USER and ADMIN
                        .requestMatchers(HttpMethod.GET, "/api/alerts/**").hasAnyRole("ADMIN", "USER")
                        // Restrict POST, PUT, DELETE requests for Alerts to ADMIN only
                        .requestMatchers(HttpMethod.POST, "/api/alerts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/alerts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/alerts/**").hasRole("ADMIN")
                        // Allow GET requests for USER and ADMIN for other endpoints
                        .requestMatchers(HttpMethod.GET, "/api/clients/**", "/api/suppliers/**", "/api/inventory-items/**", "/api/client-preferences/**").hasAnyRole("ADMIN", "USER")
                        // Restrict POST, PUT, DELETE requests for other endpoints to ADMIN only
                        .requestMatchers(HttpMethod.POST, "/api/clients/**", "/api/suppliers/**", "/api/inventory-items/**", "/api/client-preferences/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/clients/**", "/api/suppliers/**", "/api/inventory-items/**", "/api/client-preferences/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/clients/**", "/api/suppliers/**", "/api/inventory-items/**", "/api/client-preferences/**").hasRole("ADMIN")
                        .anyRequest().authenticated() // Authenticate all other requests
                )
                .httpBasic(httpBasic -> {}); // Use correct httpBasic syntax
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // Create users with roles
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("user123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}