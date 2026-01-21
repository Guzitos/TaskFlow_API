package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.loop.todo_list_api.enums.Ranks;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "perfil_entity")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PerfilEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String perfilName;

    private String password;

    @Enumerated(EnumType.STRING)
    private Ranks rank;

    private int xpTotal = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "perfil_entity_roles",
            joinColumns = @JoinColumn(name = "perfil_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Role> roles;


    // Configurações do Spring Security
    @Override
    public String getUsername() {
        return perfilName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 🔹 CORREÇÃO DO 403: Converte suas Roles para o formato que o Spring Security exige
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}