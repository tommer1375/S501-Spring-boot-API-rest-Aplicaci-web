-- MySQL Script generated by MySQL Workbench
-- Wed Apr 17 10:50:03 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema flowersbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flowersbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flowersbd` DEFAULT CHARACTER SET utf8 ;
USE `flowersbd` ;

-- -----------------------------------------------------
-- Table `flowersbd`.`flowers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowersbd`.`flowers` (
  `pk_FlowerID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_FlowerID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
