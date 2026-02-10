package com.example.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/h2-console/**").permitAll()
                .requestMatchers("/usuario/**").hasRole("ADMIN")
                .requestMatchers("/evento/**").hasAnyRole("ADMIN", "USER")

                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .permitAll()
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error")
            )
            .logout(logout -> logout
                .permitAll()
                .logoutSuccessUrl("/login?logout")
            )
            .userDetailsService(userDetailsService)
            .csrf(csrf -> csrf.disable())  // temporal
            .headers(headers -> headers.frameOptions(fo -> fo.disable()));

        return http.build();
    }
}

