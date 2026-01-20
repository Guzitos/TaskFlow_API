package org.loop.todo_list_api.dto;

// DTO (Data Transfer Object) usado como resposta do endpoint de login
// Retorna as informações necessárias para o cliente se autenticar
public record LoginResponseDTO(

        // Token JWT gerado após o login bem-sucedido
        // Esse token deve ser enviado nas próximas requisições
        // no header: Authorization: Bearer <token>
        String accessToken

        // Tempo de expiração do token em segundos
        // Exemplo: 300 = 5 minutos
) {
}