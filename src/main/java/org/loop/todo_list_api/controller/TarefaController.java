package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.service.PerfilService;
import org.loop.todo_list_api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "http://localhost:5173")
public class TarefaController {

    @Autowired
    private TarefaService taferaService;

    // rota pra puxa todas as tarefas do banco de dados.
    @GetMapping
    public List<TarefaDTO> listarTodos(){
        return taferaService.listarTarefas();
    }

    // rota pra a criação da tarefa.
    @PostMapping
    public void criar(@RequestBody TarefaDTO tarefa){
        taferaService.criar(tarefa);
    }

    // rota pra atualizar uma tarefa.
    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody TarefaDTO tarefa) {
        tarefa.setId(id);
        taferaService.atualizar(tarefa);
    }

    // rota para excluir uma tarefa pelo ID dela.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        taferaService.excluir(id);
        return ResponseEntity.ok().build();
    }

    // rota para buscar uma tarefa pelo ID.
    @GetMapping("/{id}")
    public TarefaDTO buscarPorId(@PathVariable("id") Long id){
        return taferaService.buscarPorId(id);
    }


    // concluir tarefa
    @PatchMapping("/{tarefaId}/concluir")
    public ResponseEntity<Void> concluirTarefa(
            @PathVariable Long tarefaId,
            @RequestParam Long perfilId
    ) {
        taferaService.concluirTarefa(tarefaId, perfilId);
        return ResponseEntity.ok().build();
    }

}
