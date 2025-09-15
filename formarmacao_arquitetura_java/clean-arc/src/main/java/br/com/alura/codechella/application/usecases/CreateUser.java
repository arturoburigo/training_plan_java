package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.application.gateways.UserRepository;

public class CreateUser {

    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }
}
