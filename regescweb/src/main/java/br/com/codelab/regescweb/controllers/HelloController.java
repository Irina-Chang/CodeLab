package br.com.codelab.regescweb.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("hello"); //nome do arquivo html a ser renderizado/exibido
        mv.addObject("nome", "Polenghi");
        return mv; //vai gerar a renderização do arquivo que esta dentro dos templates
    }
}
