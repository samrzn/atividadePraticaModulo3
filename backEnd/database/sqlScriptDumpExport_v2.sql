CREATE DATABASE  IF NOT EXISTS `triptour` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `triptour`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: triptour
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` int NOT NULL,
  `valor` smallint DEFAULT NULL,
  `fk_id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_id_cliente` (`fk_id_cliente`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`fk_id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_pacote_relacionamento`
--

DROP TABLE IF EXISTS `compra_pacote_relacionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_pacote_relacionamento` (
  `fk_id_compra` int DEFAULT NULL,
  `fk_id_pacote` int DEFAULT NULL,
  KEY `fk_id_compra` (`fk_id_compra`),
  KEY `fk_id_pacote` (`fk_id_pacote`),
  CONSTRAINT `compra_pacote_relacionamento_ibfk_1` FOREIGN KEY (`fk_id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `compra_pacote_relacionamento_ibfk_2` FOREIGN KEY (`fk_id_pacote`) REFERENCES `pacote` (`id_pacote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_pacote_relacionamento`
--

LOCK TABLES `compra_pacote_relacionamento` WRITE;
/*!40000 ALTER TABLE `compra_pacote_relacionamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_pacote_relacionamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacote`
--

DROP TABLE IF EXISTS `pacote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacote` (
  `id_pacote` int NOT NULL,
  `destino` varchar(140) DEFAULT NULL,
  `valor` smallint DEFAULT NULL,
  `data_viagem` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_pacote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacote`
--

LOCK TABLES `pacote` WRITE;
/*!40000 ALTER TABLE `pacote` DISABLE KEYS */;
INSERT INTO `pacote` VALUES (21567,'Bonito, Mato Grosso do Sul',430,'03/02/2023'),(114481,'Disney, Orlando',6030,'29/11/2023'),(311133,'Paris, França',2550,'11/03/2024'),(521954,'Gramado, Rio Grande do Sul',650,'13/05/2023'),(522145,'Foz do Iguaçu, Paraná',790,'24/05/2023'),(833257,'Cartagena, Colômbia',3990,'12/08/2023'),(933771,'Porto Seguro, Bahia',950,'11/09/2023'),(1044262,'Caldas Novas, Góias',1050,'17/10/2022'),(1044385,'Fortaleza, Ceará',1090,'28/10/2022'),(1144554,'Buenos Aires, Argentina',850,'07/11/2022'),(1244821,'Rio de Janeiro, RJ',1290,'01/12/2022');
/*!40000 ALTER TABLE `pacote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-06 18:36:14
