package br.com.alura.adopet.api.services;

import br.com.alura.adopet.api.dto.CadastrarTutorDTO;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validations.ValidacaoCadastrarTutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
   @Autowired
   TutorRepository repository;

   @Autowired
   List<ValidacaoCadastrarTutor> validacoes;

   public void cadastrarTutor(CadastrarTutorDTO dto){
      validacoes.forEach( v -> v.validar(dto));
      Tutor tutor = new Tutor(dto.nome(), dto.email(), dto.telefone());
      repository.save(tutor);
   }
}
