package br.com.codelab.regescweb.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        request.setAttribute(name:"nome", o:"Polenguinho");
        return "hello"; //vai gerar a renderização do arquivo que esta dentro dos templates
    }
}
