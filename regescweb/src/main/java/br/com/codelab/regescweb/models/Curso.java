package br.com.codelab.regescweb.models;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_curso", unique = true, length = 10, nullable = false)
    private String codigoCurso;

    @Column(nullable = false)
    private String nome;

    @Column(name = "descricao", length = 250)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoCurso tipoCurso;

    public Curso(){ }

    public Curso(String codigoCurso, String nome, String descricao,TipoCurso tipoCurso) {
        this.codigoCurso = codigoCurso;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoCurso = tipoCurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }
}
