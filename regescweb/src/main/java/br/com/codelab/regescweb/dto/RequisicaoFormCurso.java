package br.com.codelab.regescweb.dto;


import br.com.codelab.regescweb.models.Curso;
import br.com.codelab.regescweb.models.Professor;
import br.com.codelab.regescweb.models.TipoCurso;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

public class RequisicaoFormCurso {


    @NonNull
    @Length(min = 5,max = 5,message = "O codigo deve ter 5 caracteres")
    private String codigoCurso;

    @NonNull
    @NotBlank
    private String nome;


    @Length(min = 0,max = 250)
    private String descricao;

    private TipoCurso tipoCurso;

    @NonNull
    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(@NonNull String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
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

    public Curso toCurso(){ //utiliza o set pq estamos inserindo um dado
        Curso curso = new Curso();
        curso.setCodigoCurso(this.codigoCurso);
        curso.setNome(this.nome);
        curso.setDescricao(this.descricao);
        curso.setTipoCurso(this.tipoCurso);

        return curso;
    }
    public Curso toCurso(Curso curso){
        curso.setCodigoCurso(this.codigoCurso);
        curso.setNome(this.nome);
        curso.setDescricao(this.descricao);
        curso.setTipoCurso(this.tipoCurso);
        return curso;
    }

    public void fromCurso(Curso curso){
        this.codigoCurso = curso.getCodigoCurso();
        this.nome = curso.getNome();
        this.descricao = curso.getDescricao();
        this.tipoCurso = curso.getTipoCurso();
    }

    @Override
    public String toString() {
        return "RequisicaoFormCurso{" +
                "codigoCurso='" + codigoCurso + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipoCurso=" + tipoCurso +
                '}';
    }

}
