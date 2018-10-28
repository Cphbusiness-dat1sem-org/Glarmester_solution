-- CREATE SCHEMA `Glarmester`;
USE `Glarmester`;

DROP TABLE IF EXISTS `Glarmester`.`prices`;
CREATE TABLE `Glarmester`.`prices` (
  `product` VARCHAR(25) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`product`)
);

INSERT INTO `Glarmester`.`prices`(`product`, `price`) VALUES
('glass', 300),
('plain', 100),
('ornate', 200),
('lavish', 350);


-- CREATE USER 'BigBoss'@'%' IDENTIFIED BY '1234';
-- GRANT ALL ON `Glarmester`.* TO 'BigBoss'@'%';
