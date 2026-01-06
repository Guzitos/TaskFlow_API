package org.loop.todo_list_api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loop.todo_list_api.entity.TarefaEntity;
import org.loop.todo_list_api.enums.Dificuldades;
import org.loop.todo_list_api.repository.TaferaRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TaferaRepository tarefaRepository;

    @Mock
    private PerfilService perfilService;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveConcluirTarefaESomarXpNoPerfil() {

        // arrange
        TarefaEntity tarefa = new TarefaEntity();
        tarefa.setId(1L);
        tarefa.setConcluido(false);
        tarefa.setDificuldade(Dificuldades.MEDIA);

        when(tarefaRepository.findById(1L))
                .thenReturn(Optional.of(tarefa));

        // act
        tarefaService.concluirTarefa(1L, 10L);

        // assert
        assertTrue(tarefa.isConcluido());

        verify(perfilService)
                .adicionarXp(10L, Dificuldades.MEDIA.getXp());

        verify(tarefaRepository).save(tarefa);
    }
}
