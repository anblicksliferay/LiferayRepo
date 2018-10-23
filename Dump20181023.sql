-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: astrapdca
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `pdca_astrapdca_companydata`
--

DROP TABLE IF EXISTS `pdca_astrapdca_companydata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_astrapdca_companydata` (
  `companyId` bigint(20) NOT NULL,
  `CompanyCode` varchar(45) DEFAULT NULL,
  `CompanyName` varchar(60) DEFAULT NULL,
  `GroupName` varchar(60) DEFAULT NULL,
  `DIC` varchar(60) DEFAULT NULL,
  `DICINITIAL` varchar(60) DEFAULT NULL,
  `LEFTUP` varchar(60) DEFAULT NULL,
  `LEFTUPTITLE` varchar(60) DEFAULT NULL,
  `LEFTUPCOMPANY` varchar(60) DEFAULT NULL,
  `LEFTBOTTOM` varchar(60) DEFAULT NULL,
  `LEFTBOTTOMTITLE` varchar(60) DEFAULT NULL,
  `LEFTBOTTOMCOMPANY` varchar(60) DEFAULT NULL,
  `MIDUP` varchar(60) DEFAULT NULL,
  `MIDUPTITLE` varchar(60) DEFAULT NULL,
  `MIDUPCOMPANY` varchar(60) DEFAULT NULL,
  `MIDBOTTOM` varchar(60) DEFAULT NULL,
  `MIDBOTTOMTITLE` varchar(60) DEFAULT NULL,
  `MIDBOTTOMCOMPANY` varchar(60) DEFAULT NULL,
  `RIGHTUP` varchar(60) DEFAULT NULL,
  `RIGHTUPTITLE` varchar(60) DEFAULT NULL,
  `RIGHTUPCOMPANY` varchar(60) DEFAULT NULL,
  `RIGHTBOTTOM` varchar(60) DEFAULT NULL,
  `RIGHTBOTTOMTITLE` varchar(60) DEFAULT NULL,
  `RIGHTBOTTOMCOMPANY` varchar(60) DEFAULT NULL,
  `ModuleId` bigint(20) DEFAULT NULL,
  `YearId` bigint(20) DEFAULT NULL,
  `CheckFlag` varchar(45) DEFAULT '0',
  `SiteId` bigint(20) DEFAULT NULL,
  `CreatedBy` varchar(60) DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  `CreateDate` timestamp(6) NULL DEFAULT NULL,
  `ModifiedDate` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_astrapdca_companydata`
--

LOCK TABLES `pdca_astrapdca_companydata` WRITE;
/*!40000 ALTER TABLE `pdca_astrapdca_companydata` DISABLE KEYS */;
INSERT INTO `pdca_astrapdca_companydata` VALUES (1,'AHM','PT Astra Honda Motor','Astra Motor I','Johannes Loman','JLO','Prijono Sugiarto',NULL,'PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Johannes Loman','Executive Vice President Director','PT Astra Honda Motor',NULL,NULL,NULL,1,2018,'true',20116,'Test Test','Test Test','2018-10-13 18:36:26.439000','2018-10-23 17:50:20.601000'),(2,'HSO','PT Astra International Tbk - Honda Sales Operation','Astra Motor I','Johannes Loman','JLO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,2018,'true',20116,'Test Test','Test Test','2018-10-13 18:38:23.386000','2018-10-23 09:25:30.593000'),(3,'TAM','PT Toyota Astra Motor','Astra Motor II','Henry Tanoto','HTA','Prijono Sugiarto',NULL,'PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Henry Tanoto','Executive Vice President Director','PT Toyota Astra Motor',NULL,NULL,NULL,1,2018,'true',20116,NULL,'Test Test',NULL,'2018-10-23 17:44:59.822000'),(4,'TSO','PT Astra International Tbk - Toyota Sales Operation','Astra Motor II','Henry Tanoto','HTA','Henry Tanoto','Director in Charge','ASTRA MOTOR II',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Tujuh Martogi Siahaan','Chief Executive','PT Astra International Tbk - Toyota Sales Operation',NULL,NULL,NULL,1,2018,'true',20116,NULL,'Test Test',NULL,'2018-10-17 23:12:33.489000'),(5,'ADM','PT Astra Daihatsu Motor','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Pongki Prabowo','President Director','PT Astra Daihatsu Motor',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(6,'DSO','PT Astra International Tbk - Daihatsu Sales Operation','Astra Motor III','Djony Bunarto Tjondro','DBT','Prijono Sugiarto','President Director','PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Djony Bunarto','Chief Executive','PT Astra International - Daihatsu Sales Operation',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(7,'IAMI','PT Isuzu Astra Motor Indonesia','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro',NULL,'ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Ernando Demily','Vice President Director','PT Isuzu Astra Motor Indonesia',NULL,NULL,NULL,1,2018,'true',20116,NULL,'Test Test',NULL,'2018-10-23 17:47:07.599000'),(8,'ISO','PT Astra International Tbk - Isuzu Sales Operation','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Rahmat Samulo','Chief Executive','PT Astra International - Isuzu Sales Operation',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(9,'UDSO','PT Astra International Tbk - UD Trucks Sales Operation','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro',NULL,'ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Aloysius Chrisnoadi','Chief Executive','PT Astra International - UD Trucks Sales operation',NULL,NULL,NULL,1,2018,'true',20116,NULL,'Test Test',NULL,'2018-10-23 17:47:29.409000'),(10,'BSO','PT Astra International Tbk - BMW Sales Operation','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Fredy Handjaja Elawitachya','Chief Executive','PT Astra International - BMW Sales Operation',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(11,'PSO','PT Astra International Tbk - Peugeot Sales Operation','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Supranoto Tirtodijojo','Chief Executive','PT Astra International - Peugeot Sales Operation',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(12,'GM','PT Gaya Motor','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Ary Maryano','President Director','PT Gaya Motor',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(13,'FTI','PT Fuji Technica Indonesia','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Erlan Krisnaring Cahyono','President Director','PT Fuji Technica Indonesia',NULL,NULL,NULL,1,2018,'true',20116,NULL,'Test Test',NULL,'2018-10-17 23:17:43.691000'),(14,'IPPI','PT Inti Pantja Press Industri','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Erlan Krisnaring Cahyono','President Director','PT Inti Pantja Press Industri',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(15,'TSM','PT Tjahja Sakti Motor','Astra Motor III','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR III',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Anton Kemal Tasli Kumonthy','President Director','PT Tjanja Sakti Motor',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(16,'AOP','PT Astra Otoparts Tbk','Astra Motor IV','Djony Bunarto Tjondro','DBT','Djony Bunarto Tjondro','Director in Charge','ASTRA MOTOR IV',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Hamdhani Dzulkarnaen','President Director','PT Astra Otoparts Tbk',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(17,'FIF','PT Federal International Finance','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Margono Tunawidjaya','President Director','PT Federal International Finance',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(18,'ACC','Astra Credit Companies','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Jodjana Jody','Chief Executive Officer','Astra Credit Companies',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(19,'TAFS','PT Toyota Astra Financial Services','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Agus Prayitno','President Director','PT Toyota Astra Financial Services',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(20,'KAF','PT Komatsu Astra Finance','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Andreas Manik','President Director','PT Komatsu Astra Finance',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(21,'SANF','PT Surya Artha Nusantara Finance','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Bugie Laksmana','President Director','PT Surya Artha Nusantara Finance',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(22,'AMV','PT Astra Mitra Ventura','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Jefri R. Sirait','President Director','PT Astra Mitra Ventura',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(23,'AAV','PT Astra Aviva Life Insurance','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Auddie Wiranata','Vice President Director','PT Astra Aviva Life Insurance',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(24,'AAB','PT Asuransi Astra Buana','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ','Suparno Djasmin','Director in Charge','Astra Financial Services',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Rudy Chen','President Director','PT Asuransi Astra Buana',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(25,'PB','PT Bank Permata Tbk','Astra Finance Companies, Banking & Insurance','Suparno Djasmi','SDJ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(26,'UT','PT United Tractors Tbk','Astra Heavy Equipment, Mining, Construction & Energy','Gidion Hasan','GHA','Prijono Sugiarto','President Director','PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Gidion Hasan','President Director','PT United Tractors Tbk',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(27,'PAMA','PT Pamapersada Nusantara','Astra Heavy Equipment, Mining, Construction & Energy','Gidion Hasan','GHA','Gidion Hasan','Director in Charge','Astra Heavy Equipment, Mining, Construction & Energy',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Frans L. Kesuma','President Director','PT Pamapersada Nusantara',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(28,'TN','PT Traktor Nusantara','Astra Heavy Equipment, Mining, Construction & Energy','Gidion Hasan','GHA','Gidion Hasan','Director in Charge','Astra Heavy Equipment, Mining, Construction & Energy',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','I Wayan Parka','President Director','PT Traktor Nusantara',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(29,'ACSET','PT Acset Indonusa Tbk','Astra Heavy Equipment, Mining, Construction & Energy','Gidion Hasan','GHA','Gidion Hasan','Director in Charge','Astra Heavy Equipment, Mining, Construction & Energy',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Jeffrey Gunadi C.','President Director','PT Acset Indonusa Tbk',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(30,'AAL','PT Astra Agro Lestari Tbk','Astra Agrobusiness','Widya Wiryawan','WWI','Prijono Sugiarto','President Director','PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Santosa','President Director','PT Astra Agro Lestari Tbk',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(31,'AN','PT Astra Infra','Astra Infrastructure, Logistic, IT & Property','Paulus Bambang W. S.','PBW','Paulus Bambang W.S','Director in Charge','Astra Infrastructure, Logistic, IT & Property',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Djap Tet Fa','President Director','PT Astra Infra',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(32,'MMS','PT Marga Mandalasakti','Astra Infrastructure, Logistic, IT & Property','Paulus Bambang W. S.','PBW','Djap Tet Fa','President Director','PT Astra Infra','Prijono Sugiarto','President Director','PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,'Krist Ade Sudiyono','President Director','PT Marga Mandala Sakti','Paulus Bambang W.S','Director in Charge','Astra Infrastructure, Logistic, IT & Property',1,2018,'true',11,NULL,NULL,NULL,NULL),(33,'SERA','PT Serasi Autoraya','Astra Infrastructure, Logistic, IT & Property','Paulus Bambang W. S.','PBW','Paulus Bambang W.S','Director in Charge','Astra Infrastructure, Logistic, IT & Property',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Firman Yosafat Siregar','President Director','PT Serasi Autoraya',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(34,'AG','PT Astra Graphia Tbk','Astra Infrastructure, Logistic, IT & Property','Paulus Bambang W. S.','PBW','Paulus Bambang W.S','Director in Charge','Astra Infrastructure, Logistic, IT & Property',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Harry Halim','President Director','PT Astra Graphia TBK',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(35,'MA','PT Menara Astra','Astra Infrastructure, Logistic, IT & Property','Paulus Bambang W. S.','PBW','Prijono Sugiarto','President Director','PT Astra International Tbk',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Paulus Bambang W.S','President Director','PT Menara Astra',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(36,'AWO','PT Astra International Tbk - AstraWorld','Astra Infrastructure, Logistic, IT & Property','Paulus Bambang W. S.','PBW','Paulus Bambang W.S','Director in Charge','Astra Infrastructure, Logistic, IT & Property',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Bambang Gunawan','Chief Executive','AstraWorld',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(37,'DPA','Dana Pensiun Astra','ASTRA FOUNDATION','Suparno Djasmin','SDJ','Suparno Djasmin','Director in Charge','Astra Foundation',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Suheri','Chief','Dana Pensiun Astra',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(38,'KAI','Koperasi Astra International','ASTRA FOUNDATION','Suparno Djasmin','SDJ','Suparno Djasmin','Director in Charge','Astra Foundation',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Pongki Pamungkas','Chief','Koperasi Astra International',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(39,'YPAMDR','Yayasan Pendidikan Astra Michael D. Ruslim','ASTRA FOUNDATION','Paulus Bambang W.S','PBW','Paulus Bambang W.S','Director in Charge','Astra Foundation',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Herawati Prasetyo','Chief','Yayasan Pendidikan Astra Michael D. Ruslim',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(40,'YABI','Yayasan Astra Bina Ilmu','ASTRA FOUNDATION','Johannes Loman','JLO','Johannes Loman','Director in Charge','Astra Foundation',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Hamdhani Dzulkarnaen','Chief','Yayasan Astra Bina Ilmu',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL),(41,'YDBA','Yayasan Dharma Bakti Astra','ASTRA FOUNDATION','Johannes Loman','JLO','Johannes Loman','Director in Charge','Astra Foundation',NULL,NULL,NULL,NULL,NULL,NULL,'Prijono Sugiarto','President Director','PT Astra International Tbk','Henry C. Widjaja','Chief','Yayasan Dharma Bakti Astra',NULL,NULL,NULL,1,2018,'true',11,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `pdca_astrapdca_companydata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_astrapdca_module`
--

DROP TABLE IF EXISTS `pdca_astrapdca_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_astrapdca_module` (
  `ModuleId` bigint(20) NOT NULL,
  `ModuleId_Company` bigint(20) DEFAULT NULL,
  `ModuleName` varchar(45) DEFAULT NULL,
  `SiteId` bigint(20) DEFAULT NULL,
  `CreateDate` timestamp(6) NULL DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  `ModifiedDate` timestamp(6) NULL DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  `checkUncheckFlag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ModuleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_astrapdca_module`
--

LOCK TABLES `pdca_astrapdca_module` WRITE;
/*!40000 ALTER TABLE `pdca_astrapdca_module` DISABLE KEYS */;
INSERT INTO `pdca_astrapdca_module` VALUES (1,0,NULL,0,'2018-10-23 17:50:48.375000','Test Test','2018-10-23 17:50:48.375000','Test Test','true'),(2,0,NULL,0,'2018-10-22 13:06:40.119000','Test Test','2018-10-22 13:06:40.119000','Test Test','false'),(3,0,NULL,0,'2018-10-18 17:38:48.844000','Test Test','2018-10-18 17:38:48.844000','Test Test','false');
/*!40000 ALTER TABLE `pdca_astrapdca_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_astrapdca_year`
--

DROP TABLE IF EXISTS `pdca_astrapdca_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_astrapdca_year` (
  `YearId` bigint(20) NOT NULL,
  `YearId_Company` bigint(20) DEFAULT NULL,
  `Year` bigint(20) DEFAULT NULL,
  `SiteId` bigint(20) DEFAULT NULL,
  `CreateDate` timestamp(6) NULL DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  `ModifiedDate` timestamp(6) NULL DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`YearId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_astrapdca_year`
--

LOCK TABLES `pdca_astrapdca_year` WRITE;
/*!40000 ALTER TABLE `pdca_astrapdca_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdca_astrapdca_year` ENABLE KEYS */;
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
  `peroidInput` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`claKpiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_cla_kpi`
--

LOCK TABLES `pdca_cla_kpi` WRITE;
/*!40000 ALTER TABLE `pdca_cla_kpi` DISABLE KEYS */;
INSERT INTO `pdca_cla_kpi` VALUES ('70ba4c55-13a1-ee74-3cee-d80fbe65c0cc',44609,44603,1,54,0,90,200,'ol'),('e73f46c1-d70a-32b0-53c3-9b15c08be544',44610,44603,2,0,-1047,561.15,1247,'ol2'),('caf56806-05c4-eaeb-da6d-8359313a0599',44611,44603,3,0,0,0,0,NULL),('c1514178-8c2c-5701-e2ff-1c326c0a9d1b',44612,44603,4,0,0,0,0,NULL),('4762fd61-d74f-ac6a-7038-3ff063129407',44613,44603,5,0,0,0,0,NULL),('4fd5ef7e-d10e-d3a0-2f10-dc15d1748224',44620,44614,1,45,0,90,200,'ol1'),('ca4486f1-9c3b-dca1-58cd-8d9c609f7d68',44621,44614,2,0,0,0,0,NULL),('caea6755-0b9b-a56b-5153-f25b85d31317',44622,44614,3,0,0,0,0,NULL),('f849553d-1a83-f23c-efaa-2766e53e8a79',44623,44614,4,0,0,0,0,NULL),('335e8d89-85e9-5f1a-d5ec-e419ef4280eb',44624,44614,5,0,0,0,0,NULL),('c79c6c29-1445-cc37-e03a-23e633b08d5f',44631,44625,1,0,0,90,200,'ol1'),('6630a472-d534-e657-22be-fb1defb1d359',44632,44625,2,0,0,0,0,NULL),('1c669b34-acde-a167-866c-f56c5ca6bcbb',44633,44625,3,0,0,0,0,NULL),('d08a65fb-e2be-e635-44a7-33d3cca51027',44634,44625,4,0,0,0,0,NULL),('372c79c7-4f1e-83df-1029-c6b04d48f1c1',44635,44625,5,0,0,0,0,NULL),('dd681329-ea7c-ea63-e2ae-1b3cd0ee389b',44742,44736,1,0,0,0,0,NULL),('867ea823-3100-1613-3570-6c450e2e5895',44743,44736,2,0,0,0,0,NULL),('00532e96-0cec-dce2-8b81-968268da2aa6',44744,44736,3,0,0,0,0,NULL),('3c8db4c6-ea31-ad69-de50-66307fa1b843',44745,44736,4,0,0,0,0,NULL),('33175492-1183-8068-2f65-b6318283f10d',44746,44736,5,0,0,0,0,NULL),('d612827c-2e0c-4def-b0b9-8c6caeacd6c5',45294,45293,1,78,200,62.5,125,'ol1'),('80b9daf5-2616-ea2c-cc5d-029747c363e6',45295,45293,2,0,0,0,0,NULL),('dd2ee6dd-ff85-1b93-7f55-aa8e1bdec3b7',45296,45293,3,0,0,0,0,NULL),('92dbc2e3-fc5c-d023-54ec-3916435d18f8',45297,45293,4,0,0,0,0,NULL),('fe9d2705-81a2-720e-1fce-784e12515b0b',45298,45293,5,0,0,0,0,NULL);
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
/*!40000 ALTER TABLE `pdca_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_company_user`
--

DROP TABLE IF EXISTS `pdca_company_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_company_user` (
  `company_user_Id` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `Pdca_userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`company_user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_company_user`
--

LOCK TABLES `pdca_company_user` WRITE;
/*!40000 ALTER TABLE `pdca_company_user` DISABLE KEYS */;
INSERT INTO `pdca_company_user` VALUES (43548,2,20156),(43550,2,34065),(43552,2,34093),(43554,2,34132),(44680,3,20156),(44683,7,20156),(44685,9,20156),(44694,1,20156);
/*!40000 ALTER TABLE `pdca_company_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_controlmom`
--

DROP TABLE IF EXISTS `pdca_controlmom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_controlmom` (
  `ControlMOMId` bigint(6) NOT NULL,
  `ListMOMId` bigint(6) DEFAULT NULL,
  `pdId` bigint(6) DEFAULT NULL,
  `userId` bigint(6) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `FollowUp` varchar(45) DEFAULT NULL,
  `SiteId` bigint(6) DEFAULT NULL,
  `CreateDate` timestamp(5) NULL DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  `ModifiedDate` timestamp(5) NULL DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  `FollowUpData` longtext,
  PRIMARY KEY (`ControlMOMId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_controlmom`
--

LOCK TABLES `pdca_controlmom` WRITE;
/*!40000 ALTER TABLE `pdca_controlmom` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdca_controlmom` ENABLE KEYS */;
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
  `itemDescriptionValue` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kpiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_kpi`
--

LOCK TABLES `pdca_kpi` WRITE;
/*!40000 ALTER TABLE `pdca_kpi` DISABLE KEYS */;
INSERT INTO `pdca_kpi` VALUES ('0172dc84-fbc2-2f98-c09a-da37ef4b9611',44603,14,1,45,100,2017,'45',2,'1',20156,'Test Test','2018-10-23','2018-10-23',NULL),('f10dda5a-a5e0-3af0-0082-451d4c8865ad',44614,13,1,45,410,2018,'45',3,'1',20156,'Test Test','2018-10-23','2018-10-23',NULL),('1f4daef7-dc98-479b-4611-429fc4fbaedd',44625,1,1,45,100,2018,'41',3,'1',20156,'Test Test','2018-10-23','2018-10-23',NULL),('d533f086-5d6b-4b1e-a3ab-8febacfb1269',44736,1,1,50,120,2018,'3',3,'1',20156,'Test Test','2018-10-23','2018-10-23',NULL),('081e37d3-47e8-d443-1041-4659990bfaf1',45293,2,2,50,120,2018,'USD',8,'2',20156,'Test Test','2018-10-23','2018-10-23','non trading');
/*!40000 ALTER TABLE `pdca_kpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_listmom`
--

DROP TABLE IF EXISTS `pdca_listmom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_listmom` (
  `MomId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `meetingDate` varchar(45) DEFAULT NULL,
  `fromTime` varchar(45) DEFAULT NULL,
  `ampm` varchar(45) DEFAULT NULL,
  `MomType` varchar(45) DEFAULT NULL,
  `MomTypeId` varchar(45) DEFAULT NULL,
  `performance` varchar(45) DEFAULT NULL,
  `MOMGroup` varchar(45) DEFAULT NULL,
  `MOMparticipants` varchar(45) DEFAULT NULL,
  `MOMcompanyName` varchar(45) DEFAULT NULL,
  `MOMplace` varchar(45) DEFAULT NULL,
  `ponitDiscussionId` bigint(20) DEFAULT NULL,
  `SiteId` bigint(20) DEFAULT NULL,
  `CreateDate` timestamp(6) NULL DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  `ModifiedDate` timestamp(6) NULL DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_listmom`
--

LOCK TABLES `pdca_listmom` WRITE;
/*!40000 ALTER TABLE `pdca_listmom` DISABLE KEYS */;
INSERT INTO `pdca_listmom` VALUES (43564,20156,19,'10/13/2018','10','am','monthly','1','asd','asf','asdf',NULL,'asdf',43565,20116,'2018-10-23 10:12:41.598000','Test Test','2018-10-23 10:12:41.598000','Test Test'),(43568,20156,19,'10/13/2018','10','am','monthly','1','asd','asf','asdf',NULL,'asdf',43569,20116,'2018-10-23 10:12:57.237000','Test Test','2018-10-23 10:12:57.237000','Test Test');
/*!40000 ALTER TABLE `pdca_listmom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_mompointdiscussoin`
--

DROP TABLE IF EXISTS `pdca_mompointdiscussoin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_mompointdiscussoin` (
  `PdId` bigint(20) NOT NULL,
  `MOMpdId` bigint(20) DEFAULT NULL,
  `PonintDiscussionName` varchar(45) DEFAULT NULL,
  `Notes` longtext,
  `SiteId` bigint(20) DEFAULT NULL,
  `CreateDate` timestamp(6) NULL DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  `ModifiedDate` timestamp(6) NULL DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_mompointdiscussoin`
--

LOCK TABLES `pdca_mompointdiscussoin` WRITE;
/*!40000 ALTER TABLE `pdca_mompointdiscussoin` DISABLE KEYS */;
INSERT INTO `pdca_mompointdiscussoin` VALUES (43566,43565,'sdgf','sdfg',20116,'2018-10-23 10:12:41.766000','Test Test','2018-10-23 10:12:41.766000','Test Test'),(43567,43565,'sdfg','sdf',20116,'2018-10-23 10:12:55.331000','Test Test','2018-10-23 10:12:55.331000','Test Test');
/*!40000 ALTER TABLE `pdca_mompointdiscussoin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdca_pdca_adminsettings`
--

DROP TABLE IF EXISTS `pdca_pdca_adminsettings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdca_pdca_adminsettings` (
  `settings_Id` bigint(20) NOT NULL,
  `moduleId` bigint(20) DEFAULT NULL,
  `year` bigint(20) DEFAULT NULL,
  `SiteId` bigint(20) DEFAULT NULL,
  `CreateDate` timestamp(6) NULL DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  `ModifiedDate` timestamp(6) NULL DEFAULT NULL,
  `ModifiedBy` varchar(45) DEFAULT NULL,
  `periodId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`settings_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdca_pdca_adminsettings`
--

LOCK TABLES `pdca_pdca_adminsettings` WRITE;
/*!40000 ALTER TABLE `pdca_pdca_adminsettings` DISABLE KEYS */;
INSERT INTO `pdca_pdca_adminsettings` VALUES (44695,1,2016,0,NULL,NULL,NULL,NULL,3,1),(44696,1,2016,0,NULL,NULL,NULL,NULL,3,2),(44697,1,2016,0,NULL,NULL,NULL,NULL,3,3),(44698,1,2016,0,NULL,NULL,NULL,NULL,3,4),(44699,1,2016,0,NULL,NULL,NULL,NULL,3,5),(44700,1,2016,0,NULL,NULL,NULL,NULL,3,6),(44701,1,2016,0,NULL,NULL,NULL,NULL,3,7),(44702,1,2016,0,NULL,NULL,NULL,NULL,3,8),(44703,1,2016,0,NULL,NULL,NULL,NULL,3,9),(44704,1,2016,0,NULL,NULL,NULL,NULL,3,10),(44705,1,2016,0,NULL,NULL,NULL,NULL,3,11),(44706,1,2016,0,NULL,NULL,NULL,NULL,3,12),(44707,1,2016,0,NULL,NULL,NULL,NULL,3,13),(44708,1,2016,0,NULL,NULL,NULL,NULL,3,14),(44709,1,2016,0,NULL,NULL,NULL,NULL,3,15),(44710,1,2016,0,NULL,NULL,NULL,NULL,3,16),(44711,1,2016,0,NULL,NULL,NULL,NULL,3,17),(44712,1,2016,0,NULL,NULL,NULL,NULL,3,18),(44713,1,2016,0,NULL,NULL,NULL,NULL,3,19),(44714,1,2016,0,NULL,NULL,NULL,NULL,3,20),(44715,1,2016,0,NULL,NULL,NULL,NULL,3,21),(44716,1,2016,0,NULL,NULL,NULL,NULL,3,22),(44717,1,2016,0,NULL,NULL,NULL,NULL,3,23),(44718,1,2016,0,NULL,NULL,NULL,NULL,3,24),(44719,1,2016,0,NULL,NULL,NULL,NULL,3,25),(44720,1,2016,0,NULL,NULL,NULL,NULL,3,26),(44721,1,2016,0,NULL,NULL,NULL,NULL,3,27),(44722,1,2016,0,NULL,NULL,NULL,NULL,3,28),(44723,1,2016,0,NULL,NULL,NULL,NULL,3,29),(44724,1,2016,0,NULL,NULL,NULL,NULL,3,30),(44725,1,2016,0,NULL,NULL,NULL,NULL,3,31),(44726,1,2016,0,NULL,NULL,NULL,NULL,3,32),(44727,1,2016,0,NULL,NULL,NULL,NULL,3,33),(44728,1,2016,0,NULL,NULL,NULL,NULL,3,34),(44729,1,2016,0,NULL,NULL,NULL,NULL,3,35),(44730,1,2016,0,NULL,NULL,NULL,NULL,3,36),(44731,1,2016,0,NULL,NULL,NULL,NULL,3,37),(44732,1,2016,0,NULL,NULL,NULL,NULL,3,38),(44733,1,2016,0,NULL,NULL,NULL,NULL,3,39),(44734,1,2016,0,NULL,NULL,NULL,NULL,3,40),(44735,1,2016,0,NULL,NULL,NULL,NULL,3,41);
/*!40000 ALTER TABLE `pdca_pdca_adminsettings` ENABLE KEYS */;
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
INSERT INTO `pdca_tradingprofit` VALUES ('5ab6c2b7-e2c9-5877-28d9-6d44b8577429',43207,1,2,2018,89,65,3332,655,444,242,2424,54545),('86483b7d-a23f-17b0-4163-9773cc4e8e4e',43208,2,2,2018,10000,56,54,10000,1000,1000,1000,10000),('df34928d-883d-15a9-1c8c-13648249d451',43209,3,2,2018,0,0,0,0,0,0,0,0),('3a1db7f0-1c24-2a20-39e6-ed974f36e840',43210,4,2,2018,0,0,0,0,0,0,0,0),('74dc43f3-0197-cabc-e62c-9847fbcf0e55',43211,5,2,2018,0,0,0,0,0,0,0,0),('5e68bf9e-61b8-41ac-fb6e-eba3ac72d25b',43521,1,2,2017,1000,1000,0,547,7844,4107,100,100),('dbd435c0-d3a5-9c0b-1512-64f0ec3deecf',44503,1,4,2016,0,0,0,0,0,0,0,0),('88d00654-7723-f731-ba2f-4cf1592ffc3a',44504,1,4,2016,0,0,0,0,0,0,0,0),('8337dc2e-37db-275e-71c2-8f1e37c3e33a',44505,2,4,2016,0,0,0,0,0,0,0,0),('a4e0293c-ca18-98b7-7979-4d580ee38747',44506,2,4,2016,0,0,0,0,0,0,0,0),('7f85ace8-31d2-8d8d-db8c-ac61d8e45eea',44507,3,4,2016,0,0,0,0,0,0,0,0),('0077c3c6-df4d-4073-e6a8-f6849b215a1c',44508,3,4,2016,0,0,0,0,0,0,0,0),('f00cc8dc-0f85-e2e4-2f7e-45cdc599938c',44509,4,4,2016,0,0,0,0,0,0,0,0),('52198697-e972-ad11-94ef-b184f0b83f09',44510,4,4,2016,0,0,0,0,0,0,0,0),('07529fb7-e682-9bd8-c43e-aa003249cf13',44511,5,4,2016,0,0,0,0,0,0,0,0),('0d4ea73b-1262-edb6-3d0d-97344a52114d',44512,5,4,2016,0,0,0,0,0,0,0,0),('494cbd7a-16f5-cdeb-1b13-d2229ca8c520',44524,1,4,2016,0,0,0,0,0,0,0,0),('d0433879-0428-696c-ffe3-275693716229',44525,2,4,2016,0,0,0,0,0,0,0,0),('b4b226bc-4e38-6638-2b7d-63437c2d0ffe',44526,3,4,2016,0,0,0,0,0,0,0,0),('ca51a386-c714-e9c6-eac3-90ff7c1d97b0',44527,4,4,2016,0,0,0,0,0,0,0,0),('b0d2944f-024a-885b-28fa-edf439dd6e99',44528,5,4,2016,0,0,0,0,0,0,0,0),('e4c419c2-e148-2128-9717-d73fa87a63cc',44604,1,14,2017,0,0,0,0,0,0,0,0),('3ab0a841-5d28-f0c0-558f-188f33fc27ae',44605,2,14,2017,100,100,351,54,546,42,54,4554),('aba40ef7-e6e8-f9d0-fc3a-d224c2fa6836',44606,3,14,2017,0,0,0,0,0,0,0,0),('5aa5d5bc-99fe-8529-77d8-7d0dc8df4ac6',44607,4,14,2017,0,0,0,0,0,0,0,0),('792236a6-cc27-e49d-93de-db74dd65d59d',44608,5,14,2017,0,0,0,0,0,0,0,0),('a3c08980-5496-f641-e470-8d50ea309ed3',44615,1,13,2018,0,0,0,0,0,0,0,0),('18aad0da-9b3a-2763-f245-cdd77bf9782c',44616,2,13,2018,0,0,0,0,0,0,0,0),('6468e0c2-f92d-b3ae-114c-86317d69a0d5',44617,3,13,2018,0,0,0,0,0,0,0,0),('97f17451-cd5d-4b39-f418-801ff28a1779',44618,4,13,2018,0,0,0,0,0,0,0,0),('4f87b7fd-4f2a-77c4-c04e-938951671492',44619,5,13,2018,0,0,0,0,0,0,0,0),('2972952c-0ac4-a233-960d-3fa163c8518b',44626,1,1,2018,0,0,0,0,0,0,0,0),('8a83fa50-7a1e-a79d-971c-761514854361',44627,2,1,2018,0,0,0,0,0,0,0,0),('5da27200-e688-45af-d52a-fc27c50747b4',44628,3,1,2018,0,0,0,0,0,0,0,0),('04e2c39d-fc4e-62f4-c89c-9f55e733c72d',44629,4,1,2018,0,0,0,0,0,0,0,0),('460606ff-dc9d-68d2-58ce-33537d412d8f',44630,5,1,2018,0,0,0,0,0,0,0,0),('c6d11251-925b-30d7-5a79-2a98568e2586',44737,1,1,2018,0,0,0,0,0,0,0,0),('7033ee29-53a1-6fc9-4549-5bf1415e6276',44738,2,1,2018,0,0,0,0,0,0,0,0),('5d676cd1-5de8-baa3-e654-9f2784af4a7f',44739,3,1,2018,0,0,0,0,0,0,0,0),('3f3fd51c-37bb-7d05-b7e0-a0395b51faa1',44740,4,1,2018,0,0,0,0,0,0,0,0),('5e705a1b-36d1-a1b7-0a85-a71a30f52a06',44741,5,1,2018,0,0,0,0,0,0,0,0);
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

-- Dump completed on 2018-10-23  6:44:14
