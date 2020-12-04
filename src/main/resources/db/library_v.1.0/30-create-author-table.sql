CREATE TABLE author (
  id         BIGINT       NOT NULL,
  first_name  VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  middle_name VARCHAR(255),
  PRIMARY KEY (id)
);

GO

ALTER TABLE book
ADD CONSTRAINT author_fk FOREIGN KEY (id_of_author) REFERENCES author (id);

GO