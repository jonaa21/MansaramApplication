-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mansaram_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mansaram_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mansaram_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mansaram_db` ;

-- -----------------------------------------------------
-- Table `mansaram_db`.`verzekering`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mansaram_db`.`verzekeraar` ;

CREATE TABLE IF NOT EXISTS `mansaram_db`.`verzekeraar` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `naam` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `verzekeraar_UNIQUE` ON `mansaram_db`.`verzekeraar` (`naam` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mansaram_db`.`verzekering_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mansaram_db`.`verzekering_type` ;

CREATE TABLE IF NOT EXISTS `mansaram_db`.`verzekering_type` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `type_UNIQUE` ON `mansaram_db`.`verzekering_type` (`type` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mansaram_db`.`verzekering`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mansaram_db`.`verzekering` ;

CREATE TABLE IF NOT EXISTS `mansaram_db`.`verzekering` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `verzekeraar_id` BIGINT(10) NOT NULL,
  `verz_type_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `verzekeraar_id_fk`
    FOREIGN KEY (`verzekeraar_id`)
    REFERENCES `mansaram_db`.`verzekeraar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `verz_type_id_fk`
    FOREIGN KEY (`verz_type_id`)
    REFERENCES `mansaram_db`.`verzekering_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `verzekeraar_id_idx` ON `mansaram_db`.`verzekering` (`verzekeraar_id` ASC) VISIBLE;

CREATE INDEX `verz_type_id_fk_idx` ON `mansaram_db`.`verzekering` (`verz_type_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `verz_unique` ON `mansaram_db`.`verzekering` (`verz_type_id` ASC, `verzekeraar_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mansaram_db`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mansaram_db`.`patient` ;

CREATE TABLE IF NOT EXISTS `mansaram_db`.`patient` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `voornaam` VARCHAR(45) NOT NULL,
  `achternaam` VARCHAR(45) NOT NULL,
  `adres` VARCHAR(45) NOT NULL,
  `verzekering_id` BIGINT(10) NOT NULL,
  `verzekering_nr` VARCHAR(45) NOT NULL,
  `geslacht` VARCHAR(1) NOT NULL,
  `geb_datum` DATE NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `verzekering_id_fk`
    FOREIGN KEY (`verzekering_id`)
    REFERENCES `mansaram_db`.`verzekering` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `verzekering_nr_UNIQUE` ON `mansaram_db`.`patient` (`verzekering_nr` ASC) VISIBLE;

CREATE INDEX `verzekering_id_fk_idx` ON `mansaram_db`.`patient` (`verzekering_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mansaram_db`.`bezoek`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mansaram_db`.`bezoek` ;

CREATE TABLE IF NOT EXISTS `mansaram_db`.`bezoek` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `patient_id` BIGINT(10) NOT NULL,
  `bevinding` VARCHAR(255) NOT NULL,
  `bezoek_datum` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `patient_id_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `mansaram_db`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `patient_id_fk_idx` ON `mansaram_db`.`bezoek` (`patient_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mansaram_db`.`verzekering`
-- -----------------------------------------------------
START TRANSACTION;
USE `mansaram_db`;
INSERT INTO `mansaram_db`.`verzekeraar` (`id`, `naam`) VALUES (DEFAULT, 'Assuria');
INSERT INTO `mansaram_db`.`verzekeraar` (`id`, `naam`) VALUES (DEFAULT, 'SZF');
INSERT INTO `mansaram_db`.`verzekeraar` (`id`, `naam`) VALUES (DEFAULT, 'Parsasco');
INSERT INTO `mansaram_db`.`verzekeraar` (`id`, `naam`) VALUES (DEFAULT, 'Self Reliance');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mansaram_db`.`verzekering_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `mansaram_db`;
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'Personenverzekering');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'Bedrijvenverzekering');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'Studentenverzekering');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'Basiszorgverzekering');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'PZS Basis');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'PZS Comfort');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'PZS X-Comfort');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'Azpas Basis');
INSERT INTO `mansaram_db`.`verzekering_type` (`id`, `type`) VALUES (DEFAULT, 'Azpas Plus');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mansaram_db`.`verzekering`
-- -----------------------------------------------------
START TRANSACTION;
USE `mansaram_db`;
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 1, 8);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 1, 9);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 2, 1);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 2, 2);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 2, 3);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 2, 4);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 3, 4);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 4, 5);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 4, 6);
INSERT INTO `mansaram_db`.`verzekering` (`id`, `verzekeraar_id`, `verz_type_id`) VALUES (DEFAULT, 4, 7);

COMMIT;

