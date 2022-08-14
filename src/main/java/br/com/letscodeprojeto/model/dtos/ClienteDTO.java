package br.com.letscodeprojeto.model.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClienteDTO {

    @NotEmpty(message = "O campo name não pode estar vazio.")
    @Size(min = 5, max = 11, message = "O campo name deve ter entre 5 e 11 caracteres.")
    private String name;

    @Min(18)
    private int age;

    @Pattern(regexp = "\\w\\w\\d{9}", message = "VAT Number inválido!")
    @NotEmpty(message = "O campo vatNumber não pode estar vazio.")
    private String vatNumber;

    @Email(message = "Email inválido")
    @NotEmpty(message = "O campo email não pode estar vazio.")
    private String email;

    private int codigoCategoria;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

}
