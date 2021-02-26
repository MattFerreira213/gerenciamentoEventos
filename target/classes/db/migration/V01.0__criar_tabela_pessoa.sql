CREATE TABLE pessoa(
	id serial primary key,
	nome varchar(50) not NULL,
	sobrenome varchar(50) not NULL
);

INSERT INTO pessoa (nome, sobrenome) VALUES ('Lucas', 'Silva');
INSERT INTO pessoa (nome, sobrenome) VALUES ('Diego', 'Souza');
INSERT INTO pessoa (nome, sobrenome) VALUES ('Mauricio', 'Pereira');
INSERT INTO pessoa (nome, sobrenome) VALUES ('Anna', 'Xavier');