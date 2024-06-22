
---

# API Restful Social 

Este projeto consiste em uma API Restful desenvolvida em Spring Boot 3 
e utiliza MongoDB como banco de dados. A API permite a criação de usuários, 
adição de posts associados a esses usuários e comentários nos posts.

## Funcionalidades

- Cadastro, atualização e exclusão de usuários.
- Criação de posts associados a usuários.
- Adição de comentários em posts.
- Busca de usuários, posts e comentários por ID.
- Busca de posts por título, com opções de busca avançada por título, data mínima e máxima.
- Manipulação de comentários associados a posts.

## Tecnologias Usadas

- Java 21
- Spring Boot 3
- MongoDB
- Maven
- Lombok
- Spring Data MongoDB

## Endpoints

### Usuários

#### Cadastrar Usuário
- **URL:** `POST /users`
- **Descrição:** Cria um novo usuário com o nome e email especificados.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "name": "Nome do Usuário",
    "email": "email@example.com"
  }
  ```
- **Retorno:** Retorna o usuário criado.

#### Atualizar Usuário
- **URL:** `PUT /users/{id}`
- **Descrição:** Atualiza as informações de um usuário existente.
- **Parâmetros de URL:** `{id}` - ID do usuário a ser atualizado.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "name": "Novo Nome",
    "email": "novo_email@example.com"
  }
  ```
- **Retorno:** Retorna o usuário atualizado.

#### Deletar Usuário
- **URL:** `DELETE /users/{id}`
- **Descrição:** Deleta um usuário existente.
- **Parâmetros de URL:** `{id}` - ID do usuário a ser deletado.
- **Retorno:** Retorna uma mensagem de sucesso ou erro.

#### Buscar Usuário por ID
- **URL:** `GET /users/{id}`
- **Descrição:** Busca um usuário pelo ID.
- **Parâmetros de URL:** `{id}` - ID do usuário a ser buscado.
- **Retorno:** Retorna o usuário encontrado.

#### Buscar Todos os Usuários
- **URL:** `GET /users`
- **Descrição:** Busca todos os usuários cadastrados.
- **Retorno:** Retorna uma lista de todos os usuários.

#### Buscar Posts de um Usuário
- **URL:** `GET /users/{id}/posts`
- **Descrição:** Busca todos os posts associados a um usuário pelo ID.
- **Parâmetros de URL:** `{id}` - ID do usuário.
- **Retorno:** Retorna uma lista de posts do usuário especificado.

### Posts

#### Criar Post para Usuário
- **URL:** `POST /users/{id}/posts`
- **Descrição:** Cria um novo post associado a um usuário.
- **Parâmetros de URL:** `{id}` - ID do usuário.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "date": "2024-06-22",
    "title": "Título do Post",
    "body": "Conteúdo do Post",
    "authorDto": {
      "id": "ID_do_Autor",
      "name": "Nome_do_Autor"
    },
    "commentDTOS": []
  }
  ```
- **Retorno:** Retorna o post criado.

#### Buscar Post por ID
- **URL:** `GET /posts/{id}`
- **Descrição:** Busca um post pelo ID.
- **Parâmetros de URL:** `{id}` - ID do post a ser buscado.
- **Retorno:** Retorna o post encontrado.

#### Buscar Posts por Título
- **URL:** `GET /posts/titlesearch?text={text}`
- **Descrição:** Busca posts cujo título contenha o texto especificado.
- **Parâmetros de Query:** `text` - Texto a ser buscado no título.
- **Retorno:** Retorna uma lista de posts encontrados.

#### Buscar Posts por Título, Data Mínima e Data Máxima
- **URL:** `GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}`
- **Descrição:** Busca posts cujo título, corpo ou comentários correspondam ao texto especificado dentro do intervalo de datas.
- **Parâmetros de Query:**
  - `text` - Texto a ser buscado no título, corpo ou comentários.
  - `minDate` - Data mínima (formato: yyyy-MM-dd).
  - `maxDate` - Data máxima (formato: yyyy-MM-dd).
- **Retorno:** Retorna uma lista de posts encontrados dentro dos critérios especificados.

### Comentários

#### Adicionar Comentário a um Post
- **URL:** `POST /{id}/comments`
- **Descrição:** Adiciona um comentário a um post existente.
- **Parâmetros de URL:** `{id}` - ID do post.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "text": "Texto do Comentário",
    "date": "2024-06-22",
    "authorDTO": {
      "id": "ID_do_Autor",
      "name": "Nome_do_Autor"
    }
  }
  ```
- **Retorno:** Retorna o post atualizado com o novo comentário.

#### Buscar Comentário por ID
- **URL:** `GET /comments/{id}`
- **Descrição:** Busca um comentário pelo ID.
- **Parâmetros de URL:** `{id}` - ID do comentário a ser buscado.
- **Retorno:** Retorna o comentário encontrado.

---

## Utilização

1. **Pré-requisitos:**
   - JDK 17 ou superior
   - Maven 3.6.3 ou superior
   - MongoDB instalado e configurado

2. **Instruções de Instalação:**
   - Clone o repositório.
   - Importe o projeto em sua IDE Java preferida.
   - Configure as propriedades do MongoDB no arquivo `application.properties`.

3. **Execução:**
   - Execute a aplicação como um projeto Spring Boot.

---


