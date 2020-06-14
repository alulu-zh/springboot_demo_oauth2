package com.mypro.demo.resourceserver.endpoint;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class UserEndpoint {
    @GetMapping(value = "/user/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return String.format("resource server user: %s\n", name);
    }
}
