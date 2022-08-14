package br.com.letscodeprojeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Categoria extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeCategoria;
    private String codigo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Categoria [codigo=" + codigo + ", nomeCategoria=" + nomeCategoria + "]";
    }

}
