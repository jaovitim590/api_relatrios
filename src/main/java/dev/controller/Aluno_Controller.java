package dev.controller;


import dev.dto.AlunoDTO;
import dev.model.Aluno;
import dev.service.Aluno_Service;
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
    public Aluno findById(Long id) {
        return service.findById(id);
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
