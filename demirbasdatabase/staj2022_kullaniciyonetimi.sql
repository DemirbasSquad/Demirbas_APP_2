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
-- Table structure for table `kullaniciyonetimi`
--

DROP TABLE IF EXISTS `kullaniciyonetimi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullaniciyonetimi` (
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
-- Dumping data for table `kullaniciyonetimi`
--

LOCK TABLES `kullaniciyonetimi` WRITE;
/*!40000 ALTER TABLE `kullaniciyonetimi` DISABLE KEYS */;
INSERT INTO `kullaniciyonetimi` VALUES ('4c86681a-d2b9-4f4a-b08a-cf812d85959f','semih','b','s@mail.com','321','sem12','2022-08-09','sem13'),('63cb79b7-10b6-49dc-9614-63899d66912b','Ezgi','Kankoç','ezgi@demirbas.com','sedat123','Sedat','2022-08-11','Admin'),('6ba2a1ae-e89f-4c33-9267-c65bcd7e479d','semih','DSAF','s@mail.com','1234','Semih','2022-08-08','asd'),('admin','Admin','Admin','admin@demirbas.com','admin123','Admin','2022-07-20','admin'),('b6e318c3-385c-4c52-8de9-70a9c8965166','mehmet','akif','istiklal@cumhur.com','1923','maraba','2022-08-08','mil'),('e1267fed-9dd7-4623-999f-7ceba95eb2b2','baris','asafsa','baris@mail.com','baris123','barisss','2022-08-08','Admin');
/*!40000 ALTER TABLE `kullaniciyonetimi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-12 10:33:40
