ALTER TABLE videos ADD COLUMN categoria_id BINARY(16) NOT NULL;
ALTER TABLE videos ADD CONSTRAINT fk_videos_categorias FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE RESTRICT;