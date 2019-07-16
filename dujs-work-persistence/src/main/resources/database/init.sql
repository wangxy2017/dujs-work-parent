CREATE DATABASE IF NOT EXISTS dujs_work default character set utf8 COLLATE utf8_general_ci;
USE dujs_work;

CREATE TABLE `sys_note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` int(1) NOT NULL DEFAULT '0',
  `title` varchar(64) NOT NULL,
  `content` text NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
