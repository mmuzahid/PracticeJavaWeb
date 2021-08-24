CREATE DATABASE practicejavaweb;

USE  practicejavaweb;

CREATE TABLE `post` (
	`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`title` VARCHAR(50) NOT NULL,
	`content` TEXT NOT NULL,
	`created_at` DATETIME NOT NULL
)
ENGINE=InnoDB;


CREATE TABLE `tag` (
	`RECORD_ID` int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `post_id` mediumint(11),
  `tag_name` varchar(100) NOT NULL
) 
ENGINE=InnoDB;
