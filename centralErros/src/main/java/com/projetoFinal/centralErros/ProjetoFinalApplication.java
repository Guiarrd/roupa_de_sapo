package com.projetoFinal.centralErros;

import com.projetoFinal.centralErros.model.User;
import com.projetoFinal.centralErros.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

  //Adiciona dummy data
  @Bean
  public CommandLineRunner run(UserRepository userRepository) throws Exception {
    return (String[] args) -> {
      User user1 = new User();
      User user2 = new User();

      user1.setFullName("John");
      user1.setPassword("123456");
      user1.setEmail("john@domain.com");

      user2.setFullName("Julie");
      user2.setEmail("julie@domain.com");
      user2.setPassword("password");

      userRepository.save(user1);
      userRepository.save(user2);
    };
  }
}
