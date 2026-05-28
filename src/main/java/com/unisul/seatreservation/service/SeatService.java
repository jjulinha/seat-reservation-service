package com.unisul.seatreservation.service;

import com.unisul.seatreservation.domain.Seat;
import com.unisul.seatreservation.mapper.SeatMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Regras de negocio relacionadas a assentos.
 * Por enquanto so consulta; depois vai conter
 * a logica de reservar, confirmar e expirar.
 */
@Service
public class SeatService {

    private final SeatMapper seatMapper;

    // Injecao de dependencia via construtor.
    // O Spring entrega o SeatMapper automaticamente.
    public SeatService(SeatMapper seatMapper) {
        this.seatMapper = seatMapper;
    }

    /**
     * Lista todos os assentos disponiveis (status AVAILABLE) de um evento.
     */
    public List<Seat> findAvailableSeats(UUID eventId) {
        return seatMapper.findAvailableByEvent(eventId);
    }
}