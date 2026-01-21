package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.enums.Dificuldades;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarefa_entity")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    private boolean concluido = false;

    // Mantemos LocalDateTime para o Banco de Dados (Data + Hora)
    private LocalDateTime prazoFinal;

    @Enumerated(EnumType.STRING)
    private Dificuldades dificuldade;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private PerfilEntity perfil;

    // Construtor para conversão DTO -> Entity
    public TarefaEntity(TarefaDTO dto) {
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.concluido = dto.isConcluido();
        this.dificuldade = dto.getDificuldade();

        /* RESOLUÇÃO DO ERRO:
           Como o DTO agora usa LocalDate, chamamos atStartOfDay() nele
           para converter para o LocalDateTime que esta Entity exige.
        */
        if (dto.getPrazoFinal() != null) {
            this.prazoFinal = dto.getPrazoFinal().atStartOfDay();
        }
    }

    public void concluir() {
        this.concluido = true;
    }
}