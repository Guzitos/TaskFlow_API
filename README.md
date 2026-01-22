# 🚀 To-Do List API --- Backend Portfolio Project

API REST desenvolvida com **Spring Boot**, focada em **boas práticas de
backend**, **segurança**, **regras de negócio** e **arquitetura
limpa**.\
Projeto criado para **portfólio profissional**, demonstrando domínio em
**Java + Spring + JWT + JPA**.

------------------------------------------------------------------------

## 🎯 Objetivo do Projeto

Criar uma API robusta para gerenciamento de tarefas com: - Autenticação
segura via **JWT** - Controle de usuários - Sistema de **XP e Rank**
(gamificação) - Registro de atividades (heatmap de produtividade) -
Arquitetura em camadas bem definida

------------------------------------------------------------------------

## 🧩 Tecnologias Utilizadas

-   Java 17
-   Spring Boot
-   Spring Security
-   JWT (Auth0)
-   JPA / Hibernate
-   MySQL
-   Maven

------------------------------------------------------------------------

## 🔐 Autenticação

### POST `/auth/login`

**Request Body**

``` json
{
  "perfilName": "joao",
  "password": "123456"
}
```

**Response**

``` json
{
  "token": "JWT_TOKEN"
}
```

**Header obrigatório nas rotas protegidas**

    Authorization: Bearer JWT_TOKEN

------------------------------------------------------------------------

## 👤 Perfis

### POST `/perfis` --- Criar perfil

**Request Body**

``` json
{
  "perfilName": "joao",
  "password": "123456"
}
```

### GET `/perfis/{id}` --- Buscar perfil

**Response**

``` json
{
  "id": 1,
  "perfilName": "joao",
  "xpTotal": 120,
  "rank": "BRONZE"
}
```

### GET `/perfis/{id}/status` --- XP e Rank

**Response**

``` json
{
  "xpTotal": 120,
  "rank": "BRONZE"
}
```

------------------------------------------------------------------------

## 📝 Tarefas (🔒 JWT)

### POST `/tarefas` --- Criar tarefa

**Request Body**

``` json
{
  "titulo": "Estudar Spring Security",
  "descricao": "Implementar JWT no projeto",
  "prazoFinal": "2026-01-30",
  "dificuldade": "MEDIA"
}
```

**Response**

``` json
{
  "id": 10,
  "titulo": "Estudar Spring Security",
  "descricao": "Implementar JWT no projeto",
  "prazoFinal": "2026-01-30",
  "dificuldade": "MEDIA",
  "concluido": false
}
```

### GET `/tarefas` --- Listar tarefas do usuário

**Response**

``` json
[
  {
    "id": 10,
    "titulo": "Estudar Spring Security",
    "descricao": "Implementar JWT no projeto",
    "prazoFinal": "2026-01-30",
    "dificuldade": "MEDIA",
    "concluido": false
  }
]
```

### PUT `/tarefas/{id}` --- Atualizar tarefa

**Request Body**

``` json
{
  "titulo": "Estudar Spring Security + JWT",
  "descricao": "Finalizar autenticação",
  "prazoFinal": "2026-02-01",
  "dificuldade": "DIFICIL",
  "concluido": false
}
```

### PATCH `/tarefas/{id}/concluir` --- Concluir tarefa

**Response**

    204 No Content

### DELETE `/tarefas/{id}` --- Excluir tarefa

**Response**

    204 No Content

------------------------------------------------------------------------

## 📊 Atividades / Heatmap

### GET `/atividades`

**Query Params**

    ?inicio=2026-01-01&fim=2026-01-31

**Response**

``` json
[
  {
    "data": "2026-01-10",
    "quantidade": 3
  }
]
```

------------------------------------------------------------------------

## 🛡️ Regras de Negócio Importantes

-   O ID do usuário nunca vem do body ou URL
-   Todas as operações usam o JWT
-   Prevenção contra IDOR
-   Token com expiração de 2 horas
-   XP e Rank calculados automaticamente

------------------------------------------------------------------------


## 📌 Diferencial para Recrutadores

✅ Segurança aplicada corretamente\
✅ Arquitetura limpa e escalável\
✅ Regras de negócio claras\
✅ Pronto para Frontend\
✅ Código de nível profissional
