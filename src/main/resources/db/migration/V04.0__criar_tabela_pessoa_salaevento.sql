CREATE TABLE pessoa_salaevento(
  pessoa_id int,
  salaevento_id int,
  CONSTRAINT fkpessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    CONSTRAINT fksala FOREIGN KEY (salaevento_id) REFERENCES salaevento(id)
);


INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (1, 2);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (1, 3);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (3, 2);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (3, 3);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (2, 1);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (2, 2);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (4, 1);
INSERT INTO pessoa_salaevento (pessoa_id, salaevento_id) VALUES (4, 3);

