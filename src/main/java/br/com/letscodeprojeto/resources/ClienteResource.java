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

import br.com.letscodeprojeto.model.dtos.ClienteDTO;
import br.com.letscodeprojeto.service.ClienteService;

@Path("/client")
@ApplicationScoped
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Path("/list")
    @GET
    public Response listarClientes() {
        return Response.ok(clienteService.listarClientes()).build();
    }

    @Path("/client")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        return clienteService.cadastrarCliente(clienteDTO);
    }

    @Path("/update/{id}")
    @PUT
    public Response atualizarCliente(@Valid @RequestBody ClienteDTO clienteDTO, @PathParam("id") int id) {
        return clienteService.atualizarCliente(clienteDTO, id);
    }

    @Path("/delete/{id}")
    @DELETE
    public Response deletarCliente(@PathParam("id") long id) {
        return clienteService.deletarCliente(id);
    }

}
