package com.estech.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estech.course.entities.User;
import com.estech.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*A anotação @Autowired é uma parte central do Spring Framework e é amplamente utilizada no Spring Boot 
	 * para realizar a injeção de dependências automaticamente. A injeção de dependências é um padrão de design 
	 * que permite que um objeto forneça as dependências de outro objeto, promovendo a inversão de controle (IoC).
	 * 
	 * */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
