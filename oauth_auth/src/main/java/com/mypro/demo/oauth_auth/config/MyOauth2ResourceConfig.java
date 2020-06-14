package com.mypro.demo.oauth_auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//@Configuration
//@EnableResourceServer
public class MyOauth2ResourceConfig extends ResourceServerConfigurerAdapter {
    private AuthenticationManager authenticationManager;

    public MyOauth2ResourceConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .requestMatchers()
//                .antMatchers("/login/**")
//                .antMatchers("/user/**")
//                .antMatchers("/oauth/**")
//                .and()
//                .cors()
//                .and()
                .authorizeRequests()
//                .antMatchers("/login/**", "/oauth/**","/login", "/oauth").permitAll()
                .anyRequest().authenticated()
                .and()
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .formLogin();
//                .and()
//                .csrf().disable();
    }
}
