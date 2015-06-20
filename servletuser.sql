-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: servletuser
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `roles` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `adress` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (29,'admin','3e3e6b0e5c1c68644fc5ce3cf060211d','admin','Tedy','Delover','+143545435','tedy@gmail.com','US, NY, Brooklin st. 34/2'),(39,'user','2e1ef01b619313b6452c5c348f55cb26','user','Maria','Oliver','+394565454','maria@gmail.com','US, San Jose, Washington st.34/3'),(48,'Johny','1f874adf7a029c0284356b1009d01140','user','jhony','Frenko','+394565454','jhony@gmail.com','Italia, Napoli, Green street 43'),(49,'julia','8a570d4b6e5a45e47cb57c8c434234d7','user','Julia','Frency','+143545435','julia@gmail.com','US, California, California st 34/2'),(50,'boby','190dc531818369f1161f880707ae4138','user','Boby','Martin','+143545435','bob@gmail.com','US, San Jose, Washington st.34/3'),(51,'sergey','26aa2ea1166e8a8bc7174d0b77f69301','user','Sergey','Titov','+380504564351','titov@gmail.com','Ukraine, Lviv, Franka str. 34/3							'),(52,'google','c5a767208c725c91ae8ec564dbc91895','user','Frenky','Jerremivo','+287635343','frenky@gmail.com','France, Paris, Coco str. 43/334							'),(53,'boris','ea0a75d3cb986f079776239d132bb46f','user','Boris','Abramovich','+3765403983','borya@gmail.com','UK, London, Shenky st. 43/2							'),(54,'alex','db6243a12c9af809f3e57e0baa15b32c','admin','Alexandr','Piushnikov','+380664569837','al@gmail.com','Ukraine, Kiev, Shevchenko st. 43/23						');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-20 16:21:23
