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
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,'Peito de Frango Grelhado, sem pele',0.00,32.00,2.50,150.00,100.00,'2023-11-30 00:00:00',NULL),(2,'Arroz integral cozido',28.80,2.60,1.00,120.00,100.00,'2023-11-30 00:00:00',NULL),(3,'Feijao Carioca cozido',13.60,4.50,0.50,100.00,100.00,'2023-11-30 00:00:00',NULL);
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alimentorefeicao`
--

LOCK TABLES `alimentorefeicao` WRITE;
/*!40000 ALTER TABLE `alimentorefeicao` DISABLE KEYS */;
INSERT INTO `alimentorefeicao` VALUES (1,1,1,1,NULL),(1,1,2,1,NULL),(1,1,3,1,NULL);
/*!40000 ALTER TABLE `alimentorefeicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,70.00,187.00,23,36.00,100.00,100.00,1,20.70,2594.00,10.49,7.80,67.13,'2023-11-30 00:00:00',NULL,1),(2,79.00,177.00,22,38.00,105.00,110.00,3,22.00,3000.00,10.49,7.80,47.13,'2023-11-30 00:00:00',NULL,2),(3,75.00,190.00,23,38.00,80.00,100.00,1,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(4,75.00,190.00,23,38.00,80.00,100.00,1,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(5,75.00,190.00,23,38.00,80.00,100.00,1,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(6,75.00,190.00,23,38.00,80.00,100.00,1,20.78,2594.76,10.49,7.87,67.13,'2023-12-04 00:00:00',NULL,6),(7,80.00,190.00,23,40.00,100.00,105.00,2,22.16,2568.20,-223.72,-178.97,258.97,'2023-12-04 00:00:00',NULL,11),(8,75.00,190.00,23,38.00,80.00,100.00,1,20.78,2594.76,16.77,12.58,62.42,'2023-12-04 00:00:00',NULL,6),(9,69.00,176.00,23,35.00,90.00,98.00,2,22.28,2992.70,29.17,20.13,48.87,'2023-12-04 00:00:00',NULL,12);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mensagem`
--

LOCK TABLES `mensagem` WRITE;
/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
INSERT INTO `mensagem` VALUES (1,'E aí, tá bahum??','2023-11-30 00:00:00',NULL,1,2),(2,'Uai, bahum e ocê?','2023-11-30 00:00:00',NULL,2,1),(3,'Fica pronto quando hein?','2023-11-30 00:00:00',NULL,1,3),(4,'Na hora que quiser palhaço','2023-11-30 00:00:00',NULL,3,1);
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Renato Alves','M','2000-04-13 00:00:00','renato','renato',1,'2023-11-30 00:00:00',NULL),(2,'Hebert Oliveira','M','2001-09-21 00:00:00','hebert','hebert',1,'2023-11-30 00:00:00',NULL),(3,'ADM','M','2000-01-01 00:00:00','root','root',2,'2023-11-30 00:00:00',NULL),(6,'Renato','M','2019-03-29 00:00:00','hebert','hebert',0,'2023-12-04 00:00:00',NULL),(11,'abrobinha da silva','F','2023-12-04 00:00:00','abroba','abroba',0,'2023-12-04 00:00:00',NULL),(12,'Abrobao','M','2000-09-25 00:00:00','brobao','brobao',0,'2023-12-04 00:00:00',NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Dietinha runfando!','2023-11-30 00:00:00',NULL,1),(2,'Até o CBUM treme!','2023-11-30 00:00:00',NULL,2),(3,'Programa em fase Alpha','2023-11-30 00:00:00',NULL,3),(4,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(5,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(6,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(7,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(8,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(9,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(10,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(11,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(12,'Minha dieta esta indo bem','2023-12-04 00:00:00',NULL,6),(13,'Minha dieta esta indo bem','2023-12-05 00:00:00',NULL,6),(14,'Minha dieta esta indo bem','2023-12-05 00:00:00',NULL,6),(15,'Minha dieta esta indo bem','2023-12-05 00:00:00',NULL,6),(17,'to monstro de novo','2023-12-05 00:00:00',NULL,1);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `preferencia`
--

LOCK TABLES `preferencia` WRITE;
/*!40000 ALTER TABLE `preferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `refeicoes`
--

LOCK TABLES `refeicoes` WRITE;
/*!40000 ALTER TABLE `refeicoes` DISABLE KEYS */;
INSERT INTO `refeicoes` VALUES (1,60.00,45.00,45.00,600.00,'Cafe da Manhã','2023-11-30 00:00:00',NULL,1),(2,56.00,42.00,42.00,800.00,'Almoço','2023-11-30 00:00:00',NULL,1),(3,40.00,30.00,30.00,500.00,'Jantar','2023-11-30 00:00:00',NULL,1),(4,60.00,45.00,45.00,600.00,'Cafe da Tarde','2023-11-30 00:00:00',NULL,1);
/*!40000 ALTER TABLE `refeicoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `registrodieta`
--

LOCK TABLES `registrodieta` WRITE;
/*!40000 ALTER TABLE `registrodieta` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrodieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `seguindo`
--

LOCK TABLES `seguindo` WRITE;
/*!40000 ALTER TABLE `seguindo` DISABLE KEYS */;
INSERT INTO `seguindo` VALUES (2,1),(1,2),(1,3),(2,3);
/*!40000 ALTER TABLE `seguindo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tipodieta`
--

LOCK TABLES `tipodieta` WRITE;
/*!40000 ALTER TABLE `tipodieta` DISABLE KEYS */;
INSERT INTO `tipodieta` VALUES (1,'Equilibrada',40.00,30.00,30.00,'2023-11-30 00:00:00',NULL);
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

-- Dump completed on 2023-12-05 15:58:01
