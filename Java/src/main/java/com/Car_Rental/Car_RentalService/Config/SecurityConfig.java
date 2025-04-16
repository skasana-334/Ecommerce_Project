package com.Car_Rental.Car_RentalService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.net.PasswordAuthentication;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain secure(HttpSecurity http) throws Exception{
        http
                .sessionManagement(session->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                //by default spring will store the details in cookies but we don't want to use that we will use tokens in our local db
                .authorizeHttpRequests(Auth-> Auth
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll())
                .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
                //cors is required when our application request data from other website like our backend application request from frontend application of server 4200
                .cors(cors->cors.configurationSource(req->{
                    var corsConfig=new CorsConfiguration();
                    corsConfig.setAllowedOrigins(List.of("https://localhost:4200"));
                    corsConfig.setAllowedMethods(List.of("*"));
                    corsConfig.setAllowCredentials(true);
                    corsConfig.setExposedHeaders(List.of("Authorisation"));
                    //setMaxAge is the limit how much time your preflight request(req to check whether connection is safe by browser) is cached by brwoser
//                    corsConfig.setMaxAge(3600L);
                    return corsConfig;
                }));
                return http.build();
    }
    @Bean
    public PasswordEncoder passEncod(){
        return new BCryptPasswordEncoder();
    }
}
