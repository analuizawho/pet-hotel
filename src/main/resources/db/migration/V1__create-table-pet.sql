create table pet(
id bigint not null auto_increment,
nome varchar(100) not null,
raca varchar(100) not null,
tipo varchar(100) not null,
peso float not null,
idade float not null,
doenca varchar(100) not null,
castracao varchar(100) not null,
sexo varchar(100) not null,
ativo tinyint default 1,

primary key(id)
);