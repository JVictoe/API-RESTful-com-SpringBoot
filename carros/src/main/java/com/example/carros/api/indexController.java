package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/")
public class indexController {

    @GetMapping()
    public String get () {
        return "get web service springboot";
    }

    @PostMapping("/login")
    public String login (@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return "Login :" + login + ", Senha : " +senha;
    }

}
