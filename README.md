# 🚀 To-Do List API

API REST desenvolvida em **Spring Boot** para gerenciamento de **usuários, tarefas, XP, rank e heatmap de atividades**, com autenticação via **JWT**.

---

## 🧩 Tecnologias
- Java 17
- Spring Boot
- Spring Security + JWT
- JPA / Hibernate
- MySQL
- Maven

---

## 🔐 Autenticação

### Login
```http
POST /auth/login
```

**Body**
```json
{
  "perfilName": "usuario",
  "password": "senha"
}
```

**Response**
```json
{
  "token": "JWT_TOKEN"
}
```

➡️ Use o token no header:
```http
Authorization: Bearer JWT_TOKEN
```

---

## 👤 Perfis

### Criar perfil
```http
POST /perfis
```

### Buscar perfil por ID
```http
GET /perfis/{id}
```

### Status do perfil (XP e Rank)
```http
GET /perfis/{id}/status
```

---

## 📝 Tarefas (🔒 Protegido)

### Criar tarefa
```http
POST /tarefas
```

### Listar tarefas do usuário logado
```http
GET /tarefas
```

### Atualizar tarefa
```http
PUT /tarefas/{id}
```

### Concluir tarefa (ganha XP)
```http
PATCH /tarefas/{id}/concluir
```

### Excluir tarefa
```http
DELETE /tarefas/{id}
```

---

## 📊 Atividades / Heatmap

### Buscar atividades por período
```http
GET /atividades?inicio=YYYY-MM-DD&fim=YYYY-MM-DD
```

**Exemplo**
```http
GET /atividades?inicio=2026-01-01&fim=2026-01-31
```

---

## 🛡️ Regras de Negócio
- Token expira em **2 horas**
- XP é ganho ao concluir tarefas
- Rank é calculado automaticamente
- ID do usuário sempre vem do **JWT**, nunca da URL

---

## ▶️ Como rodar o projeto

```bash
mvn clean install
mvn spring-boot:run
```

---

## 📌 Status do Projeto
✅ Em desenvolvimento ativo

---

Feito com ☕ e foco em produtividade 🚀
