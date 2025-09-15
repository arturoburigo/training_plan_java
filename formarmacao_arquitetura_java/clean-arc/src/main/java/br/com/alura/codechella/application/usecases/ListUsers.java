package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.application.gateways.UserRepository;

import java.util.List;

public class ListUsers {
    private final UserRepository repository;

    public ListUsers(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
       return this.repository.listAllUsers();
    }
}
