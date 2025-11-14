package dev.dto;

import java.util.Date;

public class RelatorioDTO {
    private Long aluno_id;
    private Date dia;
    private String observacao;
    private String repertorio;
    private String escalas;

    public Long getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(Long aluno_id) {
        this.aluno_id = aluno_id;
    }

    public String getEscalas() {
        return escalas;
    }

    public void setEscalas(String escalas) {
        this.escalas = escalas;
    }

    public String getRepertorio() {
        return repertorio;
    }

    public void setRepertorio(String repertorio) {
        this.repertorio = repertorio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
}
