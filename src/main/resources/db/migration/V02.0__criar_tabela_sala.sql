CREATE TABLE salaevento(
	id serial primary key,
	nome varchar(50) not NULL,
	lotacao int NOT NULL
);

INSERT INTO salaevento (nome, lotacao) VALUES ('Java com React', 25);
INSERT INTO salaevento (nome, lotacao) VALUES ('Kotlin Intermediario', 20);
INSERT INTO salaevento (nome, lotacao) VALUES ('DevOps', 30);