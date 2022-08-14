package br.com.letscodeprojeto;

import javax.enterprise.context.ApplicationScoped;
import br.com.letscodeprojeto.model.dtos.CategoriaDTO;
import br.com.letscodeprojeto.service.CategoriaService;
import io.quarkus.runtime.Startup;

@Startup
@ApplicationScoped
public class EagerAppBean {

    EagerAppBean(CategoriaService categoriaService) {
        CategoriaDTO programador = new CategoriaDTO();
        programador.setCodigo("1");
        programador.setNomeCategoria("Programador");
        categoriaService.cadastrarcategoria(programador);

        CategoriaDTO comerciante = new CategoriaDTO();
        comerciante.setCodigo("2");
        comerciante.setNomeCategoria("Comerciante");
        categoriaService.cadastrarcategoria(comerciante);

    }
}