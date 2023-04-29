DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Product;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE Person
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL,
    role       VARCHAR                           NOT NULL
);
CREATE UNIQUE INDEX user_unique_email_idx ON Person (email);

CREATE TABLE Product
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR NOT NULL,
    price       INTEGER NOT NULL,
    title       VARCHAR NOT NULL,
    description VARCHAR NOT NULL
)
