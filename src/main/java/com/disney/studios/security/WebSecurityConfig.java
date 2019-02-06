package com.disney.studios.security;

/**
 * Created by Hector R Acosta on 2/5/19.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
THIS IS THE WEB SECURITY CONFIG THAT EXTENDS THE FUNCTIONALITY
IMPLEMENTED BY SPRING BOOT.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        /*
        TELL THE FRAMEWORK WHAT WE WANT TO PROTECT AND WHAT SHOULD BE OPEN.
        IF WE WERE TO IMPLEMENT THE FRONTEND, WE MIGH HAVE A LOGIN PAGE
        AND WE CAN REDIRECT TO THAT PAGE FOR THE USER TO AUTHENTICATE.
         */
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/dogs", "/dogs/{id}", "/dogs/pictures").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }



    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
