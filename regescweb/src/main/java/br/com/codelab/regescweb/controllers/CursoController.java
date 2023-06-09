        package br.com.codelab.regescweb.controllers;


                import br.com.codelab.regescweb.dto.RequisicaoFormCurso;
                import br.com.codelab.regescweb.models.Curso;
                import br.com.codelab.regescweb.models.TipoCurso;
                import br.com.codelab.regescweb.repositories.CursoRepository;
                import jakarta.validation.Valid;
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.dao.EmptyResultDataAccessException;
                import org.springframework.stereotype.Controller;
                import org.springframework.validation.BindingResult;
                import org.springframework.web.bind.annotation.GetMapping;
                import org.springframework.web.bind.annotation.PostMapping;
                import org.springframework.web.bind.annotation.RequestMapping;
                import org.springframework.web.servlet.ModelAndView;
                import org.springframework.web.bind.annotation.PathVariable;
                import org.springframework.web.servlet.ModelAndView;
                import java.util.List;
                import java.util.Optional;


        @RequestMapping(value = "/cursos")
        @Controller
        public class CursoController {

            @Autowired
            private CursoRepository cursoRepository;


            @GetMapping("") // visualizar a lista de cursos no banco
            public ModelAndView index() {

                List<Curso> cursos = this.cursoRepository.findAll();
                ModelAndView mv = new ModelAndView("cursos/index");
                mv.addObject("curso", cursos);
                return mv;
            }

            //adicionando um novo curso
            @GetMapping("/new")
            public ModelAndView nnew(RequisicaoFormCurso requisicao) {
                ModelAndView mv = new ModelAndView("cursos/new");
                mv.addObject("listaTipoCurso", TipoCurso.values());
                return mv;
            }

            @PostMapping("")
            public ModelAndView create(@Valid RequisicaoFormCurso requisicao, BindingResult bindingResult) {
                if (bindingResult.hasErrors()) {
                    System.out.println("Necessario preencher corretamente");

                    ModelAndView mv = new ModelAndView("cursos/new");
                    mv.addObject("listaTipoCurso", TipoCurso.values());
                    return mv;
                } else {
                    Curso curso = requisicao.toCurso();
                    this.cursoRepository.save(curso);
                    return new ModelAndView("redirect:/cursos/" + curso.getId());
                }
            }

            @GetMapping("/{id}")
            public ModelAndView show(@PathVariable Long id) {
                //System.out.println("*******ID: " + id);

                Optional<Curso> optional = this.cursoRepository.findById(id);

                if (optional.isPresent()) {
                    Curso curso = optional.get();

                    ModelAndView mv = new ModelAndView("cursos/show");
                    mv.addObject("curso", curso);
                    return mv;

                } else {

                    return this.retornaErroCurso("SHOW ERROR: Curso #" + id + " não encontrado no banco!");
                }
            }

            @GetMapping("/{id}/edit")
            public ModelAndView edit(@PathVariable Long id, RequisicaoFormCurso requisicao) {
                Optional<Curso> optional = this.cursoRepository.findById(id);

                if (optional.isPresent()) {
                    Curso curso = optional.get();
                    requisicao.fromCurso(curso);

                    ModelAndView mv = new ModelAndView("cursos/edit");
                    mv.addObject("cursoId", curso.getId());
                    mv.addObject("listaTipoCurso", TipoCurso.values());
                    return mv;
                } else {
                    return this.retornaErroCurso("EDIT ERROR: Curso #" + id + "não encontrado no sistema!");
                }
            }

            @PostMapping("/{id}")
            public ModelAndView update(@PathVariable Long id, @Valid RequisicaoFormCurso requisicao, BindingResult bindingResult) {
                if (bindingResult.hasErrors()) {
                    ModelAndView mv = new ModelAndView("cursos/edit");
                    mv.addObject("cursoId");
                    mv.addObject("listaTipoCurso", TipoCurso.values());
                    return mv;
                } else {
                    Optional<Curso> optional = this.cursoRepository.findById(id);

                    if (optional.isPresent()) {
                        Curso curso = requisicao.toCurso(optional.get());
                        this.cursoRepository.save(curso);

                        return new ModelAndView("redirect:/cursos/" + curso.getId());
                    } else {
                        return this.retornaErroCurso("UPDATE ERROR: Curso #" + id + "não encontrado!");
                    }

                }
            }

            @GetMapping("/{id}/delete")
            public ModelAndView delete(@PathVariable Long id) {
                ModelAndView mv = new ModelAndView("redirect:/cursos");

                try {
                    this.cursoRepository.deleteById(id);
                    mv.addObject("mensagem", "Curso #" + id + "deletado com sucesso!");
                    mv.addObject("erro", false);
                } catch (EmptyResultDataAccessException e) {

                mv = this.retornaErroCurso("DELETE ERROR: Curso #" + id + "não encontrado!");
            }
                return mv;

            }

                    private ModelAndView retornaErroCurso(String msg) {
                        ModelAndView mv = new ModelAndView("redirect:/cursos");
                        mv.addObject("mensagem", msg);
                        mv.addObject("erro", true);
                        return mv;
                    }
                }



