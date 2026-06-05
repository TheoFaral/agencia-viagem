# 🌍 API RESTful de Destinos de Viagem

## Descrição do Projeto

Este projeto foi desenvolvido utilizando **Java 17**, **Spring Boot** e **Maven**, com o objetivo de implementar uma API RESTful para gerenciamento de destinos de viagem.

A aplicação foi criada seguindo o padrão de separação em camadas (**Controller** e **Service**), atendendo aos requisitos propostos no desafio acadêmico.

---

# Objetivos

Implementar uma API capaz de:

- Cadastrar destinos de viagem
- Listar destinos cadastrados
- Pesquisar destinos por nome ou localização
- Visualizar informações detalhadas de um destino
- Realizar reservas
- Avaliar destinos com notas de 1 a 10
- Excluir destinos cadastrados

---

# Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- VS Code
- Postman
- REST API
- Programação Orientada a Objetos

---

# Estrutura do Projeto

```text
src
 ├── controller
 ├── service
 ├── model
 └── AgenciaViagemApplication
```

## Camadas

### Controller
Responsável por receber as requisições HTTP.

### Service
Responsável pela lógica de negócio.

### Model
Representa a entidade Destino.

---

# Execução do Projeto

Abra o terminal na pasta do projeto e execute:

```bash
./mvnw spring-boot:run
```

ou no Windows:

```cmd
mvnw spring-boot:run
```

## Evidência de Execução

![Execução](Execute%20o%20projeto%20no%20VSCode(2).png)

A aplicação foi iniciada com sucesso na porta:

```text
http://localhost:8080
```

---

# Endpoints Implementados

## 1. Cadastro de Destino

### Método
POST

### Endpoint

```http
POST /destinos
```

### Exemplo de Requisição

```json
{
  "nome":"Lisboa",
  "localizacao":"Portugal",
  "descricao":"Destino histórico com belas paisagens.",
  "precoPacote":6200.0
}
```

### Evidência

![Cadastro](Cadastrar%20novo%20destino(2).png)

### Resultado

O destino foi criado com sucesso.

![Confirmação Cadastro](Confirmar%20cadastro(2).png)

---

## 2. Listagem de Destinos

### Método

GET

### Endpoint

```http
GET /destinos
```

### Evidência

![Listagem](Listar%20destinos%20cadastrados(2).png)

### Resultado

A API retorna todos os destinos cadastrados.

---

## 3. Pesquisa de Destinos

### Método

GET

### Endpoint

```http
GET /destinos/pesquisa
```

### Pesquisa por Nome

```http
GET /destinos/pesquisa?nome=Lisboa
```

![Pesquisa Nome](Pesquisar%20destino%20por%20nome(2).png)

### Pesquisa por Localização

```http
GET /destinos/pesquisa?localizacao=Itália
```

![Pesquisa Localização](Pesquisar%20destino%20por%20localiza%C3%A7%C3%A3o(2).png)

### Resultado

O sistema retorna apenas os destinos que correspondem ao filtro informado.

---

## 4. Visualização de Informações Detalhadas

### Método

GET

### Endpoint

```http
GET /destinos/{id}
```

### Exemplo

```http
GET /destinos/2
```

![Detalhes](Visualizar%20detalhes%20de%20um%20destino(2).png)

### Resultado

Retorna todas as informações do destino solicitado.

---

## 5. Reserva de Destino

### Método

PUT

### Endpoint

```http
PUT /destinos/{id}/reserva
```

### Exemplo

```json
{
  "nomeCliente":"Nicole"
}
```

![Reserva](Reservar%20pacote%20de%20viagem(2).png)

### Resultado

O destino fica marcado como reservado.

---

## 6. Avaliação de Destino

### Método

PATCH

### Endpoint

```http
PATCH /destinos/{id}/avaliacao
```

### Exemplo

```json
{
  "nota":9
}
```

![Avaliação](Avaliar%20destino(2).png)

### Resultado

A média de avaliações é atualizada automaticamente.

---

## 7. Exclusão de Destino

### Método

DELETE

### Endpoint

```http
DELETE /destinos/{id}
```

### Evidência

![Excluir](Excluir%20destino(2).png)

### Confirmação

![Confirmar Exclusão](Confirmar%20exclus%C3%A3o(2).png)

### Resultado

O destino é removido da lista.

---

# Testes Realizados

Todos os testes da aplicação foram realizados utilizando o **Postman**.

Foram validados:

- Cadastro de destinos
- Listagem de destinos
- Pesquisa por nome
- Pesquisa por localização
- Visualização detalhada
- Reserva de destino
- Avaliação de destino
- Exclusão de destino

---

# Conclusão

A API RESTful desenvolvida atende integralmente aos requisitos do desafio acadêmico, implementando todos os endpoints solicitados e utilizando corretamente os métodos HTTP exigidos. A arquitetura do projeto segue boas práticas de desenvolvimento, com separação entre Controller e Service, facilitando manutenção, organização e escalabilidade do código.
