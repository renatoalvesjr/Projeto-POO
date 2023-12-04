-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: projetopoo
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimento` (
  `idAlimento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `carb` decimal(10,2) DEFAULT NULL,
  `prot` decimal(10,2) DEFAULT NULL,
  `gord` decimal(10,2) DEFAULT NULL,
  `cal` decimal(10,2) DEFAULT NULL,
  `porcao` decimal(10,2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idAlimento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `alimentorefeicao`
--

DROP TABLE IF EXISTS `alimentorefeicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimentorefeicao` (
  `Refeicoes_idRefeicoes` int NOT NULL,
  `Refeicoes_TipoDieta_idTipoDieta` int NOT NULL,
  `Alimento_idAlimento` int NOT NULL,
  `Pessoa_idPessoa` int NOT NULL,
  `Porcao` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Refeicoes_idRefeicoes`,`Refeicoes_TipoDieta_idTipoDieta`,`Alimento_idAlimento`,`Pessoa_idPessoa`),
  KEY `fk_AlimentoRefeicao_Refeicoes1_idx` (`Refeicoes_idRefeicoes`,`Refeicoes_TipoDieta_idTipoDieta`),
  KEY `fk_AlimentoRefeicao_Alimento1_idx` (`Alimento_idAlimento`),
  KEY `fk_AlimentoRefeicao_Pessoa1_idx` (`Pessoa_idPessoa`),
  CONSTRAINT `fk_AlimentoRefeicao_Alimento1` FOREIGN KEY (`Alimento_idAlimento`) REFERENCES `alimento` (`idAlimento`),
  CONSTRAINT `fk_AlimentoRefeicao_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`),
  CONSTRAINT `fk_AlimentoRefeicao_Refeicoes1` FOREIGN KEY (`Refeicoes_idRefeicoes`, `Refeicoes_TipoDieta_idTipoDieta`) REFERENCES `refeicoes` (`idRefeicoes`, `TipoDieta_idTipoDieta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao` (
  `idAvaliacao` int NOT NULL AUTO_INCREMENT,
  `peso` decimal(10,2) DEFAULT NULL,
  `altura` decimal(10,2) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `pescoco` decimal(10,2) DEFAULT NULL,
  `cintura` decimal(10,2) DEFAULT NULL,
  `quadril` decimal(10,2) DEFAULT NULL,
  `rotina` decimal(10,2) DEFAULT NULL,
  `imc` decimal(10,2) DEFAULT NULL,
  `tbm` decimal(10,2) DEFAULT NULL,
  `bf` decimal(10,2) DEFAULT NULL,
  `massGorda` decimal(10,2) DEFAULT NULL,
  `massMagra` decimal(10,2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `Pessoa_idPessoa` int NOT NULL,
  PRIMARY KEY (`idAvaliacao`,`Pessoa_idPessoa`),
  KEY `fk_Avaliacao_Pessoa1_idx` (`Pessoa_idPessoa`),
  CONSTRAINT `fk_Avaliacao_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensagem` (
  `idMensagem` int NOT NULL AUTO_INCREMENT,
  `conteudo` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `Pessoa_idPessoaRemetente` int NOT NULL,
  `Pessoa_idPessoaDestinatario` int NOT NULL,
  PRIMARY KEY (`idMensagem`,`Pessoa_idPessoaRemetente`,`Pessoa_idPessoaDestinatario`),
  KEY `fk_Mensagem_Pessoa1_idx` (`Pessoa_idPessoaRemetente`),
  KEY `fk_Mensagem_Pessoa2_idx` (`Pessoa_idPessoaDestinatario`),
  CONSTRAINT `fk_Mensagem_Pessoa1` FOREIGN KEY (`Pessoa_idPessoaRemetente`) REFERENCES `pessoa` (`idPessoa`),
  CONSTRAINT `fk_Mensagem_Pessoa2` FOREIGN KEY (`Pessoa_idPessoaDestinatario`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idPessoa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `nascimento` datetime DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `usertype` int DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `idMensagem` int NOT NULL AUTO_INCREMENT,
  `conteudo` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `Pessoa_idPessoa` int NOT NULL,
  PRIMARY KEY (`idMensagem`,`Pessoa_idPessoa`),
  KEY `fk_Mensagem_Pessoa2_idx` (`Pessoa_idPessoa`),
  CONSTRAINT `fk_Mensagem_Pessoa20` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `preferencia`
--

DROP TABLE IF EXISTS `preferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferencia` (
  `Pessoa_idPessoa` int NOT NULL,
  `Alimento_idAlimento` int NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Pessoa_idPessoa`,`Alimento_idAlimento`),
  KEY `fk_Preferencia_Pessoa1_idx` (`Pessoa_idPessoa`),
  KEY `fk_Preferencia_Alimento1_idx` (`Alimento_idAlimento`),
  CONSTRAINT `fk_Preferencia_Alimento1` FOREIGN KEY (`Alimento_idAlimento`) REFERENCES `alimento` (`idAlimento`),
  CONSTRAINT `fk_Preferencia_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refeicoes`
--

DROP TABLE IF EXISTS `refeicoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refeicoes` (
  `idRefeicoes` int NOT NULL AUTO_INCREMENT,
  `carb` decimal(10,2) DEFAULT NULL,
  `prot` decimal(10,2) DEFAULT NULL,
  `gord` decimal(10,2) DEFAULT NULL,
  `cal` decimal(10,2) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `TipoDieta_idTipoDieta` int NOT NULL,
  PRIMARY KEY (`idRefeicoes`,`TipoDieta_idTipoDieta`),
  KEY `fk_Refeicoes_TipoDieta_idx` (`TipoDieta_idTipoDieta`),
  CONSTRAINT `fk_Refeicoes_TipoDieta` FOREIGN KEY (`TipoDieta_idTipoDieta`) REFERENCES `tipodieta` (`idTipoDieta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registrodieta`
--

DROP TABLE IF EXISTS `registrodieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrodieta` (
  `idRegistroDieta` int NOT NULL AUTO_INCREMENT,
  `objetivo` int DEFAULT NULL,
  `cal` decimal(10,2) DEFAULT NULL,
  `numRefeicoes` int DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `TipoDieta_idTipoDieta` int NOT NULL,
  `Pessoa_idPessoa` int NOT NULL,
  `Avaliacao_idAvaliacao` int NOT NULL,
  `Avaliacao_Pessoa_idPessoa` int NOT NULL,
  PRIMARY KEY (`idRegistroDieta`,`TipoDieta_idTipoDieta`,`Pessoa_idPessoa`,`Avaliacao_idAvaliacao`,`Avaliacao_Pessoa_idPessoa`),
  KEY `fk_RegistroDieta_TipoDieta1_idx` (`TipoDieta_idTipoDieta`),
  KEY `fk_RegistroDieta_Pessoa1_idx` (`Pessoa_idPessoa`),
  KEY `fk_RegistroDieta_Avaliacao1_idx` (`Avaliacao_idAvaliacao`,`Avaliacao_Pessoa_idPessoa`),
  CONSTRAINT `fk_RegistroDieta_Avaliacao1` FOREIGN KEY (`Avaliacao_idAvaliacao`, `Avaliacao_Pessoa_idPessoa`) REFERENCES `avaliacao` (`idAvaliacao`, `Pessoa_idPessoa`),
  CONSTRAINT `fk_RegistroDieta_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`),
  CONSTRAINT `fk_RegistroDieta_TipoDieta1` FOREIGN KEY (`TipoDieta_idTipoDieta`) REFERENCES `tipodieta` (`idTipoDieta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seguindo`
--

DROP TABLE IF EXISTS `seguindo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguindo` (
  `Pessoa_idPessoa` int NOT NULL,
  `Pessoa_idPessoaSeguindo` int NOT NULL,
  PRIMARY KEY (`Pessoa_idPessoa`,`Pessoa_idPessoaSeguindo`),
  KEY `fk_Seguindo_Pessoa2_idx` (`Pessoa_idPessoaSeguindo`),
  CONSTRAINT `fk_Seguindo_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`),
  CONSTRAINT `fk_Seguindo_Pessoa2` FOREIGN KEY (`Pessoa_idPessoaSeguindo`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipodieta`
--

DROP TABLE IF EXISTS `tipodieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodieta` (
  `idTipoDieta` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `carb` decimal(10,2) DEFAULT NULL,
  `prot` decimal(10,2) DEFAULT NULL,
  `gord` decimal(10,2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idTipoDieta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-04 10:37:23
