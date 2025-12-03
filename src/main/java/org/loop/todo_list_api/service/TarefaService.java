package org.loop.todo_list_api.service;

import org.loop.todo_list_api.TaferaRepository;
import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.entity.TarefaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TaferaRepository taferaRepository;

    // Lista todos as tarefas do banco
    public List<TarefaDTO> listarTarefas(){
        List<TarefaEntity> tarefa = taferaRepository.findAll();
        return tarefa.stream().map(TarefaDTO::new).toList();
    }

    // Cria uma nova tarefa
    public void criar(TarefaDTO tarefa){
        TarefaEntity tarefaEntity = new TarefaEntity(tarefa);
        taferaRepository.save(tarefaEntity);
    }

    // Atualiza a tarefa do banco de dados
    public TarefaDTO atualizar(TarefaDTO tarefa){
        TarefaEntity tarefaEntity = new TarefaEntity(tarefa);
        return new TarefaDTO(taferaRepository.save(tarefaEntity));
    }

    // Exclui a tarefa correspondente ao ID dela
    public void excluir(Long id){
        TarefaEntity tarefa = taferaRepository.findById(id).get();
        taferaRepository.delete(tarefa);
    }


    // fazer uma busca pelo ID
    public TarefaDTO buscarPorId(Long id){
        return new TarefaDTO(taferaRepository.findById(id).get());
    }

}
