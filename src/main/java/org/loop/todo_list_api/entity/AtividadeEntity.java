package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.loop.todo_list_api.enums.TipoAtividade;

import java.time.LocalDate;

@Entity
@Table(name= "atividades")
@Getter
@Setter
public class AtividadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data; // DIA da atividade (2026-01-06)

    @Enumerated(EnumType.STRING)
    private TipoAtividade tipo;
}
