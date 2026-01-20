package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_roles")
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

    public enum Values {
        ADMIN(1L),
        USER(2L);
        long id;
        Values(long id) { this.id = id; }
        public long getRoleId() { return id; }
    }
}