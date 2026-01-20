# 🚀 TaskFlow API - To-Do List Gamificado

Este projeto é uma API REST para gerenciamento de tarefas com sistema de recompensas (XP e Ranks) e segurança via JWT.

---

## 🔐 Segurança JWT (Passo a Passo)

O sistema utiliza **Spring Security** com tokens **JWT**. Para acessar os recursos de tarefas, o usuário deve estar autenticado.

### Fluxo de Autenticação:
1. **Login:** `POST /auth/login` enviando `perfilName` e `password`.
2. **Token:** A API retorna um token assinado.
3. **Uso:** Enviar o token no cabeçalho `Authorization: Bearer <seu_token>`.



---

## 🎮 Gamificação

Ao concluir tarefas, o perfil acumula XP e sobe de Rank automaticamente:

| Dificuldade | XP | Rank | XP Necessário |
| :--- | :--- | :--- | :--- |
| FACIL | 10 | BRONZE | Inicial |
| MEDIA | 20 | PRATA | 101 |
| DIFICIL | 40 | OURO | 301 |
| EXTREMA | 100 | PLATINA | 601 |

---

## 🛠️ Como Rodar o Projeto

1. Configure seu banco de dados no `application.properties`.
2. Adicione sua chave secreta: `api.security.token.secret=sua_chave_aqui`.
3. Execute o comando:
   ```bash
   mvn spring-boot:run
   ```

## 📝 Exemplo de JSON (Criar Tarefa)
```bash
{
  "titulo": "Implementar JWT",
  "descricao": "Finalizar a branch implementation",
  "dificuldade": "EXTREMA",
  "prazoFinal": "2026-05-20T10:00:00"
}
```
## 📂 Git - Enviando para a Master
```bash
git add .
git commit -m "Finalizando segurança e gamificação"
git checkout master
git merge implementation
git push origin master
```








