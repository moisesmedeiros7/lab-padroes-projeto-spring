package one.digitalinnovation.labpadroesprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring initializr
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA;
 * - Spring Web;
 * - H2 Database;
 * - OpenFeign
 *
 * @author moisesmedeiros7
 */

@EnableFeignClients
@SpringBootApplication
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);
	}

}

// http://localhost:8080/swagger-ui/index.html