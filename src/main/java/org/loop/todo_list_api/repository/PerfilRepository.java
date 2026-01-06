package org.loop.todo_list_api.repository;

import org.loop.todo_list_api.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEntity,Long> {
}
