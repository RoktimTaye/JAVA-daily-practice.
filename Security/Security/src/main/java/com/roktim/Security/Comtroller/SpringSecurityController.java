package com.roktim.Security.Comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

    @GetMapping
    public String test(){
        return "Hello";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, its Roktim";
    }

    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "We are India's number 1 bank";
    }

    @GetMapping("/contactUs")
    public String contactUs(){
        return "575857583387";
    }
}
