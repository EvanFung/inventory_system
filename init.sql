-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: db_example
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dispatch`
--

DROP TABLE IF EXISTS `dispatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dispatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dest_stock_id` int(11) NOT NULL,
  `sour_stock_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_dest_stock_id_idx` (`dest_stock_id`),
  KEY `fk_sour_stock_id_idx` (`sour_stock_id`),
  CONSTRAINT `fk_dest_stock_id` FOREIGN KEY (`dest_stock_id`) REFERENCES `stock` (`id`),
  CONSTRAINT `fk_sour_stock_id` FOREIGN KEY (`sour_stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispatch`
--

LOCK TABLES `dispatch` WRITE;
/*!40000 ALTER TABLE `dispatch` DISABLE KEYS */;
INSERT INTO `dispatch` VALUES (1,36,35,500,'2021-01-10 16:12:16');
/*!40000 ALTER TABLE `dispatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  `createAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `qty` int(11) NOT NULL DEFAULT '0',
  `create_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inventory_product_id_idx` (`product_id`),
  KEY `fk_warehouse_id_idx` (`warehouse_id`),
  CONSTRAINT `fk_inventory_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_inventory_warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (9,6,1,'2021-01-10 16:08:28',3000,'2021-01-10 16:08:27.941000'),(10,6,3,'2021-01-10 16:09:51',2500,'2021-01-10 16:09:51.332000');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `weight` int(11) NOT NULL DEFAULT '0',
  `type` varchar(45) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'HB-120','PRODUCT_TEST',100,'IN-STOCK','g',NULL,NULL),(2,'HB-121','PRODUCT_TEST',99,'IN-STOCK','g',NULL,NULL),(3,'HB-121','PRODUCT_TEST',99,'IN-STOCK','g',NULL,NULL),(4,'HB-121','PRODUCT_TEST',99,'IN-STOCK','g','2021-01-09 17:06:43','2021-01-09 17:06:43'),(5,'HB-125','PRODUCT_TEST',99,'IN-STOCK','g','2021-01-09 17:55:28','2021-01-09 17:55:28'),(6,'HB-126','PRODUCT_TEST',99,'IN-STOCK','g','2021-01-09 17:56:30','2021-01-09 17:56:29'),(7,'S2831','PRODUCT1',9,'Noodle','g',NULL,'2021-01-10 18:28:17'),(8,'S4442','PRODUCT2',100,'Rice','g',NULL,'2021-01-10 18:28:17');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `operator` varchar(45) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_warehouse_id_idx` (`warehouse_id`),
  KEY `fk_product_id_idx` (`product_id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (31,1,6,'EVAN',500,'2021-01-10 16:08:28','IN_STOCK'),(32,1,6,'EVAN',500,'2021-01-10 16:08:30','IN_STOCK'),(33,1,6,'EVAN',500,'2021-01-10 16:08:31','IN_STOCK'),(34,1,6,'EVAN',500,'2021-01-10 16:08:32','IN_STOCK'),(35,1,6,'EVAN',500,'2021-01-10 16:09:10','OUT_STOCK'),(36,3,6,'EVAN',500,'2021-01-10 16:09:51','IN_STOCK'),(37,1,6,'Evan',200,'2021-01-10 20:17:18','IN_STOCK'),(38,1,6,'Evan',500,'2021-01-10 20:17:18','IN_STOCK'),(39,1,6,'Evan',200,'2021-01-10 20:25:17','IN_STOCK'),(40,1,6,'Evan',500,'2021-01-10 20:25:17','IN_STOCK'),(41,1,6,'Evan',200,'2021-01-10 20:30:42','IN_STOCK'),(42,1,6,'Evan',500,'2021-01-10 20:30:42','IN_STOCK'),(43,1,6,'Evan',200,'2021-01-10 20:33:22','IN_STOCK'),(44,1,6,'Evan',500,'2021-01-10 20:33:22','IN_STOCK'),(45,1,6,'Evan',200,'2021-01-10 20:33:44','IN_STOCK'),(46,1,6,'Evan',500,'2021-01-10 20:33:44','IN_STOCK');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'abc@email.com','First');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,'CWB','Causeway Bay'),(3,'TM','Tuen Mun'),(4,'YL','Yuen Long');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 16:00:37
