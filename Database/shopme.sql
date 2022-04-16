-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: shopme
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `addressId` int NOT NULL AUTO_INCREMENT,
  `addressLine1` varchar(255) DEFAULT NULL,
  `addressLine2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `houseNo` varchar(255) DEFAULT NULL,
  `pincode` int NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`addressId`),
  KEY `FKh8prrk7u2qbxfbl9ptfosixqt` (`userId`),
  CONSTRAINT `FKh8prrk7u2qbxfbl9ptfosixqt` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'jkbkio','jhjhl','pune','kjhuoiupi',411044,'Maharashtra',2),(2,'latur','latur','latur','112',413512,'Maharashtra',8);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdDate` datetime(6) DEFAULT NULL,
  `quantity` int NOT NULL,
  `productId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3c4ga0hag411seaphckslibxb` (`productId`),
  KEY `FKndob6d3jargfso5690jd8a5uv` (`userId`),
  CONSTRAINT `FK3c4ga0hag411seaphckslibxb` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `FKndob6d3jargfso5690jd8a5uv` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,'2022-04-14 13:33:39.874000',1,37,2),(32,'2022-04-16 11:56:37.241000',1,37,9);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `categoryName` varchar(255) NOT NULL,
  `categoryDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('books','kkjhk'),('electronics','sf'),('furniture','kkjhk'),('toys','kkjhk');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedbackId` int NOT NULL AUTO_INCREMENT,
  `feebackDescription` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL,
  `createdDate` datetime(6) DEFAULT NULL,
  `quantity` int NOT NULL,
  `productId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK89vja5g4tl1u0gh4jveukmm5` (`productId`),
  KEY `FKmq48uaxeuvit0c34nlua02214` (`userId`),
  CONSTRAINT `FK89vja5g4tl1u0gh4jveukmm5` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `FKmq48uaxeuvit0c34nlua02214` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `productDescription` varchar(255) DEFAULT NULL,
  `productDiscount` double DEFAULT NULL,
  `productFinalPrice` double DEFAULT NULL,
  `productImage` varchar(255) DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productQuantity` int NOT NULL,
  `categoryName` varchar(255) DEFAULT NULL,
  `subCategoryName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  KEY `FK8lqn6cdwxe53sriqd0jauggjm` (`categoryName`),
  KEY `FK6tk6bs5e37jfx7ujddtqxnlkf` (`subCategoryName`),
  KEY `FK9okxkr2fx69vaq8wbj1cs66x7` (`userId`),
  KEY `FKf1bb1w3gd6u1mtjimcvtbujbg` (`companyName`),
  CONSTRAINT `FK6tk6bs5e37jfx7ujddtqxnlkf` FOREIGN KEY (`subCategoryName`) REFERENCES `subcategory` (`subCategoryName`),
  CONSTRAINT `FK8lqn6cdwxe53sriqd0jauggjm` FOREIGN KEY (`categoryName`) REFERENCES `category` (`categoryName`),
  CONSTRAINT `FK9okxkr2fx69vaq8wbj1cs66x7` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKf1bb1w3gd6u1mtjimcvtbujbg` FOREIGN KEY (`companyName`) REFERENCES `vendor` (`companyName`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (37,'hgkgk',2,1176,'https://i.ibb.co/WsV4jGR/download.jpg','chgh',1200,5,'books','novel',5,NULL),(38,'dsas',1,11.88,'sdf','as',12,12,'electronics','mobile',1,NULL),(41,'good',10,10800,'https://i.ibb.co/fkPwSMB/note11.jpg','Note11',12000,12,'electronics','mobile',5,NULL),(42,'good',5,11875,'https://i.ibb.co/ncB93mF/m33.jpg','m33',12500,5,'electronics','mobile',5,NULL),(43,'good',12,47080,'https://i.ibb.co/frBVJgb/table.jpg','Table',53500,10,'furniture','kitchen',5,NULL),(44,'good',5,23750,'https://i.ibb.co/sCdt00T/chair.jpg','chair',25000,15,'furniture','kitchen',5,NULL),(45,'sofa',5,8930,'https://i.ibb.co/SQ8ft12/sofa.jpg','sofa',9400,5,'furniture','bedroom',5,NULL),(46,'mobile',10,9000,'https://i.ibb.co/fkPwSMB/note11.jpg','iphone',10000,12,'electronics','mobile',5,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productdetails` (
  `detailsId` int NOT NULL AUTO_INCREMENT,
  `productProperties` varchar(255) DEFAULT NULL,
  `propertiesValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`detailsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetails`
--

LOCK TABLES `productdetails` WRITE;
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcategory` (
  `subCategoryName` varchar(255) NOT NULL,
  `subCategoryDescription` varchar(255) DEFAULT NULL,
  `categoryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subCategoryName`),
  KEY `FK4w11jarak5x97dorcsokfhb7f` (`categoryName`),
  CONSTRAINT `FK4w11jarak5x97dorcsokfhb7f` FOREIGN KEY (`categoryName`) REFERENCES `category` (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES ('bedroom','hgkjhjk','furniture'),('comics','ghkgk','books'),('drawing room','hgkg','furniture'),('fiction','jgkgh','books'),('kitchen','hgkh','furniture'),('laptop','jhgkhk','electronics'),('mobile','Nbh','electronics'),('novel','kjhjh','books'),('story','gghkg','books'),('tab','jgkgk','electronics');
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `mobile` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profileImg` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `walletBalance` double NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sa@','s',NULL,'a',827515060,'1234','dfdf','Vendor',0),(2,'aa@','Magar',NULL,'Ramakant',8275151090,NULL,'nbmm','Customer',110642),(3,'bb@',NULL,NULL,NULL,0,NULL,NULL,'Admin',10000),(4,'rohit@','rohit',NULL,'magar',8275151090,'123','good','Admin',8380),(5,'k@','kabir',NULL,'h',8275151090,'123','kkjk','Vendor',81577),(6,'shubham@gmail.com',NULL,NULL,NULL,0,NULL,NULL,'Admin',0),(7,'shubh@','sa',NULL,'ada',432565,'123','zccz','Customer',98515),(8,'p@gmail.com','Priyanka',NULL,'m',8275151090,'123','https://i.ibb.co/2crZrKb/logo.png','Customer',99595),(9,'onkar@gmail.com','onkar',NULL,'patil',8275151090,'123','ghjgh','Customer',78074),(10,'shailesh@gmail.com','shailesh ',NULL,'gambhire',8256535535,'123','shailesh','Admin',0),(11,'kabir@gmail.com','kabir',NULL,'hipparkar',8275135353,'123','kabir','Vendor',11080);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `companyName` varchar(255) NOT NULL,
  `companyAddress` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`companyName`),
  KEY `FKgxifbkcavyxjy3hh1hyh3y0eq` (`userId`),
  CONSTRAINT `FKgxifbkcavyxjy3hh1hyh3y0eq` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-16 20:27:58
