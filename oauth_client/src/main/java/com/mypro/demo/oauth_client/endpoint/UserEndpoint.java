package com.mypro.demo.oauth_client.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@EnableOAuth2Sso
public class UserEndpoint {
    @GetMapping(value = "/userxxx/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return String.format("resource server user: %s\n", name);
    }

    // sso测试接口
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        log.info("auth : {}", authentication);
        return authentication;

    }
}
