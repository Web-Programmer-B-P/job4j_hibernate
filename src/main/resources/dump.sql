create table if not exists users
(
    id       serial not null
        constraint users_pk
            primary key,
    login    varchar(200),
    password varchar(200),
    date     varchar(200)
);