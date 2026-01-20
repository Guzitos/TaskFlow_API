package org.loop.todo_list_api.dto;

import lombok.*;
import org.loop.todo_list_api.entity.TarefaEntity;
import org.loop.todo_list_api.enums.Dificuldades;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluido;
    private LocalDateTime prazoFinal; // Padronizado para LocalDateTime
    private Dificuldades dificuldade;

    // Construtor para conversão Entity -> DTO
    public TarefaDTO(TarefaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.concluido = entity.isConcluido();
        this.prazoFinal = entity.getPrazoFinal();
        this.dificuldade = entity.getDificuldade();
    }
}