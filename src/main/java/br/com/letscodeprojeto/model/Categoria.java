package br.com.letscodeprojeto.model;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Categoria extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeCategoria;
    private int codigo;

    @ElementCollection(fetch = FetchType.LAZY)
    protected static Map<Integer, String> mapCategorias = new HashMap<Integer, String>();

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Map<Integer, String> getMapCategorias() {
        return mapCategorias;
    }


    public static String getCategoriaMap(int key){
        return mapCategorias.get(key);

    }

    public static void setCategoriaMap(int key, String value){
        mapCategorias.put(key, value);
    }

    public static void removerCategoria(int codigo){
        mapCategorias.remove(codigo);
    }

    public static void atualizarCategoria(int key, String value){

    }


}
