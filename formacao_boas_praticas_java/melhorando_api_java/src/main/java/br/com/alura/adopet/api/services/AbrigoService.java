package br.com.alura.adopet.api.services;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.alura.adopet.api.dto.CadastrarPetDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.validations.ValidacaoCadastroAbrigo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {
    @Autowired
    AbrigoRepository repository;

    @Autowired
    List<ValidacaoCadastroAbrigo> validacoes;

    public void cadastrarAbrigo(CadastrarAbrigoDTO dto){
       validacoes.forEach( v -> v.validar(dto));
       Abrigo abrigo = new Abrigo(dto.nome(), dto.email(), dto.telefone());
    }

    public void CadastrarPet(CadastrarPetDTO dto, String idOuNome) {
        try {
            Long id = Long.parseLong(idOuNome);
            Abrigo abrigo = repository.getReferenceById(id);
            Pet pet = new Pet(abrigo, dto);
            abrigo.getPets().add(pet);
        } catch (EntityNotFoundException enfe) {
            throw new ValidacaoException(enfe.getMessage());
        } catch (NumberFormatException nfe) {
            try {
               Abrigo abrigo = repository.findByNome(idOuNome);
               Pet pet = new Pet(abrigo, dto);
               abrigo.getPets().add(pet);
            } catch (EntityNotFoundException enfe) {
               throw new ValidacaoException(enfe.getMessage());
            }
        }
    }

    public List<Pet> listarPetsAbrigo(String idOuNome) {
       try {
          Long id = Long.parseLong(idOuNome);
          List<Pet> pets = repository.getReferenceById(id).getPets();
          return pets;
       } catch (EntityNotFoundException enfe) {
             throw new ValidacaoException(enfe.getMessage());
       } catch (NumberFormatException e) {
          try {
             List<Pet> pets = repository.findByNome(idOuNome).getPets();
             return pets;
          } catch (EntityNotFoundException enfe) {
            throw new ValidacaoException(enfe.getMessage());
          }
       }
    }
}
