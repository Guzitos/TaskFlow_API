package org.loop.todo_list_api.controller;
import org.loop.todo_list_api.dto.LoginDTO;
import org.loop.todo_list_api.dto.LoginResponseDTO;
import org.loop.todo_list_api.dto.PerfilDTO;
import org.loop.todo_list_api.entity.PerfilEntity;
import org.loop.todo_list_api.service.PerfilService;
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

    @Autowired
    private PerfilService perfilService; // Chame o seu serviço aqui!

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.perfilName(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var perfil = (PerfilEntity) auth.getPrincipal();
        String token = tokenService.generateToken(perfil);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody PerfilDTO data) {
        // Usa a lógica robusta que você já criou no PerfilService
        this.perfilService.criarPerfil(data);
        return ResponseEntity.ok().build();
    }
}
