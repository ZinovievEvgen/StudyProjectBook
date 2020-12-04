CREATE TABLE book_genre_lnk (
  book_id BIGINT NOT NULL,
  genre_id BIGINT NOT NULL,
  PRIMARY KEY (book_id, genre_id),
  FOREIGN KEY (book_id)
      REFERENCES book (id),
  FOREIGN KEY (genre_id)
      REFERENCES dim_genre (id)
);