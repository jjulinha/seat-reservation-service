package com.unisul.seatreservation.dto;

import com.unisul.seatreservation.domain.Seat;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Representacao publica de um assento na API.
 * Esconde campos internos como locked_until e locked_by_order.
 */
public class SeatResponse {

    private UUID seatId;
    private String seatIdentifier;
    private String status;
    private BigDecimal price;

    public SeatResponse() {
    }

    public SeatResponse(UUID seatId, String seatIdentifier, String status, BigDecimal price) {
        this.seatId = seatId;
        this.seatIdentifier = seatIdentifier;
        this.status = status;
        this.price = price;
    }

    /**
     * Fabrica que converte uma entity Seat em SeatResponse.
     * Centraliza a traducao num lugar so.
     */
    public static SeatResponse from(Seat seat) {
        return new SeatResponse(
                seat.getSeatId(),
                seat.getSeatIdentifier(),
                seat.getStatus(),
                seat.getPrice()
        );
    }

    public UUID getSeatId() {
        return seatId;
    }

    public void setSeatId(UUID seatId) {
        this.seatId = seatId;
    }

    public String getSeatIdentifier() {
        return seatIdentifier;
    }

    public void setSeatIdentifier(String seatIdentifier) {
        this.seatIdentifier = seatIdentifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}