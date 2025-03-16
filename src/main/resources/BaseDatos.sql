CREATE TABLE IF NOT EXISTS account (
    id SERIAL PRIMARY KEY,
    client_identification VARCHAR(10) NOT NULL,
    number VARCHAR(6) NOT NULL UNIQUE,
    type VARCHAR(10),
    initial_balance DOUBLE PRECISION NOT NULL,
    state BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS movement (
    id SERIAL PRIMARY KEY,
    movement_date TIMESTAMP NOT NULL,
    type VARCHAR(10),
    movement_value DOUBLE PRECISION NOT NULL,
    balance DOUBLE PRECISION NOT NULL,
    account_number VARCHAR(6),
    FOREIGN KEY (account_number) REFERENCES account (number)
);

-- INSERT INTO account (client_identification, number, type, initial_balance, state)
-- VALUES
-- ('1234567890', '478758', 'SAVES', 2000.0, TRUE),
-- ('1234567891', '225487', 'CHECKING', 100.0, TRUE),
-- ('1234567893', '495878', 'SAVES', 0.0, TRUE),
-- ('1234567891', '496825', 'SAVES', 540.0, TRUE),
-- ('1234567890', '585545', 'CHECKING', 1000.0, TRUE);
--
-- INSERT INTO movement (movement_date, type, movement_value, balance, account_number)
-- VALUES
-- ('2025-03-15 10:00:00', 'SAVES', -575.0, 1425.0, '478758'),
-- ('2025-03-15 15:30:00', 'CHECKING', 600.0, 700.0, '225487'),
-- ('2025-03-15 09:45:00', 'SAVES', 150.0, 150.0, '495878'),
-- ('2025-03-15 09:45:00', 'SAVES', -540.0, 0.0, '496825');
