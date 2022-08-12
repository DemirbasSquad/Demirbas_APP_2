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
-- Table structure for table `personelyonetimi`
--

DROP TABLE IF EXISTS `personelyonetimi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personelyonetimi` (
  `ID` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_turkish_ci NOT NULL,
  `personelAdi` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `personelSoyadi` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `personelSicilNumarasi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `proje` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `kullaniciAdi` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sonDuzenlenenTarih` date DEFAULT NULL,
  `girisTarihi` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `personelSicilNumarasi_UNIQUE` (`personelSicilNumarasi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personelyonetimi`
--

LOCK TABLES `personelyonetimi` WRITE;
/*!40000 ALTER TABLE `personelyonetimi` DISABLE KEYS */;
INSERT INTO `personelyonetimi` VALUES ('0db15f0e-e08a-40b7-aa96-b1c5773e1aa2','cingo','sdsd','33','sdfÅdfd','kym','2022-08-08','1999-09-09'),('309ee316-5061-4ae0-92b3-8510ecb32a4b','baris','dffd','9','dfkdlf',NULL,'2022-08-08',NULL),('8098bc90-6a75-40b8-931e-a649d873b15e','kerem','cng','44','dddddddg',NULL,'2022-08-05',NULL),('a84698e5-ab08-4efe-af3a-7db579e23bd4','barissfffdfd','see','3','kus',NULL,'2022-08-09',NULL),('cbfa9230-b66f-425b-940a-b1e7804f0d8e','yyummy','tytrr','78','kus',NULL,'2022-08-09',NULL);
/*!40000 ALTER TABLE `personelyonetimi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-12 10:33:41
