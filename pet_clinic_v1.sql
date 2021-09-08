SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS doctor_schedule;
DROP TABLE IF EXISTS pet_drug;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS drug_type;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS owner;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS pet_login;
DROP TABLE IF EXISTS species;




/* Create Tables */

CREATE TABLE appointment
(
	app_id int NOT NULL AUTO_INCREMENT,
	app_date date,
	app_time time,
	owner_id varchar(7) NOT NULL,
	PRIMARY KEY (app_id)
);


CREATE TABLE card
(
	card_id int NOT NULL AUTO_INCREMENT,
	card_number varchar(16),
	voucher_no varchar(11) NOT NULL,
	PRIMARY KEY (card_id)
);


CREATE TABLE doctor
(
	doctor_id varchar(7) NOT NULL,
	doctor_name varchar(25),
	doctor_rank varchar(50),
	PRIMARY KEY (doctor_id)
);


CREATE TABLE doctor_schedule
(
	schedule_id int NOT NULL AUTO_INCREMENT,
	day_name enum('MON','TUE','WED','THU','FRI','SAT','SUN'),
	start_time time,
	end_time time,
	doctor_id varchar(7) NOT NULL,
	PRIMARY KEY (schedule_id)
);


CREATE TABLE drug_type
(
	drug_id int NOT NULL AUTO_INCREMENT,
	drug_name varchar(50),
	drug_duration int,
	drug_duration_type enum('year','month','day'),
	PRIMARY KEY (drug_id)
);


CREATE TABLE owner
(
	owner_id varchar(7) NOT NULL,
	owner_name varchar(20),
	owner_ph varchar(20),
	owner_email varchar(50),
	owner_add varchar(100),
	PRIMARY KEY (owner_id)
);


CREATE TABLE payment
(
	voucher_no varchar(11) NOT NULL,
	payment_date date,
	payment_amt int,
	payment_status enum('cash','card'),
	PRIMARY KEY (voucher_no)
);


CREATE TABLE pet
(
	pet_id varchar(9) NOT NULL,
	pet_name varchar(30),
	pet_sex enum('F','M'),
	pet_birth date,
	pet_death date,
	species_id int NOT NULL,
	owner_id varchar(7) NOT NULL,
	PRIMARY KEY (pet_id)
);


CREATE TABLE pet_drug
(
	id int NOT NULL AUTO_INCREMENT,
	drug_date date,
	drug_next_date date,
	drug_desc varchar(50),
	pet_id varchar(9) NOT NULL,
	drug_id int NOT NULL,
	doctor_id varchar(7) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE pet_login
(
	login_id varchar(20) NOT NULL,
	login_password varchar(150),
	PRIMARY KEY (login_id)
);


CREATE TABLE species
(
	species_id int NOT NULL AUTO_INCREMENT,
	species_name varchar(30),
	PRIMARY KEY (species_id)
);



/* Create Foreign Keys */

ALTER TABLE doctor_schedule
	ADD FOREIGN KEY (doctor_id)
	REFERENCES doctor (doctor_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pet_drug
	ADD FOREIGN KEY (doctor_id)
	REFERENCES doctor (doctor_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pet_drug
	ADD FOREIGN KEY (drug_id)
	REFERENCES drug_type (drug_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE appointment
	ADD FOREIGN KEY (owner_id)
	REFERENCES owner (owner_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pet
	ADD FOREIGN KEY (owner_id)
	REFERENCES owner (owner_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE card
	ADD FOREIGN KEY (voucher_no)
	REFERENCES payment (voucher_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pet_drug
	ADD FOREIGN KEY (pet_id)
	REFERENCES pet (pet_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pet
	ADD FOREIGN KEY (species_id)
	REFERENCES species (species_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



