package br.com.alura.codechella.Domain.entities;

import br.com.alura.codechella.Domain.entities.users.User;
import br.com.alura.codechella.Domain.entities.users.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserTest {

    @Test
    void shouldNotGenerateUserIfCPFIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("07309213", "Steve Jobs", LocalDate.parse("2003-01-01"), "Steve@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", "Steve Jobs", LocalDate.parse("2003-01-01"), "Steve@gmail.com"));

        //Sem formatacao
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("06636388013", "Steve Jobs", LocalDate.parse("2003-01-01"), "Steve@gmail.com"));
    }

    @Test
    void shouldGenerateUserIfCPFIsValid() {
        Assertions.assertDoesNotThrow(()-> new User("386.311.180-01", "Steve Jobs", LocalDate.parse("2003-01-01"), "Steve@gmail.com"));
    }

    @Test
    void shouldCreateUserUsingBuilder(){
        UserBuilder builder = new UserBuilder();
        User user = builder.withNameCpfEmail("386.311.180-01", "Steve",LocalDate.parse("2003-01-01"));
        builder.addAddress("07302", 10, "xpto");

        Assertions.assertEquals("Steve", user.getName());
        Assertions.assertEquals("386.311.180-01", user.getCpf());
        Assertions.assertEquals(LocalDate.parse("2003-01-01"), user.getBirthDate());
        Assertions.assertEquals("xpto", user.getAddress().getComplement());
    }
}