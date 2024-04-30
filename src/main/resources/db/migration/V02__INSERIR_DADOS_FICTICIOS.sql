-- Inserção de dados na tabela Usuario
INSERT INTO Usuario (id, email, senha) VALUES
(1, 'fulano@email.com', 'senha123'),
(2, 'ciclano@email.com', 'senha456'),
(3, 'beltrano@email.com', 'senha789');

-- Inserção de dados na tabela Aluno
INSERT INTO Aluno (id, id_usuario, nome, matricula) VALUES
(1, 1, 'Fulano de Tal', 12345),
(2, 2, 'Ciclano da Silva', 54321),
(3, 3, 'Beltrano Pereira', 98765);

-- Inserção de dados na tabela Curso
INSERT INTO Curso (id, nome, descricao, ativo) VALUES
(1, 'Curso de Programação', 'Um curso para aprender programação', true),
(2, 'Curso de Inglês', 'Um curso para aprender inglês', true),
(3, 'Curso de Matemática', 'Um curso para aprender matemática', false);

-- Inserção de dados na tabela Aula
INSERT INTO Aula (nome, id, data, status, id_curso) VALUES
('Aula 1', 1, '2024-04-01', 'Concluída', 1),
('Aula 2', 2, '2024-04-03', 'Concluída', 1),
('Aula 1', 3, '2024-04-05', 'Concluída', 2),
('Aula 2', 4, '2024-04-07', 'Pendente', 2),
('Aula 1', 5, '2024-04-02', 'Concluída', 3),
('Aula 2', 6, '2024-04-04', 'Concluída', 3);

-- Inserção de dados na tabela AlunoCurso
INSERT INTO AlunoCurso (id_aluno, id_curso) VALUES
(1, 1),
(2, 1),
(3, 2),
(3, 3);
