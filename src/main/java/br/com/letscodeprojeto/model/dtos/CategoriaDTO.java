package br.com.letscodeprojeto.model.dtos;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {

    @NotEmpty(message = "O campo nomeCategoria não pode estar vazio.")
    private String nomeCategoria;
    @NotEmpty(message = "O campo codigo não pode estar vazio.")
    private String codigo;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
