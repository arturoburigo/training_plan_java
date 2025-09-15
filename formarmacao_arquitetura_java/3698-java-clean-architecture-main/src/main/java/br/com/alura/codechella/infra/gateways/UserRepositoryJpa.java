package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.infra.persistence.UserRepositoryPersistence;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryJpa implements UserRepository {
    private final UserRepositoryPersistence userRepository;
    private final UserEntityMapper mapper;

    public UserRepositoryJpa(UserRepositoryPersistence userRepository, UserEntityMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        userRepository.save(userEntity);
        return mapper.toDomain(userEntity);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
