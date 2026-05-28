package com.unisul.seatreservation.controller;

import com.unisul.seatreservation.dto.SeatResponse;
import com.unisul.seatreservation.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Endpoints HTTP do servico de Reserva de Assentos.
 * Recebe requests, delega para o Service, devolve DTOs.
 */
@RestController
@RequestMapping("/events/{eventId}/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    /**
     * GET /events/{eventId}/seats
     * Lista os assentos disponiveis (status AVAILABLE) de um evento.
     */
    @GetMapping
    public List<SeatResponse> listAvailableSeats(@PathVariable UUID eventId) {
        return seatService.findAvailableSeats(eventId)
                .stream()
                .map(SeatResponse::from)
                .toList();
    }
}