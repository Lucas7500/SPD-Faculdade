CREATE DATABASE avaliacao1;

USE avaliacao1;

CREATE TABLE curso (
    iden INT PRIMARY KEY,
    ano INT NOT NULL,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE disciplina (
    nome VARCHAR(255) PRIMARY KEY,
    ch INT NOT NULL,
    iden_curso INT,
    FOREIGN KEY (iden_curso) REFERENCES curso(iden)
);
