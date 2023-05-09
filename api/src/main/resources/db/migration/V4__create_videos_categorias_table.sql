CREATE TABLE videos_categorias (
    video_id binary(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    categorias_id binary(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    PRIMARY KEY (video_id, categorias_id),
    FOREIGN KEY (video_id) REFERENCES videos (id) ON DELETE CASCADE,
    FOREIGN KEY (categorias_id) REFERENCES categorias (id) ON DELETE CASCADE
);
