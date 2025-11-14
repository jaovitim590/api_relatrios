package dev.service;

import dev.dto.AlunoDTO;
import dev.model.Aluno;
import dev.repository.Aluno_Repository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Aluno_Service {
    private final Aluno_Repository repo;
    public Aluno_Service(Aluno_Repository repo) {
        this.repo = repo;
    }
    public List<Aluno> findAll() {
        return repo.findAll();
    }

    public Aluno findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
    }

    public Aluno save(Aluno aluno) {
        return repo.save(aluno);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public long findByname(String nome) {
        nome = nome.trim();
        Aluno aluno  =  repo.findByAlunoNome(nome);
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado: " + nome);
        }
        return aluno.getId();
    }

    @Transactional
    public void updatePartial(Long id, AlunoDTO dto) {

        Aluno aluno = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado: " + id));

        boolean mudou = false;

        if (dto.getNome() != null && !dto.getNome().equals(aluno.getNome())) {
            aluno.setNome(dto.getNome());
            mudou = true;
        }

        if (dto.isMulher() != aluno.isMulher()) {
            aluno.setMulher(dto.isMulher());
            mudou = true;
        }

        if (mudou) {
            repo.save(aluno);
        }
    }

}
