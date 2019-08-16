-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- Server version:               5.5.53 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------
DROP TABLE IF EXISTS `country`;
-- Dumping structure for table demo.country
CREATE TABLE IF NOT EXISTS `country`
(
  `code`       varchar(2)  NOT NULL,
  `name`       varchar(50) NOT NULL,
  `population` int(11)     NOT NULL DEFAULT '0',
  PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- Dumping data for table demo.country: ~10 rows (approximately)
/*!40000 ALTER TABLE `country`
  DISABLE KEYS */;
INSERT INTO `country` (`code`, `name`, `population`)
VALUES ('AU', 'Australia', 18886000),
       ('BR', 'Brazil', 170115000),
       ('CA', 'Canada', 1147000),
       ('CN', 'China', 1277558000),
       ('DE', 'Germany', 82164700),
       ('FR', 'France', 59225700),
       ('GB', 'United Kingdom', 59623400),
       ('IN', 'India', 1013662000),
       ('RU', 'Russia', 146934000),
       ('US', 'United States', 278357000);
/*!40000 ALTER TABLE `country`
  ENABLE KEYS */;

/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
