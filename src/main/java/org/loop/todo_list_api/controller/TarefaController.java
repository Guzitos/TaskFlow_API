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

    // Pega o ID do usuário logado através do SecurityContext
    private Long getLogadoId() {
        PerfilEntity logado = (PerfilEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return logado.getId();
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criar(@RequestBody TarefaDTO dto) {
        return ResponseEntity.ok(tarefaService.criar(dto, getLogadoId()));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar() {
        return ResponseEntity.ok(tarefaService.listarTarefasPorUsuario(getLogadoId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizar(@PathVariable Long id, @RequestBody TarefaDTO dto) {
        // Garante que o ID da URL seja o mesmo do DTO para evitar confusão
        dto.setId(id);
        return ResponseEntity.ok(tarefaService.atualizar(dto));
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Void> concluir(@PathVariable Long id) {
        tarefaService.concluirTarefa(id, getLogadoId());
        return ResponseEntity.noContent().build(); // 204 No Content é o ideal para Patch/Delete de sucesso
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        // No seu Service atual, o excluir não valida o dono,
        // mas é boa prática passar o ID do logado se quiser proteger o Delete no futuro
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}