package org.loop.todo_list_api.repository;

import org.loop.todo_list_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Metodo de consulta customizado
    // O Spring Data JPA gera automaticamente a query com base no nome do metodo
    //
    // Busca uma Role pelo campo "name"
    // Retorna Optional para evitar NullPointerException
    Optional<Role> findByName(String name);

}