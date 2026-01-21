package org.loop.todo_list_api.service;

import jakarta.transaction.Transactional;
import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.entity.TarefaEntity;
import org.loop.todo_list_api.repository.PerfilRepository;
import org.loop.todo_list_api.repository.TaferaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired private TaferaRepository tarefaRepository;
    @Autowired private PerfilRepository perfilRepository;
    @Autowired private PerfilService perfilService;

    public List<TarefaDTO> listarTarefasPorUsuario(Long perfilId){
        return tarefaRepository.findByPerfilId(perfilId).stream()
                .map(TarefaDTO::new).toList();
    }

    @Transactional
    public TarefaDTO criar(TarefaDTO tarefaDTO, Long perfilId){
        PerfilEntity dono = perfilRepository.findById(perfilId)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        TarefaEntity tarefaEntity = new TarefaEntity(tarefaDTO);
        tarefaEntity.setPerfil(dono);

        return new TarefaDTO(tarefaRepository.save(tarefaEntity));
    }

    @Transactional
    public TarefaDTO atualizar(TarefaDTO tarefaDTO) {
        TarefaEntity existente = tarefaRepository.findById(tarefaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        existente.setTitulo(tarefaDTO.getTitulo());
        existente.setDescricao(tarefaDTO.getDescricao());
        existente.setDificuldade(tarefaDTO.getDificuldade());
        existente.setConcluido(tarefaDTO.isConcluido());

        // Converte o LocalDate do DTO para LocalDateTime da Entity
        if (tarefaDTO.getPrazoFinal() != null) {
            existente.setPrazoFinal(tarefaDTO.getPrazoFinal().atStartOfDay());
        }

        return new TarefaDTO(tarefaRepository.save(existente));
    }

    @Transactional
    public void concluirTarefa(Long tarefaId, Long perfilId) {
        TarefaEntity tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if (tarefa.isConcluido()) throw new IllegalStateException("Tarefa já concluída");

        tarefa.concluir();
        int xp = tarefa.getDificuldade().getXp();
        perfilService.adicionarXp(perfilId, xp);

        tarefaRepository.save(tarefa);
    }

    public void excluir(Long id){
        TarefaEntity tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaRepository.delete(tarefa);
    }
}