package com.manuel.workshop.controller;

import com.manuel.workshop.dto.ClienteDTO;
import com.manuel.workshop.model.Cliente;
import com.manuel.workshop.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Cliente", description = "Controller Cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ApiOperation(value = "Registrar cliente", notes = "Se recibe por el body un objeto de tipo clienteDTO y este se registra en la " +
            "base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/cliente")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO clienteDTO){
        return this.clienteService.crear(clienteDTO);
    }
    @ApiOperation(value = "Llenar base de datos de clientes." , hidden = true)
    @PostMapping("/clientes")
    public String crearClientes(){
        this.clienteService.crearClientes();
        return "Clientes creados!";
    }

}
