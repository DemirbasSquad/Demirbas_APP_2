-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 10.10.10.241    Database: staj2022
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
-- Table structure for table `KullaniciYonetimi`
--

DROP TABLE IF EXISTS `KullaniciYonetimi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KullaniciYonetimi` (
  `ID` varchar(50) NOT NULL,
  `adi` varchar(20) NOT NULL,
  `soyadi` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `parola` varchar(20) NOT NULL,
  `kullaniciAdi` varchar(30) NOT NULL,
  `sonDuzenlenenTarih` date NOT NULL,
  `olusturanKullanici` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KullaniciYonetimi`
--

LOCK TABLES `KullaniciYonetimi` WRITE;
/*!40000 ALTER TABLE `KullaniciYonetimi` DISABLE KEYS */;
INSERT INTO `KullaniciYonetimi` VALUES ('1','Admin','Admin','admin@demirbas.com','admin123','Admin','2022-07-20','admin'),('4d3536d1-e0fa-4e47-bd41-b9018b5d0b94','Ezgi','Kara','ezgi@demirbas.com','ezgi123','Ezgi Kara','2022-08-16','Sedat'),('69f964a4-3db7-4cd5-a4e7-d8b6d317d709','Sedat','Kankoç','sedat@demirbas.com','Sedat123','Sedaaaaat','2022-08-15','Admin');
/*!40000 ALTER TABLE `KullaniciYonetimi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  9:58:02
