-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema agendaa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agendaa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS agendaa DEFAULT CHARACTER SET utf8 ;
USE agendaa;

-- -----------------------------------------------------
-- Table contato
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contato (
  codigo INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  dataNascimento VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB;


SELECT * FROM contato;
