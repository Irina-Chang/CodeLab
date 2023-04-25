package br.com.codelab.regescweb.controllers;


        import br.com.codelab.regescweb.dto.RequisicaoFormCurso;
        import br.com.codelab.regescweb.models.Curso;
        import br.com.codelab.regescweb.models.TipoCurso;
        import br.com.codelab.regescweb.repositories.CursoRepository;
        import jakarta.validation.Valid;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.servlet.ModelAndView;
        import java.util.List;


@RequestMapping(value = "/cursos")
@Controller
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;


    @GetMapping("") // visualizar a lista de cursos no banco
    public ModelAndView index (){
        List<Curso> cursos = this.cursoRepository.findAll();
        ModelAndView mv = new ModelAndView("cursos/index");
        mv.addObject("cursos" , cursos);
        return mv;
    }

    //adicionando um novo curso
    @GetMapping("/new")
    public ModelAndView nnew(RequisicaoFormCurso requisicao){
        ModelAndView mv = new ModelAndView("cursos/new");
        mv.addObject("listaTipoCurso", TipoCurso.values());
        return mv;
    }

    @PostMapping("")
    public ModelAndView create(@Valid RequisicaoFormCurso requisicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            ModelAndView mv = new ModelAndView("cursos/new");
            mv.addObject("listaTipoCurso", TipoCurso.values());
            return mv;
        } else {

            Curso curso = requisicao.toCurso();
            this.cursoRepository.save(curso);

            return new ModelAndView("redirect:/cursos" + curso.getId());
        }
    }

    /*

    @GetMapping ("/{id}")
    public ModelAndView show(@PathVariable Long id) {
        //System.out.println("*******ID: " + id);

        Optional<Professor> optional = this.professorRepository.findById(id);

        if (optional.isPresent()) {
            Professor professor = optional.get();

            ModelAndView mv = new ModelAndView("professores/show");
            mv.addObject("professor", professor);
            return mv;

        }
        //se nao encontrou o registro na tabela com o id requerido
        else {
            System.out.println("***$$$ Nao achou o professor de id" + id + "$$$");
            return this.retornaErroProfessor("SHOW ERROR: Professor #" + id + " não encontrado no banco!");
        }
    }
     */
}

