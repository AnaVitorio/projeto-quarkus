package br.com.letscodeprojeto.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum CategoriaEnum {
    PROGRAMADOR(1),
    COMERCIANTE(2);

    private int codigo;
    private static Map<Integer, CategoriaEnum> map = new HashMap<>();

    private CategoriaEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    static {
        for (CategoriaEnum categoriaEnum : CategoriaEnum.values()) {
            map.put(categoriaEnum.codigo, categoriaEnum);
        }
    }

    public static String valueOf(int codigo) {
        return map.get(codigo).toString();
    }

}
