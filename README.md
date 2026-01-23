# 🚀 TaskFlow API - Backend Project

TaskFlow API é uma aplicação **backend RESTful** desenvolvida em **Java
com Spring Boot**, criada como evolução de um projeto inicial de To-Do
List simples.\
Nesta versão, o projeto foi transformado em um **backend completo**, com
**autenticação de usuários**, **sistema de XP e Rank**, **regras de
negócio**, e **deploy em produção**.

------------------------------------------------------------------------

## 🎯 Objetivo do Projeto

O objetivo deste projeto foi:

-   Evoluir de um CRUD simples para uma aplicação backend real
-   Implementar autenticação e autorização com JWT
-   Criar regras de negócio (XP e Rank por conclusão de tarefas)
-   Trabalhar persistência de dados com banco relacional
-   Realizar deploy em ambiente de produção

------------------------------------------------------------------------

## 🛠️ Tecnologias Utilizadas

-   Java 17
-   Spring Boot
-   Spring Security + JWT
-   Spring Data JPA
-   PostgreSQL
-   Swagger (Documentação da API)
-   Deploy em produção no Render

------------------------------------------------------------------------

## 🏗️ Arquitetura

O projeto segue arquitetura em camadas:

-   Controller → Camada de entrada das requisições
-   Service → Regras de negócio
-   Repository → Persistência de dados
-   DTO → Transferência de dados entre camadas

Além disso:

-   Autenticação stateless com JWT\
-   Filtro de segurança customizado\
-   Endpoints protegidos por autenticação

------------------------------------------------------------------------

## 🔐 Autenticação

A API utiliza **Spring Security + JWT**.

Fluxo:

1.  Registro de usuário
2.  Login e geração do token JWT
3.  Envio do token nas requisições protegidas

------------------------------------------------------------------------

## 📌 Rotas da API

### 🔐 Autenticação

| Método | Endpoint           | Descrição |
|--------|-------------------|-----------|
| POST   | `/auth/register` | Registro de novo usuário |
| POST   | `/auth/login`    | Login e geração do token JWT |

---

### 👤 Perfil

| Método | Endpoint                | Descrição |
|--------|------------------------|-----------|
| GET    | `/perfis/me`           | Consulta XP e Rank do usuário logado |
| GET    | `/perfis/{id}/status`  | Consulta XP e Rank por ID |

---

### ✅ Tarefas

| Método | Endpoint                     | Descrição |
|--------|------------------------------|-----------|
| POST   | `/tarefas`                  | Criar nova tarefa |
| GET    | `/tarefas`                  | Listar tarefas do usuário |
| PUT    | `/tarefas/{id}`             | Atualizar tarefa |
| PATCH | `/tarefas/{id}/concluir`     | Concluir tarefa |
| DELETE| `/tarefas/{id}`             | Remover tarefa |

---

## 💡 Principais Funcionalidades

-   Autenticação e autorização de usuários
-   CRUD completo de tarefas
-   Sistema de XP e Rank por conclusão de tarefas
-   Associação de tarefas por usuário
-   Filtro de atividades por intervalo de datas
-   Endpoints REST semânticos

------------------------------------------------------------------------

## 🚀 Deploy

A API está em produção no Render:

https://taskflow-api-00e6.onrender.com

------------------------------------------------------------------------

## 📂 Repositório

https://github.com/Guzitos/TaskFlow_API

------------------------------------------------------------------------

## ▶️ Como executar localmente

### Pré-requisitos

-   Java 17+
-   Maven
-   PostgreSQL

### Passos

``` bash
# Clonar o repositório
git clone https://github.com/Guzitos/TaskFlow_API.git

# Entrar na pasta
cd TaskFlow_API

# Configurar o application.properties com seu banco

# Rodar a aplicação
mvn spring-boot:run
```

A API estará disponível em:

http://localhost:8080

Swagger:

http://localhost:8080/swagger-ui.html

------------------------------------------------------------------------

## 📈 Próximas melhorias

-   Testes automatizados
-   Paginação de tarefas
-   Refresh Token
-   Dockerização

------------------------------------------------------------------------

## 👨‍💻 Autor

Gustavo (Guzitos Developer)

Focado em Desenvolvimento Backend com Java e Banco de Dados.

------------------------------------------------------------------------
