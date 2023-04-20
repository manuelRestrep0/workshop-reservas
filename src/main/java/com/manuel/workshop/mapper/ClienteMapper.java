package com.manuel.workshop.mapper;

import com.manuel.workshop.dto.ClienteDTO;
import com.manuel.workshop.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.function.Function;

@Mapper
public interface ClienteMapper  {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteToClienteDTO(Cliente cliente);
    @Mapping(target = "cuentaHabilitada", ignore = true)
    @Mapping(target = "contrasena", ignore = true)
    Cliente clienteDTOtoCliente(ClienteDTO clienteDTO);

}
