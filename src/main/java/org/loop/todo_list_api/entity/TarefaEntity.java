package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.loop.todo_list_api.dto.TarefaDTO;

import java.time.LocalDate;

@Entity
@Table(name = "Tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Column(nullable = false)
    private boolean concluido;

    @Column(nullable = false)
    private LocalDate prazoFinal;

    // Construtor para converter DTO → Entity
    public TarefaEntity(TarefaDTO dto) {
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.concluido = dto.isConcluido();
        this.prazoFinal = dto.getPrazoFinal();
    }
}
