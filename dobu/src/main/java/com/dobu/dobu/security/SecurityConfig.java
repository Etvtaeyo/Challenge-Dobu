
package com.dobu.dobu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // Rotas públicas
                        .requestMatchers(
                                "/login",
                                "/css/**",
                                "/js/**",
                                "/error"
                        ).permitAll()

                        // Rotas exclusivas do veterinário
                        .requestMatchers("/veterinario/**", "/consultas/**", "/usuarios/**", "/historicos/**", "/pagamentos/**", "/prontuarios/**")
                        .hasRole("VETERINARIO")

                        // Rotas exclusivas do dono do pet
                        .requestMatchers("/dono/**", "/pets/**", "/vacinas/**")
                        .hasRole("DONO")

                        // Fluxos compartilhados, mas sempre autenticados
                        .requestMatchers("/agendamentos/**", "/fluxos/**")
                        .hasAnyRole("DONO", "VETERINARIO")

                        // Qualquer outra rota exige login
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
