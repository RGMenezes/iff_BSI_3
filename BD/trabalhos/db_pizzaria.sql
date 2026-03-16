-- Parte 01
create database db_pizzaria;

use db_pizzaria;

create table Produto(id_produto INT primary key, nome VARCHAR(45), descricao VARCHAR(255), preco FLOAT);
create table Loja(cnpj VARCHAR(14) primary key);
create table Cliente(cpf VARCHAR(11) primary key, nome VARCHAR(45), telefone VARCHAR(13));
create table Cargo(id_cargo INT primary key, nome VARCHAR(25), salario FLOAT);

create table Funcionario(
	cpf VARCHAR(11) primary key, 
    loja_cnpj VARCHAR(14) not null,
    gerente_cpf VARCHAR(11), 
    cargo INT,
    nome VARCHAR(45) not null,
    cnh VARCHAR(11),
    constraint fk_loja foreign key (loja_cnpj) references Loja(cnpj),
    constraint fk_gerente foreign key (gerente_cpf) references Funcionario(cpf),
    constraint fk_cargo foreign key (cargo) references Cargo(id_cargo)
);

create table Endereco(
	id_endereco INT primary key,
    cliente_cpf VARCHAR(11) not null,
    logradouro VARCHAR(255),
    numero VARCHAR(10),
    bairro VARCHAR(100),
    complemento VARCHAR(255),
    cep VARCHAR(9),
    endereco_principal tinyint,
    constraint fk_cliente foreign key (cliente_cpf) references Cliente(cpf)
);

create table Pedido(
	ticket INT primary key,
    cliente_cpf VARCHAR(11) not null,
    funcionario_cpf VARCHAR(11),
    endereco_id INT,
    status VARCHAR(45),
    data DATETIME,
    constraint fk_pedido_cliente foreign key (cliente_cpf) references Cliente(cpf),
    constraint fk_pedido_funcionario foreign key (funcionario_cpf) references Funcionario(cpf),
    constraint fk_pedido_endereco foreign key (endereco_id) references Endereco(id_endereco)
);

create table Produto_has_Pedido(
	produto_id INT,
    pedido_ticket INT,
    quantidade INT,
    preco_unitario FLOAT,
	PRIMARY KEY (produto_id, pedido_ticket),
    constraint fk_php_produto foreign key (produto_id) references Produto(id_produto),
    constraint fk_php_pedido foreign key (pedido_ticket) references Pedido(ticket)
);

alter table Loja add nome varchar(45);

-- Parte 2
INSERT INTO Loja (cnpj, nome) VALUES
('09012012000125', 'Filial Centro'),
('09012012000133', 'Filial Shopping'),
('09012012000141', 'Filial Norte'),
('09012012000158', 'Filial Sul');

INSERT INTO Cargo (id_cargo, nome, salario) VALUES
(1, 'Gerente', 4500.00),
(2, 'Atendente', 1800.00),
(3, 'Pizzaiolo', 2500.00),
(4, 'Entregador', 1600.00);

INSERT INTO Cliente (cpf, nome, telefone) VALUES
('12345678901', 'João Silva', '5522998765432'),
('23456789012', 'Maria Oliveira', '5522987654321'),
('34567890123', 'Pedro Santos', '5522976543210'),
('45678901234', 'Ana Costa', '5522965432109'),
('56789012345', 'Lucas Mendes', '5522954321098');

INSERT INTO Produto (id_produto, nome, descricao, preco) VALUES
(1, 'Margherita', 'Molho de tomate, mussarela, manjericão e azeite', 42.90),
(2, 'Calabresa', 'Mussarela, calabresa, cebola e orégano', 45.90),
(3, 'Portuguesa', 'Mussarela, presunto, ovos, cebola, azeitona e ervilha', 48.90),
(4, 'Frango com Catupiry', 'Frango desfiado, catupiry e milho', 47.90),
(5, 'Pepperoni', 'Mussarela, pepperoni e orégano', 49.90);

INSERT INTO Funcionario (cpf, loja_cnpj, gerente_cpf, cargo, nome, cnh) VALUES
('11122233344', '09012012000125', NULL, 1, 'Roberto Gerente', 'ABC12345678');

INSERT INTO Funcionario (cpf, loja_cnpj, gerente_cpf, cargo, nome, cnh) VALUES
('22233344455', '09012012000125', '11122233344', 3, 'Carlos Pizzaiolo', 'DEF98765432'),
('33344455566', '09012012000125', '11122233344', 2, 'Fernanda Atendente', NULL),
('44455566677', '09012012000125', '11122233344', 4, 'Rafael Entregador', 'GHI11223344'),
('55566677788', '09012012000133', '11122233344', 3, 'Juliana Pizzaiola', 'JKL55667788');

INSERT INTO Endereco (id_endereco, cliente_cpf, logradouro, numero, bairro, complemento, cep, endereco_principal) VALUES
(1, '12345678901', 'Rua São João', '150', 'Centro', 'Apto 301', '28010-050', 1),
(2, '23456789012', 'Av. Brasil', '890', 'Parque Tarcísio', NULL, '28013-200', 1),
(3, '34567890123', 'Rua das Flores', '320', 'Centro', NULL, '28015-030', 1),
(4, '45678901234', 'Rua do Comércio', '45', 'Turquinho', 'Casa', '28020-100', 1),
(5, '12345678901', 'Rua São João', '150', 'Centro', 'Apto 302', '28010-050', 0);

INSERT INTO Pedido (ticket, cliente_cpf, funcionario_cpf, endereco_id, status, data) VALUES
(1001, '12345678901', '33344455566', 1, 'Entregue', '2026-03-15 19:30:00'),
(1002, '23456789012', '44455566677', 2, 'Pendente', '2026-03-16 20:15:00'),
(1003, '34567890123', '33344455566', 3, 'Entregue', '2026-03-14 18:45:00'),
(1004, '45678901234', '55566677788', 4, 'Entregue', '2026-03-16 21:00:00'),
(1005, '56789012345', '44455566677', NULL, 'Pendente', '2026-03-16 22:30:00');

INSERT INTO Produto_has_Pedido (produto_id, pedido_ticket, quantidade, preco_unitario) VALUES
(1, 1001, 2, 42.90),
(2, 1001, 1, 45.90),
(3, 1002, 1, 48.90),
(4, 1003, 2, 47.90),
(5, 1004, 1, 49.90),
(2, 1005, 3, 45.90);

-- Parte 3

UPDATE Produto 
SET preco = 44.90 
WHERE id_produto = 1;

UPDATE Pedido 
SET status = 'Entregue' 
WHERE ticket = 1002;


DELETE FROM Endereco 
WHERE id_endereco = 5;

DELETE FROM Produto_has_Pedido 
WHERE produto_id = 5 AND pedido_ticket = 1004;


SELECT 
    c.nome AS Cliente,
    p.ticket AS Ticket,
    p.data AS Data_Pedido,
    p.status
FROM Cliente c
INNER JOIN Pedido p ON c.cpf = p.cliente_cpf
WHERE p.data BETWEEN '2026-03-15' AND '2026-03-16'
ORDER BY c.nome ASC;


SELECT nome, preco 
FROM Produto 
WHERE nome LIKE '%Calabresa%';


SELECT nome, preco 
FROM Produto 
WHERE preco BETWEEN 45.00 AND 49.00;


SELECT DISTINCT status 
FROM Pedido;


-- Testes
SELECT * FROM Produto;
SELECT * FROM Pedido;
SELECT * FROM Endereco;
SELECT * FROM Produto_has_Pedido;