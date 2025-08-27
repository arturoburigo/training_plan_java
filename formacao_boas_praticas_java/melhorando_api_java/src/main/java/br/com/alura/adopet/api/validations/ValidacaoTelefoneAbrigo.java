package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTelefoneAbrigo implements ValidacaoCadastroAbrigo {
   @Autowired
   AbrigoRepository repository;

   public void validar(CadastrarAbrigoDTO dto) {
      boolean telefoneJaCadastrado = repository.existsByTelefone(dto.telefone());
      if (telefoneJaCadastrado) {
         throw new ValidacaoException("Telefone ja cadastrado para outro abrigo");
      }
   }
}
