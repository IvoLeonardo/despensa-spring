package br.com.ilsc.despensa.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = "br.com.ilsc.despensa.spring.model")
//@ComponentScan(basePackages = { "br.com.ilsc.*" }) // A anotação @ComponenteScan com o "*" mapeia todos os packages de
// Controller -> pesquisar para saber se esse código é legado
//@EnableJpaRepositories(basePackages = "br.com.ilsc.despensa.spring.repository") // Anotação para reconhecer os
// repositorys
//@EnableTransactionManagement // Responsável por fazer todas as transações
public class DespensaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DespensaSpringApplication.class, args);
	}

}
