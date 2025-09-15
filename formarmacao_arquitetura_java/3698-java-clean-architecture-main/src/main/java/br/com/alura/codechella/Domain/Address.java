package br.com.alura.codechella.Domain;

public class Address {
    private String zipcode;
    private Integer number;
    private String complement;

    public Address(String zipcode, Integer number, String complement) {
        this.zipcode = zipcode;
        this.number = number;
        this.complement = complement;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
