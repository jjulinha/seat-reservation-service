-- ============================================================
-- V2 - Dados de seed para desenvolvimento e demo
-- Cria um evento ficticio com alguns assentos para teste.
-- ============================================================

-- Variavel local com o ID do evento de teste
-- Usamos um UUID fixo para facilitar o teste manual.
-- Em producao real, este seed nao existiria.
SET @event_id_demo = UNHEX('01979ABCDEF070008000000000000ACE');

-- Inventario do evento de demo: 10 assentos
INSERT INTO seat (seat_id, event_id, seat_identifier, status, price) VALUES
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'PISTA-01',     'AVAILABLE', 150.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'PISTA-02',     'AVAILABLE', 150.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'PISTA-03',     'AVAILABLE', 150.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'PISTA-04',     'AVAILABLE', 150.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'CAMAROTE-A1',  'AVAILABLE', 400.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'CAMAROTE-A2',  'AVAILABLE', 400.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'CAMAROTE-A3',  'AVAILABLE', 400.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'CADEIRA-01',   'AVAILABLE', 250.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'CADEIRA-02',   'AVAILABLE', 250.00),
                                                                         (UNHEX(REPLACE(UUID(), '-', '')), @event_id_demo, 'CADEIRA-03',   'SOLD',      250.00);