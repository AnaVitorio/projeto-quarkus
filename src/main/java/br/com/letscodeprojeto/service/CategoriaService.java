package br.com.letscodeprojeto.service;

import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;

import br.com.letscodeprojeto.model.Categoria;
import br.com.letscodeprojeto.model.dtos.CategoriaDTO;

@ApplicationScoped
public class CategoriaService {

    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> listarcategorias() {
        return Categoria.findAll().list();
    };

    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarcategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = toCategoria(categoriaDTO);
        Categoria.persist(categoria);
        Categoria.setCategoriaMap(categoria.getCodigo(), categoria.getNomeCategoria());
        return Response.ok(categoriaDTO).status(Response.Status.CREATED).build();
    }

    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarcategoria(CategoriaDTO categoriaDTO, long id) {
        Categoria categoriaAtualizado = Categoria.findById(id);
        categoriaAtualizado.getMapCategorias().remove(categoriaAtualizado.getCodigo());

        categoriaAtualizado.setCodigo(categoriaDTO.getCodigo());
        categoriaAtualizado.setNomeCategoria(categoriaDTO.getNomeCategoria());

        categoriaAtualizado.getMapCategorias().put(categoriaAtualizado.getCodigo(), categoriaAtualizado.getNomeCategoria());

        return Response.ok(categoriaDTO).status(Response.Status.OK).build();
    }

    @Transactional
    public Response deletarcategoria(long id) {
        Categoria categoria = Categoria.findById(id);
        Categoria.deleteById(id);
        Categoria.removerCategoria(categoria.getCodigo());
        return Response.ok().status(Response.Status.OK).build();
    }

    public static CategoriaDTO toCategoriaDTO(Categoria categoria) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    public static Categoria toCategoria(CategoriaDTO categoriaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoriaDTO, Categoria.class);
    }

}
