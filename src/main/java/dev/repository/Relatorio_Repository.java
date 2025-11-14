package dev.repository;

import dev.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Relatorio_Repository extends JpaRepository<Relatorio, Long> {
    List<Relatorio> findByAlunoId(Long alunoId);
}