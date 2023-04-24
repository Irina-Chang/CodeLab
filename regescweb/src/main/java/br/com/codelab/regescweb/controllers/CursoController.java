package br.com.codelab.regescweb.controllers;


import br.com.codelab.regescweb.models.Curso;
import br.com.codelab.regescweb.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping(value = "/cursos")
@Controller
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @GetMapping("")
    public ModelAndView index (){
        List<Curso> cursos =this.cursoRepository.findAll();
        ModelAndView mv = new ModelAndView("cursos/index");
        mv.addObject("cursos" , cursos);
        return mv;
    }
}
