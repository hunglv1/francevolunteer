CREATE DATABASE IF NOT EXISTS francevolunteerdb;

CREATE TABLE users (
                       user_id int NOT NULL AUTO_INCREMENT,
                       email varchar(30) NOT NULL,
                       password varchar(300) NOT NULL,
                       PRIMARY KEY (user_id)
);