CREATE SCHEMA ecommerce;

CREATE TABLE ecommerce.cliente(
	id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	email TEXT NOT NULL,
	senha TEXT NOT NULL,
	telefone TEXT,
	data_cadastro TIMESTAMPTZ
);

CREATE TABLE ecommerce.pedido(
	id_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_cliente INT NOT NULL,
	data_cadastro TIMESTAMPTZ,
	valor_total NUMERIC (10,4),
	status TEXT,

	FOREIGN KEY (id_cliente)
	REFERENCES ecommerce.cliente(id_cliente)
);

CREATE TABLE ecommerce.pagamento(
id_pagamento INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_pedido INT NOT NULL,
	forma_pagamento TEXT NOT NULL,
	status TEXT,
	data_pagamento DATE NOT NULL,

	FOREIGN KEY (id_pagamento)
	REFERENCES ecommerce.pagamento(id_pagamento)
);

CREATE TABLE ecommerce.produto(
	id_produto INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	preco NUMERIC (18,4) NOT NULL,
	estoque_disponivel INT NOT NULL,
	imagem_url TEXT NOT NULL
);

CREATE TABLE ecommerce.item_pedido(
	id_item INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_produto INT NOT NULL,
	id_pedido INT NOT NULL,
	quantidade INT NOT NULL,

	FOREIGN KEY (id_produto)
	REFERENCES ecommerce.produto(id_produto),

	FOREIGN KEY (id_pedido)
	REFERENCES ecommerce.pedido(id_pedido)
	

);

