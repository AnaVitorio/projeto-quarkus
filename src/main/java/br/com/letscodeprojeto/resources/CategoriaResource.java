package br.com.letscodeprojeto.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import br.com.letscodeprojeto.model.dtos.CategoriaDTO;
import br.com.letscodeprojeto.service.CategoriaService;

@Path("/categoria")
@ApplicationScoped
public class CategoriaResource {

    @Inject
    CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Path("/list")
    @GET
    public Response listarcategorias() {
        return Response.ok(categoriaService.listarcategorias()).build();
    }

    @Path("/criar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response cadastrarcategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.cadastrarcategoria(categoriaDTO);
    }

    @Path("/update/{id}")
    @PUT
    public Response atualizarcategoria(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathParam("id") int id) {
        return categoriaService.atualizarcategoria(categoriaDTO, id);
    }

    @Path("/delete/{id}")
    @DELETE
    public Response deletarcategoria(@PathParam("id") long id) {
        return categoriaService.deletarcategoria(id);
    }

}
