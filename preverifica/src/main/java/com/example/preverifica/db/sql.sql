DROP DATABASE IF EXISTS azienda;

CREATE DATABASE azienda;
USE azienda;

CREATE TABLE dipartimenti (
                              id int auto_increment primary key,
                              descrizione varchar(500)
);

CREATE TABLE dipendenti (
                            matricola int auto_increment not null primary key,
                            cognome varchar(64) not null,
                            nome varchar(64) not null,
                            qualifica varchar(64) not null,
                            codice_dipartimento int not null,

                            FOREIGN KEY (codice_dipartimento) REFERENCES dipartimenti(id)
);

INSERT INTO dipartimenti (descrizione) VALUES ('Sono un dipartimento');
INSERT INTO dipartimenti (descrizione) VALUES ('Dipartimento di informatica');
INSERT INTO dipartimenti (descrizione) VALUES ('Dipartimento di elettronica');
INSERT INTO dipartimenti (descrizione) VALUES ('Dipartimento di ingegneria');
INSERT INTO dipartimenti (descrizione) VALUES ('Dipartimento di scienze');

INSERT INTO dipendenti(cognome, nome, qualifica, codice_dipartimento) VALUES ('Reppucci', 'Giuseppe', 'Nulla', 2);
INSERT INTO dipendenti(cognome, nome, qualifica, codice_dipartimento) VALUES ('Azzini', 'Fabio', 'Fortissimo', 3);
INSERT INTO dipendenti(cognome, nome, qualifica, codice_dipartimento) VALUES ('Franchi', 'Ettore', 'Assembly', 2);
INSERT INTO dipendenti(cognome, nome, qualifica, codice_dipartimento) VALUES ('Giuseppe', 'Fontanella', 'Nullafacente', 5);
INSERT INTO dipendenti(cognome, nome, qualifica, codice_dipartimento) VALUES ('Bombardeli', 'Elia', 'Matematico', 5);