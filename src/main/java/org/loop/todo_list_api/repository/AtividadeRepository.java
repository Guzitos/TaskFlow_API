package org.loop.todo_list_api.repository;

import org.loop.todo_list_api.entity.AtividadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AtividadeRepository extends JpaRepository<AtividadeEntity, Long> {

    @Query("""
    SELECT a.data, COUNT(a)
    FROM AtividadeEntity a
    WHERE a.data BETWEEN :inicio AND :fim
    GROUP BY a.data
    ORDER BY a.data
    """)
    List<Object[]> contarAtividadesPorDia(
            @Param("inicio") LocalDate inicio,
            @Param("fim") LocalDate fim
    );
}