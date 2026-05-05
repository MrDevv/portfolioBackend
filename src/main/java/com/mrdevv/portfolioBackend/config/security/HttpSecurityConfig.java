package com.mrdevv.portfolioBackend.config.security;

import com.mrdevv.portfolioBackend.config.security.filters.ApiKeyAuthenticationFilter;
import com.mrdevv.portfolioBackend.config.security.filters.JwtAuthenticationFilter;
import com.mrdevv.portfolioBackend.config.security.handler.CustomAuthenticationEntryPoint;
import com.mrdevv.portfolioBackend.config.security.handler.CustomDeniedEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final ApiKeyAuthenticationFilter apiKeyAuthenticationFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomDeniedEntryPoint customDeniedEntryPoint;

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessManagement -> sessManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(excep -> {
                    excep.authenticationEntryPoint(customAuthenticationEntryPoint);
                    excep.accessDeniedHandler(customDeniedEntryPoint);
                })
                .cors(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .addFilterAfter(apiKeyAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    requests.requestMatchers(HttpMethod.GET, "/admin/usuarios").hasAnyRole("admin");

                    requests.anyRequest().authenticated();
                })
                .build();

    }
}
