package com.unisul.seatreservation.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Representa um assento no inventario de um evento.
 * Espelha a tabela 'seat'. Este servico e o dono deste inventario.
 */
public class Seat {

    private UUID seatId;
    private UUID eventId;
    private String seatIdentifier;
    private String status;          // AVAILABLE, LOCKED, SOLD
    private BigDecimal price;
    private LocalDateTime lockedUntil;
    private UUID lockedByOrder;

    public Seat() {
    }

    public UUID getSeatId() {
        return seatId;
    }

    public void setSeatId(UUID seatId) {
        this.seatId = seatId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
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

    public LocalDateTime getLockedUntil() {
        return lockedUntil;
    }

    public void setLockedUntil(LocalDateTime lockedUntil) {
        this.lockedUntil = lockedUntil;
    }

    public UUID getLockedByOrder() {
        return lockedByOrder;
    }

    public void setLockedByOrder(UUID lockedByOrder) {
        this.lockedByOrder = lockedByOrder;
    }
}