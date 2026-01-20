package org.loop.todo_list_api.repository;

import org.loop.todo_list_api.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
    Optional<PerfilEntity> findByPerfilName(String perfilName);
}