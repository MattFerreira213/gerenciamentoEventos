CREATE TABLE pessoa_espacocafe(
  pessoa_id int,
  espacocafe_id int,
    CONSTRAINT fkpessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    CONSTRAINT fkespacocafe FOREIGN KEY (espacocafe_id) REFERENCES espacocafe(id)
);


INSERT INTO pessoa_espacocafe (pessoa_id, espacocafe_id) VALUES (1, 1);
INSERT INTO pessoa_espacocafe (pessoa_id, espacocafe_id) VALUES (3, 2);
INSERT INTO pessoa_espacocafe (pessoa_id, espacocafe_id) VALUES (2, 1);
INSERT INTO pessoa_espacocafe (pessoa_id, espacocafe_id) VALUES (4, 2);