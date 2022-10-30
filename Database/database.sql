CREATE DATABASE  IF NOT EXISTS `java5_asm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java5_asm`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: java5_asm
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `gender` tinyint DEFAULT '1',
  `password` varchar(130) NOT NULL,
  `phone_number` varchar(12) DEFAULT NULL,
  `status` tinyint DEFAULT '1',
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gex1lmaqpg0ir5g1f5eftyaa1` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','2022-10-09 00:00:00.000000',NULL,NULL,'Bac Giang','2002-11-10 00:00:00','98taeyang@gmail.com','Dong Thai Duong',1,'123','052777515',1,'admin'),(2,'admin','2022-10-09 21:10:20.000000',NULL,NULL,'Bac Giang','2002-10-11 00:00:00','99taeyang@gmail.com','Dong Thai Duong',0,'456','052777515',1,'user01'),(6,NULL,'2022-10-13 14:55:56.859000',NULL,NULL,'HiepHoa,BacGiang','2002-11-10 00:00:00','uchihaitachi.duongx@gmail.com','Thai Duong',1,'bA9DmGtFf-Q','09222245557',1,'theyangcoder'),(8,NULL,'2022-10-13 15:00:38.994000',NULL,NULL,'HiepHoa,BacGiang','2002-11-10 00:00:00','uchihaitachi.duongx@gmail.com','Thai Duong',0,'bA9DmGtFf-Q','09222245557',1,'poly');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role`
--

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role` (
  `account_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`account_id`,`role_id`),
  KEY `FKrs2s3m3039h0xt8d5yhwbuyam` (`role_id`),
  CONSTRAINT `FK1f8y4iy71kb1arff79s71j0dh` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKrs2s3m3039h0xt8d5yhwbuyam` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
INSERT INTO `account_role` VALUES (1,1),(2,2),(6,2),(8,2);
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_acatplu22q5d1andql2jbvjy7` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'admin','2022-10-13 16:52:54.000000','admin','2022-10-13 20:29:06.784000','1','Áo'),(2,'admin','2022-10-13 17:20:24.101000',NULL,NULL,'12','Váy'),(8,'admin','2022-10-24 22:15:28.666000',NULL,NULL,'52925','Thanh An');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `phone_number` varchar(12) DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modified_by` varchar(45) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'Bac Giang','052777515','admin','2022-10-22 00:35:37',NULL,NULL,1),(2,'Bac Giang','052777515','admin','2022-10-23 21:33:54',NULL,NULL,1),(3,'Bac Giang','052777515','admin','2022-10-23 21:44:03',NULL,NULL,1),(4,'Bac Giang','052777515','user01','2022-10-23 21:51:10',NULL,NULL,1),(5,'Bac Giang','052777515','admin','2022-10-23 22:28:01',NULL,NULL,1),(6,'Bac Giang','052777515','user01','2022-10-23 22:32:11',NULL,NULL,1),(7,'Bac Giang','052777515','user01','2022-10-23 22:32:32',NULL,NULL,1),(8,'Bac Giang','052777515','user01','2022-10-24 22:44:52',NULL,NULL,1),(9,'Bac Giang','052777515','admin','2022-10-28 15:47:54',NULL,NULL,1),(10,'Bac Giang','052777515','admin','2022-10-28 15:48:09',NULL,NULL,1),(11,'Bac Giang','052777515','admin','2022-10-28 15:51:53',NULL,NULL,1),(12,'Bac Giang','052777515','admin','2022-10-28 15:53:19',NULL,NULL,1),(13,'Bac Giang','052777515','user01','2022-10-28 17:54:59',NULL,NULL,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `order_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_oder_detail_idx` (`order_id`),
  KEY `product_order_detail_idx` (`product_id`),
  CONSTRAINT `order_oder_detail` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `product_order_detail` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,14800,'M',1,7),(2,1,14800,'S',1,7),(3,1,14800,'XXL',1,7),(4,3,270000,'S',2,1),(5,2,180000,'XL',2,1),(6,1,14800,'M',2,10),(7,1,14800,'XXL',2,7),(8,1,14800,'S',3,7),(9,1,100000,'S',3,29),(10,1,100000,'XL',3,29),(11,1,100000,'XXL',3,29),(12,1,100000,'S',4,30),(13,1,14800,'XL',4,7),(14,1,90000,'S',6,1),(15,1,100000,'XL',6,34),(16,1,100000,'L',6,34),(17,1,100000,'S',6,29),(18,1,100000,'M',6,34),(19,1,100000,'S',7,30),(20,1,14800,'S',7,7),(21,1,100000,'S',7,29),(22,1,100000,'S',8,36),(23,1,100000,'M',9,30),(24,1,100000,'S',9,29),(25,1,100000,'XL',9,29),(26,1,14800,'S',9,6),(27,1,100000,'XXL',9,29),(28,1,90000,'S',10,1),(29,1,100000,'M',11,29),(30,1,100000,'S',11,29),(31,2,29600,'S',12,3),(32,1,14800,'XXL',12,3),(33,1,14800,'XL',12,3),(34,1,14800,'L',12,3),(35,1,90000,'S',13,1),(36,1,14800,'S',13,11),(37,10,1200000,'XL',13,2),(38,1,14800,'XL',13,6),(39,1,14800,'S',13,7),(40,1,100000,'XL',13,36);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `available` tinyint NOT NULL DEFAULT '1',
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(20,0) NOT NULL,
  `quantity` int NOT NULL,
  `size` varchar(105) DEFAULT 'M,L,XL,XXL',
  `image` varchar(455) DEFAULT NULL,
  `quantity_sold` int DEFAULT '0',
  `category_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Dáng Rộng',1,'Áo Thun',90000,1786,'S,M,L,XL,XXL','anh1.png',814,1),(2,'admin','2022-10-18 03:52:46.800000',NULL,NULL,'Lỡ Tay',1,'Áo Forn Rộng',120000,1386,'S,M,L,XL,XXL','anh2.png',22,1),(3,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Lỡ Tay',1,'Áo Form Rộng Unisex',14800,1391,'S,M,L,XL,XXL','anh3.png',184,1),(4,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Lỡ Tay - Unisex',1,'Áo Form Rộng Gucci',14800,1399,'S,M,L,XL,XXL','anh4.png',201,1),(5,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Chất Vải Dày',1,'Áo Form Rộng Dio',14800,1400,'S,M,L,XL,XXL','anh5.png',153,1),(6,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Logo Ver',1,'Áo Khá Bảnh',14800,1397,'S,M,L,XL,XXL','anh6.png',148,1),(7,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Unisex',1,'Áo Polo',14800,1392,'S,M,L,XL,XXL','anh7.png',1788,1),(8,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Unisex',1,'Áo Hai Dây',14800,1400,'S,M,L,XL,XXL','anh8.png',472,1),(9,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Lỡ Tay',1,'Áo Thun Sexy',14800,1400,'S,M,L,XL,XXL','anh9.png',47,1),(10,'admin','2022-10-13 16:52:54.800000',NULL,NULL,'Lỡ Tay',1,'Áo Cổ Tròn',14800,1399,'S,M,L,XL,XXL','anh10.png',13,1),(11,'admin','2022-10-13 16:52:54.700000',NULL,NULL,'Lỡ Tay',1,'Áo 2 dây promax',14800,1388,'S,M,L,XL,XXL','anh11.png',14,1),(28,'admin','2022-10-15 22:22:50.871000',NULL,NULL,'Áo Mẫu Cosplay Couple Nữ',0,'UnMakerCode',100000,1000,'S,M,L,XL,XXL','graphviz15102022102250.png',5800,1),(29,'admin','2022-10-15 22:24:12.870000',NULL,NULL,'Áo Mẫu Cosplay Couple Nữ',1,'Áo Cosplay',100000,987,'S,M,L,XL,XXL','z3802802767878_ec2f8b91b0d5a3401d2bb7c2c7c17a1a15102022102412.png',587,1),(30,'admin','2022-10-16 00:20:59.851000',NULL,NULL,'Thun ',1,'Áo Cosplay',100000,994,'S,M,L,XL,XXL','bex.png',5006,1),(31,'admin','2022-10-17 11:36:33.205000',NULL,NULL,'Thun 2 Dây',1,'Váy',100000,1000,'S,M,L,XL,XXL','test17102022113633.png',0,2),(33,'admin','2022-10-19 17:01:59.395000',NULL,NULL,'Váy Xinh Cho Những Cô Làng Xesy',1,'Váy Xinh',100000,1000,'S,M,L,XL','gai-xinh-mac-vay-xep-ly-ngan-1419102022050159.png',0,2),(34,'admin','2022-10-19 17:01:59.395000','admin','2022-10-19 17:48:25.811000','Áo Mẫu Cosplay Couple Nữ',1,'Váy Xinh',100000,997,'S,M,L,XL','e13e39a78812ebeef80deab062f471b119102022054825.png',3,2),(35,'admin','2022-10-19 17:01:59.395000','admin','2022-10-19 17:44:03.618000','Váy Xinh Cho Những Cô Làng Xesy',1,'Váy Xinh',100000,995,'S,M,L,XL','Untitled19102022054403.png',5,2),(36,'admin','2022-10-24 22:29:36.193000',NULL,NULL,'Thun 2 Dây',1,'Áo Cosplay',100000,998,'S,M,L,XL','f5aa930cb2d404114741d3631a91bfa624102022102936.png',2,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','2022-10-09 21:09:28.000000',NULL,NULL,'admin'),(2,'admin','2022-10-09 21:09:46.000000',NULL,NULL,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'java5_asm'
--

--
-- Dumping routines for database 'java5_asm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-30  6:09:25
