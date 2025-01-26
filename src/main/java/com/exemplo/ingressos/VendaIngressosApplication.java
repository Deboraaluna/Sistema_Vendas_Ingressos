package com.exemplo.ingressos;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.exemplo.ingressos.model") // Especifique o pacote onde as entidades estão localizadas
@EnableJpaRepositories(basePackages = "com.exemplo.ingressos.repository")  // Escaneia o repositório
public class VendaIngressosApplication {
	public static void main(String[] args) {
		SpringApplication.run(VendaIngressosApplication.class, args);
	}
}
//ponto de partida de execução da aplicação
//add as notaçoes @EntityScan e @EnablesJPA para o spring reconhecer