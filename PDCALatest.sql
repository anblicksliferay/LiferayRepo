-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: pdca
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `pdca_achivementformula`
--

DROP TABLE IF EXISTS `pdca_achivementformula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_achivementformula` (
  `uuid_` varchar(75) DEFAULT NULL,
  `achivementFormulaId` bigint(20) NOT NULL,
  `achivementFormula` varchar(75) DEFAULT NULL,
  `itemDescriptionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`achivementFormulaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_achivementformula`
--

LOCK TABLES `pdca_achivementformula` WRITE;
/*!40000 ALTER TABLE `pdca_achivementformula` DISABLE KEYS */;
INSERT INTO `pdca_achivementformula` VALUES (NULL,1,'Actual/Target',1),(NULL,2,'1+((Actual-Target)/-Target)',1),(NULL,3,'1-((Actual-Target)/Target)',1),(NULL,4,'Actual/Target',2),(NULL,5,'1+((Target-Actual)/Target)',2),(NULL,6,'1% = 10% Achievement',2),(NULL,7,'1 Month = 5% Achievement',2),(NULL,8,'1% = 5% Achievement',2),(NULL,9,'-0.1% = 5% Achievement',2);
/*!40000 ALTER TABLE `pdca_achivementformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_cla_kpi`
--

DROP TABLE IF EXISTS `pdca_cla_kpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_cla_kpi` (
  `uuid_` varchar(75) DEFAULT NULL,
  `claKpiId` bigint(20) NOT NULL,
  `kpiId` bigint(20) DEFAULT NULL,
  `periodId` bigint(20) DEFAULT NULL,
  `ytd` bigint(20) DEFAULT NULL,
  `ol` double DEFAULT NULL,
  `claPoint` double DEFAULT NULL,
  `achivement` double DEFAULT NULL,
  PRIMARY KEY (`claKpiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_cla_kpi`
--

LOCK TABLES `pdca_cla_kpi` WRITE;
/*!40000 ALTER TABLE `pdca_cla_kpi` DISABLE KEYS */;
INSERT INTO `pdca_cla_kpi` VALUES ('3d8ffc0a-f6ea-7484-7efd-fac541d358c5',41809,41803,1,222,20,29.56521739130435,86.95652173913044),('f38d9530-4064-0d57-8cf2-eaaeed44bc39',41810,41803,2,0,0,0,0),('ac69d5e5-5c9d-13b8-7ce6-4e793c8ce1fd',41811,41803,3,0,0,100,0),('8b445866-d099-6d02-c5e3-be11a2535c45',41812,41803,4,0,0,90,0),('c453170f-d91e-3e11-1a9c-23d69e58d963',41813,41803,5,0,0,40,0),('3c41d798-fa0a-5e4f-7828-28baa6bd4433',42899,42893,1,34,20,19.999999999999996,33.33333333333333),('f753d6a1-51a4-3e12-807e-fae419bcb887',42900,42893,2,0,0,0,0),('cae88156-6ff3-9756-9cf1-0be9c0675c28',42901,42893,3,0,0,123,0),('efca1c5b-d016-e761-5162-09187d6717a5',42902,42893,4,0,0,0,0),('36906da7-ca68-e79d-55bf-90dad47466aa',42903,42893,5,89,20,19.999999999999996,33.33333333333333),('93c31b92-0f7d-9ef4-9f8e-afefbf131cd0',44007,44001,1,678,16,16,26.666666666666668),('dad27594-322d-a949-f7d9-3ff6f188af3f',44008,44001,2,0,0,0,0),('75900283-0863-0ecd-9f5f-aad3e71ec0f6',44009,44001,3,0,0,0,0),('36962e81-b2b7-7c38-5e7d-7c35f6ff7615',44010,44001,4,0,0,456,0),('4c1a4445-c0a0-b68b-3b5b-3ee0b2196d69',44011,44001,5,0,0,567,0),('3e43c8df-d5c8-956d-853d-e0b5199da8be',44025,44024,1,0,0,0,0),('39b46073-5ac7-4879-19cb-9f7b34afedd0',44026,44024,2,0,0,0,0),('33e6ea3f-9eb5-afef-654b-ecb5485fe4fd',44027,44024,3,10,10.6,90,123),('8582224e-29eb-3d7c-a6a6-9e0ecfe8122f',44028,44024,4,0,0,0,0),('67cc334b-e8b7-cbcf-3124-49e962529961',44029,44024,5,0,0,0,0),('b11856dd-534a-d28b-c25f-7fbd1d673280',44032,44031,1,0,0,0,0),('30578053-ee2b-a495-1d50-a7f45743ac75',44033,44031,2,0,0,0,0),('776fd6aa-150a-51a2-fdef-8014158b2616',44034,44031,3,0,0,95,0),('e504e8d3-95f1-007d-f415-4ae54f9f8b42',44035,44031,4,0,0,0,0),('a5f713e2-8166-9224-b4f2-6ed01c709dbe',44036,44031,5,0,0,0,0);
/*!40000 ALTER TABLE `pdca_cla_kpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_company`
--

DROP TABLE IF EXISTS `pdca_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_company` (
  `uuid_` varchar(75) DEFAULT NULL,
  `companyId` bigint(20) NOT NULL,
  `companyName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_company`
--

LOCK TABLES `pdca_company` WRITE;
/*!40000 ALTER TABLE `pdca_company` DISABLE KEYS */;
INSERT INTO `pdca_company` VALUES (NULL,1,'Astra International'),(NULL,2,'Honda Motors'),(NULL,3,'Hero Motors');
/*!40000 ALTER TABLE `pdca_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_itemdescription`
--

DROP TABLE IF EXISTS `pdca_itemdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_itemdescription` (
  `uuid_` varchar(75) DEFAULT NULL,
  `itemDescriptionId` bigint(20) NOT NULL,
  `itemDescriptionName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`itemDescriptionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_itemdescription`
--

LOCK TABLES `pdca_itemdescription` WRITE;
/*!40000 ALTER TABLE `pdca_itemdescription` DISABLE KEYS */;
INSERT INTO `pdca_itemdescription` VALUES (NULL,1,'TradingPoint'),(NULL,2,'Non-TradingPoint');
/*!40000 ALTER TABLE `pdca_itemdescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_kpi`
--

DROP TABLE IF EXISTS `pdca_kpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_kpi` (
  `uuid_` varchar(75) DEFAULT NULL,
  `kpiId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `typeId` bigint(20) DEFAULT NULL,
  `weight` bigint(20) DEFAULT NULL,
  `target` bigint(20) DEFAULT NULL,
  `year` bigint(20) DEFAULT NULL,
  `unit` varchar(75) DEFAULT NULL,
  `achivementFormulaId` bigint(20) DEFAULT NULL,
  `itemDescriptionName` varchar(75) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  PRIMARY KEY (`kpiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_kpi`
--

LOCK TABLES `pdca_kpi` WRITE;
/*!40000 ALTER TABLE `pdca_kpi` DISABLE KEYS */;
INSERT INTO `pdca_kpi` VALUES ('373ed48d-06a8-51ff-4dc4-4ef001943af2',41803,1,1,34,23,2017,'USD',1,'1',20156,'Test Test','2018-10-11','2018-10-11'),('b80515f1-0d32-c0d3-7ce2-84a6c0603d48',42893,2,1,60,60,2017,'USD',1,'1',20156,'Test Test','2018-10-11','2018-10-11'),('90ac2f2c-c7cd-3006-e23d-8d9ff39e8120',44001,3,1,60,60,2017,'USD',1,'1',20156,'Test Test','2018-10-12','2018-10-12'),('1ddb1677-3461-f9d9-acfc-c5c8ff9f0614',44024,1,2,60,60,2017,'usd',4,'2',20156,'Test Test','2018-10-12','2018-10-12'),('edddad8c-09fb-e959-30c2-8b503778ea49',44031,1,2,60,60,2017,'usd',5,'2',20156,'Test Test','2018-10-12','2018-10-12');
/*!40000 ALTER TABLE `pdca_kpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_period`
--

DROP TABLE IF EXISTS `pdca_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_period` (
  `uuid_` varchar(75) DEFAULT NULL,
  `periodId` bigint(20) NOT NULL,
  `periodName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`periodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_period`
--

LOCK TABLES `pdca_period` WRITE;
/*!40000 ALTER TABLE `pdca_period` DISABLE KEYS */;
INSERT INTO `pdca_period` VALUES (NULL,1,'OL1Achivement'),(NULL,2,'OL2Achivement'),(NULL,3,'OL2AdjAchivement'),(NULL,4,'OL3Achivement'),(NULL,5,'FYAchivement');
/*!40000 ALTER TABLE `pdca_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_tradingprofit`
--

DROP TABLE IF EXISTS `pdca_tradingprofit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_tradingprofit` (
  `uuid_` varchar(75) DEFAULT NULL,
  `tradingProfitId` bigint(20) NOT NULL,
  `periodId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `year` bigint(20) DEFAULT NULL,
  `npat` double DEFAULT NULL,
  `netForex` double DEFAULT NULL,
  `ppeDispos` double DEFAULT NULL,
  `revalutionOnPropertyInvestment` double DEFAULT NULL,
  `investment` double DEFAULT NULL,
  `taxExpense` double DEFAULT NULL,
  `impairmentOnAsset` double DEFAULT NULL,
  `others` double DEFAULT NULL,
  PRIMARY KEY (`tradingProfitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_tradingprofit`
--

LOCK TABLES `pdca_tradingprofit` WRITE;
/*!40000 ALTER TABLE `pdca_tradingprofit` DISABLE KEYS */;
INSERT INTO `pdca_tradingprofit` VALUES ('227ec0e4-6118-77d4-d3f4-4d1d0f29d20d',41804,1,1,2018,100,10,20,10,14,12,14,14),('e1728f7b-78ed-fb30-27bd-5f24f93bde29',41805,2,1,2018,0,0,0,0,0,0,0,0),('116a883e-f58c-bdf2-c22a-bba68d0ee2e8',41806,3,1,2018,0,0,0,0,0,0,0,0),('6cc1d646-f32e-322c-40e0-e3ac09bd8bf2',41807,4,1,2018,0,0,0,0,0,0,0,0),('4db4e30d-26b8-c034-1a1c-1d44597f73e1',41808,5,1,2018,100,0,0,0,0,0,0,0),('d11baaa3-543d-e91d-0a1f-98a255ca2b11',42894,1,2,2017,100,10,20,10,14,12,14,14),('ab8467b0-2f2a-5a1f-6531-26bf4ea6b12a',42895,2,2,2017,0,0,0,0,0,0,0,0),('441cd0a3-e98f-bd05-5256-13e8df79b268',42896,3,2,2017,0,0,0,0,0,0,0,0),('3938eea4-7022-d981-7aaf-ee3f490ce90c',42897,4,2,2017,0,0,0,0,0,0,0,0),('48593c97-9ee6-a372-6a72-1245c25c0785',42898,5,2,2017,100,10,20,10,12,14,14,14),('2eaec743-6247-9c53-12d2-603c8c5e652f',44002,1,3,2017,100,10,20,10,18,12,14,14),('6d8e3169-33f7-4677-274f-3821f8b7bc81',44003,2,3,2017,0,0,0,0,0,0,0,0),('b71a125c-9c2f-f521-6459-6a571fb31909',44004,3,3,2017,0,0,0,0,0,0,0,0),('95bea660-e815-113a-f747-8874dde95a98',44005,4,3,2017,0,0,0,0,0,0,0,0),('2d1c7320-11fc-659d-25e2-c885c0cc6979',44006,5,3,2017,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `pdca_tradingprofit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_type`
--

DROP TABLE IF EXISTS `pdca_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_type` (
  `uuid_` varchar(75) DEFAULT NULL,
  `typeId` bigint(20) NOT NULL,
  `typeName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_type`
--

LOCK TABLES `pdca_type` WRITE;
/*!40000 ALTER TABLE `pdca_type` DISABLE KEYS */;
INSERT INTO `pdca_type` VALUES (NULL,1,'Financial'),(NULL,2,'Strategy');
/*!40000 ALTER TABLE `pdca_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pdca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-12 20:19:10
