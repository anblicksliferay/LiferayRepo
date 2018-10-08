-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: astra
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `astra_achivementformula`
--

DROP TABLE IF EXISTS `astra_achivementformula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_achivementformula` (
  `uuid_` varchar(75) DEFAULT NULL,
  `achivementFormulaId` bigint(20) NOT NULL,
  `achivementFormula` varchar(75) DEFAULT NULL,
  `itemDescriptionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`achivementFormulaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astra_achivementformula`
--

LOCK TABLES `astra_achivementformula` WRITE;
/*!40000 ALTER TABLE `astra_achivementformula` DISABLE KEYS */;
INSERT INTO `astra_achivementformula` VALUES (NULL,1,'Actual/Target',1),(NULL,2,'1+((Actual-Target)/-Target)',1),(NULL,3,'1-((Actual-Target)/Target)',1),(NULL,4,'Actual/Target',2),(NULL,5,'1+((Target-Actual)/Target)',2),(NULL,6,'1% = 10% Achievement',2),(NULL,7,'1 Month = 5% Achievement',2),(NULL,8,'1% = 5% Achievement',2),(NULL,9,'-0.1% = 5% Achievement',2);
/*!40000 ALTER TABLE `astra_achivementformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_cla_kpi`
--

DROP TABLE IF EXISTS `astra_cla_kpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_cla_kpi` (
  `uuid_` varchar(75) DEFAULT NULL,
  `claKpiId` bigint(20) NOT NULL,
  `kpiId` bigint(20) DEFAULT NULL,
  `periodId` bigint(20) DEFAULT NULL,
  `ytd` bigint(20) DEFAULT NULL,
  `ol` bigint(20) DEFAULT NULL,
  `claPoint` bigint(20) DEFAULT NULL,
  `achivement` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`claKpiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astra_cla_kpi`
--

LOCK TABLES `astra_cla_kpi` WRITE;
/*!40000 ALTER TABLE `astra_cla_kpi` DISABLE KEYS */;
INSERT INTO `astra_cla_kpi` VALUES (NULL,1,1,1,10,123,123,123),(NULL,2,1,2,10,123,123,123),(NULL,3,1,3,10,123,123,123),(NULL,4,1,4,10,123,123,123),(NULL,5,1,5,12,123,123,123),(NULL,6,2,1,10,123,123,123),(NULL,7,2,2,10,123,123,123),(NULL,8,2,3,10,123,123,123),(NULL,9,2,4,10,123,123,123),(NULL,10,2,5,12,123,123,123);
/*!40000 ALTER TABLE `astra_cla_kpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_company`
--

DROP TABLE IF EXISTS `astra_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_company` (
  `uuid_` varchar(75) DEFAULT NULL,
  `companyId` bigint(20) NOT NULL,
  `companyName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astra_company`
--

LOCK TABLES `astra_company` WRITE;
/*!40000 ALTER TABLE `astra_company` DISABLE KEYS */;
INSERT INTO `astra_company` VALUES (NULL,1,'Astra International'),(NULL,2,'Honda Motors'),(NULL,3,'Hero Motors');
/*!40000 ALTER TABLE `astra_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_itemdescription`
--

DROP TABLE IF EXISTS `astra_itemdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_itemdescription` (
  `uuid_` varchar(75) DEFAULT NULL,
  `itemDescriptionId` bigint(20) NOT NULL,
  `itemDescriptionName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`itemDescriptionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astra_itemdescription`
--

LOCK TABLES `astra_itemdescription` WRITE;
/*!40000 ALTER TABLE `astra_itemdescription` DISABLE KEYS */;
INSERT INTO `astra_itemdescription` VALUES (NULL,1,'TradingPoint'),(NULL,2,'Non-TradingPoint');
/*!40000 ALTER TABLE `astra_itemdescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_kpi`
--

DROP TABLE IF EXISTS `astra_kpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_kpi` (
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
-- Dumping data for table `astra_kpi`
--

LOCK TABLES `astra_kpi` WRITE;
/*!40000 ALTER TABLE `astra_kpi` DISABLE KEYS */;
INSERT INTO `astra_kpi` VALUES (NULL,1,1,1,60,60,2018,'USD',1,'TradingPoint',1,'admin',NULL,NULL),(NULL,2,1,1,25,78,2017,'USD',1,'TradingPoint',1,'admin',NULL,NULL),(NULL,3,1,1,60,60,2018,'USD',2,'TradingPoint',1,'admin',NULL,NULL),(NULL,4,1,1,60,60,2018,'USD',3,'TradingPoint',1,'admin',NULL,NULL),(NULL,5,1,1,60,60,2018,'USD',4,'TradingPoint',1,'admin',NULL,NULL),(NULL,6,1,1,60,60,2018,'USD',5,'TradingPoint',1,'admin',NULL,NULL),(NULL,7,1,1,60,60,2018,'USD',6,'TradingPoint',1,'admin',NULL,NULL),(NULL,8,1,1,60,60,2018,'USD',7,'TradingPoint',1,'admin',NULL,NULL),(NULL,9,1,1,60,60,2018,'USD',8,'TradingPoint',1,'admin',NULL,NULL),(NULL,10,1,1,60,60,2018,'USD',9,'TradingPoint',1,'admin',NULL,NULL);
/*!40000 ALTER TABLE `astra_kpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_period`
--

DROP TABLE IF EXISTS `astra_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_period` (
  `uuid_` varchar(75) DEFAULT NULL,
  `periodId` bigint(20) NOT NULL,
  `periodName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`periodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astra_period`
--

LOCK TABLES `astra_period` WRITE;
/*!40000 ALTER TABLE `astra_period` DISABLE KEYS */;
INSERT INTO `astra_period` VALUES (NULL,1,'OL1Achivement'),(NULL,2,'OL2Achivement'),(NULL,3,'OL2AdjAchivement'),(NULL,4,'OL3Achivement'),(NULL,5,'FYAchivement');
/*!40000 ALTER TABLE `astra_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_tradingprofit`
--

DROP TABLE IF EXISTS `astra_tradingprofit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_tradingprofit` (
  `uuid_` varchar(75) DEFAULT NULL,
  `tradingProfitId` bigint(20) NOT NULL,
  `periodId` bigint(20) DEFAULT NULL,
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
-- Dumping data for table `astra_tradingprofit`
--

LOCK TABLES `astra_tradingprofit` WRITE;
/*!40000 ALTER TABLE `astra_tradingprofit` DISABLE KEYS */;
INSERT INTO `astra_tradingprofit` VALUES (NULL,1,1,100,10,20,10,14,12,14,14),(NULL,2,2,100,12,20,10,14,12,14,14),(NULL,3,3,100,10,34,10,14,12,14,14),(NULL,4,4,100,10,20,23,14,12,14,14),(NULL,5,5,100,10,20,10,12,14,14,14);
/*!40000 ALTER TABLE `astra_tradingprofit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astra_type`
--

DROP TABLE IF EXISTS `astra_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astra_type` (
  `uuid_` varchar(75) DEFAULT NULL,
  `typeId` bigint(20) NOT NULL,
  `typeName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astra_type`
--

LOCK TABLES `astra_type` WRITE;
/*!40000 ALTER TABLE `astra_type` DISABLE KEYS */;
INSERT INTO `astra_type` VALUES (NULL,1,'Financial'),(NULL,2,'Strategy');
/*!40000 ALTER TABLE `astra_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-08 10:19:13
