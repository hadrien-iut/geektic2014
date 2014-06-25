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
sexe varchar(1) not null,
mail varchar(255) not null,
view_prof numeric,
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


delete from geek_interet;
delete from geek;
delete from interet;

insert into interet values (1,'Java');
insert into interet values (2,'Ruby');
insert into interet values (3,'C#');
insert into interet values (4,'Cobol');
insert into interet values (5,'C++');

insert into geek values (1, 'QUENIN', 'Hadrien', 'M', 'hadrien.quenin@etu.univ-lyon1.fr', 0);
insert into geek values (2, 'SIKHOUN', 'David', 'M', 'david.sikhoun@etu.univ-lyon1.fr',0);
insert into geek values (3, 'ROUSSET', 'Vincent', 'M', 'vincent.rousset@etu.univ-lyon1.fr',0);
insert into geek values (4, 'DUTRONC', 'Monique', 'F', 'monique.dutronc@etu.univ-lyon1.fr',0);

insert into geek_interet values (1,1);
insert into geek_interet values (2,1);
insert into geek_interet values (2,2);
insert into geek_interet values (3,3);
insert into geek_interet values (4,3);
insert into geek_interet values (2,3);
insert into geek_interet values (4,4);