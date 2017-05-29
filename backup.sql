-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: DoggyTracker
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Device`
--

DROP TABLE IF EXISTS `Device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  `imei` varchar(16) DEFAULT NULL,
  `activationCode` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `Device_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Device`
--

LOCK TABLES `Device` WRITE;
/*!40000 ALTER TABLE `Device` DISABLE KEYS */;
/*!40000 ALTER TABLE `Device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DeviceReport`
--

DROP TABLE IF EXISTS `DeviceReport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DeviceReport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) DEFAULT NULL,
  `latitude` decimal(10,0) DEFAULT NULL,
  `longitude` decimal(10,0) DEFAULT NULL,
  `batteryLevel` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deviceId` (`deviceId`),
  CONSTRAINT `DeviceReport_ibfk_1` FOREIGN KEY (`deviceId`) REFERENCES `Device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DeviceReport`
--

LOCK TABLES `DeviceReport` WRITE;
/*!40000 ALTER TABLE `DeviceReport` DISABLE KEYS */;
/*!40000 ALTER TABLE `DeviceReport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(16) DEFAULT NULL,
  `lastName` varchar(16) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (17,'test','test','test@gmail.com','cc03e747a6afbbcbf8be7668acfebee5');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-30  0:19:04
