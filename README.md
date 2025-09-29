# Gestão de Produtos API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.0-red)

API RESTful para gestão de produtos e categorias, desenvolvida como projeto para a disciplina de Sistemas Distribuídos e Mobile.

##  Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para criação de aplicações Java de forma rápida e configurável.
- **Spring Data JPA**: Para persistência de dados e comunicação com o banco de dados.
- **Maven**: Gerenciador de dependências e de build do projeto.
- **H2 Database**: Banco de dados relacional em memória, utilizado para o ambiente de desenvolvimento.
- **Lombok**: Para reduzir código boilerplate (getters, setters, etc.).

##  Arquitetura

A aplicação segue uma arquitetura em camadas para garantir a separação de responsabilidades e a manutenibilidade do código:

- **Resource (Controller)**: Camada responsável por expor os endpoints da API REST e receber as requisições HTTP.
- **Service**: Camada que contém a lógica de negócio da aplicação.
- **Repository**: Camada de acesso a dados, que utiliza o Spring Data JPA para interagir com o banco de dados.
- **Model (Entity)**: Camada que representa as entidades do domínio da aplicação.

## ⚙️ Como Executar o Projeto

Siga os passos abaixo para executar a aplicação localmente.

```bash
# 1. Clone o repositório
git clone https://github.com/Caio-Campolino/gestaoprodutos-api.git

# 2. Navegue até a pasta do projeto
cd gestaoprodutos-api

# 3. Execute a aplicação com o Maven Wrapper
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## 📖 Endpoints da API

A API expõe os seguintes endpoints para manipulação de Categorias e Produtos.

### Categorias

| Método HTTP | URI               | Descrição                    | Exemplo de Corpo (Body)                                             |
|-------------|-------------------|------------------------------|---------------------------------------------------------------------|
| `POST`      | `/categorias`     | Cria uma nova categoria.     | `{"nome": "Livros", "descricao": "Livros de ficção e não-ficção"}` |
| `GET`       | `/categorias`     | Lista todas as categorias.   | N/A                                                                 |
| `GET`       | `/categorias/{id}`| Busca uma categoria por ID.  | N/A                                                                 |
| `PUT`       | `/categorias/{id}`| Atualiza uma categoria.      | `{"nome": "Livros Técnicos", "descricao": "Livros sobre tecnologia"}` |
| `DELETE`    | `/categorias/{id}`| Deleta uma categoria por ID. | N/A                                                                 |

### Produtos

| Método HTTP | URI             | Descrição                 | Exemplo de Corpo (Body)                                                                                             |
|-------------|-----------------|---------------------------|---------------------------------------------------------------------------------------------------------------------|
| `POST`      | `/produtos`     | Cria um novo produto.     | `{"nome": "O Senhor dos Anéis", "descricao": "Edição completa", "preco": 150.00, "categoria": {"id": 1}}` |
| `GET`       | `/produtos`     | Lista todos os produtos.  | N/A                                                                                                                 |
| `GET`       | `/produtos/{id}`| Busca um produto por ID.  | N/A                                                                                                                 |
| `PUT`       | `/produtos/{id}`| Atualiza um produto.      | `{"nome": "O Hobbit", "descricao": "Edição de capa dura", "preco": 89.90, "categoria": {"id": 1}}`       |
| `DELETE`    | `/produtos/{id}`| Deleta um produto por ID. | N/A                                                                                                                 |

##  Acesso ao Banco de Dados (H2 Console)

Durante a execução, é possível acessar o console web do banco de dados H2 para visualizar as tabelas e os dados.

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User Name**: `sa`
- **Password**: (deixe em branco)

Clique em `Connect` para acessar.