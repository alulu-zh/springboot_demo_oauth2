package com.mypro.demo.oauth_login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {
    @GetMapping(value = "/user/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return String.format("resource server user: %s\n", name);
    }
}
