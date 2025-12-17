# 📌 To Do Task API
Uma API simples e eficiente para gerenciamento de tarefas, desenvolvida em **Java + Spring Boot**, com suporte a criação, listagem, edição e exclusão de tarefas.

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Lombok**

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── org.loop.todo_list_api/
     │       ├── controller/
     │       ├── dto/
     │       ├── entity/
     │       ├── repository/
     │       └── service/
     └── resources/
         ├── application.properties
         └── schema.sql (opcional)
```

---

## 🧠 Funcionalidades da API

✔ Criar uma nova tarefa  
✔ Listar todas as tarefas  
✔ Buscar tarefa por ID  
✔ Atualizar tarefa  
✔ Marcar como concluída  
✔ Deletar tarefa  
✔ Integração com MySQL  
✔ Respostas em JSON  

---

## 📬 Endpoints

### **GET /tarefas**
Retorna todas as tarefas.

### **GET /tarefas/{id}**
Retorna uma tarefa específica.

### **POST /tarefas**
Cria uma nova tarefa.  
Exemplo de JSON:
```json
{
  "titulo": "Estudar Spring",
  "descricao": "Praticar CRUD e JPA",
  "concluido": false,
  "deadline": "2025-12-31"
}
```

### **PUT /tarefas/{id}**
Atualiza uma tarefa existente.

### **DELETE /tarefas/{id}**
Remove a tarefa.

---

## 🗄 Configuração do Banco (MySQL)

No arquivo `application.properties`:

```properties
spring.datasource.url=${DB_URL}  - sua url em uma variavel de ambiente
spring.datasource.username=${DB_USER}  - seu usuario em uma variavel de ambiente
spring.datasource.password=${DB_PASSWORD} - sua senha em uma variavel de ambiente

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶ Como rodar o projeto

### **1. Clone o repositório**
```bash
git clone https://github.com/Guzitos/TaskFlow_API.git
```

### **2. Entre na pasta**
```bash
cd TaskFlow_API
```

### **3. Instale as dependências**
O Maven cuida disso automaticamente.

### **4. Rode o projeto**
```bash
mvn spring-boot:run
```

---

## 📘 Sobre o projeto

Este projeto foi criado com o objetivo de praticar **Spring Boot, JPA, REST API e conexão com MySQL**, aplicando boas práticas como DTOs, camadas organizadas e padrões de projeto.

---

## 📎 Autor

**Gustavo Rodrigues**  
Desenvolvedor Java | Spring Boot | MySQL
