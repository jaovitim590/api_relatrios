package dev.repository;

import dev.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Aluno_Repository extends JpaRepository<Aluno, Long>{
    @Query("SELECT a FROM Aluno a WHERE a.nome LIKE %:nome%")
    Aluno findByAlunoNome(@Param("nome") String nome);
}
