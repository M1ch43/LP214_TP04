create database aulajava;

use aulajava;

create table tbcargos(
  cd_cargo smallint primary key auto_increment,
  ds_cargo varchar(20)
);

create table tbfuncs(
  cod_func smallint primary key auto_increment,
  nome_func varchar(30),
  sal_func decimal(8,2),
  cod_cargo smallint not null,
  foreign key(cod_cargo) references tbcargos(cd_cargo)
);

insert into tbcargos (ds_cargo) values
  ('Analista'),
  ('Programador'),
  ('DBA'),
  ('Gerente'),
  ('Ag. Administrativo');
  
select * from tbcargos;
  
insert into tbfuncs (nome_func, sal_func, cod_cargo) values
  ('Michael Almeida', 5656.01, 1),
  ('Vinicius Carmo', 5656.01, 1),
  ('Walmir Junior', 4170.99, 2),
  ('Bruno Cunha', 4170.99, 2),
  ('Larissa Manoela', 6695.43, 3),
  ('Matheus Melo', 6695.43, 3),
  ('Livia Rodrigues', 11200.79, 4),
  ('Luana Juarez', 11200.79, 4),
  ('Milena Araujo', 1601.00, 5),
  ('anderson Gaudo', 1601.00, 5);
  
select * from tbfuncs;