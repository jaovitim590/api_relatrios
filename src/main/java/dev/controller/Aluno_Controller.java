package dev.controller;


import dev.dto.AlunoDTO;
import dev.model.Aluno;
import dev.service.Aluno_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class Aluno_Controller {

    private final Aluno_Service service;
    public Aluno_Controller(Aluno_Service service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAluno(@PathVariable Long id) {
        try {
            Aluno aluno = service.findById(id); // já retorna o objeto ou lança RuntimeException
            return ResponseEntity.ok(aluno);
        } catch (Exception e) {
            e.printStackTrace(); // vai aparecer no log do servidor
            return ResponseEntity.status(500).body("Erro ao buscar aluno: " + e.getMessage());
        }
    }

    @PostMapping("/salvar")
    public Aluno save(@RequestBody Aluno aluno) {
        return service.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PatchMapping("/update/{id}")
    public void atualizarParcial(@PathVariable Long id, @RequestBody AlunoDTO dto) {
        service.updatePartial(id, dto);
    }
}
