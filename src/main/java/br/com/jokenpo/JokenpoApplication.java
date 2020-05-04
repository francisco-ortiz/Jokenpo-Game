package br.com.jokenpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@SpringBootApplication
@EnableJpaAuditing
public class JokenpoApplication { 

	public static void main(String[] args) {
		SpringApplication.run(JokenpoApplication.class, args);
	}
	
}
