package com.kayuni.monitorlizard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World!";
    }
}
