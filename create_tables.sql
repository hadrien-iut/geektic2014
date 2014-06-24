drop table geek_interet if exists cascade;
drop table geek if exists cascade;
drop table interet if exists cascade;

drop sequence geek_seq if exists;
drop sequence interet_seq if exists;

create table interet (
id numeric not null,
libelle varchar(255) not null,
primary key (id)
);

create table geek (
id numeric not null,
nom varchar(255) not null,
prenom varchar(255) not null,
mail varchar(255) not null,
primary key (id));

create table geek_interet (
	id_interet numeric not null,
	id_geek numeric not null,
	primary key (id_interet,id_geek),
	foreign key (id_interet) references interet(id),
	foreign key (id_geek) references geek(id)
);

create sequence geek_seq start with 1000;
create sequence interet_seq start with 1000;