package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.ListUsers;
import br.com.alura.codechella.infra.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final ListUsers listUsers;

    public UserController(CreateUser createUser, ListUsers listUsers) {
        this.createUser = createUser;
        this.listUsers = listUsers;
    }

    @PostMapping
    public UserDTO registerUser(@RequestBody UserDTO dto) {
        User userCreated = createUser.createUser(new User(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UserDTO(userCreated.getCpf(), userCreated.getName(), userCreated.getBirthDate(), userCreated.getEmail());
    }

    @GetMapping
    public List<UserDTO> listUsers() {
        return listUsers.getAllUsers().stream()
                .map(user -> new UserDTO(user.getCpf(), user.getName(), user.getBirthDate(), user.getEmail()))
                .collect(Collectors.toList());
    }
}

