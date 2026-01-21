package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.StatusPerfilResponse;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    // 🔹 Buscar MEU perfil (Pelo Token)
    // Rota: GET /perfis/me
    @GetMapping("/me")
    public ResponseEntity<StatusPerfilResponse> buscarMeuPerfil() {
        PerfilEntity logado = (PerfilEntity) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        // Recarregamos do banco para garantir que o XP/Rank estejam atualizados
        PerfilEntity perfil = perfilService.buscarPorId(logado.getId());

        return ResponseEntity.ok(new StatusPerfilResponse(
                perfil.getXpTotal(),
                perfil.getRank()
        ));
    }

    // 🔹 Ver XP e Rank de qualquer ID (Opcional)
    // Rota: GET /perfis/{id}/status
    @GetMapping("/{id}/status")
    public ResponseEntity<StatusPerfilResponse> status(@PathVariable Long id) {
        PerfilEntity perfil = perfilService.buscarPorId(id);

        return ResponseEntity.ok(
                new StatusPerfilResponse(
                        perfil.getXpTotal(),
                        perfil.getRank()
                )
        );
    }
}