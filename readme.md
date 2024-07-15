# ForoHub API

ForoHub API es una aplicación de backend para gestionar foros, construida con Spring Boot. Proporciona funcionalidades para autenticar usuarios, registrar, listar, actualizar y eliminar tópicos.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Lombok

## Dependencias

- spring-boot-starter-data-jpa
- spring-boot-starter-web
- flyway-core
- flyway-mysql
- spring-boot-devtools
- mysql-connector-j
- lombok
- spring-boot-starter-test
- spring-boot-starter-validation
- spring-boot-starter-security
- java-jwt

## Endpoints

### Autenticación

- `POST /login` - Autenticar usuario

### Tópicos

- `POST /topicos` - Registrar nuevo tópico
- `GET /topicos` - Listar tópicos
- `PUT /topicos` - Actualizar tópico
- `DELETE /topicos/{idTopico}` - Eliminar tópico

## Autor
Santiago Pocón  
Formación Java Spring Boot  
Alura Latam ONE G6  
2014100santiagopocon@gmail.com