DELETE
FROM person;
DELETE
FROM product;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO person (name, email, password, role)
VALUES ('admin', 'nikitamasslennikov@mail.ru', '$2a$10$.zFG5ce5JFEM4GZ1L3DiReKnybdJ9L5lnQ95FsdPlprg8SHQHbKL.', 'ROLE_ADMIN'),
       ('user', 'gal.117@yandex.ru', '$2a$10$0GSeZZY1NGWi1fxNE92GOe0/Z4tqgbaHN2JwMtrCuLZBd6bpUSByW', 'ROLE_USER');

