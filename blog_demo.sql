# database : test

# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;


INSERT INTO `role` ( `role`)
VALUES
	('ADMIN'),
    ('USER');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

/*
INSERT INTO `user` (`email`, `name`, `password`)
VALUES
	('admin@gmail.com','admin','admin'),
    ('sam@gmail.com', 'sam', 'sam');

*/
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  -- UNIQUE KEY `UK_role` (`role_id`),
  CONSTRAINT `FK_user_ur` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_role_ur` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

/*
INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
	(1,1),
    (2,2);
*/
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

# Dump of table post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `body` varchar(255) NOT NULL,
  `date_created` DATETIME NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`),
--   UNIQUE KEY `UK_role` (`role_id`),
  CONSTRAINT `FK_user_post` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*
INSERT INTO `post` (`title`, `body`, `date_created`, `user_id`)
VALUES
	("hello wolrd", "hello hello", CURRENT_TIMESTAMP, 1);
*/
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

