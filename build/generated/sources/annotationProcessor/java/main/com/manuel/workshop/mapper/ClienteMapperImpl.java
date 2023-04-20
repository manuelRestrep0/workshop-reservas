package com.manuel.workshop.mapper;

import com.manuel.workshop.dto.ClienteDTO;
import com.manuel.workshop.model.Cliente;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T08:27:41-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setNombre( cliente.getNombre() );
        clienteDTO.setApellido( cliente.getApellido() );
        clienteDTO.setCedula( cliente.getCedula() );
        clienteDTO.setCorreo( cliente.getCorreo() );
        clienteDTO.setDireccion( cliente.getDireccion() );
        clienteDTO.setEdad( cliente.getEdad() );

        return clienteDTO;
    }

    @Override
    public Cliente clienteDTOtoCliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre( clienteDTO.getNombre() );
        cliente.setApellido( clienteDTO.getApellido() );
        cliente.setCedula( clienteDTO.getCedula() );
        cliente.setDireccion( clienteDTO.getDireccion() );
        cliente.setEdad( clienteDTO.getEdad() );
        cliente.setCorreo( clienteDTO.getCorreo() );

        return cliente;
    }
}
