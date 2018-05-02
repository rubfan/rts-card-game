CREATE TABLE `User` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(16) NOT NULL UNIQUE,
	`password` varchar(16) NOT NULL,
	`token` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`room_id` INT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Room` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	`account_1_id` INT,
	`account_2_id` INT,
	`start_game_time` DATETIME,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`building_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`resource_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Upgrade` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`upgrade_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`achievement_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Message` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`text` varchar(128) NOT NULL,
	`from_account_id` INT,
	`to_account_id` INT,
	`time` DATETIME,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Upgrade` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(16) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Action` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`card_id` INT NOT NULL,
	`p1_building_id` INT,
	`p2_building_id` INT,
	`p1_building_number` FLOAT,
	`p2_building_number` FLOAT,
	`p1_resource_id` INT,
	`p2_resource_id` INT,
	`p1_resource_number` FLOAT,
	`p2_resource_number` FLOAT,
	`p1_upgrade_id` INT,
	`p2_upgrade_id` INT,
	`p1_upgrade_number` FLOAT,
	`p2_upgrade_number` FLOAT,
	`necessary_building_id` INT,
	`necessary_upgrade_id` INT,
	`necessary_building_number` INT,
	`necessary_upgrade_number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trigger_Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`notification_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`upgrade_id` INT,
	`building_number` FLOAT,
	`resource_number` FLOAT,
	`upgrade_number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Upgrade_Product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`upgrade_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`percent` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Building_Product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`building_id` INT NOT NULL,
	`resource_id` INT NOT NULL,
	`number_per_sec` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trigger_Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`achievement_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`upgrade_id` INT,
	`building_number` INT,
	`resource_number` INT,
	`upgrade_number` INT,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Account` ADD CONSTRAINT `Account_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);

ALTER TABLE `Account` ADD CONSTRAINT `Account_fk1` FOREIGN KEY (`room_id`) REFERENCES `Room`(`id`);

ALTER TABLE `Room` ADD CONSTRAINT `Room_fk0` FOREIGN KEY (`account_1_id`) REFERENCES `Account`(`id`);

ALTER TABLE `Room` ADD CONSTRAINT `Room_fk1` FOREIGN KEY (`account_2_id`) REFERENCES `Account`(`id`);

#ALTER TABLE `Account_Building` ADD CONSTRAINT `Account_Building_fk0` FOREIGN KEY (`account_id`) REFERENCES `Account`(`id`);

#ALTER TABLE `Account_Building` ADD CONSTRAINT `Account_Building_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Account_Resource` ADD CONSTRAINT `Account_Resource_fk0` FOREIGN KEY (`account_id`) REFERENCES `Account`(`id`);

ALTER TABLE `Account_Resource` ADD CONSTRAINT `Account_Resource_fk1` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Account_Upgrade` ADD CONSTRAINT `Account_Upgrade_fk0` FOREIGN KEY (`account_id`) REFERENCES `Account`(`id`);

ALTER TABLE `Account_Upgrade` ADD CONSTRAINT `Account_Upgrade_fk1` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Account_Achievement` ADD CONSTRAINT `Account_Achievement_fk0` FOREIGN KEY (`account_id`) REFERENCES `Account`(`id`);

ALTER TABLE `Account_Achievement` ADD CONSTRAINT `Account_Achievement_fk1` FOREIGN KEY (`achievement_id`) REFERENCES `Achievement`(`id`);

ALTER TABLE `Message` ADD CONSTRAINT `Message_fk0` FOREIGN KEY (`from_account_id`) REFERENCES `Account`(`id`);

ALTER TABLE `Message` ADD CONSTRAINT `Message_fk1` FOREIGN KEY (`to_account_id`) REFERENCES `Account`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk0` FOREIGN KEY (`card_id`) REFERENCES `Card`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk1` FOREIGN KEY (`p1_building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk2` FOREIGN KEY (`p2_building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk3` FOREIGN KEY (`p1_resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk4` FOREIGN KEY (`p2_resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk5` FOREIGN KEY (`p1_upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk6` FOREIGN KEY (`p2_upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk7` FOREIGN KEY (`necessary_building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Card_Action` ADD CONSTRAINT `Card_Action_fk8` FOREIGN KEY (`necessary_upgrade_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk0` FOREIGN KEY (`notification_id`) REFERENCES `Notification`(`id`);

ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk2` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk3` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Upgrade_Product` ADD CONSTRAINT `Upgrade_Product_fk0` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Upgrade_Product` ADD CONSTRAINT `Upgrade_Product_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Upgrade_Product` ADD CONSTRAINT `Upgrade_Product_fk2` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Building_Product` ADD CONSTRAINT `Building_Product_fk0` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

#ALTER TABLE `Building_Product` ADD CONSTRAINT `Building_Product_fk1` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk0` FOREIGN KEY (`achievement_id`) REFERENCES `Achievement`(`id`);

ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk2` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk3` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);
