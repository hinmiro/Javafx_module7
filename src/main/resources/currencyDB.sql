-- Dumping database structure for currencyconverter
DROP DATABASE `currencyconverter`
CREATE DATABASE IF NOT EXISTS `currencyconverter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `currencyconverter`;

-- Dumping structure for taulu currencyconverter.currency
CREATE TABLE IF NOT EXISTS `currency` (
  `rate` float NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table currencyconverter.currency: ~9 rows (suunnilleen)
INSERT INTO `currency` (`rate`, `name`) VALUES
	(1.0846, 'USD'),
	(163.22, 'JPY'),
	(1.9558, 'BGN'),
	(25.356, 'CZK'),
	(7.4539, 'DKK'),
	(0.85583, 'GBP'),
	(4.322, 'PLN'),
	(11.2424, 'SEK'),
	(1, 'EUR');

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'appuser';
GRANT SELECT ON currencyconverter.* TO 'appuser'@'localhost';