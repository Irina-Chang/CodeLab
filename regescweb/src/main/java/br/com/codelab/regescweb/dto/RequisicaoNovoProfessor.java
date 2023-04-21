package br.com.codelab.regescweb.dto;

import br.com.codelab.regescweb.models.Professor;
import br.com.codelab.regescweb.models.StatusProfessor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public class RequisicaoNovoProfessor {


    @NonNull
    @NotBlank
    private String  nome;
    @NonNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal salario;
    private StatusProfessor statusProfessor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public StatusProfessor getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(StatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }


    public Professor toProfessor(){

        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);

        return professor;
    }


    public String toString(){
        return "RequisicaoNovoProfessor {"+
                "nome='"+ nome + '\''+
                ", salario="+salario +
                ", statusProfessor=" + statusProfessor +
                '}';
    }
}