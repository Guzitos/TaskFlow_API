package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.LoginDTO;
import org.loop.todo_list_api.dto.LoginResponseDTO;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO data) {
        // Tenta autenticar
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.perfilName(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        // Pega o usuário autenticado e converte para sua entidade
        var perfil = (PerfilEntity) auth.getPrincipal();

        // Gera o token usando o seu serviço
        String token = tokenService.generateToken(perfil);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}