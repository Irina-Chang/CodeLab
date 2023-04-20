package br.com.codelab.regescweb.controllers;

import br.com.codelab.regescweb.models.Professor;
import br.com.codelab.regescweb.models.StatusProfessor;
import br.com.codelab.regescweb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professores")
    public ModelAndView index(){

        List<Professor> professores = this.professorRepository.findAll();
        ModelAndView mv = new ModelAndView( "professores/index");
        mv.addObject("professores", professores);

        return mv;

    }
}
 /*Professor  garnet = new Professor( "Garnet", new BigDecimal(5000), StatusProfessor.ATIVO);
        garnet.setId(1L);
        Professor perola = new Professor("Perola", new BigDecimal(6000), StatusProfessor.APOSENTADO);
        perola.setId(2L);
        Professor ametista = new Professor("Ametista", new BigDecimal(8000), StatusProfessor.INATIVO);
        ametista.setId(3L);*/