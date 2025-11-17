package dev.service;

import dev.model.Aluno;
import dev.model.Relatorio;
import dev.repository.Aluno_Repository;
import dev.repository.Relatorio_Repository;
import dev.dto.RelatorioDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Relatorio_service {

    private final Relatorio_Repository relatorioRepository;
    private final Aluno_Repository alunoRepository;

    public Relatorio_service(Relatorio_Repository relatorioRepository, Aluno_Repository alunoRepository) {
        this.relatorioRepository = relatorioRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Relatorio> findAll() {
        return relatorioRepository.findAll();
    }

    public Relatorio save(RelatorioDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAluno_id())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + dto.getAluno_id()));

        Relatorio relatorio = new Relatorio();
        relatorio.setAluno(aluno);
        relatorio.setObservacao(dto.getObservacao());
        relatorio.setRepertorio(dto.getRepertorio());
        relatorio.setEscalas(dto.getEscalas());
        relatorio.setDia(dto.getDia());

        return relatorioRepository.save(relatorio);
    }

    public List<Relatorio> findByAlunoId(Long alunoId) {
        return relatorioRepository.findByAlunoId(alunoId);
    }

    public Relatorio findById(Long id) {
        return relatorioRepository.findById(id).orElse(null);
    }

    @Transactional
    public void updatePartial(Long id, RelatorioDTO dto) {

        Relatorio relatorio = relatorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relatório não encontrado: " + id));

        boolean mudou = false;

        if (dto.getAluno_id() != null) {
            Aluno aluno = alunoRepository.findById(dto.getAluno_id())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado: " + dto.getAluno_id()));

            if (relatorio.getAluno() == null || !relatorio.getAluno().getId().equals(dto.getAluno_id())) {
                relatorio.setAluno(aluno);
                mudou = true;
            }
        }

        if (dto.getObservacao() != null && !dto.getObservacao().equals(relatorio.getObservacao())) {
            relatorio.setObservacao(dto.getObservacao());
            mudou = true;
        }

        if (dto.getRepertorio() != null && !dto.getRepertorio().equals(relatorio.getRepertorio())) {
            relatorio.setRepertorio(dto.getRepertorio());
            mudou = true;
        }

        if (dto.getEscalas() != null && !dto.getEscalas().equals(relatorio.getEscalas())) {
            relatorio.setEscalas(dto.getEscalas());
            mudou = true;
        }

        if (dto.getDia() != null && !dto.getDia().equals(relatorio.getDia())) {
            relatorio.setDia(dto.getDia());
            mudou = true;
        }

        if (mudou) {
            relatorioRepository.save(relatorio);
        }
    }

    public void delete(Long id) {
        relatorioRepository.deleteById(id);
    }
}

