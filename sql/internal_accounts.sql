-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.17-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for internal_accounts
CREATE DATABASE IF NOT EXISTS `internal_accounts` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `internal_accounts`;


-- Dumping structure for table internal_accounts.account
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `entityid` int(11) DEFAULT NULL,
  `account_number` varchar(50) DEFAULT NULL,
  `account_name` varchar(50) DEFAULT NULL,
  `account_category` varchar(50) DEFAULT NULL,
  `account_type` varchar(50) DEFAULT NULL,
  `current_market_value` double DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `FK_account_user` (`entityid`),
  CONSTRAINT `FK_account_user` FOREIGN KEY (`entityid`) REFERENCES `user` (`entityid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table internal_accounts.account: ~4 rows (approximately)
DELETE FROM `account`;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`account_id`, `entityid`, `account_number`, `account_name`, `account_category`, `account_type`, `current_market_value`) VALUES
	(1, 1, 'Cash10a-C', 'Cash10a-C', 'gdg', 'Investment Account', 102303),
	(2, 1, 'CAshB', 'CashB', 'sffd', 'Saving', 1345),
	(3, 3, 'kfdkf', 'dlfdlfd', 'lorogk', 'Investment', 3232323),
	(4, 2, 'mdmdmdmfdm', 'ddmfdmfdm', 'ddmfdmfdm', 'Investment', 98383939);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- Dumping structure for table internal_accounts.user
CREATE TABLE IF NOT EXISTS `user` (
  `entityid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `panid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`entityid`),
  UNIQUE KEY `panid` (`panid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table internal_accounts.user: ~3 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`entityid`, `firstname`, `lastname`, `dob`, `panid`) VALUES
	(1, 'ganesh', 'pol', '1981-04-22', 'ALGPP0779P'),
	(2, 'Pankaj', 'Bhogate', '1980-01-01', 'ALGPP'),
	(3, 'Manish', 'Singh', '1980-01-01', 'ABCD');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
