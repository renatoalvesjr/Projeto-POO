-- MySQL Script generated by MySQL Workbench
-- Wed Nov 29 11:56:21 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projetopoo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projetopoo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projetopoo` DEFAULT CHARACTER SET utf8 ;
USE `projetopoo` ;

-- -----------------------------------------------------
-- Table `projetopoo`.`Alimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Alimento` (
  `idAlimento` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `carb` DECIMAL(10,2) NULL,
  `prot` DECIMAL(10,2) NULL,
  `gord` DECIMAL(10,2) NULL,
  `cal` DECIMAL(10,2) NULL,
  `porcao` DECIMAL(10,2) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  PRIMARY KEY (`idAlimento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `sexo` CHAR(1) NULL,
  `nascimento` DATETIME NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `usertype` INT NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`TipoDieta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`TipoDieta` (
  `idTipoDieta` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `carb` DECIMAL(10,2) NULL,
  `prot` DECIMAL(10,2) NULL,
  `gord` DECIMAL(10,2) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  PRIMARY KEY (`idTipoDieta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Refeicoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Refeicoes` (
  `idRefeicoes` INT NOT NULL AUTO_INCREMENT,
  `carb` DECIMAL(10,2) NULL,
  `prot` DECIMAL(10,2) NULL,
  `gord` DECIMAL(10,2) NULL,
  `cal` DECIMAL(10,2) NULL,
  `nome` VARCHAR(45) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  `TipoDieta_idTipoDieta` INT NOT NULL,
  PRIMARY KEY (`idRefeicoes`, `TipoDieta_idTipoDieta`),
  INDEX `fk_Refeicoes_TipoDieta_idx` (`TipoDieta_idTipoDieta` ASC) VISIBLE,
  CONSTRAINT `fk_Refeicoes_TipoDieta`
    FOREIGN KEY (`TipoDieta_idTipoDieta`)
    REFERENCES `projetopoo`.`TipoDieta` (`idTipoDieta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`AlimentoRefeicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`AlimentoRefeicao` (
  `idAlimentoRefeicao` INT NOT NULL AUTO_INCREMENT,
  `porcao` DECIMAL(10,2) NULL,
  `prot` DECIMAL(10,2) NULL,
  `carb` DECIMAL(10,2) NULL,
  `gord` DECIMAL(10,2) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  `Refeicoes_idRefeicoes` INT NOT NULL,
  `Refeicoes_TipoDieta_idTipoDieta` INT NOT NULL,
  `Alimento_idAlimento` INT NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idAlimentoRefeicao`, `Refeicoes_idRefeicoes`, `Refeicoes_TipoDieta_idTipoDieta`, `Alimento_idAlimento`, `Pessoa_idPessoa`),
  INDEX `fk_AlimentoRefeicao_Refeicoes1_idx` (`Refeicoes_idRefeicoes` ASC, `Refeicoes_TipoDieta_idTipoDieta` ASC) VISIBLE,
  INDEX `fk_AlimentoRefeicao_Alimento1_idx` (`Alimento_idAlimento` ASC) VISIBLE,
  INDEX `fk_AlimentoRefeicao_Pessoa1_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_AlimentoRefeicao_Refeicoes1`
    FOREIGN KEY (`Refeicoes_idRefeicoes` , `Refeicoes_TipoDieta_idTipoDieta`)
    REFERENCES `projetopoo`.`Refeicoes` (`idRefeicoes` , `TipoDieta_idTipoDieta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AlimentoRefeicao_Alimento1`
    FOREIGN KEY (`Alimento_idAlimento`)
    REFERENCES `projetopoo`.`Alimento` (`idAlimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AlimentoRefeicao_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Avaliacao` (
  `idAvaliacao` INT NOT NULL AUTO_INCREMENT,
  `peso` DECIMAL(3,2) NULL,
  `altura` DECIMAL(3,2) NULL,
  `idade` INT NULL,
  `pescoco` DECIMAL(3,2) NULL,
  `cintura` DECIMAL(3,2) NULL,
  `quadril` DECIMAL(3,2) NULL,
  `rotina` DECIMAL(3,3) NULL,
  `imc` DECIMAL(3,2) NULL,
  `tbm` DECIMAL(5,2) NULL,
  `bf` DECIMAL(3,2) NULL,
  `massGorda` DECIMAL(3,2) NULL,
  `massMagra` DECIMAL(3,2) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idAvaliacao`, `Pessoa_idPessoa`),
  INDEX `fk_Avaliacao_Pessoa1_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_Avaliacao_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Mensagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Mensagem` (
  `idMensagem` INT NOT NULL AUTO_INCREMENT,
  `conteudo` VARCHAR(200) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  `Pessoa_idPessoaRemetente` INT NOT NULL,
  `Pessoa_idPessoaDestinatario` INT NOT NULL,
  PRIMARY KEY (`idMensagem`, `Pessoa_idPessoaRemetente`, `Pessoa_idPessoaDestinatario`),
  INDEX `fk_Mensagem_Pessoa1_idx` (`Pessoa_idPessoaRemetente` ASC) VISIBLE,
  INDEX `fk_Mensagem_Pessoa2_idx` (`Pessoa_idPessoaDestinatario` ASC) VISIBLE,
  CONSTRAINT `fk_Mensagem_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoaRemetente`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mensagem_Pessoa2`
    FOREIGN KEY (`Pessoa_idPessoaDestinatario`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Post` (
  `idMensagem` INT NOT NULL AUTO_INCREMENT,
  `conteudo` VARCHAR(200) NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idMensagem`, `Pessoa_idPessoa`),
  INDEX `fk_Mensagem_Pessoa2_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_Mensagem_Pessoa20`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Preferencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Preferencia` (
  `Pessoa_idPessoa` INT NOT NULL,
  `Alimento_idAlimento` INT NOT NULL,
  `createDate` DATETIME NULL,
  `modifyDate` DATETIME NULL,
  PRIMARY KEY (`Pessoa_idPessoa`, `Alimento_idAlimento`),
  INDEX `fk_Preferencia_Pessoa1_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  INDEX `fk_Preferencia_Alimento1_idx` (`Alimento_idAlimento` ASC) VISIBLE,
  CONSTRAINT `fk_Preferencia_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Preferencia_Alimento1`
    FOREIGN KEY (`Alimento_idAlimento`)
    REFERENCES `projetopoo`.`Alimento` (`idAlimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`RegistroDieta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`RegistroDieta` (
  `idRegistroDieta` INT NOT NULL AUTO_INCREMENT,
  `objetivo` INT NULL,
  `cal` DECIMAL(4,2) NULL,
  `numRefeicoes` INT NULL,
  `modifyDate` DATETIME NULL,
  `createDate` DATETIME NULL,
  `TipoDieta_idTipoDieta` INT NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  `Avaliacao_idAvaliacao` INT NOT NULL,
  `Avaliacao_Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idRegistroDieta`, `TipoDieta_idTipoDieta`, `Pessoa_idPessoa`, `Avaliacao_idAvaliacao`, `Avaliacao_Pessoa_idPessoa`),
  INDEX `fk_RegistroDieta_TipoDieta1_idx` (`TipoDieta_idTipoDieta` ASC) VISIBLE,
  INDEX `fk_RegistroDieta_Pessoa1_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  INDEX `fk_RegistroDieta_Avaliacao1_idx` (`Avaliacao_idAvaliacao` ASC, `Avaliacao_Pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_RegistroDieta_TipoDieta1`
    FOREIGN KEY (`TipoDieta_idTipoDieta`)
    REFERENCES `projetopoo`.`TipoDieta` (`idTipoDieta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroDieta_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroDieta_Avaliacao1`
    FOREIGN KEY (`Avaliacao_idAvaliacao` , `Avaliacao_Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Avaliacao` (`idAvaliacao` , `Pessoa_idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetopoo`.`Seguindo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetopoo`.`Seguindo` (
  `Pessoa_idPessoa` INT NOT NULL,
  `Pessoa_idPessoaSeguindo` INT NOT NULL,
  PRIMARY KEY (`Pessoa_idPessoa`, `Pessoa_idPessoaSeguindo`),
  INDEX `fk_Seguindo_Pessoa2_idx` (`Pessoa_idPessoaSeguindo` ASC) VISIBLE,
  CONSTRAINT `fk_Seguindo_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Seguindo_Pessoa2`
    FOREIGN KEY (`Pessoa_idPessoaSeguindo`)
    REFERENCES `projetopoo`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
