CREATE TABLE videos (
  id binary(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
  titulo VARCHAR(255) NOT NULL,
  descricao VARCHAR(255),
  url VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)
