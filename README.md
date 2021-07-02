# Microservice de agencia de turismo 

#### CREATE
#### READ
#### UPDATE
#### DELETE

# Tecnologias utilizadas no curso
As tecnologias que eu utilizei durante o curso foram:

- JDK 8

- MySql 

- Intelij 2021.1.3 Comunity Version

## Extrutura:
#### Application:
- TourApplication

#### Advice:
- ErroHandler

#### Controller
- PromocaoController

#### Model:
- ErrorMessage
- Promocao
- RespostaJSON

#### Repository:
- PromocaoRepository

#### Exception:
- PromocaoNotFoundException

## Payload / Body

#### Nova Promocao
<details>
  <summary>POST - http://localhost:8080/promocoes</summary>

```
{
    "descricao": "Viagem de Natal",
    "local": "Fampos do Jordão",
    "isAllInclusive": false,
    "qtdDias": 3,
    "preco" : 500.00
}
```
</details>

#### Actuator health
<details>
  <summary>GET - http://localhost:8080/actuator/health</summary>
</details>

#### Find By Nome
<details>
  <summary>GET - http://localhost:8080/promocoes?localFilter=Gramado</summary>
</details>

#### Get All
<details>
  <summary>GET - http://localhost:8080/promocoes</summary>
</details>

#### Get Promocao By Id
<details>
  <summary>GET - http://localhost:8080/promocoes/2</summary>
</details>

#### Count
<details>
  <summary>GET - http://localhost:8080/promocoes/count</summary>
</details>

#### Ordenados
<details>
  <summary>GET - http://localhost:8080/promocoes/ordernados</summary>
</details>

#### Update promocao
<details>
  <summary>PUT - http://localhost:8080/promocoes/1</summary>

```
{
    "descricao": "Viagem",
    "local": "Campos do Jordão",
    "isAllInclusive": false,
    "qtdDias": 3,
    "preco" : 550.00
}
```
</details>

#### Delete Promocoes
<details>
  <summary>DELETE - http://localhost:8080/promocoes/1</summary>
</details>

## Bibliotecas Utilizadas: 

- MySQL Connector/J
- Spring Web
- Spring Boot Starter Data JPA
- Spring Boot DevTools
- Hibernate Validator
- Swagger UI
- Swagger2
- Kotlin-Reflect
- Jackson-module-kotlin
- jdk8
- Actuator
- Cache
