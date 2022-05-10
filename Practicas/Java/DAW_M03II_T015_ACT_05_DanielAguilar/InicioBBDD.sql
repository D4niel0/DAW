/* Creacion BBDD FILMOTECA */
DROP SCHEMA IF EXISTS FILMOTECA;
CREATE SCHEMA FILMOTECA;
USE FILMOTECA;

/* Creación de la tabla PELICULA */
CREATE TABLE IF NOT EXISTS PELICULA(
	Titulo VARCHAR(30),
    Director int,
    Pais VARCHAR(30),
    Duracion INTEGER,
    Genero VARCHAR(15)
);

/* Crear algunas películas */
INSERT INTO PELICULA VALUES('Terminator','1','EEUU',100,'Accion');
INSERT INTO PELICULA VALUES('ESDLA','2','EEUU',180,'Fantasia');
INSERT INTO PELICULA VALUES('Torrente','3','España',120,'Comedia');
INSERT INTO PELICULA VALUES('Otra Pelicula','4','Francia',200,'Amor');
INSERT INTO PELICULA VALUES('Programadores','5','Italia',120,'Drama');

/* Creación de la tabla DIRECTOR */
CREATE TABLE IF NOT EXISTS DIRECTOR(
	id_director int PRIMARY KEY auto_increment,
	Nombre VARCHAR(50),
    Apellidos VARCHAR(100)
);

/* Crear directores */
INSERT INTO DIRECTOR VALUES(1,'Dani','Aguilar');
INSERT INTO DIRECTOR VALUES(2,'Alicia','Revilla');
INSERT INTO DIRECTOR VALUES(3,'Marco','Polo');
INSERT INTO DIRECTOR VALUES(4,'Lolo','Perro');
INSERT INTO DIRECTOR VALUES(5,'Coco','Loco');

/* Modificar la tabla Pelicula para vincular la tabla director */
ALTER TABLE PELICULA ADD CONSTRAINT fk_pelicula_director foreign key (Director) references DIRECTOR(id_director);
