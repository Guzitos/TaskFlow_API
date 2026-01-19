package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.StatusPerfilResponse;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/perfis")

public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    // 🔹 Criar perfil
    @PostMapping
    public ResponseEntity<PerfilEntity> criarPerfil() {
        PerfilEntity perfil = perfilService.criarPerfil();
        return ResponseEntity.ok(perfil);
    }

    // 🔹 Buscar perfil por ID
    @GetMapping("/{id}")
    public ResponseEntity<PerfilEntity> buscarPorId(@PathVariable Long id) {
        PerfilEntity perfil = perfilService.buscarPorId(id);
        return ResponseEntity.ok(perfil);
    }

    // 🔹 Ver XP e Rank
    @GetMapping("/{id}/status")
    public ResponseEntity<?> status(@PathVariable Long id) {
        PerfilEntity perfil = perfilService.buscarPorId(id);

        return ResponseEntity.ok(
                new StatusPerfilResponse(
                        perfil.getXpTotal(),
                        perfil.getRank()
                )
        );
    }
}