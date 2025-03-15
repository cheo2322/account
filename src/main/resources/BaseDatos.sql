CREATE TABLE IF NOT EXISTS account (
    id SERIAL PRIMARY KEY,
    client_identification VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(10),
    initial_balance BIGINT NOT NULL,
    state BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS movement (
    id SERIAL PRIMARY KEY,
    movement_date TIMESTAMP NOT NULL,
    type VARCHAR(10),
    movement_value BIGINT NOT NULL,
    balance BIGINT NOT NULL,
    account_number VARCHAR(255),
    FOREIGN KEY (account_number) REFERENCES account (number)
);
