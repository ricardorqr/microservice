# Microservice Model

This is a sample project model for microservices using Spring Boot.

### Architecture

###### Services

- [Department](http://localhost:9002/users/swagger)
- [User](http://localhost:9002/users/h2)

### Settings

###### Spring Boot

- POM.XML

Add the dependencies below:
- Spring Web
- Spring Data JPA
- Lombok
- H2

###### H2

To make H2 Console work, you have to change the property `spring.datasource.url` in the Spring boot file `application.properties`. Use login `sa` and password `password`.

Windows:
```
spring.datasource.url=jdbc:h2:mem:C:/Workspace-IntelliJ/microservice/service-user/userdb
```

Linux:
```
spring.datasource.url=jdbc:h2:mem:C:/Workspace-IntelliJ/microservice/service-user/userdb
```

###### Port

Change the property `server.port` in the Spring boot file `application.properties`.

```
server.port=9002
```