DELETE
FROM person;
DELETE
FROM product;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO person (name, email, password, role)
VALUES ('User', 'user@yandex.ru', 'password', 'USER_ROLE'),
       ('Admin', 'admin@gmail.com', 'admin', 'USER_ROLE'),
       ('Guest', 'guest@gmail.com', 'guest', 'USER_ROLE');

INSERT INTO product (name, price, title, description)
VALUES ('coffee 1', 200, 'title', 'description'),
       ('coffee 2', 300, 'title', 'description'),
       ('coffee 3', 400, 'title', 'description');