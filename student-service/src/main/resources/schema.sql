create schema if not exists studentDB;
use studentDB;

create table if not exists student (
	id int(11) not null auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);

create table if not exists courses (
	id int(11) not null auto_increment primary key,
	student_id int(11) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);