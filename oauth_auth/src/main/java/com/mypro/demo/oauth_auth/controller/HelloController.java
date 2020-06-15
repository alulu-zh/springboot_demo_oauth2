package com.mypro.demo.oauth_auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@ResponseBody
@Slf4j
public class HelloController {
    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return String.format("oauth_auth server hello world: %s\n", name);
    }
    @GetMapping(value = "/user/me", produces = "application/json")
    public User user(Principal principal) {
        log.info("zhouhuxxx: iam coming user me!!!");
        if (principal != null) {
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
            Authentication authentication = oAuth2Authentication.getUserAuthentication();
            User user = (User) authentication.getPrincipal();
//            Map<String, String> details = new LinkedHashMap<>();
//            details = (Map<String, String>) authentication.getDetails();
//            log.info("details = " + details);  // id, email, name, link etc.
//            Map<String, String> map = new LinkedHashMap<>();
//            map.put("email", details.get("email"));
            return user;
        }
        return null;
    }
}
