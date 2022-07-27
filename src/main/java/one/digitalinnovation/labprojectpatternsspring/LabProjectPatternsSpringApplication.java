package one.digitalinnovation.labprojectpatternsspring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabProjectPatternsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabProjectPatternsSpringApplication.class, args);
	}

}
