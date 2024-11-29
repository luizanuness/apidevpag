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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'luiza@top.com.br','Luiza Nunes',NULL,NULL,'$2a$10$IJe5cAXHBYHuZnu0YXep0.3hlENlp8jcCCt9m.a7kS2CuilOumHIO','luiza@top.com.br'),(6,NULL,NULL,NULL,NULL,'',NULL),(8,NULL,NULL,NULL,NULL,'',NULL),(9,'soraya.faria@geradornv.com.br','Soraya Valente Faria',NULL,NULL,'$2a$10$3X/mlrVfAMAMkeoESbzbnesauvRLVjujzY5271K8G7267l/LHov8K','soraya.faria@geradornv.com.br'),(10,'eric.monteiro@geradornv.com.br','Eric Uchôa Monteiro',NULL,NULL,'$2a$10$ej20BUYN6nCqP5vRZv.Yt.n1gF8jwm/.SdFe.sQXluhiNv7as6YYm','eric.monteiro@geradornv.com.br'),(11,'rogerio.alvarenga@geradornv.com.br','Rogério Borner Alvarenga',NULL,NULL,'$2a$10$KkckSqNOUZlqm1z5shz.jOGz9W2swN4N.yLdI7KjKGXBYNJnu5zQ6','rogerio.alvarenga@geradornv.com.br'),(14,'eliana.prucho@geradornv.com.br','Eliana Santos Prucho',NULL,NULL,'$2a$10$9wR1B6/G3Q6Xe6CXSPJJKeT.VFObjSb5whz93gfWsAIjTCKzLItGq','eliana.prucho@geradornv.com.br'),(17,NULL,NULL,NULL,NULL,'',NULL),(18,'olga.batista@geradornv.com.br','Olga Laporte Batista',NULL,NULL,'$2a$10$kZ9cpCxKja8s7BVSjRn9DOjC5bb.o4kdIfan80DVyT364ZYwS7Z6y','olga.batista@geradornv.com.br'),(19,NULL,NULL,NULL,NULL,'',NULL),(20,NULL,NULL,NULL,NULL,'',NULL),(24,'nunesss.luiza@gmail.com','Luiza Nunes',NULL,NULL,'$2a$10$1WuC8A18zKWf5tTXsjMWwOmla/9SOE7Lt0YIsGPL5O88X9XmPrYVa','nunesss.luiza@gmail.com'),(25,'humberto.albuquerque@geradornv.com.br','Humberto Fausto Albuquerque',NULL,NULL,'$2a$10$1d3BztvcGmDe5yvzgWXk1.v94X35EbMe.NoFH/T9iToFIaZfR7s..','humberto.albuquerque@geradornv.com.br'),(26,'responsavel@gmail.com','Aparecida Vasconcellos Nazare',NULL,NULL,'$2a$10$S8.ZbQHSvF.xYz6X2uAHoOQOQqi8ghTM208atC/jubI1UU6hl3U..','responsavel@gmail.com'),(27,'portaria@gmail.com','Maria Beatriz Luques Ramos',NULL,NULL,'$2a$10$.CqZVk5vgBf2UTwrpk7WY.9wkB6oOJx8ceYDAbgw86Y5YMQMZetaS','portaria@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-29 14:01:29
