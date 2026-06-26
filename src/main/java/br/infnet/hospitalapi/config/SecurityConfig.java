package br.infnet.hospitalapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilitado para facilitar testes de APIs RESTful externos
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/health").permitAll() // Endpoint público exigido pela rubrica
                        .anyRequest().authenticated() // Todos os outros endpoints exigem autenticação básica
                )
                .httpBasic(Customizer.withDefaults()); // Autenticação HTTP Basic ativa

        return http.build();
    }
}