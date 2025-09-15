package br.com.alura.codechella.infra.persistence;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.application.gateways.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryPersistence extends JpaRepository<UserEntity, Long> {
}
