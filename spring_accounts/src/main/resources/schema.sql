CREATE TABLE users (
    id          INTEGER PRIMARY KEY,
    active      BOOLEAN,
    username    varchar(100) NOT NULL,
    password    varchar(100) NOT NULL,
    roles       varchar(255)
);