package org.loop.todo_list_api.repository;

import org.loop.todo_list_api.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaferaRepository extends JpaRepository<TarefaEntity, Long> {

    // 🔹 Este método permite buscar apenas as tarefas que pertencem a um perfil específico
    // O Spring Data JPA cria a query automaticamente baseada no nome do método.
    List<TarefaEntity> findByPerfilId(Long perfilId);
}