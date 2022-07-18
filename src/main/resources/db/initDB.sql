DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS boats;
DROP TABLE IF EXISTS clothes;
DROP TABLE IF EXISTS fishing_summer;
DROP TABLE IF EXISTS fishing_winter;
DROP TABLE IF EXISTS tourism;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE boats
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        TEXT             NOT NULL,
    price       DOUBLE PRECISION NOT NULL,
    count       SMALLINT         NOT NULL,
    description TEXT             NOT NULL,
    length      DOUBLE PRECISION NOT NULL,
    capacity    SMALLINT         NOT NULL,
    pass_count  SMALLINT         NOT NULL,
    boats_brand VARCHAR          NOT NULL
);
CREATE INDEX boats_brand ON boats (boats_brand);

CREATE TABLE clothes
(
    id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name         TEXT             NOT NULL,
    price        DOUBLE PRECISION NOT NULL,
    count        SMALLINT         NOT NULL,
    description  TEXT             NOT NULL,
    size         TEXT             NOT NULL,
    clothes_type VARCHAR          NOT NULL
);
CREATE INDEX clothes_type_idx ON clothes (clothes_type);

CREATE TABLE fishing_summer
(
    id                  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name                TEXT             NOT NULL,
    price               DOUBLE PRECISION NOT NULL,
    count               SMALLINT         NOT NULL,
    description         TEXT             NOT NULL,
    fishing_summer_type VARCHAR          NOT NULL
);
CREATE INDEX fishing_summer_type_idx ON fishing_summer (fishing_summer_type);

CREATE TABLE fishing_winter
(
    id                  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name                TEXT             NOT NULL,
    price               DOUBLE PRECISION NOT NULL,
    count               SMALLINT         NOT NULL,
    description         TEXT             NOT NULL,
    fishing_winter_type VARCHAR          NOT NULL
);
CREATE INDEX fishing_winter_type_idx ON fishing_winter (fishing_winter_type);

CREATE TABLE tourism
(
    id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name         TEXT             NOT NULL,
    price        DOUBLE PRECISION NOT NULL,
    count        SMALLINT         NOT NULL,
    description  TEXT             NOT NULL,
    tourism_type VARCHAR          NOT NULL
);
CREATE INDEX tourism_type_idx ON tourism (tourism_type);