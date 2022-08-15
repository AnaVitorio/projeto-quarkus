package br.com.letscodeprojeto.model.dtos;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {
    private String nomeCategoria;

    private int codigo;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
