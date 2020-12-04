CREATE TABLE person (
  id         BIGINT       NOT NULL,
  first_name  VARCHAR(255) NOT NULL,
  last_name   VARCHAR(255) NOT NULL,
  middle_name VARCHAR(255),
  birth_date  TIMESTAMP (8),
  PRIMARY KEY (id)
);

GO