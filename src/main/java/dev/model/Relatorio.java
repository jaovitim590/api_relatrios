package dev.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "relatorios")
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    @Temporal(TemporalType.DATE)
    private Date dia;
    @Column(columnDefinition = "TEXT")
    private String observacao;
    @Column(columnDefinition = "TEXT")
    private String repertorio;
    @Column(columnDefinition = "TEXT")
    private String escalas;

    public Relatorio() {}

    public Relatorio(Aluno aluno, Date dia, String observacao, String repertorio, String escalas) {
        this.aluno = aluno;
        this.dia = dia;
        this.observacao = observacao;
        this.repertorio = repertorio;
        this.escalas = escalas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getRepertorio() {
        return repertorio;
    }

    public void setRepertorio(String repertorio) {
        this.repertorio = repertorio;
    }

    public String getEscalas() {
        return escalas;
    }

    public void setEscalas(String escalas) {
        this.escalas = escalas;
    }
}
