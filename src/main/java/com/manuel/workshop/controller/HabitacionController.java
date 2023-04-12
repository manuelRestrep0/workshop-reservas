package com.manuel.workshop.controller;

import com.manuel.workshop.dto.HabitacionDTO;
import com.manuel.workshop.model.Cliente;
import com.manuel.workshop.model.Habitacion;
import com.manuel.workshop.service.HabitacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Habitacion", description = "Controller Habitacion")
public class HabitacionController {

    private HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @ApiOperation(value = "Registrar habitacion", notes = "Se recibe por el body un objeto de tipo habitacionDTO y este se registra en la " +
            "base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/habitacion")
    public HabitacionDTO crearHabitacion(@RequestBody HabitacionDTO habitacion){
        return this.habitacionService.crearHabitacion(habitacion);
    }

    @ApiOperation(value = "llenar base de datos de habitaciones", hidden = true)
    @PostMapping("/habitaciones")
    public ResponseEntity<Habitacion> crearHabitacion(){
        this.habitacionService.crearHabitaciones();
        return new ResponseEntity("habitaciones creadas",HttpStatus.CREATED);
    }
}
