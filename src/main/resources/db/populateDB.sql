DELETE FROM user_roles;
DELETE FROM boats;
DELETE FROM clothes;
DELETE FROM fishing_summer;
DELETE FROM fishing_winter;
DELETE FROM tourism;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Moderator', 'moder@gmail.com', 'moder');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('MODERATOR', 100002);

INSERT INTO boats (name, price, count, description, length, capacity, pass_count, boats_brand)
VALUES ('АКВА ОПТИМА 260', 14000, 1, 'Лодка ПВХ надувная зеленый', 260, 220, 2, 'AKVA'),
       ('АКВА МАСТЕР 280', 17700, 2, 'Лодка ПВХ надувная зеленый', 280, 220, 2, 'AKVA'),
       ('АКВА ОПТИМА 220', 12400, 3, 'Лодка ПВХ надувная зеленый', 220, 170, 1, 'AKVA'),
       ('Аква оптима 190 с гребками', 9900, 4, 'Самая маленькая и легкая лодка ПВХ', 190, 120, 1, 'AKVA'),
       ('Аква оптима 240', 13600, 4, 'Надувная лодка ПВХ', 240, 220, 2, 'AKVA'),
       ('Лоцман C-200 ГР', 9000, 4, 'Лоцман серый', 200, 120, 1, 'LOCMAN'),
       ('Лоцман Профи 260', 14700, 3, 'Лоцман серый', 260, 220, 2, 'LOCMAN'),
       ('Лоцман Стандарт 240', 15400, 2, 'Надуваня лодка Лоцман серый', 240, 220, 2, 'LOCMAN'),
       ('Румб 280', 17300, 2, 'Надуваня лодка Румб серый/зеленый', 280, 220, 2, 'RUMB');

INSERT INTO clothes (name, price, count, description, size, clothes_type)
VALUES ('Костюм х/б', 2500, 4, 'Костюм зимний', '42-43', 'WINTER'),
       ('Валенки', 400, 5, 'Валеник зимние', '43', 'SHOES'),
       ('Варежки', 500, 4, 'Ватные варежки', 'X', 'WINTER'),
       ('Костюм нательный', 1500, 8, 'Нательное белье', 'XL', 'WINTER'),
       ('Комбинезон защитный', 1300, 6, 'Защитный дождевик цвет хаки', 'XL', 'SUMMER');

INSERT INTO fishing_summer (name, price, count, description, fishing_summer_type)
VALUES ('Крючки', 50, 15, 'Крючек на карпа', 'HOOKS'),
       ('Крючки', 40, 13, 'Крючек на окуня', 'HOOKS'),
       ('Поплавки', 60, 10, 'Поплавки перьевые', 'FLOATS'),
       ('Грузила наборные', 80, 10, 'Грузила 10-15-20 гр.', 'SINKERS');

INSERT INTO fishing_winter (name, price, count, description, fishing_winter_type)
VALUES ('Крючки зимние', 40, 8, 'Крючек зимний', 'HOOKS'),
       ('Удилище зимнее', 300, 7, 'Зимняя удочка', 'FISHING_RODS');

INSERT INTO tourism (name, price, count, description, tourism_type)
VALUES ('Сумка', 560, 4, 'Сумка походная', 'BAGS'),
       ('Ящик', 600, 4, 'Ящик утепленный', 'BAGS'),
       ('Мангал', 800, 4, 'Мангал маленький', 'BARBECUES');