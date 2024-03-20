CREATE DATABASE fsd;
USE fsd;

CREATE TABLE users (
                       id int(11) NOT NULL AUTO_INCREMENT,
                       username VARCHAR(30) NOT NULL,
                       password VARCHAR(80) NOT NULL,
                       age int(8) DEFAULT NULL,
                       registration_date DATE DEFAULT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET = utf8mb4 COLLATE=utf8mb4_0900_ai_ci;