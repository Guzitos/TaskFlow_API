package org.loop.todo_list_api.config;

import jakarta.transaction.Transactional;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.entity.Role;
import org.loop.todo_list_api.enums.Ranks;
import org.loop.todo_list_api.repository.PerfilRepository;
import org.loop.todo_list_api.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final PerfilRepository perfilRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           PerfilRepository perfilRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Busca ou cria a role de ADMIN
        Role adminRole = roleRepository.findByName(Role.Values.ADMIN.name())
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(Role.Values.ADMIN.name());
                    return roleRepository.save(newRole);
                });

        perfilRepository.findByPerfilName("admin")
                .ifPresentOrElse(
                        user -> System.out.println("Admin já existe."),
                        () -> {
                            var admin = new PerfilEntity();
                            admin.setPerfilName("admin");
                            admin.setPassword(passwordEncoder.encode("123"));
                            admin.setRoles(Set.of(adminRole)); // Agora adminRole é reconhecido
                            admin.setRank(Ranks.BRONZE);
                            perfilRepository.save(admin);
                        }
                );
    }
}