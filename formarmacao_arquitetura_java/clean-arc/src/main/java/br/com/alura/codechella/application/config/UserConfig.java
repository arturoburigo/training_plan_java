package br.com.alura.codechella.application.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.ListUsers;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryJpa;
import br.com.alura.codechella.infra.persistence.UserRepositoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CreateUser createUser(UserRepository userRepository){
        return new CreateUser(userRepository);
    }

    @Bean
    UserRepositoryJpa crateRepositoryJpa(UserRepositoryPersistence repository, UserEntityMapper mapper){
        return new UserRepositoryJpa(repository, mapper);
    }

    @Bean
    UserEntityMapper userEntityMapper(){
        return new UserEntityMapper();
    }

    @Bean
    ListUsers listUsers(UserRepository userRepository){
        return new ListUsers(userRepository);
    }
}
