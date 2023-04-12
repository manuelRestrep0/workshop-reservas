package com.manuel.workshop.controller;

import com.manuel.workshop.dto.HabitacionDTO;
import com.manuel.workshop.dto.ReservaDTO;
import com.manuel.workshop.model.Habitacion;
import com.manuel.workshop.model.Reserva;
import com.manuel.workshop.service.ReservaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Reserva", description = "Controller Reserva")
public class ReservaController {

    private ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @ApiOperation(value = "Obtener habitaciones disponibles",
            notes = "Se recibe por la url la fecha en la que se desea ver la disponibilidad de las habitaciones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/disponibles/{fecha}")
    public List<HabitacionDTO> disponiblesFecha(@PathVariable("fecha") String fecha){
        return this.reservaService.obtenerHabitacionesDisponiblesFecha(fecha);
    }
    @ApiOperation(value = "Obtener habitaciones disponibles",
            notes = "Se recibe por la url la fecha y el tipo de habitaciones" +
                    " en la que se desea ver la disponibilidad de las habitaciones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/disponibles/habitacion")
    public List<HabitacionDTO> disponiblesTipo(@RequestParam("tipo") String tipo, @RequestParam("fecha") String fecha){
        return this.reservaService.filtrarHabitacionesTipo(tipo,fecha);
    }

    @ApiOperation(value = "Obtener las reservas hechas por un cliente",
            notes = "Se recibe por la url la cedula del cliente y se devuelve una lista con todas sus reservas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/reservas/{cedula}")
    public List<ReservaDTO> reservasCliente(@PathVariable("cedula") Integer cedula){
        return this.reservaService.obtenerReservasCliente(cedula);
    }

    @ApiOperation(value = "Obtener habitaciones disponibles",
            notes = "Se recibe por la url el numero de la habitacion, la fecha a reservar y la cedula del cliente." +
                    "de cumplir las validaciones se retorna la informacion de la reserva.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/reservar")
    public ReservaDTO reservar(@RequestParam("numero")Integer numeroHabitacion, @RequestParam("fecha") String fecha, @RequestParam("cedula") Integer cedula){
        return this.reservaService.crearReserva(numeroHabitacion,cedula,fecha);
    }


}
