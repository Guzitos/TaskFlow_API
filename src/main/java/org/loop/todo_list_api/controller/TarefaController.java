package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // Criar tarefa (O ID vem do Token, não da URL!)
    @PostMapping
    public ResponseEntity<TarefaDTO> criar(@RequestBody TarefaDTO dto) {
        PerfilEntity logado = (PerfilEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(tarefaService.criar(dto, logado.getId()));
    }

    // Listar apenas as tarefas do dono do Token
    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar() {
        PerfilEntity logado = (PerfilEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(tarefaService.listarTarefasPorUsuario(logado.getId()));
    }

    // Atualizar uma tarefa
    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizar(@PathVariable Long id, @RequestBody TarefaDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(tarefaService.atualizar(dto));
    }

    // Concluir tarefa e ganhar XP
    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Void> concluir(@PathVariable Long id) {
        PerfilEntity logado = (PerfilEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tarefaService.concluirTarefa(id, logado.getId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}