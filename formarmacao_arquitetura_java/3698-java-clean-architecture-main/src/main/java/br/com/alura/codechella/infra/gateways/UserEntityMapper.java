package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.infra.persistence.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User user){
        return new UserEntity(user.getName(), user.getCpf(), user.getBirthDate(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getCpf(), userEntity.getNome(), userEntity.getNascimento(), userEntity.getEmail());
    }
}
