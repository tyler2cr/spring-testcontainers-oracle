CREATE TABLE person
(
    id         NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    first_name VARCHAR2(50) NOT NULL,
    last_name  VARCHAR2(50) NOT NULL,
    email      VARCHAR2(50) NOT NULL,
    UNIQUE (first_name, last_name, email)
);

ALTER TABLE person
    ADD (CONSTRAINT person_id_primary_key PRIMARY KEY (id));

CREATE SEQUENCE person_id_primary_key START WITH 1;
