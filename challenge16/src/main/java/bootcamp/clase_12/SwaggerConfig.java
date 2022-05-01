package bootcamp.clase_12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
@Configuration //Es para que spring boot sepa que es una clase de configuracion
@EnableSwagger2 //habilitamos el modulo de swagger
public class SwaggerConfig {
    @Bean //para que spring boot sepa que es un bean que se tiene que configurar.
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select() //genera un builder,
                .apis(RequestHandlerSelectors.basePackage("bootcamp.clase_12")) //en lugar de esto, podria ir any() y me documenta
                // todoel codigo. Si uso basePachage, le doy el paquete que quiero que documente.
                .paths(PathSelectors.any())//aca le digo que documente todas los path (todas la url)
                .build() // es un patron de diseno
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "Order Service API",
                "Order Service API Description",
                "1.0",
                "http://ejemplo.com/terms",
                new Contact("Ejemplo", "https://ejemplo.com", "apis@ejemplo.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }


}