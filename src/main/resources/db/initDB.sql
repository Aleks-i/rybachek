DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS boats_brand;
DROP TABLE IF EXISTS boats_pass_count;
DROP TABLE IF EXISTS boats;
DROP TABLE IF EXISTS clothes_type;
DROP TABLE IF EXISTS clothes;
DROP TABLE IF EXISTS fishing_winter_type;
DROP TABLE IF EXISTS fishing_winter;
DROP TABLE IF EXISTS fishing_summer_type;
DROP TABLE IF EXISTS fishing_summer;
DROP TABLE IF EXISTS tourism_type;
DROP TABLE IF EXISTS tourism;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS shops;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE shops
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                           NOT NULL
);

CREATE TABLE users
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                           NOT NULL,
    email            VARCHAR                           NOT NULL,
    password         VARCHAR                           NOT NULL,
    registered       TIMESTAMP           DEFAULT now() NOT NULL,
    enabled          BOOL                DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id          INTEGER NOT NULL,
    role             VARCHAR NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE boats
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        TEXT                NOT NULL,
    article     INTEGER             NOT NULL,
    price       DOUBLE PRECISION    NOT NULL,
    count       SMALLINT            NOT NULL,
    description TEXT                NOT NULL,
    length      DOUBLE PRECISION    NOT NULL,
    capacity    SMALLINT            NOT NULL,
    shop_id     INTEGER             NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops (id) ON DELETE CASCADE
);

CREATE TABLE boats_brand
(
    brand   VARCHAR                         NOT NULL,
    boat_id     INTEGER                         NOT NULL,
    FOREIGN KEY (boat_id) REFERENCES boats (id) ON DELETE CASCADE
);
CREATE INDEX boats_brand_idx ON boats_brand (brand);

CREATE TABLE boats_pass_count
(
    pass_count             VARCHAR                         NOT NULL,
    boat_id                INTEGER                         NOT NULL,
    FOREIGN KEY (boat_id) REFERENCES boats (id) ON DELETE CASCADE
);
CREATE INDEX boats_pass_count_idx ON boats_pass_count (boats_pass_count);

CREATE TABLE clothes
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        TEXT                NOT NULL,
    article     INTEGER             NOT NULL,
    price       DOUBLE PRECISION    NOT NULL,
    count       SMALLINT            NOT NULL,
    description TEXT                NOT NULL,
    size        TEXT                NOT NULL,
    shop_id     INTEGER             NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops (id) ON DELETE CASCADE
);

CREATE TABLE clothes_type
(
    clothes_type    VARCHAR           NOT NULL,
    clothes_id      INTEGER           NOT NULL,
    FOREIGN KEY (clothes_id) REFERENCES clothes (id) ON DELETE CASCADE
);
CREATE INDEX clothes_type_idx ON clothes_type (clothes_type);

CREATE TABLE fishing_summer
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        TEXT                NOT NULL,
    article     INTEGER             NOT NULL,
    price       DOUBLE PRECISION    NOT NULL,
    count       SMALLINT            NOT NULL,
    description TEXT                NOT NULL,
    shop_id     INTEGER             NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops (id) ON DELETE CASCADE
);

CREATE TABLE fishing_summer_type
(
    type                   VARCHAR           NOT NULL,
    fishing_summer_id      INTEGER           NOT NULL,
    FOREIGN KEY (fishing_summer_id) REFERENCES fishing_summer (id) ON DELETE CASCADE
);
CREATE INDEX fishing_summer_type_idx ON fishing_summer_type (type);

CREATE TABLE fishing_winter
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        TEXT                NOT NULL,
    article     INTEGER             NOT NULL,
    price       DOUBLE PRECISION    NOT NULL,
    count       SMALLINT            NOT NULL,
    description TEXT                NOT NULL,
    shop_id     INTEGER             NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops (id) ON DELETE CASCADE
);

CREATE TABLE fishing_winter_type
(
    type                   VARCHAR           NOT NULL,
    fishing_winter_id      INTEGER           NOT NULL,
    FOREIGN KEY (fishing_winter_id) REFERENCES fishing_winter (id) ON DELETE CASCADE
);
CREATE INDEX fishing_winter_type_idx ON fishing_winter_type (type);

CREATE TABLE tourism
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        TEXT                NOT NULL,
    article     INTEGER             NOT NULL,
    price       DOUBLE PRECISION    NOT NULL,
    count       SMALLINT            NOT NULL,
    description TEXT                NOT NULL,
    shop_id     INTEGER             NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops (id) ON DELETE CASCADE
);

CREATE TABLE tourism_type
(
    type            VARCHAR           NOT NULL,
    tourism_id      INTEGER           NOT NULL,
    FOREIGN KEY (tourism_id) REFERENCES tourism (id) ON DELETE CASCADE
);
CREATE INDEX tourism_type_idx ON tourism_type (type);