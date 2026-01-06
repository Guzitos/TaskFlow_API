package org.loop.todo_list_api.service;

import jakarta.transaction.Transactional;
import org.loop.todo_list_api.repository.TaferaRepository;
import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.entity.TarefaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TaferaRepository tarefaRepository;

    @Autowired
    private PerfilService perfilService;


    // Lista todos as tarefas do banco
    public List<TarefaDTO> listarTarefas(){
        List<TarefaEntity> tarefa = tarefaRepository.findAll();
        return tarefa.stream().map(TarefaDTO::new).toList();
    }

    // Cria uma nova tarefa
    public void criar(TarefaDTO tarefa){
        TarefaEntity tarefaEntity = new TarefaEntity(tarefa);
        tarefaRepository.save(tarefaEntity);
    }

    // Atualiza a tarefa do banco de dados
    public TarefaDTO atualizar(TarefaDTO tarefa){
        TarefaEntity tarefaEntity = new TarefaEntity(tarefa);
        return new TarefaDTO(tarefaRepository.save(tarefaEntity));

    }

    // Exclui a tarefa correspondente ao ID dela
    public void excluir(Long id){
        TarefaEntity tarefa = tarefaRepository.findById(id).get();
        tarefaRepository.delete(tarefa);
    }

    // fazer uma busca pelo ID
    public TarefaDTO buscarPorId(Long id){
        return new TarefaDTO(tarefaRepository.findById(id).get());
    }


    public void alternarConclusao(Long id) {
        TarefaEntity tarefa = tarefaRepository.findById(id)
                .orElseThrow();

        tarefa.setConcluido(!tarefa.isConcluido());
        tarefaRepository.save(tarefa);
    }


    // Concluir Tarefa.
    @Transactional
    public void concluirTarefa(Long tarefaId, Long perfilId) {

        TarefaEntity tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if (tarefa.isConcluido()) {
            throw new IllegalStateException("Tarefa já concluída");
        }

        tarefa.concluir();

        int xp = tarefa.getDificuldade().getXp();

        perfilService.adicionarXp(perfilId, xp);

        tarefaRepository.save(tarefa);
    }


}
