-- SQL Required to get set up with the project
-- database config is in the application.properties
-- db default name is book_store
CREATE TABLE "pets"(
	id SERIAL PRIMARY KEY,
	"name" VARCHAR (250) NOT NULL,
	"breed" VARCHAR (100) NOT NULL,
	"color" VARCHAR (100) NOT NULL
);

CREATE TABLE "owners"(
	id SERIAL PRIMARY KEY,
	"name" VARCHAR (250) NOT NULL,
	"number_pets" Int NOT NULL
);
INSERT INTO pets ("name", "breed", "color") VALUES ('goodboy', 'dog','purple');

INSERT INTO owners ("name", "number_pets") VALUES ('Frank', '2');
