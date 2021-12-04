CREATE database if not exists dragons;

use dragons;

-- DROP TABLE IF EXISTS dragons;

CREATE TABLE dragons(
	dragon_id int (3) NOT NULL auto_increment,
	name varchar (20) NOT NULL unique,
	dragon_color varchar (10) NOT NULL,
	dragon_size varchar (10) NOT NULL,
	dragon_age int (6) NOT NULL,
    primary key (dragon_id)
);