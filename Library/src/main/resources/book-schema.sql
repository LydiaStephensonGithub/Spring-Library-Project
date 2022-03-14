DROP TABLE IF EXISTS books CASCADE
CREATE TABLE book (
	id bigint generated by default as identity, 
	category varchar(3) not null, 
	first_name varchar(255), 
	isbn varchar(17), 
	last_name varchar(255), 
	title varchar(255) not null, 
	primary key (id)
);