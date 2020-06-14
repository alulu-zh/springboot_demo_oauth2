package com.mypro.demo.oauth_test.endpoint;

import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {
    @GetMapping("/loginoauth")
    public String getLoginPage(Model model) {
        return "login_oauth";
    }
}
