package dev.dto;

public class AlunoDTO {
    private Long id;
    private String nome;
    private boolean mulher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMulher() {
        return mulher;
    }

    public void setMulher(boolean mulher) {
        this.mulher = mulher;
    }
}
