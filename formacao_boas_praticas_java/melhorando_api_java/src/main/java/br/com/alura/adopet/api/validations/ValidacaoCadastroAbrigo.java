package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import org.springframework.stereotype.Component;

@Component
public interface ValidacaoCadastroAbrigo {
   void validar(CadastrarAbrigoDTO dto);
}
