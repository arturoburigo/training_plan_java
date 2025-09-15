package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.Domain.entities.users.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);
    List<User> listAllUsers();
}
