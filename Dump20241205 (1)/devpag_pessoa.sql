-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: devpag
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `tipo_pessoa` varchar(1) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `matricula` bigint DEFAULT NULL,
  `funcao` tinyint DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `serie` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKa2s7lwxwtd171ow57u8lf3i6r` (`user_id`),
  CONSTRAINT `FKp494dpyuv5ng27kkeceocqhtw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `pessoa_chk_1` CHECK ((`funcao` between 0 and 1)),
  CONSTRAINT `pessoa_chk_2` CHECK ((`serie` between 0 and 11))
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('R',7,'35134164584','eric.monteiro@geradornv.com.br','Eric Uchôa Monteiro',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10,'(79) 3418-3986',NULL),('R',12,'12636451196','olga.batista@geradornv.com.br','Olga Laporte Batista',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,18,'(63) 3231-5067',NULL),('R',13,'35134164584','eric.monteiro@geradornv.com.br','Waleska Bragança Guedes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20,'(79) 3418-3986',NULL),('F',17,'51887801863','adm@gmail.com','Luiza Nunes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,31,'(63) 99282-5494',NULL),('A',18,'07931576411','humberto.albuquerque@geradornv.com.br','Humberto Fausto Albuquerque',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,25,'(83) 98223-5572',NULL),('R',19,'25144316204','responsavel@gmail.com','Aparecida Vasconcellos Nazare',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,26,'(96) 98636-7134',NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-05 15:54:42
