package br.com.letscodeprojeto.model;

import javax.enterprise.context.ApplicationScoped;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.letscodeprojeto.model.dtos.ClienteDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface ClienteMapper {

    @Mapping(target = "name", ignore = true)
    ClienteDTO toDTO(Cliente cliente);

    @Mapping(target = "id", ignore = true)
    Cliente toClienteEntity(ClienteDTO clienteDTO);

}
