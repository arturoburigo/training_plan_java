package br.com.alura.codechella.Domain.entities.users;

import br.com.alura.codechella.Domain.Address;

import java.time.LocalDate;

public class User {
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String email;
    private Address address;


    public User(String cpf, String name, LocalDate birthDate, String email) {
        // por padrao no clean arc, as validacoes deve ocorrer no dominio
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("cpf not formatted correctly");
        }
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
