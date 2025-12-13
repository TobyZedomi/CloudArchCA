DROP
DATABASE IF EXISTS movie_project;
CREATE
DATABASE IF NOT EXISTS movie_project;

USE
movie_project;

CREATE TABLE users
(
    username    varchar(50) UNIQUE  NOT NULL,
    displayName varchar(50)         NOT NULL,
    email       varchar(255) UNIQUE NOT NULL,
    password    varchar(255)        NOT NULL,
    dateOfBirth DATE                NOT NULL,
    isAdmin     boolean             NOT NULL DEFAULT false,
    createdAt   datetime            NOT NULL,
    user_image     varchar(255) NOT NULL,
    PRIMARY KEY (username)
);