DROP DATABASE IF EXISTS `currencyconverter`;
CREATE DATABASE `currencyconverter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `currencyconverter`;

CREATE TABLE IF NOT EXISTS `currency` (
    `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `rate` float NOT NULL,
    `abbreviation` varchar(50) NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `currency` (`rate`, `abbreviation`, `name`) VALUES
	(1.0846, 'USD', 'US dollar'),
	(163.22, 'JPY', 'Japanese yen'),
	(1.9558, 'BGN', 'Bulgarian lev'),
	(25.356, 'CZK', 'Czech koruna'),
	(7.4539, 'DKK', 'Danish koruna'),
	(0.85583, 'GBP', 'Pound sterling'),
	(4.322, 'PLN', 'Polish zloty'),
	(11.2424, 'SEK', 'Swedish koruna'),
	(1, 'EUR', 'European euro');

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'appuser';
GRANT SELECT, INSERT, DROP ON currencyconverter.* TO 'appuser'@'localhost' IDENTIFIED BY 'appuser';