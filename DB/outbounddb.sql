-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema outbounddb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `outbounddb` ;

-- -----------------------------------------------------
-- Schema outbounddb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `outbounddb` DEFAULT CHARACTER SET utf8 ;
USE `outbounddb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(2000) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(200) NULL,
  `role` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `phone` VARCHAR(200) NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trip` ;

CREATE TABLE IF NOT EXISTS `trip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `description` TEXT NULL,
  `success` TINYINT NULL,
  `create_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hunt_trip_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_hunt_trip_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `license`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `license` ;

CREATE TABLE IF NOT EXISTS `license` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `license_number` VARCHAR(200) NULL,
  `year` INT NULL,
  `type` VARCHAR(45) NULL,
  `from_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `purchase_date` DATETIME NULL,
  `sportsmans_number` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weather`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weather` ;

CREATE TABLE IF NOT EXISTS `weather` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tag` ;

CREATE TABLE IF NOT EXISTS `tag` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `tag_number` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `country` ;

CREATE TABLE IF NOT EXISTS `country` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `abbr` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL,
  `address` VARCHAR(45) NULL,
  `address2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `postal_code` INT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_address_country1_idx` (`country_id` ASC),
  CONSTRAINT `fk_address_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `draw_odds`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `draw_odds` ;

CREATE TABLE IF NOT EXISTS `draw_odds` (
  `id` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `state_id` INT NOT NULL,
  PRIMARY KEY (`state_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `state` ;

CREATE TABLE IF NOT EXISTS `state` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `abbr` VARCHAR(45) NULL,
  `country_id` INT NOT NULL,
  `resident` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_state_country1_idx` (`country_id` ASC),
  CONSTRAINT `fk_state_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hunting_information`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hunting_information` ;

CREATE TABLE IF NOT EXISTS `hunting_information` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `species` ;

CREATE TABLE IF NOT EXISTS `species` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hunt_method_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hunt_method_type` ;

CREATE TABLE IF NOT EXISTS `hunt_method_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season` ;

CREATE TABLE IF NOT EXISTS `season` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `region` ;

CREATE TABLE IF NOT EXISTS `region` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `unit` ;

CREATE TABLE IF NOT EXISTS `unit` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tag_has_species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tag_has_species` ;

CREATE TABLE IF NOT EXISTS `tag_has_species` (
  `tag_id` INT NOT NULL,
  `species_id` INT NOT NULL,
  PRIMARY KEY (`tag_id`, `species_id`),
  INDEX `fk_tag_has_species_species1_idx` (`species_id` ASC),
  INDEX `fk_tag_has_species_tag1_idx` (`tag_id` ASC),
  CONSTRAINT `fk_tag_has_species_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tag_has_species_species1`
    FOREIGN KEY (`species_id`)
    REFERENCES `species` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `preference_points`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preference_points` ;

CREATE TABLE IF NOT EXISTS `preference_points` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(2000) NULL,
  `amount` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weapon_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon_type` ;

CREATE TABLE IF NOT EXISTS `weapon_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(200) NULL,
  `description` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clothing_layer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clothing_layer` ;

CREATE TABLE IF NOT EXISTS `clothing_layer` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `top_copy2`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `top_copy2` ;

CREATE TABLE IF NOT EXISTS `top_copy2` (
  `1` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`1`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clothing_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clothing_category` ;

CREATE TABLE IF NOT EXISTS `clothing_category` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory` ;

CREATE TABLE IF NOT EXISTS `inventory` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_inventory_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_inventory_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT NOT NULL,
  `brand` VARCHAR(200) NULL,
  `model_name` VARCHAR(200) NULL,
  `description` VARCHAR(2000) NULL,
  `weight` DOUBLE NULL,
  `inventory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_inventory_item_inventory1_idx` (`inventory_id` ASC),
  CONSTRAINT `fk_inventory_item_inventory1`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `inventory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_category` ;

CREATE TABLE IF NOT EXISTS `item_category` (
  `id` INT NOT NULL,
  `gear_type` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_has_item_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_has_item_category` ;

CREATE TABLE IF NOT EXISTS `item_has_item_category` (
  `gear_item_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`gear_item_id`, `category_id`),
  INDEX `fk_gear_item_has_category_category1_idx` (`category_id` ASC),
  INDEX `fk_gear_item_has_category_gear_item1_idx` (`gear_item_id` ASC),
  CONSTRAINT `fk_gear_item_has_category_gear_item1`
    FOREIGN KEY (`gear_item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gear_item_has_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `item_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `preference_points_has_species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preference_points_has_species` ;

CREATE TABLE IF NOT EXISTS `preference_points_has_species` (
  `preference_points_id` INT NOT NULL,
  `species_id` INT NOT NULL,
  PRIMARY KEY (`preference_points_id`, `species_id`),
  INDEX `fk_preference_points_has_species_species1_idx` (`species_id` ASC),
  INDEX `fk_preference_points_has_species_preference_points1_idx` (`preference_points_id` ASC),
  CONSTRAINT `fk_preference_points_has_species_preference_points1`
    FOREIGN KEY (`preference_points_id`)
    REFERENCES `preference_points` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_preference_points_has_species_species1`
    FOREIGN KEY (`species_id`)
    REFERENCES `species` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hunting_information_has_state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hunting_information_has_state` ;

CREATE TABLE IF NOT EXISTS `hunting_information_has_state` (
  `hunting_information_id` INT NOT NULL,
  `state_id` INT NOT NULL,
  PRIMARY KEY (`hunting_information_id`, `state_id`),
  INDEX `fk_hunting_information_has_state_state1_idx` (`state_id` ASC),
  INDEX `fk_hunting_information_has_state_hunting_information1_idx` (`hunting_information_id` ASC),
  CONSTRAINT `fk_hunting_information_has_state_hunting_information1`
    FOREIGN KEY (`hunting_information_id`)
    REFERENCES `hunting_information` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hunting_information_has_state_state1`
    FOREIGN KEY (`state_id`)
    REFERENCES `state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hunt_method_type_has_hunt_trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hunt_method_type_has_hunt_trip` ;

CREATE TABLE IF NOT EXISTS `hunt_method_type_has_hunt_trip` (
  `hunt_method_type_id` INT NOT NULL,
  PRIMARY KEY (`hunt_method_type_id`),
  INDEX `fk_hunt_method_type_has_hunt_trip_hunt_method_type1_idx` (`hunt_method_type_id` ASC),
  CONSTRAINT `fk_hunt_method_type_has_hunt_trip_hunt_method_type1`
    FOREIGN KEY (`hunt_method_type_id`)
    REFERENCES `hunt_method_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hunt_method_type_has_hunting_information`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hunt_method_type_has_hunting_information` ;

CREATE TABLE IF NOT EXISTS `hunt_method_type_has_hunting_information` (
  `hunt_method_type_id` INT NOT NULL,
  `hunting_information_id` INT NOT NULL,
  PRIMARY KEY (`hunt_method_type_id`, `hunting_information_id`),
  INDEX `fk_hunt_method_type_has_hunting_information_hunting_informa_idx` (`hunting_information_id` ASC),
  INDEX `fk_hunt_method_type_has_hunting_information_hunt_method_typ_idx` (`hunt_method_type_id` ASC),
  CONSTRAINT `fk_hunt_method_type_has_hunting_information_hunt_method_type1`
    FOREIGN KEY (`hunt_method_type_id`)
    REFERENCES `hunt_method_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hunt_method_type_has_hunting_information_hunting_informati1`
    FOREIGN KEY (`hunting_information_id`)
    REFERENCES `hunting_information` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_category_has_weapon_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_category_has_weapon_type` ;

CREATE TABLE IF NOT EXISTS `item_category_has_weapon_type` (
  `weapon_type_id` INT NOT NULL,
  `gear_category_id` INT NOT NULL,
  PRIMARY KEY (`weapon_type_id`, `gear_category_id`),
  INDEX `fk_weapon_type_has_gear_category_gear_category1_idx` (`gear_category_id` ASC),
  INDEX `fk_weapon_type_has_gear_category_weapon_type1_idx` (`weapon_type_id` ASC),
  CONSTRAINT `fk_weapon_type_has_gear_category_weapon_type1`
    FOREIGN KEY (`weapon_type_id`)
    REFERENCES `weapon_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weapon_type_has_gear_category_gear_category1`
    FOREIGN KEY (`gear_category_id`)
    REFERENCES `item_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_category_has_clothing_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_category_has_clothing_category` ;

CREATE TABLE IF NOT EXISTS `item_category_has_clothing_category` (
  `clothing_category_id` INT NOT NULL,
  `gear_category_id` INT NOT NULL,
  PRIMARY KEY (`clothing_category_id`, `gear_category_id`),
  INDEX `fk_clothing_category_has_gear_category_gear_category1_idx` (`gear_category_id` ASC),
  INDEX `fk_clothing_category_has_gear_category_clothing_category1_idx` (`clothing_category_id` ASC),
  CONSTRAINT `fk_clothing_category_has_gear_category_clothing_category1`
    FOREIGN KEY (`clothing_category_id`)
    REFERENCES `clothing_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clothing_category_has_gear_category_gear_category1`
    FOREIGN KEY (`gear_category_id`)
    REFERENCES `item_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gear_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gear_list` ;

CREATE TABLE IF NOT EXISTS `gear_list` (
  `id` INT NOT NULL,
  `description` TEXT NULL,
  `active` TINYINT NULL,
  `user_id` INT NOT NULL,
  `inventory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gear_list_user1_idx` (`user_id` ASC),
  INDEX `fk_gear_list_gear_inventory1_idx` (`inventory_id` ASC),
  CONSTRAINT `fk_gear_list_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gear_list_gear_inventory1`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `inventory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_category_has_clothing_layer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_category_has_clothing_layer` ;

CREATE TABLE IF NOT EXISTS `item_category_has_clothing_layer` (
  `gear_category_id` INT NOT NULL,
  `clothing_layer_id` INT NOT NULL,
  PRIMARY KEY (`gear_category_id`, `clothing_layer_id`),
  INDEX `fk_gear_category_has_clothing_layer_clothing_layer1_idx` (`clothing_layer_id` ASC),
  INDEX `fk_gear_category_has_clothing_layer_gear_category1_idx` (`gear_category_id` ASC),
  CONSTRAINT `fk_gear_category_has_clothing_layer_gear_category1`
    FOREIGN KEY (`gear_category_id`)
    REFERENCES `item_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gear_category_has_clothing_layer_clothing_layer1`
    FOREIGN KEY (`clothing_layer_id`)
    REFERENCES `clothing_layer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS outboundadmin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'outboundadmin'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'outboundadmin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `role`, `description`, `phone`, `active`) VALUES (1, 'lpaladini90', '$2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv.', 'Lucas', 'Paladini', 'lpaladini@me.com', 'ADMIN', 'I like to hunt', '(509)-993-8866', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `trip`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (1, 'Fall Antelope Hunt', NULL, NULL, 'Wyoming Hunt in the fall for antelope and mule deer', 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (2, 'Mule Deer Fall Hunt', NULL, NULL, 'Hunting Mule Deer in Colorado', 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (3, 'Black Bear Spring Hunt ', NULL, NULL, 'Alaskan Black bear hunt in the spring', 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (4, 'Roosevelt Elk Hunt', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (5, 'Alaska Caribou Hunt', NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (6, 'White Tail Hunt', NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (7, 'Sage Grouse Hunt', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (8, 'Grouse Bird Hunt', NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (9, 'Black Bear Spring Hunt ', NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (10, 'Mule Deer Wyoming Hunt', NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (11, 'Pheasant Hunt Nebraska', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (12, 'Black Bear Spring Hunt ', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (13, 'Racoon Hunt Wi', NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (14, 'Pheasant Hunt Washington', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `start_date`, `end_date`, `description`, `success`, `create_date`, `user_id`) VALUES (15, 'Forest Grouse Hunt Idaho', NULL, NULL, NULL, 1, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `license`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `license` (`id`, `license_number`, `year`, `type`, `from_date`, `end_date`, `purchase_date`, `sportsmans_number`) VALUES (1, 'LN 21162119583', 2021, 'general', NULL, NULL, NULL, 2064906149);

COMMIT;


-- -----------------------------------------------------
-- Data for table `weather`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `weather` (`id`, `name`, `description`) VALUES (1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tag`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `tag` (`id`, `name`, `description`, `tag_number`) VALUES (1, 'Antelope/ Pronghorn', 'antelope for bow season in fall in wyoming', 028810);

COMMIT;


-- -----------------------------------------------------
-- Data for table `country`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `country` (`id`, `name`, `abbr`) VALUES (1, 'United States of America', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country_id`) VALUES (1, '28818 N Hardesty Rd', NULL, 'Chattaroy', 'Washington', 99003, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `draw_odds`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `draw_odds` (`id`, `name`, `description`, `state_id`) VALUES ('1', 'Black Bear', 'Black Bear Draw Odds for non residents', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `state`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `state` (`id`, `name`, `abbr`, `country_id`, `resident`) VALUES (1, 'Alaska', 'AK', 1, NULL);
INSERT INTO `state` (`id`, `name`, `abbr`, `country_id`, `resident`) VALUES (2, 'Colorado', 'CO', 1, NULL);
INSERT INTO `state` (`id`, `name`, `abbr`, `country_id`, `resident`) VALUES (3, 'Washington', 'WA', 1, NULL);
INSERT INTO `state` (`id`, `name`, `abbr`, `country_id`, `resident`) VALUES (4, 'Wyoming', 'WY', 1, NULL);
INSERT INTO `state` (`id`, `name`, `abbr`, `country_id`, `resident`) VALUES (5, 'Nebraska', 'NE', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hunting_information`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `hunting_information` (`id`, `name`, `description`) VALUES (1, 'Hunt Information', 'General');

COMMIT;


-- -----------------------------------------------------
-- Data for table `species`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `species` (`id`, `name`, `description`) VALUES (1, 'Black Bear', 'black bear ');
INSERT INTO `species` (`id`, `name`, `description`) VALUES (2, 'Brown Bear', 'brown bear');
INSERT INTO `species` (`id`, `name`, `description`) VALUES (3, 'Moose', 'moose');
INSERT INTO `species` (`id`, `name`, `description`) VALUES (4, 'Mule Deer', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (5, 'White Tail Deer', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (6, 'Black Tail Deer', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (7, 'Dall Sheep', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (8, 'Rocky Mountain Goat', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (9, 'Roosevelt Elk', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (10, 'Rock Mountain Elk', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (11, 'Caribou', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (12, 'Bison', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (13, 'Pronghorn', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (14, 'Auodad', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (15, 'Muskox', NULL);
INSERT INTO `species` (`id`, `name`, `description`) VALUES (16, 'Bighorn Sheep', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hunt_method_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `hunt_method_type` (`id`, `name`, `description`) VALUES (1, 'Archery', 'The use of a compound, recurve, or cross bow while hunting.');
INSERT INTO `hunt_method_type` (`id`, `name`, `description`) VALUES (2, 'Modern Firearm', 'The use of a modern firearm while hunting.');
INSERT INTO `hunt_method_type` (`id`, `name`, `description`) VALUES (3, 'Muzzle Loader', 'The use of a muzzle loader while hunting');

COMMIT;


-- -----------------------------------------------------
-- Data for table `season`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `season` (`id`, `name`, `description`) VALUES (1, 'Youth General', 'youth general hunt');
INSERT INTO `season` (`id`, `name`, `description`) VALUES (2, 'Youth Late', 'youth late hunt');
INSERT INTO `season` (`id`, `name`, `description`) VALUES (3, 'General', 'general hunt');
INSERT INTO `season` (`id`, `name`, `description`) VALUES (4, 'Late General', 'late general hunt');
INSERT INTO `season` (`id`, `name`, `description`) VALUES (5, 'Hunters Over 65 or Disabled', 'general hunt');
INSERT INTO `season` (`id`, `name`, `description`) VALUES (6, 'Early General', 'early general season hunt');

COMMIT;


-- -----------------------------------------------------
-- Data for table `region`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `region` (`id`, `name`, `description`) VALUES (1, 'Hunt Region', 'hunt region if applicable');

COMMIT;


-- -----------------------------------------------------
-- Data for table `unit`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `unit` (`id`, `name`, `description`) VALUES (1, 'Hunt Unit 22', 'Hunt Area 22');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tag_has_species`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `tag_has_species` (`tag_id`, `species_id`) VALUES (1, 13);

COMMIT;


-- -----------------------------------------------------
-- Data for table `preference_points`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `preference_points` (`id`, `name`, `description`, `amount`) VALUES (1, 'Mule Deer', 'preference points', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `weapon_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `weapon_type` (`id`, `name`, `description`) VALUES (1, 'Rifle', 'rifle ');
INSERT INTO `weapon_type` (`id`, `name`, `description`) VALUES (2, 'Bow', 'bow');
INSERT INTO `weapon_type` (`id`, `name`, `description`) VALUES (3, 'Muzzleloader', 'muzzleloader');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clothing_layer`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `clothing_layer` (`id`, `type`, `description`) VALUES (1, 'Under Layer', 'Under layer packed');
INSERT INTO `clothing_layer` (`id`, `type`, `description`) VALUES (2, 'Mid Layer', 'Mid layer packed');
INSERT INTO `clothing_layer` (`id`, `type`, `description`) VALUES (3, 'Outer Layer', 'Outer layer packed');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clothing_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `clothing_category` (`id`, `type`) VALUES (1, 'headwear');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (2, 'neckwear');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (3, 'top');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (4, 'belt');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (5, 'bottom');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (6, 'socks');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (7, 'footwear');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (8, 'watch');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (9, 'gloves');
INSERT INTO `clothing_category` (`id`, `type`) VALUES (10, 'eyewear');

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `inventory` (`id`, `user_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (1, 'Kifaru', 'Fulcrum', 'Functional, versatile and durable are just a few words that describe the Fulcrum', 3.4, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (2, 'Adventure Med Kits', 'Ultralight/ Watertight .9 Med Kit', 'The kit features two layers of rugged waterproofing protection, keeping the contents safe and dry even in the most extreme elements. Ideal for ultralight hiking, this kit lets you keep weight to a minimum, as it weighs less than 8 oz., while still being prepared. ', .75, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (3, 'Vortex Binoculars', 'Diamondback HD 12x50', 'The Diamondback® HD smashes the scale of price vs performance, delivering a rock-solid optic that optically punches high above its class.', 1.80, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (4, 'Mountain House', 'Beef Strogi ', 'freeze dried food- use with jet boil.', .268, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (5, 'Jetboil', 'MicroMo', 'Cooking System', .75, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (6, 'MSR', 'IsoPro', 'jet boil fuel', .25, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (7, 'Ascent', '900', 'light weight down sleeping bag', 3.55, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (8, 'Black Diamond', 'Alpine Carbon Cork', 'Trekking Poles - Pair', 1.06, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (9, 'SPOT', 'Gen 3', 'The latest generation of award-winning SPOT devices from Globalstar, the SPOT Gen3 offers a critical, life-saving line of communication when traveling beyond cellular coverage zones. ', .25, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (10, 'Counter Assault', 'Bear Spray', 'Bear protection with holster', .5, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (11, 'Matthews', 'Vertix', 'Compound Bow', 4.75, 1);
INSERT INTO `item` (`id`, `brand`, `model_name`, `description`, `weight`, `inventory_id`) VALUES (12, 'First Lite', 'Corrugate Pants', 'brown general hunt pants', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (1, 'Backpack');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (2, 'Cooking');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (3, 'First Aid');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (4, 'Miscellaneous');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (5, 'Optics');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (6, 'Sleeping');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (7, 'Food');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (8, 'Clothing');
INSERT INTO `item_category` (`id`, `gear_type`) VALUES (9, 'Weapon');

COMMIT;


-- -----------------------------------------------------
-- Data for table `item_has_item_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (1, 1);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (2, 3);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (3, 5);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (4, 7);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (5, 2);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (6, 2);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (7, 6);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (8, 4);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (9, 4);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (10, 4);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (11, 9);
INSERT INTO `item_has_item_category` (`gear_item_id`, `category_id`) VALUES (12, 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `preference_points_has_species`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `preference_points_has_species` (`preference_points_id`, `species_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hunting_information_has_state`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `hunting_information_has_state` (`hunting_information_id`, `state_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hunt_method_type_has_hunt_trip`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `hunt_method_type_has_hunt_trip` (`hunt_method_type_id`) VALUES (1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hunt_method_type_has_hunting_information`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `hunt_method_type_has_hunting_information` (`hunt_method_type_id`, `hunting_information_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item_category_has_weapon_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `item_category_has_weapon_type` (`weapon_type_id`, `gear_category_id`) VALUES (1, 9);
INSERT INTO `item_category_has_weapon_type` (`weapon_type_id`, `gear_category_id`) VALUES (2, 9);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item_category_has_clothing_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (1, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (2, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (3, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (4, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (5, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (6, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (7, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (8, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (9, 8);
INSERT INTO `item_category_has_clothing_category` (`clothing_category_id`, `gear_category_id`) VALUES (10, 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gear_list`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `gear_list` (`id`, `description`, `active`, `user_id`, `inventory_id`) VALUES (1, 'Antelope Hunt List', 1, 1, 1);
INSERT INTO `gear_list` (`id`, `description`, `active`, `user_id`, `inventory_id`) VALUES (2, 'Mule Deer Hunt', 1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item_category_has_clothing_layer`
-- -----------------------------------------------------
START TRANSACTION;
USE `outbounddb`;
INSERT INTO `item_category_has_clothing_layer` (`gear_category_id`, `clothing_layer_id`) VALUES (8, 1);
INSERT INTO `item_category_has_clothing_layer` (`gear_category_id`, `clothing_layer_id`) VALUES (8, 2);
INSERT INTO `item_category_has_clothing_layer` (`gear_category_id`, `clothing_layer_id`) VALUES (8, 3);

COMMIT;

