package br.com.alura.service;

import br.com.alura.service.client.ClientHttpConfiguration;
import br.com.alura.service.services.AbrigoService;
import br.com.alura.service.services.PetService;

import java.io.IOException;

public class ListarPetCommand implements Command {
   @Override
   public void execute() {
      try {
         ClientHttpConfiguration client = new ClientHttpConfiguration();
         PetService petService = new PetService(client);
         petService.listarPets();
      } catch (IOException | InterruptedException e) {
         System.out.println(e.getMessage());
      }
   }
}
