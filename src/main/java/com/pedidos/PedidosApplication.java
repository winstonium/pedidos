package com.pedidos;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:application.properties")
    , @PropertySource(value="file:${spring.config.location}", ignoreResourceNotFound = true)
})

@EntityScan(basePackageClasses = {PedidosApplication.class})
public class PedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidosApplication.class, args);
    }
    
    @Bean
    public OpenAPI customOpenAPI(@Value("${application.description}") String appDesciption, @Value("${application.version}") String appVersion) {
        Contact contact=new Contact();
        contact.name("Winston Quispe Yujra");
        contact.email("winston.qy@gmail.com");
        
        return new OpenAPI()
                .info(new Info()
                        .title("API - Servicio pedido de productos ")
                        .contact(contact)
                        .version(appVersion)
                        .description("Esta es un API simple para consultar pedidos de productos.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }

}
