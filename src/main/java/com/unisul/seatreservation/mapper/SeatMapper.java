package com.unisul.seatreservation.mapper;

import com.unisul.seatreservation.domain.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

/**
 * Contrato de acesso aos dados da tabela 'seat'.
 * O SQL de cada metodo fica em SeatMapper.xml.
 */
@Mapper
public interface SeatMapper {

    // Lista os assentos disponiveis de um evento
    List<Seat> findAvailableByEvent(@Param("eventId") UUID eventId);

    // Lista todos os assentos de um evento (qualquer status)
    List<Seat> findAllByEvent(@Param("eventId") UUID eventId);

    // Busca um assento especifico
    Seat findById(@Param("seatId") UUID seatId);

    // Insere um novo assento no inventario
    int insert(Seat seat);
}