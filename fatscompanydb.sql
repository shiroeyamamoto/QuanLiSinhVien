-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: fatscompanydb
-- ------------------------------------------------------
-- Server version	8.0.34

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
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','Admin@123','ADMIN','1'),(2,'giaovien1','giaovien1','TEACHER','1'),(3,'sinhvien1','sinhvien1','SINHVIEN','1'),(4,'sinhvien2','sinhvien2','SINHVIEN','1'),(5,'giaovien2','giaovien2','TEACHER','1');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bai_viet`
--

DROP TABLE IF EXISTS `bai_viet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bai_viet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `noi_dung` longtext NOT NULL,
  `Status` tinyint NOT NULL,
  `accountBV_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accountBV_id_idx` (`accountBV_id`),
  CONSTRAINT `accountBV_id` FOREIGN KEY (`accountBV_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bai_viet`
--

LOCK TABLES `bai_viet` WRITE;
/*!40000 ALTER TABLE `bai_viet` DISABLE KEYS */;
INSERT INTO `bai_viet` VALUES (1,'Bai Toan','Huong Dan giả phep toan 1+1',1,2),(2,'Câu hỏi về thể dục','Thể dục mặc đồ gì',1,4);
/*!40000 ALTER TABLE `bai_viet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bang_diem`
--

DROP TABLE IF EXISTS `bang_diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bang_diem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diem_giuaki` float NOT NULL,
  `diem_cuoiki` float NOT NULL,
  `status` tinyint DEFAULT NULL,
  `sinhvienScore_id` int NOT NULL,
  `monhocScore_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sinhvienScore_id_idx` (`sinhvienScore_id`),
  KEY `monhocScore_id_idx` (`monhocScore_id`),
  CONSTRAINT `monhocScore_id` FOREIGN KEY (`monhocScore_id`) REFERENCES `mon_hoc` (`id`),
  CONSTRAINT `sinhvienScore_id` FOREIGN KEY (`sinhvienScore_id`) REFERENCES `sinh_vien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_diem`
--

LOCK TABLES `bang_diem` WRITE;
/*!40000 ALTER TABLE `bang_diem` DISABLE KEYS */;
INSERT INTO `bang_diem` VALUES (1,1,1,1,3,5),(2,9,9,1,4,2);
/*!40000 ALTER TABLE `bang_diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noi_dung` longtext NOT NULL,
  `baivietCM_id` int NOT NULL,
  `accountCM_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accountCM_id_idx` (`accountCM_id`),
  KEY `baivietCM_id_idx` (`baivietCM_id`),
  CONSTRAINT `accountCM_id` FOREIGN KEY (`accountCM_id`) REFERENCES `account` (`id`),
  CONSTRAINT `baivietCM_id` FOREIGN KEY (`baivietCM_id`) REFERENCES `bai_viet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'Cảm ơn thầy',1,4),(2,'Mặc đồ bó em',2,5);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day`
--

DROP TABLE IF EXISTS `day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `day` (
  `id` int NOT NULL AUTO_INCREMENT,
  `giangvien_id` int NOT NULL,
  `monhoc_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `monhoc_id_idx` (`monhoc_id`),
  KEY `giangvien_id_idx` (`giangvien_id`),
  CONSTRAINT `giangvien_id` FOREIGN KEY (`giangvien_id`) REFERENCES `giang_vien` (`id`),
  CONSTRAINT `monhoc_id` FOREIGN KEY (`monhoc_id`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day`
--

LOCK TABLES `day` WRITE;
/*!40000 ALTER TABLE `day` DISABLE KEYS */;
INSERT INTO `day` VALUES (11,1,1),(12,1,3),(13,2,2),(14,2,5),(15,2,4);
/*!40000 ALTER TABLE `day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giang_vien`
--

DROP TABLE IF EXISTS `giang_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giang_vien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `accountGV_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`accountGV_id`),
  CONSTRAINT `accountGV_id` FOREIGN KEY (`accountGV_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien`
--

LOCK TABLES `giang_vien` WRITE;
/*!40000 ALTER TABLE `giang_vien` DISABLE KEYS */;
INSERT INTO `giang_vien` VALUES (1,'Phuong','Luu','Phuong@maill',2),(2,'Khai','Ho','Khai@123',5);
/*!40000 ALTER TABLE `giang_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoc`
--

DROP TABLE IF EXISTS `hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `register_date` datetime NOT NULL,
  `sinhvienHOC_id` int NOT NULL,
  `monhocHOC_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `monhocHOC_id_idx` (`monhocHOC_id`),
  KEY `sinhvienHOC_id_idx` (`sinhvienHOC_id`),
  CONSTRAINT `monhocHOC_id` FOREIGN KEY (`monhocHOC_id`) REFERENCES `mon_hoc` (`id`),
  CONSTRAINT `sinhvienHOC_id` FOREIGN KEY (`sinhvienHOC_id`) REFERENCES `sinh_vien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc`
--

LOCK TABLES `hoc` WRITE;
/*!40000 ALTER TABLE `hoc` DISABLE KEYS */;
INSERT INTO `hoc` VALUES (1,'2023-08-05 00:00:00',3,1),(2,'2023-08-05 00:00:00',3,2),(3,'2023-08-05 00:00:00',3,3),(4,'2023-10-08 00:00:00',4,1),(5,'2023-10-08 00:00:00',4,5);
/*!40000 ALTER TABLE `hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `so_luong_sinh_vien` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (1,'IT1',90),(2,'IT2',90),(3,'IT3',90);
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_hoc`
--

DROP TABLE IF EXISTS `mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_hoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `tin_chi` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_hoc`
--

LOCK TABLES `mon_hoc` WRITE;
/*!40000 ALTER TABLE `mon_hoc` DISABLE KEYS */;
INSERT INTO `mon_hoc` VALUES (1,'Toan',4),(2,'Sinh',3),(3,'Van',4),(4,'Ly',4),(5,'TheDuc',2),(6,'Hoa',4);
/*!40000 ALTER TABLE `mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_score`
--

DROP TABLE IF EXISTS `other_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diem` float DEFAULT NULL,
  `bangdiem_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `svOtherScore_id_idx` (`bangdiem_id`),
  CONSTRAINT `svOtherScore_id` FOREIGN KEY (`bangdiem_id`) REFERENCES `bang_diem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_score`
--

LOCK TABLES `other_score` WRITE;
/*!40000 ALTER TABLE `other_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `other_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinh_vien`
--

DROP TABLE IF EXISTS `sinh_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `lop_id` int NOT NULL,
  `accountSV_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id_idx` (`accountSV_id`),
  KEY `lop_id_idx` (`lop_id`),
  CONSTRAINT `accountSV_id` FOREIGN KEY (`accountSV_id`) REFERENCES `account` (`id`),
  CONSTRAINT `lop_id` FOREIGN KEY (`lop_id`) REFERENCES `lop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien`
--

LOCK TABLES `sinh_vien` WRITE;
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` VALUES (3,'Khoa','Beo','khoa123',1,3),(4,'Son','MongLep','son@mail',2,4);
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-08 21:47:06
