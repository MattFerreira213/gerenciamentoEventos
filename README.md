# GerenciamentoEventos
## Tecnologias utilizadas
* STS
* SpringBoot
* Spring Data JPA
* Lombok
* Postgres
* Flyway
* Docker Compose
* JDK 8
#
## Base de dados
### Com o Docker instalado,acesse:
_**/gerenciamantoEventos**_ e digite: _**docker-compose up**_. 

Crie a base de dados **gerenciador_eventos**. O flyway irá criar as tabelas, e populalas com dados iniciais.

Uma outra opção, caso você não queira utilizar o docker, é instalar o **postgres12.6** na sua máquina.

### Tabelas:
* pessoa
* salaevento
* espacocafe
* pessoa_salaevento
* pessoa_espacocafe
#
### Ferramentas para utilizar o database
* PgAdmin4
* DBeaver
#
## Levantar a aplicação 
Após clonar o repositório, deverá abri-lo em uma IDE, de sua preferência, para projetos java.
Com a aplicação em execução, a mesma estará disponível na url:http://localhost:8080
### IDE's recomendadas
* Intellij
* STS
#

