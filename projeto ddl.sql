--E UM COMENTARIO!
/*COMENTARIO DE MULTIPLAS LINHAS*/

--DDL - CRIAR - CREATE(SCRHEMA, TABELA)
CREATE SCHEMA clinica;

--CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE clinica.medico (
	--informar Colunas
	--nome_da_coluna tipo_de_dados
	--PRIMARY KEY GENERATED ALWAYAS AS IDENTITY
	--É CRIAR AUTOMATICAMENTE
	id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	crm TEXT NOT NULL,
	especialidade TEXT NOT NULL
);

CREATE TABLE clinica.paciente (
	--informar Colunas
	--nome_da_coluna tipo_de_dados
	--PRIMARY KEY GENERATED ALWAYAS AS IDENTITY
	--É CRIAR AUTOMATICAMENTE
	id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	idade int NOT NULL,
	date_nascimento DATE NOT NULL
);

CREATE TABLE clinica.clinica (
	--informar Colunas
	--nome_da_coluna tipo_de_dados
	--PRIMARY KEY GENERATED ALWAYAS AS IDENTITY
	--É CRIAR AUTOMATICAMENTE
	id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	endereco TEXT NOT NULL
);

CREATE TABLE clinica.consulta (
	--informar Colunas
	--nome_da_coluna tipo_de_dados
	--PRIMARY KEY GENERATED ALWAYAS AS IDENTITY
	--É CRIAR AUTOMATICAMENTE
	id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	data TIMESTAMPTZ NOT NULL,
	valor NUMERIC (10,4), 
	id_medico INT NOT NULL,
	FOREIGN KEY (id_medico)
	REFERENCES clinica.medico(id_medico),
	
	--maneira abreviada
	id_clinica INT NOT NULL 
	REFERENCES clinica.clinica(id_clinica),
	
	id_paciente INT NOT NULL
	REFERENCES clinica.paciente(id_paciente)
);


--APAGAR TABELA - DROP
/*DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;*/


