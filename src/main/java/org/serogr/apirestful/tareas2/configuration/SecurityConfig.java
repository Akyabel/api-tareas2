package org.serogr.apirestful.tareas2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain cadenaDeFiltros(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults()). //tener una autorizacion basica por defaul
                authorizeHttpRequests((authz) -> authz.requestMatchers("/autenticacion/**").permitAll()
                .anyRequest().authenticated()); //cualquier petición debe estar autenticada
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager crearUsuario() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Leonardo")
                .password("123leo")
                .roles("USER")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("Liliana")
                .password("123Pass")
                .roles("USER")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("Sebastian")
                .password("123Pasw")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(List.of(user,user2, user3));
    }
}
