package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.entity.AtividadeEntity;
import org.loop.todo_list_api.enums.TipoAtividade;
import org.loop.todo_list_api.repository.AtividadeRepository;
import org.loop.todo_list_api.service.AtividadeService;
import org.loop.todo_list_api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tarefas")

public class TarefaController {

    @Autowired
    private TarefaService taferaService;

    @Autowired
    private AtividadeService atividadeService;

    // 🔹 rota pra puxa todas as tarefas do banco de dados.
    @GetMapping
    public List<TarefaDTO> listarTodos(){
        return taferaService.listarTarefas();
    }

    // 🔹 Criação da tarefa.
    @PostMapping
    public ResponseEntity<TarefaDTO> criar(@RequestBody TarefaDTO tarefa){
        TarefaDTO criada = taferaService.criar(tarefa);
        atividadeService.registrarCriacaoTarefa();
        return ResponseEntity.ok(criada);
    }

    // 🔹 Atualizar uma tarefa.
    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody TarefaDTO tarefa) {
        tarefa.setId(id);
        taferaService.atualizar(tarefa);
    }

    // 🔹 rota para excluir uma tarefa pelo ID dela.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        taferaService.excluir(id);
        return ResponseEntity.ok().build();
    }

    // 🔹 rota para buscar uma tarefa pelo ID.
    @GetMapping("/{id}")
    public TarefaDTO buscarPorId(@PathVariable("id") Long id){
        return taferaService.buscarPorId(id);
    }


    // 🔹 concluir tarefa
    @PatchMapping("/{tarefaId}/concluir")
    public ResponseEntity<Void> concluirTarefa( @PathVariable Long tarefaId, @RequestParam Long perfilId ) {

        atividadeService.registrarConclusaoTarefa();
        taferaService.concluirTarefa(tarefaId, perfilId);
        return ResponseEntity.ok().build();
    }

}
