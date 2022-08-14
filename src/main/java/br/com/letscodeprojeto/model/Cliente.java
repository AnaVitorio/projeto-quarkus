package br.com.letscodeprojeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Cliente extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "O campo name não pode estar vazio.")
    @NotNull(message = "O campo name não pode ser nulo.")
    @Size(min = 5, max = 11, message = "O campo name deve ter entre 5 e 11 caracteres.")
    private String name;

    @NotNull(message = "O campo age não pode ser nulo.")
    @Min(18)
    private int age;

    @Pattern(regexp = "\\w\\w\\d{9}", message = "VAT Number inválido!")
    @NotEmpty(message = "O campo vatNumber não pode estar vazio.")
    @NotNull(message = "O campo vatNumber não pode ser nulo.")
    private String vatNumber;

    @Email(message = "Email inválido")
    @NotEmpty(message = "O campo email não pode estar vazio.")
    @NotNull(message = "O campo email não pode ser nulo.")
    private String email;

    @NotEmpty(message = "O campo categoria não pode estar vazio.")
    @NotNull(message = "O campo categoria não pode ser nulo.")
    private String categoria;

    @NotNull(message = "O campo codigoCategoria não pode ser nulo.")
    private int codigoCategoria;

    public long getId() {
        return this.id;
    };

    public void setId(long id) {
        this.id = id;
    };

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

}
