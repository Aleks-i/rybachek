DELETE FROM user_roles;
DELETE FROM boats_brand;
DELETE FROM boats_pass_count;
DELETE FROM boats;
DELETE FROM clothes_type;
DELETE FROM clothes;
DELETE FROM fishing_winter_type;
DELETE FROM fishing_winter;
DELETE FROM fishing_summer_type;
DELETE FROM fishing_summer;
DELETE FROM tourism_type;
DELETE FROM tourism;
DELETE FROM users;
DELETE FROM shops;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Moderator', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('MODERATOR', 100002);

INSERT INTO shops (name)
VALUES ('Рыбачек'),
       ('Левый магазин');

INSERT INTO boats (name, article, price, count, description, length, capacity, shop_id)
VALUES ('АКВА ОПТИМА 260', 0, 14000, 1, 'Лодка ПВХ надувная зеленый', 260, 220, 100003),
       ('АКВА-МАСТЕР 280', 0, 17700, 2, 'Лодка ПВХ надувная зеленый', 280, 220, 100003),
       ('АКВА ОПТИМА 220', 0, 12400, 3, 'Лодка ПВХ надувная зеленый', 220, 170, 100003),
       ('Аква-оптима 190 с гребками', 0, 9900, 4, 'Самая маленькая и легкая лодка ПВХ', 190, 120, 100003),
       ('Аква оптима 240', 0, 13600, 4, 'Надувная лодка ПВХ', 240, 220, 100003),
       ('Лоцман C-200 ГР', 0, 9000, 4, 'Лоцман серый', 200, 120, 100003),
       ('Лоцман Профи 260', 0, 14700, 3, 'Лоцман серый', 260, 220, 100003),
       ('Лоцман Стандарт 240', 0, 15400, 2, 'Надуваня лодка Лоцман серый', 240, 220, 100004),
       ('Румб 280', 0, 17300, 2, 'Надуваня лодка Румб серый/зеленый', 280, 220, 100004);

INSERT INTO boats_brand (brand, boat_id)
VALUES ('AKVA', 100005),
       ('AKVA', 100006),
       ('AKVA', 100007),
       ('AKVA', 100008),
       ('AKVA', 100009),
       ('LOCMAN', 100010),
       ('LOCMAN', 100011),
       ('LOCMAN', 100012),
       ('RUMB', 100013);

INSERT INTO boats_pass_count (pass_count, boat_id)
VALUES ('TWO', 100005),
       ('TWO', 100006),
       ('ONE', 100007),
       ('ONE', 100008),
       ('TWO', 100009),
       ('ONE', 100010),
       ('TWO', 100011),
       ('TWO', 100012),
       ('TWO', 100013);

INSERT INTO clothes (name, article, price, count, description, size, shop_id)
VALUES ('Костюм х/б', 0, 2500, 4, 'Костюм зимний', '42-43', 100003),
       ('Валенки', 0, 400, 5, 'Валеник зимние', '43', 100003),
       ('Варежки', 0, 500, 4, 'Ватные варежки', 'X', 100003),
       ('Костюм нательный', 0, 1500, 8, 'Нательное белье', 'XL', 100003),
       ('Комбинезон защитный', 0, 1300, 6, 'Защитный дождевик цвет хаки', 'XL', 100003);

INSERT INTO clothes_type (clothes_type, clothes_id)
VALUES ('WINTER', 100014),
       ('SHOES', 100015),
       ('WINTER', 100016),
       ('WINTER', 100017),
       ('SUMMER', 100018);

INSERT INTO fishing_summer (name, article, price, count, description, shop_id)
VALUES ('Крючки', 0, 50, 15, 'Крючек на карпа', 100003),
       ('Крючки', 0, 40, 13, 'Крючек на окуня', 100003),
       ('Поплавки', 0, 60, 10, 'Поплавки перьевые', 100003),
       ('Грузила наборные', 0, 80, 10, 'Грузила 10-15-20 гр.', 100003);

INSERT INTO fishing_summer_type (type, fishing_summer_id)
VALUES ('HOOKS', 100019),
       ('HOOKS', 100020),
       ('FLOATS', 100021),
       ('SINKERS', 100022);

INSERT INTO fishing_winter (name, article, price, count, description, shop_id)
VALUES ('Крючки зимние', 0, 40, 8, 'Крючек зимний', 100003),
       ('Удилище зимнее', 0, 300, 7, 'Зимняя удочка', 100003);

INSERT INTO fishing_winter_type (type, fishing_winter_id)
VALUES ('HOOKS', 100023),
       ('FISHING_RODS', 100024);

INSERT INTO tourism (name, article, price, count, description, shop_id)
VALUES ('Сумка', 0, 560, 4, 'Сумка походная', 100003),
       ('Ящик', 0, 600, 4, 'Ящик утепленный', 100003),
       ('Мангал', 0, 800, 4, 'Мангал маленький', 100003);

INSERT INTO tourism_type (type, tourism_id)
VALUES ('BAGS', 100025),
       ('BAGS', 100026),
       ('BARBECUES', 100027);