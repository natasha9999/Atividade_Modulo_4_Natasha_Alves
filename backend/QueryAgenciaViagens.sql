create database AgenciaDeViagens;

use AgenciaDeViagens;


create table Cliente(
idCliente int primary key,
Nome varchar(50) NOT NULL,
cpf varchar(20) UNIQUE,
Email varchar(50),
Telefone varchar(20)
);


create table Destino(
idDestino int primary key,
Origem varchar(50),
Destino varchar(50),
DataIda varchar(50),
DataVolta varchar(50),
FormaDePagamento varchar(30)
);


insert into Cliente(idCliente, Nome, CPF, Email, Telefone) values (1, "Edivaldo", "13351690762", "valdo@gmail.com", "21123456789");

insert into Cliente(idCliente, Nome, CPF, Email, Telefone) values (2, "Joanna", "15351381739", "jo@gmail.com", "11129450789");

insert into Destino(idDestino, Origem, Destino, DataIda, DataVolta, FormaDePagamento) values (1, "Bahia", "Rio Grande do Sul", '28/04/2022', "15/05/2022", "Pix");

insert into Destino(idDestino, Origem, Destino, DataIda, DataVolta, FormaDePagamento) values (2, "Maranhão", "Rio de Janeiro", "24/02/2022", "01/03/2022", "Cartão de crédito");


select * from Cliente;
select * from Destino;
select Nome from Cliente;
select * from Destino order by Origem desc;


UPDATE Cliente SET Nome = "Crisvianno" WHERE idCliente = 1;


delete from Destino WHERE idDestino = 2;
