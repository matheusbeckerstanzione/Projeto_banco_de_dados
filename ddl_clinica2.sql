-- DML (data manipulation language)
--INSERT (cadastrar)
--UPDATE (atualizar)
--DELETE (apaga)

-- OPCIONAL
--SET search_path TO clinica;
--clinica.paciente -> paciente 

--INSERT INFO <SCHEMA>.<TABELA>(<COLUNAS>) VALUE
INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
('Ana Duarte', 'pediatra', '123456'),
('Matheus Becker', 'cirurgião', '654321')

--DQL (data query language) -linguagem de consulta de dados
--SELECT
--SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.novopaciente(nome, idade, date_nascimento)
VALUES
('Ana Duarte', 15,'2010-04-29'),
('Matheus Becker', 16, '2008-12-03')

SELECT * FROM clinica.novopaciente;

INSERT INTO clinica.clinica(nome, descricao, endereco)
VALUES
('Clinica São Caetano', 'A melhor clinica de SCS', 'Rua Lomas Valentinas')

SELECT *FROM clinica.clinica;

INSERT INTO clinica.consulta(data, valor, id_medico,id_clinica, id_paciente)
VALUES
('2025-08-28 09:30:00-03', 350.54, 1, 2, 2 ),
('2025-08-28 09:30:00-03', 510.30, 2, 1, 1 )

SELECT * FROM clinica.consulta;

--UPDATE
UPDATE clinica.consulta
SET valor = 200.50
WHERE id_medico = 1;

UPDATE clinica.consulta
SET valor = 530
WHERE valor > 500 AND valor < 1000;

--DELETE FROM cliente.medico
--WHERE nome = 'matheus'

--WHERO ID_MEDICO 5;









