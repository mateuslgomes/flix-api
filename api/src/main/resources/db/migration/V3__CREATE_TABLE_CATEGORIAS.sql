CREATE TABLE categorias (
    id binary(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    titulo VARCHAR(255) NOT NULL,
    cor VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);