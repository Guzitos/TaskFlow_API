package org.loop.todo_list_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.loop.todo_list_api.dto.LoginDTO;
import org.loop.todo_list_api.enums.Ranks;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Set;

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
    private Ranks rank = Ranks.BRONZE;

    private int xpTotal = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    // Resolve o erro "Cannot resolve method 'adicionarXp'"
    public void adicionarXp(int xp) {
        this.xpTotal += xp;
        atualizarRank();
    }

    private void atualizarRank() {
        if (xpTotal >= 1000) this.rank = Ranks.PLATINA;
        else if (xpTotal >= 500) this.rank = Ranks.OURO;
        else if (xpTotal >= 200) this.rank = Ranks.PRATA;
        else this.rank = Ranks.BRONZE;
    }

    // Resolve o erro "Cannot resolve method 'isLoginCorrect'"
    public boolean isLoginCorrect(LoginDTO loginDTO, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginDTO.password(), this.password);
    }

    @Override public String getUsername() { return perfilName; }
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}