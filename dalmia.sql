-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: dalima_salse
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dealer`
--

DROP TABLE IF EXISTS `dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dealer` (
  `Dealer_id` int NOT NULL,
  `Chassis_no` varchar(45) NOT NULL,
  `Price` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`Dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealer`
--

LOCK TABLES `dealer` WRITE;
/*!40000 ALTER TABLE `dealer` DISABLE KEYS */;
/*!40000 ALTER TABLE `dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventry`
--

DROP TABLE IF EXISTS `inventry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventry` (
  `Product_ID` int NOT NULL AUTO_INCREMENT,
  `Chassis_no` varchar(8) NOT NULL,
  `Product _Catagory` varchar(45) NOT NULL,
  `Price` varchar(45) NOT NULL,
  PRIMARY KEY (`Product_ID`),
  KEY `idx_inventry_Product_ID` (`Product_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventry`
--

LOCK TABLES `inventry` WRITE;
/*!40000 ALTER TABLE `inventry` DISABLE KEYS */;
INSERT INTO `inventry` VALUES (4,'0013','EV Bike','90000'),(5,'0014','EV Bike','90000'),(6,'0012','EV Scooter','60000'),(7,'0023','EV Scooter','60000'),(8,'0024','EV Scooter','60000'),(9,'0026','EV Scooter','60000'),(10,'0031','EV Rikshaw','600000'),(11,'0032','EV Rikshaw','600000'),(12,'0033','EV Rikshaw','600000'),(13,'0034','EV Rikshaw','600000'),(14,'0040','EV Trailer','800000'),(15,'0041','EV Trailer','800000'),(16,'0042','EV Trailer','800000'),(17,'0043','EV Trailer','800000'),(18,'000123','EV Scooter','60000');
/*!40000 ALTER TABLE `inventry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soled_product`
--

DROP TABLE IF EXISTS `soled_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soled_product` (
  `Product_ID` int NOT NULL,
  `Chassis_no` varchar(8) NOT NULL,
  `Reg_no` varchar(10) NOT NULL,
  `Owner_name` varchar(45) NOT NULL,
  `Owner_mobile_no` int NOT NULL,
  `Ownwer_Address` varchar(300) NOT NULL,
  `Price` varchar(300) NOT NULL,
  `Product_Caterory` varchar(45) NOT NULL,
  `dos` varchar(45) NOT NULL,
  PRIMARY KEY (`Product_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soled_product`
--

LOCK TABLES `soled_product` WRITE;
/*!40000 ALTER TABLE `soled_product` DISABLE KEYS */;
INSERT INTO `soled_product` VALUES (1,'093456','002','xcy',1234,'bareilly','900000','EV Bike','12-04-2023'),(2,'9087654','2345','abc',123456,'abcd','3400000','EV Scooter','8-4-2023'),(3,'0012','UP25AB1234','Sahil',1234567890,'Bareilly','90000','EV Bike','14-10-2022');
/*!40000 ALTER TABLE `soled_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-12 22:27:35
