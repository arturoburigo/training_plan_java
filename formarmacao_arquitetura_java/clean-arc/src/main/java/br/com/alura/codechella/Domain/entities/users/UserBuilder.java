package br.com.alura.codechella.Domain.entities.users;

import br.com.alura.codechella.Domain.Address;

import java.time.LocalDate;

public class UserBuilder {
    private User user;

    public User withNameCpfEmail (String cpf, String name,  LocalDate birthDate) {
        this.user = new User(cpf,name, birthDate, "");
        return this.user;
    }

    public User addAddress(String zipcode, Integer number, String complement) {
        this.user.setAddress(new Address(zipcode, number, complement));
        return this.user;
    }
}
