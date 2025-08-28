package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastrarTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoEmailTutor implements ValidacaoCadastrarTutor {

   @Autowired
   private TutorRepository repository;

   public void validar(CadastrarTutorDTO dto) {
      boolean emailJaCadastrado = repository.existsByEmail(dto.email());
      if (emailJaCadastrado) {
         throw new ValidacaoException("E-mail ja cadastrado para outro tutor");
      }
   }
}
