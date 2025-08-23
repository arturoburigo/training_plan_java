package br.com.alura.service;

import br.com.alura.service.client.ClientHttpConfiguration;
import br.com.alura.service.services.PetService;

import java.io.IOException;

public class ImportarPetsCommand implements Command {
   @Override
   public void execute() {
      try {
         ClientHttpConfiguration client = new ClientHttpConfiguration();
         PetService petService = new PetService(client);
         petService.importarPets();
      } catch (IOException | InterruptedException e) {
         System.out.println(e.getMessage());
      }
   }}
