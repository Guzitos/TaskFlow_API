package org.loop.todo_list_api.service;

import org.loop.todo_list_api.dto.PerfilDTO;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.entity.Role;
import org.loop.todo_list_api.repository.PerfilRepository;
import org.loop.todo_list_api.repository.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.Set;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public PerfilService(PerfilRepository perfilRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.perfilRepository = perfilRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void adicionarXp(Long perfilId, int xp) {
        PerfilEntity perfil = perfilRepository.findById(perfilId)
                .orElseThrow(() -> new RuntimeException("Perfil ID " + perfilId + " não encontrado no banco."));

        perfil.adicionarXp(xp);
        perfilRepository.save(perfil);
    }

    @Transactional
    public PerfilEntity criarPerfil(PerfilDTO dto) {
        if(perfilRepository.findByPerfilName(dto.getPerfilName()).isPresent()) {
            throw new RuntimeException("Este nome de usuário já está em uso.");
        }

        // Garante que a Role USER existe para não dar erro 500 ao salvar
        Role userRole = roleRepository.findByName("USER")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName("USER");
                    return roleRepository.save(newRole);
                });

        PerfilEntity perfil = new PerfilEntity();
        perfil.setPerfilName(dto.getPerfilName());
        perfil.setPassword(passwordEncoder.encode(dto.getPassword()));
        perfil.setRoles(Set.of(userRole));

        return perfilRepository.save(perfil);
    }

    public PerfilEntity buscarPorId(Long id) {
        return perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }
}