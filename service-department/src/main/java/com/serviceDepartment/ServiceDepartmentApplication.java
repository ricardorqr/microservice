package com.serviceDepartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Department API",
                version = "1.0",
                contact = @Contact(name = "Ricardo Ribeiro", url = "http://exampleurl.com/contact", email = "ricardorqr@gmail.com"),
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
        )
)
public class ServiceDepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDepartmentApplication.class, args);
    }

}
