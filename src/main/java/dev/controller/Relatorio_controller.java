package dev.controller;

import dev.model.Relatorio;
import dev.service.Aluno_Service;
import dev.service.Relatorio_service;
import org.springframework.web.bind.annotation.*;
import dev.dto.RelatorioDTO;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class Relatorio_controller {

    private final Relatorio_service relatorioService;
    private final Aluno_Service alunoService;

    public Relatorio_controller(Relatorio_service relatorioService, Aluno_Service alunoService) {
        this.relatorioService = relatorioService;
        this.alunoService = alunoService;
    }

    @GetMapping("/buscar/{nome}")
    public List<Relatorio> getRelatoriosPorNome(@PathVariable String nome) {
        long alunoId = alunoService.findByname(nome);
        return relatorioService.findByAlunoId(alunoId);
    }

    @GetMapping
    public List<Relatorio> findAll() {
        return relatorioService.findAll();
    }

    @PostMapping("/salvar")
    public Relatorio save(@RequestBody RelatorioDTO dto) {
        return relatorioService.save(dto);
    }

    @GetMapping("/{id}")
    public Relatorio findById(@PathVariable Long id) {
        return relatorioService.findById(id);
    }

    @PatchMapping("/update/{id}")
    public void atualizarParcial(@PathVariable Long id, @RequestBody RelatorioDTO dto) {
        relatorioService.updatePartial(id, dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        relatorioService.delete(id);
    }
}

