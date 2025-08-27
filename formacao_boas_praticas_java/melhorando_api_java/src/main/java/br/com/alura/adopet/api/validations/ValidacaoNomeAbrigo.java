package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoNomeAbrigo implements ValidacaoCadastroAbrigo {
   @Autowired
   AbrigoRepository repository;

   public void validar(CadastrarAbrigoDTO dto) {
      boolean nomeJaCadastrado = repository.existsByNome(dto.nome());
      if (nomeJaCadastrado) {
         throw new ValidacaoException("Nome ja cadastrado para outro abrigo");
      }
   }
}
