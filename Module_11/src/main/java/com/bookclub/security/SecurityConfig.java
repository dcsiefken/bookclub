/*
    Clay Siefken (2024) CIS 530 Server-Side Development. Bellevue Univ.
    Adaptations taken from https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
*/

package com.bookclub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.bookclub.service.impl.MongoBookOfTheMonthDao;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    // https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("P@ssword1!"))
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("P@ssword1!"))
                .roles("USER", "ADMIN")
                .build());
        return manager;
    }

    // https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // configure Spring security to require authenticated users, use a custom login
        // page, and handle user logouts
        http
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/monthly-books/list", "/monthly-books/new", "/monthly-books").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated())
                .formLogin(formLoginConfigurer -> formLoginConfigurer
                        .loginPage("/login")
                        .permitAll())
                .logout(logoutConfigurer -> logoutConfigurer
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .permitAll());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MongoBookOfTheMonthDao mongoBookOfTheMonthDao() {
        return new MongoBookOfTheMonthDao();
    }

}
