package com.mypro.demo.oauth_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class OauthAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthAuthApplication.class, args);
    }

}
