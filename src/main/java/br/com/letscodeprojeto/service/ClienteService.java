package br.com.letscodeprojeto.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.letscodeprojeto.model.Categoria;
import org.modelmapper.ModelMapper;

import br.com.letscodeprojeto.model.Cliente;
import br.com.letscodeprojeto.model.ClienteMapper;
import br.com.letscodeprojeto.model.dtos.ClienteDTO;

@ApplicationScoped
public class ClienteService {

    @Inject
    public ClienteMapper clienteMapper;


    public Categoria categoria;

    @Produces(MediaType.APPLICATION_JSON)
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = Cliente.findAll().list();
        return clientes.stream()
                .map(cliente -> toClienteDTO(cliente))
                .collect(Collectors.toList());
    };

    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = toCliente(clienteDTO);
        cliente.setCategoria(Categoria.getCategoriaMap(clienteDTO.getCodigoCategoria()));
        Cliente.persist(cliente);
        return Response.ok(clienteDTO).status(Response.Status.CREATED).build();
    }

    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarCliente(ClienteDTO clienteDTO, long id) {
        Cliente clienteAtualizado = Cliente.findById(id);
        clienteAtualizado.setName(clienteDTO.getName());
        clienteAtualizado.setAge(clienteDTO.getAge());
        clienteAtualizado.setEmail(clienteDTO.getEmail());
        clienteAtualizado.setVatNumber(clienteDTO.getVatNumber());
        clienteAtualizado.setCodigoCategoria(clienteDTO.getCodigoCategoria());
        clienteAtualizado.setCategoria(Categoria.getCategoriaMap(clienteDTO.getCodigoCategoria()));

        return Response.ok(clienteDTO).status(Response.Status.OK).build();
    }

    @Transactional
    public Response deletarCliente(long id) {
        Cliente cliente = Cliente.findById(id);
        cliente.delete();
        return Response.ok().status(Response.Status.OK).build();
    }

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clienteDTO, Cliente.class);
    }

}
