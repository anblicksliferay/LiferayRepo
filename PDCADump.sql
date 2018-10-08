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
  `ol` bigint(20) DEFAULT NULL,
  `claPoint` bigint(20) DEFAULT NULL,
  `achivement` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`claKpiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_cla_kpi`
--

LOCK TABLES `pdca_cla_kpi` WRITE;
/*!40000 ALTER TABLE `pdca_cla_kpi` DISABLE KEYS */;
INSERT INTO `pdca_cla_kpi` VALUES (NULL,1,1,1,10,123,123,123),(NULL,2,1,2,10,123,123,123),(NULL,3,1,3,10,123,123,123),(NULL,4,1,4,10,123,123,123),(NULL,5,1,5,12,123,123,123);
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
  `unit` bigint(20) DEFAULT NULL,
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
INSERT INTO `pdca_kpi` VALUES (NULL,1,1,1,30,40,2018,5,2,'TradingPoint',1,'admin',NULL,NULL);
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
INSERT INTO `pdca_period` VALUES (NULL,1,'OL1  Achivement'),(NULL,2,'OL2  Achivement'),(NULL,3,'OL2  Adj Achivement'),(NULL,4,'OL3  Achivement'),(NULL,5,'FY Achivement');
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
  `npat` bigint(20) DEFAULT NULL,
  `netForex` bigint(20) DEFAULT NULL,
  `ppeDispos` bigint(20) DEFAULT NULL,
  `revalutionOnPropertyInvestment` bigint(20) DEFAULT NULL,
  `investment` bigint(20) DEFAULT NULL,
  `taxExpense` bigint(20) DEFAULT NULL,
  `impairmentOnAsset` bigint(20) DEFAULT NULL,
  `others` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`tradingProfitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_tradingprofit`
--

LOCK TABLES `pdca_tradingprofit` WRITE;
/*!40000 ALTER TABLE `pdca_tradingprofit` DISABLE KEYS */;
INSERT INTO `pdca_tradingprofit` VALUES (NULL,1,1,10,10,10,10,10,10,10,10),(NULL,2,2,10,10,10,10,10,10,10,10),(NULL,3,3,10,10,10,10,10,10,10,10),(NULL,4,4,10,10,10,10,10,10,10,10),(NULL,5,5,10,10,10,10,10,10,10,10);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-08 10:20:16
