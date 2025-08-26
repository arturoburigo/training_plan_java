package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitarAdocaoPet{
   @Autowired
   PetRepository petRepository;
   @Autowired
   AdocaoRepository adocaoRepository;
   public void validar(SolicitacaoAdocaoDTO dto) {
       boolean petTemAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);
       Pet pet = petRepository.getReferenceById(dto.idPet());
       if (petTemAdocaoEmAndamento) {
             throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
      }
   }
}
