package com.mypro.demo.oauth_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@ResponseBody
public class HelloController {
    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return String.format("oauth_auth server hello world: %s\n", name);
    }
    @GetMapping(value = "/user/me", produces = "application/json")
    public Principal user(Principal principal) {
        return principal;
    }
}
