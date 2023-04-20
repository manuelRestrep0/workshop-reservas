package com.manuel.workshop.mapper;

import com.manuel.workshop.dto.ReservaDTO;
import com.manuel.workshop.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    ReservaDTO reservaToReservaDTO(Reserva reserva);

    Reserva reservaDTOtoReserva(ReservaDTO reservaDTO);


}
