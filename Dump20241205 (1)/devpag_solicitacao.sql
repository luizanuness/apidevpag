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
-- Table structure for table `solicitacao`
--

DROP TABLE IF EXISTS `solicitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitacao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ds_motivo` varchar(255) DEFAULT NULL,
  `dt_solicitacao` date DEFAULT NULL,
  `hr_solicitacao` time(6) DEFAULT NULL,
  `nm_aluno` varchar(255) DEFAULT NULL,
  `autorizado_saida` enum('NAO','SIM') DEFAULT NULL,
  `aluno_id` bigint DEFAULT NULL,
  `responsavel_id` bigint DEFAULT NULL,
  `status` enum('AUTORIZADA','PENDENTE') DEFAULT NULL,
  `confirmado_pela_portaria` bit(1) NOT NULL,
  `autorizado_pelo_administrador` bit(1) NOT NULL,
  `enum_autorizado_saida` enum('NAO','SIM') NOT NULL,
  `status_solicitacao` enum('AUTORIZADA','CONFIRMADA','NAO_CONFIRMADA','PENDENTE') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3hocjh0vp6yeg0dxe9vu5v2wj` (`aluno_id`),
  KEY `FKq12ibbw1nu77sikm4gie8i5ym` (`responsavel_id`),
  CONSTRAINT `FK3hocjh0vp6yeg0dxe9vu5v2wj` FOREIGN KEY (`aluno_id`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FKq12ibbw1nu77sikm4gie8i5ym` FOREIGN KEY (`responsavel_id`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `solicitacao_chk_1` CHECK ((`autorizado_saida` between 0 and 1))
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
INSERT INTO `solicitacao` VALUES (22,'Pessoal','2024-12-06','15:41:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA'),(23,'Pessoal','2024-12-05','14:59:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA'),(24,'Pessoal','2024-12-06','15:27:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA'),(25,'Pessoal','2024-12-06','15:48:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA'),(26,'Pessoal','2024-12-06','16:12:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA'),(27,'z','2024-12-05','16:27:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA'),(28,'.','2024-12-05','15:28:00.000000',NULL,'NAO',18,19,'PENDENTE',_binary '\0',_binary '\0','NAO','AUTORIZADA');
/*!40000 ALTER TABLE `solicitacao` ENABLE KEYS */;
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
