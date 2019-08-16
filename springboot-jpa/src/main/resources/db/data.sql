-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.17 - MySQL Community Server - GPL
-- 服务器OS:                        Linux
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table demo.sys_role
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `role_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- Dumping data for table demo.sys_role: ~2 rows (大约)
/*!40000 ALTER TABLE `sys_role`
    DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `role_name`)
VALUES (1, 'ADMIN'),
       (2, 'USER');
/*!40000 ALTER TABLE `sys_role`
    ENABLE KEYS */;

-- Dumping structure for table demo.sys_user
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user`
(
    `id`                       bigint(20) NOT NULL AUTO_INCREMENT,
    `password`                 varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `username`                 varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_password_reset_date` datetime                                DEFAULT NULL COMMENT '最后修改密码时间',
    `enabled`                  bit(1)                                  DEFAULT b'1',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- Dumping data for table demo.sys_user: ~2 rows (大约)
/*!40000 ALTER TABLE `sys_user`
    DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `password`, `username`, `last_password_reset_date`, `enabled`)
VALUES (4, 'admin', 'admin', NULL, b'1'),
       (6, 'user', 'user', NULL, b'1');
/*!40000 ALTER TABLE `sys_user`
    ENABLE KEYS */;

-- Dumping structure for table demo.sys_user_role
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role`
(
    `u_id` bigint(20) NOT NULL,
    `r_id` bigint(20) NOT NULL,
    PRIMARY KEY (`u_id`, `r_id`),
    KEY `FKj6b1j8csidus0qf5or87gpwdi` (`r_id`),
    CONSTRAINT `FKj6b1j8csidus0qf5or87gpwdi` FOREIGN KEY (`r_id`) REFERENCES `sys_role` (`id`),
    CONSTRAINT `FKt7u9ggroj0hseyo20nexvep86` FOREIGN KEY (`u_id`) REFERENCES `sys_user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- Dumping data for table demo.sys_user_role: ~2 rows (大约)
/*!40000 ALTER TABLE `sys_user_role`
    DISABLE KEYS */;
INSERT INTO `sys_user_role` (`u_id`, `r_id`)
VALUES (4, 1),
       (4, 2),
       (6, 2);
/*!40000 ALTER TABLE `sys_user_role`
    ENABLE KEYS */;

/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
