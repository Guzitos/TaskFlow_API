package org.loop.todo_list_api.service;

import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.enums.Ranks;
import org.loop.todo_list_api.repository.PerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public void adicionarXp(Long perfilId, int xp) {
        PerfilEntity perfil = perfilRepository.findById(perfilId)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        perfil.adicionarXp(xp);

        perfilRepository.save(perfil);
    }

    public PerfilEntity criarPerfil() {
        PerfilEntity perfil = new PerfilEntity();
        perfil.setXpTotal(0);
        perfil.setRank(Ranks.BRONZE);
        return perfilRepository.save(perfil);
    }

    public PerfilEntity buscarPorId(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }
}