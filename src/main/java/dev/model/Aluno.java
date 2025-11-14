package dev.model;


import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Aluno(Long id, String nome, boolean mulher) {
        this.id = id;
        this.nome = nome;
        this.mulher = mulher;
    }

    public Aluno() {}
}
