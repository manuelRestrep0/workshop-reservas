package com.manuel.workshop.mapper;

import com.manuel.workshop.dto.ReservaDTO;
import com.manuel.workshop.model.Reserva;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T08:27:41-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public ReservaDTO reservaToReservaDTO(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        ReservaDTO reservaDTO = new ReservaDTO();

        reservaDTO.setFechaReserva( reserva.getFechaReserva() );
        reservaDTO.setHabitacion( reserva.getHabitacion() );
        reservaDTO.setCliente( reserva.getCliente() );
        reservaDTO.setTotalPago( reserva.getTotalPago() );

        return reservaDTO;
    }

    @Override
    public Reserva reservaDTOtoReserva(ReservaDTO reservaDTO) {
        if ( reservaDTO == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setFechaReserva( reservaDTO.getFechaReserva() );
        reserva.setHabitacion( reservaDTO.getHabitacion() );
        reserva.setCliente( reservaDTO.getCliente() );
        reserva.setTotalPago( reservaDTO.getTotalPago() );

        return reserva;
    }
}
