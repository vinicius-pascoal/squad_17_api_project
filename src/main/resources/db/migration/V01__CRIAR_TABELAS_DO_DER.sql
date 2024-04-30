CREATE TABLE Aluno (
	id INT PRIMARY KEY,
	id_usuario INT,
	nome varchar(60),
	matricula INT UNIQUE
);

CREATE TABLE Curso (
	id INT PRIMARY KEY,
	nome varchar(50),
	descricao varchar(250),
	ativo boolean
);

CREATE TABLE Aula (
	nome varchar(60),
	id INT PRIMARY KEY,
	data date,
	status varchar(15),
	id_curso INT
);

CREATE TABLE Usuario (
	id INT PRIMARY KEY,
	email varchar(60),
	senha varchar(20)
);

CREATE TABLE AlunoCurso (
	id_aluno INT,
	id_curso INT
);
 
ALTER TABLE Aluno ADD CONSTRAINT FK_Aluno_2
	FOREIGN KEY (id_usuario)
	REFERENCES Usuario (id)
	ON DELETE RESTRICT;
 
ALTER TABLE Aula ADD CONSTRAINT FK_Aula_2
	FOREIGN KEY (id_curso)
	REFERENCES Curso (id)
	ON DELETE RESTRICT;
 
ALTER TABLE AlunoCurso ADD CONSTRAINT FK_AlunoCurso_1
	FOREIGN KEY (id_aluno)
	REFERENCES Aluno (id)
	ON DELETE RESTRICT;
 
ALTER TABLE AlunoCurso ADD CONSTRAINT FK_AlunoCurso_2
	FOREIGN KEY (id_curso)
	REFERENCES Curso (id)
	ON DELETE SET NULL;
