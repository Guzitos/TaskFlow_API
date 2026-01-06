package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.loop.todo_list_api.enums.Ranks;

@Entity
@Table(name = "perfil_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil_rank", nullable = false)
    private Ranks rank;

    @Column(nullable = false)
    private int xpTotal;

    // 🔥 regra de negócio fica AQUI
    public void adicionarXp(int xp) {
        this.xpTotal += xp;
        atualizarRank();
    }

    private void atualizarRank() {
        if (xpTotal >= 1000) {
            rank = Ranks.PLATINA;
        } else if (xpTotal >= 500) {
            rank = Ranks.OURO;
        } else if (xpTotal >= 200) {
            rank = Ranks.PRATA;
        } else {
            rank = Ranks.BRONZE;
        }
    }
}