-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: projetopoo
-- ------------------------------------------------------
-- Server version	8.0.35

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,'Peito de Frango Grelhado, sem pele',0.00,32.00,2.50,150.00,100.00,'2023-11-30 00:00:00',NULL),(2,'Arroz integral cozido',28.80,2.60,1.00,120.00,100.00,'2023-11-30 00:00:00',NULL),(3,'Feijao Carioca cozido',13.60,4.50,0.50,100.00,100.00,'2023-11-30 00:00:00',NULL),(4,'Peito de Frango Grelhado, sem pele',0.00,32.00,2.50,150.50,100.00,'2023-12-04 00:00:00',NULL),(5,'Peito de Frango Grelhado, sem pele',0.00,32.00,2.50,150.50,100.00,'2023-12-04 00:00:00',NULL),(6,'Peito de Frango Grelhado, sem pele',0.00,32.00,2.50,150.50,100.00,'2023-12-04 00:00:00',NULL);
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `alimentorefeicao`
--

LOCK TABLES `alimentorefeicao` WRITE;
/*!40000 ALTER TABLE `alimentorefeicao` DISABLE KEYS */;
INSERT INTO `alimentorefeicao` VALUES (1,1,1,1,NULL),(1,1,2,1,NULL),(1,1,3,1,NULL);
/*!40000 ALTER TABLE `alimentorefeicao` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,70.00,187.00,23,36.00,100.00,100.00,1.00,20.70,2594.00,10.49,7.80,67.13,'2023-11-30 00:00:00',NULL,1),(2,79.00,177.00,22,38.00,105.00,110.00,3.00,22.00,3000.00,10.49,7.80,47.13,'2023-11-30 00:00:00',NULL,2),(3,75.00,190.00,23,38.00,80.00,100.00,1.00,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(4,75.00,190.00,23,38.00,80.00,100.00,1.00,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(5,75.00,190.00,23,38.00,80.00,100.00,1.00,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(6,75.00,190.00,23,38.00,80.00,100.00,1.00,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(7,80.00,190.00,23,40.00,100.00,105.00,2.00,22.16,2568.20,-223.72,-178.97,258.97,'2023-12-04 00:00:00',NULL,11),(8,75.00,190.00,23,38.00,80.00,100.00,1.00,20.78,2594.76,16.77,12.58,62.42,'2023-12-04 00:00:00',NULL,6),(9,69.00,176.00,23,35.00,90.00,98.00,2.00,22.28,2992.70,29.17,20.13,48.87,'2023-12-04 00:00:00',NULL,12);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `mensagem`
--

LOCK TABLES `mensagem` WRITE;
/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
INSERT INTO `mensagem` VALUES (1,'E aí, tá bahum??','2023-11-30 00:00:00',NULL,1,2),(2,'Uai, bahum e ocê?','2023-11-30 00:00:00',NULL,2,1),(3,'Fica pronto quando hein?','2023-11-30 00:00:00',NULL,1,3),(4,'Na hora que quiser palhaço','2023-11-30 00:00:00',NULL,3,1);
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Renato Alves','M','2000-04-13 00:00:00','renato','renato',1,'2023-11-30 00:00:00',NULL),(2,'Hebert Oliveira','M','2001-09-21 00:00:00','hebert','hebert',1,'2023-11-30 00:00:00',NULL),(3,'ADM','M','2000-01-01 00:00:00','root','root',2,'2023-11-30 00:00:00',NULL),(6,'Renato','M','2019-03-29 00:00:00','hebert','hebert',0,'2023-12-04 00:00:00',NULL),(11,'abrobinha da silva','F','2023-12-04 00:00:00','abroba','abroba',0,'2023-12-04 00:00:00',NULL),(12,'Abrobao','M','2000-09-25 00:00:00','brobao','brobao',0,'2023-12-04 00:00:00',NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Dietinha runfando!','2023-11-30 00:00:00',NULL,1),(2,'Até o CBUM treme!','2023-11-30 00:00:00',NULL,2),(3,'Programa em fase Alpha','2023-11-30 00:00:00',NULL,3),(4,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `preferencia`
--

LOCK TABLES `preferencia` WRITE;
/*!40000 ALTER TABLE `preferencia` DISABLE KEYS */;
INSERT INTO `preferencia` VALUES (1,1,'2023-11-11 00:00:00',NULL),(1,2,'2023-11-11 00:00:00',NULL),(2,3,'2023-11-11 00:00:00',NULL),(2,4,'2023-11-11 00:00:00',NULL);
/*!40000 ALTER TABLE `preferencia` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `refeicoes`
--

LOCK TABLES `refeicoes` WRITE;
/*!40000 ALTER TABLE `refeicoes` DISABLE KEYS */;
INSERT INTO `refeicoes` VALUES (1,60.00,45.00,45.00,600.00,'Cafe da Manhã','2023-11-30 00:00:00',NULL,1),(2,56.00,42.00,42.00,800.00,'Almoço','2023-11-30 00:00:00',NULL,1),(3,40.00,30.00,30.00,500.00,'Jantar','2023-11-30 00:00:00',NULL,1),(4,60.00,45.00,45.00,600.00,'Cafe da Tarde','2023-11-30 00:00:00',NULL,1);
/*!40000 ALTER TABLE `refeicoes` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrodieta`
--

LOCK TABLES `registrodieta` WRITE;
/*!40000 ALTER TABLE `registrodieta` DISABLE KEYS */;
INSERT INTO `registrodieta` VALUES (1,1,500.00,3,NULL,'2023-11-11 00:00:00',1,1,1,1),(2,1,800.00,5,NULL,'2023-11-11 00:00:00',2,2,2,2);
/*!40000 ALTER TABLE `registrodieta` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `seguindo`
--

LOCK TABLES `seguindo` WRITE;
/*!40000 ALTER TABLE `seguindo` DISABLE KEYS */;
INSERT INTO `seguindo` VALUES (2,1),(1,2),(1,3),(2,3);
/*!40000 ALTER TABLE `seguindo` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodieta`
--

LOCK TABLES `tipodieta` WRITE;
/*!40000 ALTER TABLE `tipodieta` DISABLE KEYS */;
INSERT INTO `tipodieta` VALUES (1,'Equilibrada',40.00,30.00,30.00,'2023-11-30 00:00:00',NULL),(2,'EQUILIBRADA',40.00,30.00,30.00,'2023-12-11 00:00:00',NULL);
/*!40000 ALTER TABLE `tipodieta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11 18:22:10
