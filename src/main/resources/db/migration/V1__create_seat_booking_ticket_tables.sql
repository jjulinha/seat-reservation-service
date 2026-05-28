-- ============================================================
-- V1 - Estrutura inicial do servico de Reserva de Assentos
-- ============================================================

-- Inventario de assentos por evento (este servico e o dono)
CREATE TABLE seat (
                      seat_id          BINARY(16)     NOT NULL,
                      event_id         BINARY(16)     NOT NULL,
                      seat_identifier  VARCHAR(50)    NOT NULL,
                      status           VARCHAR(20)    NOT NULL DEFAULT 'AVAILABLE',
                      price            DECIMAL(10,2)  NOT NULL,
                      locked_until     TIMESTAMP      NULL,
                      locked_by_order  BINARY(16)     NULL,
                      PRIMARY KEY (seat_id),
                      UNIQUE KEY uk_seat_event_identifier (event_id, seat_identifier),
                      INDEX idx_seat_event_status (event_id, status)
);

-- Reserva (booking) feita por um usuario
CREATE TABLE booking (
                         order_id        BINARY(16)     NOT NULL,
                         user_id         BINARY(16)     NOT NULL,
                         event_id        BINARY(16)     NOT NULL,
                         booking_status  VARCHAR(20)    NOT NULL DEFAULT 'PENDING',
                         total_price     DECIMAL(10,2)  NOT NULL DEFAULT 0.00,
                         expires_at      TIMESTAMP      NULL,
                         created_at      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (order_id),
                         INDEX idx_booking_status_expires (booking_status, expires_at)
);

-- Ingresso emitido apos confirmacao da reserva
CREATE TABLE ticket (
                        ticket_id      BINARY(16)     NOT NULL,
                        order_id       BINARY(16)     NOT NULL,
                        seat_id        BINARY(16)     NOT NULL,
                        event_id       BINARY(16)     NOT NULL,
                        ticket_type    VARCHAR(20)    NOT NULL,
                        ticket_price   DECIMAL(10,2)  NOT NULL,
                        issued_at      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (ticket_id),
                        CONSTRAINT fk_ticket_booking FOREIGN KEY (order_id) REFERENCES booking (order_id),
                        CONSTRAINT fk_ticket_seat    FOREIGN KEY (seat_id)  REFERENCES seat (seat_id),
                        INDEX idx_ticket_order (order_id)
);