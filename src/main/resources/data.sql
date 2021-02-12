DROP TABLE IF EXISTS urls;

CREATE TABLE urls (
  id int AUTO_INCREMENT PRIMARY KEY,
  original VARCHAR(250) NOT NULL,
  shortened VARCHAR(250) NOT NULL
);

INSERT INTO urls (original, shortened) VALUES
  ('https://guseyn.com/posts/type-is-not-source-of-behaviour?v=1.0.227', 'http://localhost:8080/short1');
