CREATE DATABASE IF NOT EXISTS test CHARACTER SET utf8;
CREATE USER 'test'@'localhost' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON test.* TO 'test'@'localhost';


USE test;

CREATE TABLE IF NOT EXISTS articles (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    content TEXT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO articles (title, author, content) VALUES
("Premiere partie", 'Sebastien M.', "La premiere partie de notre CM"),
("Seconde partie", 'Sebastien M.', "La seconde partie de notre CM"),
("Derniere partie", 'Sebastien M.', "La derniere partie de notre CM")
