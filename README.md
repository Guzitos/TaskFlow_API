# 🚀 To-Do List API — Backend Portfolio Project

API REST desenvolvida com **Spring Boot**, focada em **boas práticas de backend**, **segurança**, **regra de negócio** e **arquitetura limpa**.  
Projeto ideal para demonstrar domínio em **Java + Spring + JWT + JPA**.

---

## 🎯 Objetivo do Projeto

Criar uma API robusta para gerenciamento de tarefas com:
- Autenticação segura via **JWT**
- Controle de usuários e permissões
- Sistema de **XP e Rank** para gamificação
- Registro de atividades para **heatmap de produtividade**
- Separação clara de responsabilidades (Controller, Service, Repository)

---

## 🧠 Principais Conceitos Aplicados

- 🔐 **Spring Security com JWT**
- 🧱 Arquitetura em camadas
- 🗂️ DTOs para controle de exposição de dados
- 🔄 Transações com `@Transactional`
- 📊 Regras de negócio desacopladas
- 🛡️ Segurança baseada no usuário autenticado
- 📈 Gamificação (XP + Rank automático)

---

## 🧩 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Security  
- JWT (Auth0)  
- JPA / Hibernate  
- MySQL  
- Maven  

---

## 🔐 Autenticação

```http
POST /auth/login
```

Utiliza **JWT** para autenticação.  
O ID do usuário é extraído diretamente do token, garantindo maior segurança.

---

## 👤 Perfis

- Criação de usuários
- Consulta de perfil
- Consulta de status (XP e Rank)

```http
POST   /perfis
GET    /perfis/{id}
GET    /perfis/{id}/status
```

---

## 📝 Tarefas (Protegido por JWT)

- Criar tarefas
- Listar tarefas do usuário autenticado
- Atualizar tarefas
- Concluir tarefas (ganha XP automaticamente)
- Excluir tarefas

```http
POST    /tarefas
GET     /tarefas
PUT     /tarefas/{id}
PATCH   /tarefas/{id}/concluir
DELETE  /tarefas/{id}
```

---

## 📊 Atividades / Heatmap

Registro automático de ações do usuário para análise de produtividade.

```http
GET /atividades?inicio=YYYY-MM-DD&fim=YYYY-MM-DD
```

---

## 🛡️ Regras de Negócio Importantes

- O **ID do usuário nunca vem da URL**, sempre do JWT
- Token com expiração de **2 horas**
- XP é calculado com base na dificuldade da tarefa
- Rank evolui automaticamente conforme XP acumulado

---

## ▶️ Como Executar

```bash
mvn clean install
mvn spring-boot:run
```

---

## 📌 Diferencial para Recrutadores

✅ Segurança real aplicada  
✅ Código organizado e escalável  
✅ Uso correto de autenticação e autorização  
✅ Projeto pronto para integração com Frontend  
✅ Fácil evolução para microserviços ou novos módulos  

---

## 👨‍💻 Autor

Projeto desenvolvido para **portfólio profissional**, demonstrando habilidades em backend com Java e Spring Boot.

---

🚀 Sempre evoluindo.
