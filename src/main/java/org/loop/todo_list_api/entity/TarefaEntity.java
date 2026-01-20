package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.loop.todo_list_api.dto.TarefaDTO;
import org.loop.todo_list_api.enums.Dificuldades;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarefa_entity")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private boolean concluido;
    private LocalDateTime prazoFinal;

    @Enumerated(EnumType.STRING)
    private Dificuldades dificuldade;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private PerfilEntity perfil;

    // Construtor manual para o TarefaService não dar erro
    public TarefaEntity(TarefaDTO dto) {
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.concluido = dto.isConcluido();
        this.prazoFinal = dto.getPrazoFinal();
        this.dificuldade = dto.getDificuldade();
    }

    public void concluir() {
        this.concluido = true;
    }
}