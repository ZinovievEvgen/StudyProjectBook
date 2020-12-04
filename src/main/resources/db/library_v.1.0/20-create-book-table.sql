CREATE TABLE book (
  id         BIGINT       NOT NULL,
  name  VARCHAR(255) NOT NULL,
  id_of_person BIGINT,
  id_of_author BIGINT,
  PRIMARY KEY (id)
);

GO

ALTER TABLE book
ADD CONSTRAINT person_fk FOREIGN KEY (id_of_person) REFERENCES person (id);

GO