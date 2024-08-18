# TodoListAPI

A TodoListAPI é uma API desenvolvida em Java com Spring Boot, projetada para gerenciar e manipular dados de uma aplicação web de lista de tarefas para itens de compras. Este projeto fornece uma interface RESTful para criar, ler, atualizar e excluir tarefas.

## Funcionalidades

- **Criar Tarefa**: Adicione novas tarefas à sua lista.
- **Listar Tarefas**: Obtenha uma lista de todas as tarefas.
- **Atualizar Tarefa**: Modifique detalhes de uma tarefa existente.
- **Excluir Tarefa**: Remova tarefas da lista.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para interação com o banco de dados.
- **H2 Database**: Banco de dados em memória (pode ser substituído por outro banco de dados).
- **Maven**: Gerenciador de dependências e construção.

## Requisitos

- JDK 11 ou superior
- Maven

## Instalação

1. Clone este repositório:

    ```bash
    git clone https://github.com/seuusuario/todolistapi.git
    ```

2. Navegue para o diretório do projeto:

    ```bash
    cd todolistapi
    ```

3. Compile e execute a aplicação:

    ```bash
    mvn spring-boot:run
    ```

4. A API estará disponível em `http://localhost:8080`.

## Endpoints

- **POST /tasks**
  - Cria uma nova tarefa.
  - Requisição: `POST /tasks`
  - Corpo da requisição:
    ```json
    {
      "title": "Comprar leite",
      "description": "Leite desnatado"
    }
    ```

- **GET /tasks**
  - Lista todas as tarefas.
  - Requisição: `GET /tasks`

- **GET /tasks/{id}**
  - Obtém uma tarefa específica.
  - Requisição: `GET /tasks/{id}`

- **PUT /tasks/{id}**
  - Atualiza uma tarefa existente.
  - Requisição: `PUT /tasks/{id}`
  - Corpo da requisição:
    ```json
    {
      "title": "Comprar leite",
      "description": "Leite integral"
    }
    ```

- **DELETE /tasks/{id}**
  - Exclui uma tarefa.
  - Requisição: `DELETE /tasks/{id}`

## Contribuindo

1. Faça um fork deste repositório.
2. Crie uma branch para sua modificação: `git checkout -b minha-modificacao`.
3. Faça commit das suas alterações: `git commit -am 'Adiciona nova funcionalidade'`.
4. Envie para o repositório remoto: `git push origin minha-modificacao`.
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contato

Se você tiver alguma dúvida, entre em contato com [seuemail@example.com](mailto:seuemail@example.com).

