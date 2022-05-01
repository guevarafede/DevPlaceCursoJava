package bootcamp.clase_12;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableAutoConfiguration
@SpringBootApplication
@OpenAPIDefinition
@EnableWebMvc
public class Clase12Application {  //esta clase se genera solaal hacer un proyecto spring boot, y no se toca nada.

	public static void main(String[] args) {
		SpringApplication.run(Clase12Application.class, args);

	}

}