package br.com.codelab.regescweb.controllers;

import br.com.codelab.regescweb.dto.RequisicaoNovoProfessor;
import br.com.codelab.regescweb.models.Professor;
import br.com.codelab.regescweb.models.StatusProfessor;
import br.com.codelab.regescweb.repositories.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView index() {

        List<Professor> professores = this.professorRepository.findAll();
        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professores);

        return mv;

    }

    @GetMapping("/professores/new") //nome do caminho na url
    public ModelAndView nnew(RequisicaoNovoProfessor requisicao) {
        ModelAndView mv = new ModelAndView("professores/new"); //caminho da pasta
        mv.addObject("listaStatusProfessor", StatusProfessor.values());

        return mv;
    }

    @PostMapping("/professores")
    public ModelAndView create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Preencha todos os campos");
            ModelAndView mv = new ModelAndView( "professores/new");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {

            Professor professor = requisicao.toProfessor();
            this.professorRepository.save(professor);

            return new ModelAndView ("redirect:/professores");
        }
    }
}


 /*Professor  garnet = new Professor( "Garnet", new BigDecimal(5000), StatusProfessor.ATIVO);
        garnet.setId(1L);
        Professor perola = new Professor("Perola", new BigDecimal(6000), StatusProfessor.APOSENTADO);
        perola.setId(2L);
        Professor ametista = new Professor("Ametista", new BigDecimal(8000), StatusProfessor.INATIVO);
        ametista.setId(3L);*/