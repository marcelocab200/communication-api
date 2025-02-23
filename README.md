# Communication API

![Java](https://img.shields.io/badge/Java-23-red?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-green?logo=springboot)
![Swagger](https://img.shields.io/badge/Swagger-2.8.5-yellow?logo=swagger)
![MySQL](https://img.shields.io/badge/MySQL-9.2.0-4479A1?logo=mysql&logoColor=fff)
![Docker](https://img.shields.io/badge/Docker-2.29.7-blue?logo=docker)

A **Communication API** é uma aplicação Spring Boot e foi feita como resolução do desafio para vaga de Desenvolvedor Júnior do Magalu.
É uma API RESTful que permite agendar o envio de uma comunicação, bem como consultar e realizar seu cancelamento. Foi o primeiro projeto em que tive a experiência de aplicar a Arquitetura Hexagonal e realizar integração de banco de dados MySQL com Spring Data JPA, e ele me trouxe grandes aprendizados sobre o padrão hexagonal.

---

## Funcionalidades

- **Agendamento**: Agenda o envio de comunicação a partir do JSON com valores de destinatário, tipo de comunicação e a mensagem.
- **Validação de dados**: Garante que os campos obrigatórios estejam preenchidos e que os valores sejam válidos.
- **Consulta e cancelamento do envio**: Permite ver o status do envio e alterar para cancelado.
- **Documentação com Swagger**: A API é documentada automaticamente com Swagger UI para facilitar o uso e testes.
- **Respostas HTTP padronizadas**: Retorna códigos de status HTTP adequados para cada operação.
- **Docker**: Suporte para containerização da aplicação.

---

## Ferramentas e Tecnologias Utilizadas

- **Java 23**
- **Spring Boot**
- **MySQL**
- **Spring Data JPA**
- **Lombok**
- **Maven**
- **Swagger**
- **Docker**

---

## Como executar a aplicação a partir do Docker

#### Clone o repositório

```
git clone https://github.com/marcelocb200/communication-api.git
cd communication-api
```

#### Compile o projeto

Use o Maven para compilar o projeto e gerar o arquivo .jar da aplicação:

```
mvn clean package
```

#### Construa a imagem Docker

```
docker compose up --build
```

A aplicação estará disponível em:  
- http://localhost:8080

---

## Endpoints da API

A API possui os seguintes endpoints:

### 1. **Agendar o envio da comunicação**
- `POST /agendar`

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `recipient` | `string` | **Obrigatório**. Destinatário da comunicação |
| `message` | `string` | **Obrigatório**. Mensagem da comunicação |
| `type` | `string` | **Obrigatório**. Tipo de comunicação (deve ser **EMAIL, SMS, PUSH** ou **WHATSAPP**) |

### 2. **Consultar a comunicação**
- `GET /consultar`

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. O ID da comunicação que deseja consultar |

### 3. **Cancelar o envio**
- `DELETE /cancelar`

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. O ID da comunicação que deseja cancelar |
  
## Documentação da API

A API está documentada usando **Swagger UI**, onde você pode acessar mais informações sobre RequestBody ou RequestParams das endpoints. Após iniciar a aplicação, acesse a documentação em:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

A documentação inclui:
- Descrição de todos os endpoints.
- Exemplos de requisições e respostas.
- Possibilidade de testar os endpoints diretamente na interface.
