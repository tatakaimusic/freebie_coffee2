DELETE
FROM person;
DELETE
FROM product;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO person (name, email, password, role)
VALUES ('User', 'user@yandex.ru', '$2a$10$e97fqtCh3hitk3j9Ir/hd.T/A9MZd96TPBUm6EM6JYkphEgy7phsi', 'ROLE_USER'),
       ('Admin', 'admin@gmail.com', '$2a$10$e97fqtCh3hitk3j9Ir/hd.T/A9MZd96TPBUm6EM6JYkphEgy7phsi', 'ROLE_USER'),
       ('Guest', 'guest@gmail.com', '$2a$10$e97fqtCh3hitk3j9Ir/hd.T/A9MZd96TPBUm6EM6JYkphEgy7phsi', 'ROLE_USER');

INSERT INTO product (name, price, title, description)
VALUES ('coffee 1', 200, 'title', 'description'),
       ('coffee 2', 300, 'title', 'description'),
       ('coffee 3', 400, 'title', 'description');