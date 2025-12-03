package org.loop.todo_list_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.loop.todo_list_api.entity.TarefaEntity;

import java.time.LocalDate;

@JsonPropertyOrder({ "id", "titulo", "descricao", "concluido", "prazoFinal" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluido;
    private LocalDate prazoFinal;

    // Construtor para converter Entity → DTO
    public TarefaDTO(TarefaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.concluido = entity.isConcluido();
        this.prazoFinal = entity.getPrazoFinal();
    }
}
