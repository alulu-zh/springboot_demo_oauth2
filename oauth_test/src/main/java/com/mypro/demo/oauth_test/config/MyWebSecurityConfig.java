package com.mypro.demo.oauth_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity(debug = true)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhouhu")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
                .roles("user");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/swagger-resources/configuration/security",
                "/swagger-ui.html"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .requestMatchers()
//                .antMatchers("/login/**")
//                .antMatchers("/login")
//                .antMatchers("/oauth/**", "/api/**")
//                .and()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/login/**", "/oauth/**","/login", "/oauth").permitAll()
                .anyRequest().authenticated()
                .and()
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

//    @Override
    protected void configure2(HttpSecurity http) throws Exception {
        http
//                .httpBasic().disable()
//                .formLogin(AbstractHttpConfigurer::disable)
                .requestMatchers().antMatchers("/oauth/**", "/actuator/**", "/login/**", "/login")
                .and().formLogin().permitAll()
                .and()
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/oauth/**", "/actuator/**", "/login/**", "/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin().permitAll()
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .oauth2ResourceServer(oauth2ResourceServer ->
//                        oauth2ResourceServer.jwt(jwt ->
//                                jwt.jwtAuthenticationConverter(jwtDecoder())));
                .and()
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
    }
}
