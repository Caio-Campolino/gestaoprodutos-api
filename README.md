# API de Gestão de Produtos

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.0-red)

API RESTful desenvolvida como projeto para a disciplina de **Sistemas Distribuídos e Mobile**. A aplicação permite o gerenciamento completo de produtos e suas respectivas categorias.

## Funcionalidades

* CRUD completo para **Categorias**.
* CRUD completo para **Produtos**.
* Associação entre Produtos e Categorias (um produto pertence a uma categoria).
* Endpoint de **filtragem** de produtos por categoria.
* **Tratamento de exceções** customizado para recursos não encontrados (retorna `404 Not Found`).

## Como Executar o Projeto

1.  **Pré-requisitos:**
    * JDK 17 ou superior.
    * Maven 3.8 ou superior.

2.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/Caio-Campolino/gestaoprodutos-api.git](https://github.com/Caio-Campolino/gestaoprodutos-api.git)
    cd gestaoprodutos-api
    ```

3.  **Compilar e Empacotar:**
    ```bash
    ./mvnw clean install
    ```

4.  **Executar a Aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

## Documentação dos Endpoints da API

A seguir estão listados todos os endpoints disponíveis na aplicação.

---

### 📦 Recursos de Categoria

#### `GET /categorias`
Lista todas as categorias cadastradas.

#### `GET /categorias/{id}`
Busca uma categoria específica pelo seu ID.

#### `POST /categorias`
Cria uma nova categoria.

* **Corpo da Requisição (Exemplo):**
    ```json
    {
        "nome": "Eletrônicos",
        "descricao": "Dispositivos de tecnologia"
    }
    ```

#### `PUT /categorias/{id}`
Atualiza os dados de uma categoria existente.

* **Corpo da Requisição (Exemplo):**
    ```json
    {
        "nome": "Eletrônicos e Gadgets",
        "descricao": "Todos os tipos de dispositivos de tecnologia"
    }
    ```

#### `DELETE /categorias/{id}`
Remove uma categoria pelo seu ID.
*(Obs: A operação falhará se a categoria possuir produtos associados a ela, para proteger a integridade dos dados.)*

---

### 🛍️ Recursos de Produto

#### `GET /produtos`
Lista todos os produtos cadastrados.

#### `GET /produtos?categoria={id}`
**Funcionalidade de Filtro:** Filtra a lista de produtos, retornando apenas aqueles que pertencem à categoria com o ID especificado.
* **Exemplo:** `http://localhost:8080/produtos?categoria=1`

#### `GET /produtos/{id}`
Busca um produto específico pelo seu ID.

#### `POST /produtos`
Cria um novo produto, associando-o a uma categoria existente.

* **Corpo da Requisição (Exemplo):