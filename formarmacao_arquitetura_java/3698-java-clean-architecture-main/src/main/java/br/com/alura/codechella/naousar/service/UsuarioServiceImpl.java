package br.com.alura.codechella.naousar.service;

import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.naousar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserEntity cadastrarUsuario(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    @Override
    public List<UserEntity> listarTodos() {
        return repository.findAll();
    }
}
