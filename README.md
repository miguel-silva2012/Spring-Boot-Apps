# Spring Boot Apps

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.9.16-C71A36?logo=apachemaven)

APIs que desenvolvi em Java com o framework Spring Boot.

## Propósito

Coloco todas essas APIs aqui com o intuito de aprender Spring Boot no java, incluindo seus modulos como: 

- Spring Data JPA;
    - Hibernate(H2 database).
- Spring Security.

## Templates para novos projetos spring

Configurando a conecção com um banco de dados **PostgreSQL**

```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driver-class-name=org.postgresql.Driver

spring.datasource.url=jdbc:postgresql://localhost:5432/<name-of-the-DB>
spring.datasource.username=postgres
spring.datasource.password=<your-password>
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

