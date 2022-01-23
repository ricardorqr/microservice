# Department API

### URLs

* [Swagger](http://localhost:8080/departments/swagger)
* [H2](http://localhost:8080/departments/h2)

### Used Libraries

- Swagger
- H2
- Lombok

### Settings

###### H2

To make H2 Console work, you have to change the property `spring.datasource.url` in the Spring boot file `application.properties`. Use login `sa` and password `password`.

Windows:
```
spring.datasource.url=jdbc:h2:mem:C:/Workspace-IntelliJ/microservice/service-department/departmentdb
```

Linux:
```
spring.datasource.url=jdbc:h2:mem:C:/Workspace-IntelliJ/microservice/service-department/departmentdb
```

###### Port

Change the property `server.port` in the Spring boot file `application.properties`.

```
server.port=9001
```