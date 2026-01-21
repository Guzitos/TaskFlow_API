package org.loop.todo_list_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDate; // IMPORTANTE: LocalDate e não LocalDateTime
import org.loop.todo_list_api.enums.Dificuldades;
import org.loop.todo_list_api.entity.TarefaEntity;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluido;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate prazoFinal; // Alterado para LocalDate

    private Dificuldades dificuldade;

    public TarefaDTO(TarefaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.concluido = entity.isConcluido();
        // Converte LocalDateTime da Entity para LocalDate do DTO
        this.prazoFinal = entity.getPrazoFinal() != null ? entity.getPrazoFinal().toLocalDate() : null;
        this.dificuldade = entity.getDificuldade();
    }
}