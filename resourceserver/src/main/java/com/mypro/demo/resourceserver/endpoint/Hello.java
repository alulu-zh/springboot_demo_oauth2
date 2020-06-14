package com.mypro.demo.resourceserver.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return String.format("resource server hello world: %s\n", name);
    }
}
