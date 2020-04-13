-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.4.1-beta-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema document_tracking
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ document_tracking;
USE document_tracking;

--
-- Table structure for table `document_tracking`.`documents`
--

DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents` (
  `documentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_data` varchar(250) NOT NULL DEFAULT '',
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`documentID`,`tracking_data`),
  KEY `FK-userID` (`userID`),
  CONSTRAINT `FK-userID` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=777 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`documents`
--

/*!40000 ALTER TABLE `documents` DISABLE KEYS */;
INSERT INTO `documents` (`documentID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_data`,`userID`) VALUES 
 (754,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 4:15:53 AM','20200115-0001',66),
 (755,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 5:36:20 AM','20200115-0002',50),
 (756,'BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','Head of ICE','Jan / 15 / 2020 / 5:38:16 AM','20200115-0003',50),
 (757,'President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:39:1 AM','20200115-0004',41),
 (758,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ITSU','Jan / 16 / 2020 / 2:55:7 AM','20200116-0005',50),
 (759,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 7:26:43 PM','20200117-0006',50),
 (760,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 7:31:22 PM','20200117-0007',50);
INSERT INTO `documents` (`documentID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_data`,`userID`) VALUES 
 (761,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 7:31:57 PM','20200117-0008',50),
 (762,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ICE','Jan / 17 / 2020 / 7:41:8 PM','20200117-0009',50),
 (763,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ICE','Jan / 17 / 2020 / 7:43:26 PM','20200117-0010',50),
 (764,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ICE','Jan / 17 / 2020 / 7:59:13 PM','20200117-0011',50),
 (765,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 8:6:53 PM','20200117-0012',50),
 (766,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 8:6:58 PM','20200117-0013',50),
 (767,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:3:13 PM','20200127-0014',50);
INSERT INTO `documents` (`documentID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_data`,`userID`) VALUES 
 (768,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:5:45 PM','20200127-0015',50),
 (769,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Journal and Publication Office','Jan / 27 / 2020 / 9:6:13 PM','20200127-0016',50),
 (770,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Journal and Publication Office','Jan / 27 / 2020 / 9:6:35 PM','20200127-0017',50),
 (771,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','President of DOSCST Alumni Association','Jan / 27 / 2020 / 9:7:11 PM','20200127-0018',50),
 (772,'BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Office of ITSU','Jan / 27 / 2020 / 9:8:25 PM','20200127-0019',50),
 (773,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:13:14 PM','20200127-0020',50);
INSERT INTO `documents` (`documentID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_data`,`userID`) VALUES 
 (774,'BSIT Faculty','Jonathan Cabrera','Utang','Mangutang kog 1000','For approval','Head of ICE','Feb / 10 / 2020 / 10:46:21 PM','20200210-0021',50),
 (775,'BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 10:32:16 AM','20200222-0022',50),
 (776,'BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 1:26:54 PM','20200222-0023',50);
/*!40000 ALTER TABLE `documents` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`incoming`
--

DROP TABLE IF EXISTS `incoming`;
CREATE TABLE `incoming` (
  `incomingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `tracking_data` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`incomingID`,`userID`),
  KEY `userID` (`userID`) USING BTREE,
  CONSTRAINT `userID` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`incoming`
--

/*!40000 ALTER TABLE `incoming` DISABLE KEYS */;
INSERT INTO `incoming` (`incomingID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`userID`,`tracking_data`,`status`) VALUES 
 (1,'BSIT Faculty','Jonathan Cabrera','Utang','Mangutang kog 1000','For approval','Head of ICE','Feb / 10 / 2020 / 10:46:22 PM',50,'20200210-0021',''),
 (2,'BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 10:32:16 AM',50,'20200222-0022',''),
 (3,'BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 1:26:55 PM',50,'20200222-0023','');
/*!40000 ALTER TABLE `incoming` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`incominglist`
--

DROP TABLE IF EXISTS `incominglist`;
CREATE TABLE `incominglist` (
  `incoming_listID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_number` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`incoming_listID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `FK_incomintlist_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=424 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`incominglist`
--

/*!40000 ALTER TABLE `incominglist` DISABLE KEYS */;
INSERT INTO `incominglist` (`incoming_listID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`) VALUES 
 (413,66,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 4:20:33 AM','20200115-0001','Received'),
 (414,66,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:46:48 AM','20200115-0001','Received'),
 (415,50,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 5:36:37 AM','20200115-0002','Received'),
 (416,50,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:37:23 AM','20200115-0002','Received'),
 (417,50,'BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','Head of ICE','Jan / 15 / 2020 / 5:39:27 AM','20200115-0003','Received'),
 (418,41,'President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:39:31 AM','20200115-0004','Received');
INSERT INTO `incominglist` (`incoming_listID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`) VALUES 
 (419,41,'President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:40:9 AM','20200115-0004','Received'),
 (420,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:18:39 PM','20200127-0020','Received'),
 (421,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Budget Office','Jan / 27 / 2020 / 9:20:43 PM','20200127-0020','Received'),
 (422,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Internal Control Unit','Jan / 27 / 2020 / 9:22:33 PM','20200127-0020','Received'),
 (423,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Procurement Office','Jan / 27 / 2020 / 9:24:29 PM','20200127-0020','Received');
/*!40000 ALTER TABLE `incominglist` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`outgoing`
--

DROP TABLE IF EXISTS `outgoing`;
CREATE TABLE `outgoing` (
  `outgoingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_number` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(250) NOT NULL DEFAULT '',
  `forwarded_by` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`outgoingID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `FK_outgoing_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`outgoing`
--

/*!40000 ALTER TABLE `outgoing` DISABLE KEYS */;
/*!40000 ALTER TABLE `outgoing` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`outgoinglist`
--

DROP TABLE IF EXISTS `outgoinglist`;
CREATE TABLE `outgoinglist` (
  `outgoing_listID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_number` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(250) NOT NULL DEFAULT '',
  `forwarded_by` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`outgoing_listID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `FK_outgoinglist_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`outgoinglist`
--

/*!40000 ALTER TABLE `outgoinglist` DISABLE KEYS */;
INSERT INTO `outgoinglist` (`outgoing_listID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`,`forwarded_by`) VALUES 
 (273,66,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 4:20:33 AM','20200115-0001','Forwarded',''),
 (274,66,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:46:49 AM','20200115-0001','Forwarded',''),
 (275,50,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 5:36:37 AM','20200115-0002','Forwarded',''),
 (276,50,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:37:23 AM','20200115-0002','Forwarded',''),
 (277,50,'BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','Head of ICE','Jan / 15 / 2020 / 5:39:27 AM','20200115-0003','Forwarded',''),
 (278,41,'President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:39:31 AM','20200115-0004','Forwarded','');
INSERT INTO `outgoinglist` (`outgoing_listID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`,`forwarded_by`) VALUES 
 (279,41,'President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:40:10 AM','20200115-0004','Forwarded',''),
 (280,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:18:39 PM','20200127-0020','Forwarded',''),
 (281,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Budget Office','Jan / 27 / 2020 / 9:20:44 PM','20200127-0020','Forwarded',''),
 (282,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Internal Control Unit','Jan / 27 / 2020 / 9:22:33 PM','20200127-0020','Forwarded',''),
 (283,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Procurement Office','Jan / 27 / 2020 / 9:24:30 PM','20200127-0020','Forwarded','');
/*!40000 ALTER TABLE `outgoinglist` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`pending`
--

DROP TABLE IF EXISTS `pending`;
CREATE TABLE `pending` (
  `pendingID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_number` varchar(250) NOT NULL DEFAULT '',
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `status` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`pendingID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `FK_pending_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`pending`
--

/*!40000 ALTER TABLE `pending` DISABLE KEYS */;
/*!40000 ALTER TABLE `pending` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`pendinglist`
--

DROP TABLE IF EXISTS `pendinglist`;
CREATE TABLE `pendinglist` (
  `pending_listID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_number` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(250) NOT NULL DEFAULT '',
  `forwarded_by` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`pending_listID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `FK_pendinglist_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`pendinglist`
--

/*!40000 ALTER TABLE `pendinglist` DISABLE KEYS */;
INSERT INTO `pendinglist` (`pending_listID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`,`forwarded_by`) VALUES 
 (280,66,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:21:1 AM','20200115-0001','Accepted','Head of ICE'),
 (281,66,'BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:47:32 AM','20200115-0001','Done','Dean of ICE'),
 (282,50,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:36:50 AM','20200115-0002','Accepted','Head of ICE'),
 (283,50,'BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:37:29 AM','20200115-0002','Done','BSIT Faculty'),
 (284,50,'BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','ar-jay sacay','Jan / 15 / 2020 / 5:39:42 AM','20200115-0003','Done','Head of ICE'),
 (285,41,'President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','ar-jay sacay','Jan / 15 / 2020 / 5:39:55 AM','20200115-0004','Done','Head of ICE');
INSERT INTO `pendinglist` (`pending_listID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`,`forwarded_by`) VALUES 
 (286,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Internal Control Unit','Jan / 27 / 2020 / 9:21:12 PM','20200127-0020','Accepted','Budget Office'),
 (287,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Procurement Office','Jan / 27 / 2020 / 9:22:56 PM','20200127-0020','Accepted','Office of Internal Control Unit'),
 (288,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Diego Tan','Jan / 27 / 2020 / 9:24:54 PM','20200127-0020','Done','Procurement Office');
/*!40000 ALTER TABLE `pendinglist` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `grade` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`trackinghistory`
--

DROP TABLE IF EXISTS `trackinghistory`;
CREATE TABLE `trackinghistory` (
  `tracking_historyID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_number` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`tracking_historyID`,`userID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`trackinghistory`
--

/*!40000 ALTER TABLE `trackinghistory` DISABLE KEYS */;
INSERT INTO `trackinghistory` (`tracking_historyID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_number`,`status`) VALUES 
 (126,50,'BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Diego Tan','Jan / 27 / 2020 / 9:24:54 PM','20200127-0020','Done');
/*!40000 ALTER TABLE `trackinghistory` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`trackingpage`
--

DROP TABLE IF EXISTS `trackingpage`;
CREATE TABLE `trackingpage` (
  `tracking_pageID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `tracking_data` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`tracking_pageID`,`tracking_data`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`trackingpage`
--

/*!40000 ALTER TABLE `trackingpage` DISABLE KEYS */;
INSERT INTO `trackingpage` (`tracking_pageID`,`userID`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`tracking_data`,`status`) VALUES 
 (1,50,'BSIT Faculty','Jonathan Cabrera','Utang','Mangutang kog 1000','For approval','Head of ICE','Feb / 10 / 2020 / 10:46:22 PM','20200210-0021','Ongoing'),
 (2,50,'BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 10:32:16 AM','20200222-0022','Ongoing'),
 (3,50,'BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 1:26:55 PM','20200222-0023','Ongoing');
/*!40000 ALTER TABLE `trackingpage` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(250) NOT NULL DEFAULT '',
  `password` varchar(250) NOT NULL DEFAULT '',
  `permission` varchar(250) NOT NULL DEFAULT '',
  `institute` varchar(250) NOT NULL DEFAULT '',
  `name` varchar(250) NOT NULL DEFAULT '',
  `lastname` varchar(250) NOT NULL DEFAULT '',
  `field` varchar(250) NOT NULL DEFAULT '',
  `program` varchar(250) NOT NULL DEFAULT '',
  `position` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`,`password`,`permission`,`institute`,`name`,`lastname`,`field`,`program`,`position`) VALUES 
 (40,'admin','admin','admin','','','','admin','',''),
 (41,'pres','pres','President','','Edito','Sumile','','',''),
 (50,'joecabs','joecabs','BSIT Faculty','ICE','Jonathan','Cabrera','Academic','ICE','Faculty'),
 (51,'headbudget','headbudget','Head of Budget Office','null','wingkey ','low','Administrative','null','Dean/Head/Director '),
 (52,'acavpa','acavpa','Vice-President for Academic Affairs','null','samson','manaloto','Academic','null','Dean/Head/Director'),
 (53,'vpaadm','vpaadm','Vice-President for Administrative','null','joselito','Edong','Administrative','null','Dean/Head/Director '),
 (54,'arjaysacay','arjaysacay','Head of ICE','null','ar-jay','sacay','Academic','null','Dean/Head/Director'),
 (55,'jeanko','jeanko','Dean of ICE','null','jean','ebali','Academic','null','Dean/Head/Director'),
 (63,'dsadfas','asdfasdf','null','null','asdfasdf','asdfasdf','Select','null','null'),
 (64,'sdfghjk','zxcvbnm','null','null','jhffg','gjh','Select','null','null');
INSERT INTO `users` (`id`,`username`,`password`,`permission`,`institute`,`name`,`lastname`,`field`,`program`,`position`) VALUES 
 (66,'Example','asdfasdf','BSIT Faculty','ICE','Wingo','TheGreat','Academic','ICE','Faculty'),
 (67,'deanofice','asdfasdf','Dean of ICE','null','Dean','of ICE','Academic','null','Dean/Head/Director'),
 (68,'diegotan','diegotan','Office of Director for Administration Services','null','Diego','Tan','Administrative','null','Dean/Head/Director '),
 (69,'budoff','budoff','Budget Office','null','Maria luisa','Talaboc','Administrative','null','Dean/Head/Director '),
 (70,'janess','janess','Office of Internal Control Unit','null','Dr. Janessa','Catam-isan','Administrative','null','Dean/Head/Director '),
 (71,'diego2','diego2','Procurement Office','null','Diego','Tan','Administrative','null','Dean/Head/Director ');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


--
-- Table structure for table `document_tracking`.`viewdetails`
--

DROP TABLE IF EXISTS `viewdetails`;
CREATE TABLE `viewdetails` (
  `viewdetail_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL DEFAULT '0',
  `tracking_data` varchar(250) NOT NULL DEFAULT '',
  `from_data` varchar(250) NOT NULL DEFAULT '',
  `by_data` varchar(250) NOT NULL DEFAULT '',
  `documenttype_data` varchar(250) NOT NULL DEFAULT '',
  `details_data` varchar(50000) NOT NULL DEFAULT '',
  `purpose_data` varchar(250) NOT NULL DEFAULT '',
  `to_data` varchar(250) NOT NULL DEFAULT '',
  `postedtime_data` varchar(250) NOT NULL DEFAULT '',
  `status` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`viewdetail_ID`,`tracking_data`)
) ENGINE=InnoDB AUTO_INCREMENT=1377 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_tracking`.`viewdetails`
--

/*!40000 ALTER TABLE `viewdetails` DISABLE KEYS */;
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1333,66,'20200115-0001','BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 4:15:53 AM','Ongoing'),
 (1334,66,'20200115-0001','BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 4:20:33 AM','Received'),
 (1335,66,'20200115-0001','BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:21:1 AM','Forwarded'),
 (1336,66,'20200115-0001','BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:46:48 AM','Received'),
 (1337,66,'20200115-0001','BSIT Faculty','Wingo TheGreat','Leave Form','Please type text','For approval','Dean of ICE','Jan / 15 / 2020 / 4:47:32 AM','Done'),
 (1338,50,'20200115-0002','BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 5:36:20 AM','Ongoing'),
 (1339,50,'20200115-0002','BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ICE','Jan / 15 / 2020 / 5:36:37 AM','Received');
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1340,50,'20200115-0002','BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:36:50 AM','Forwarded'),
 (1341,50,'20200115-0002','BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:37:23 AM','Received'),
 (1342,50,'20200115-0002','BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Jonathan Cabrera','Jan / 15 / 2020 / 5:37:29 AM','Done'),
 (1343,50,'20200115-0003','BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','Head of ICE','Jan / 15 / 2020 / 5:38:16 AM','Ongoing'),
 (1344,41,'20200115-0004','President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:39:1 AM','Ongoing'),
 (1345,50,'20200115-0003','BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','Head of ICE','Jan / 15 / 2020 / 5:39:27 AM','Received');
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1346,41,'20200115-0004','President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:39:31 AM','Received'),
 (1347,50,'20200115-0003','BSIT Faculty','Jonathan Cabrera','PRR','1 billion money','For approval','ar-jay sacay','Jan / 15 / 2020 / 5:39:42 AM','Done'),
 (1348,41,'20200115-0004','President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','ar-jay sacay','Jan / 15 / 2020 / 5:39:55 AM','Done'),
 (1349,41,'20200115-0004','President','Edito Sumile','Tagbo sa purok','mag tagbo ta ninyo','For approval','For Everyone','Jan / 15 / 2020 / 5:40:10 AM','Received'),
 (1350,50,'20200116-0005','BSIT Faculty','Jonathan Cabrera','Request Form','Please type text','For approval','Head of ITSU','Jan / 16 / 2020 / 2:55:8 AM','Ongoing'),
 (1351,50,'20200117-0006','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 7:26:44 PM','Ongoing'),
 (1352,50,'20200117-0007','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 7:31:22 PM','Ongoing');
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1353,50,'20200117-0008','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 7:31:57 PM','Ongoing'),
 (1354,50,'20200117-0009','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ICE','Jan / 17 / 2020 / 7:41:8 PM','Ongoing'),
 (1355,50,'20200117-0010','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ICE','Jan / 17 / 2020 / 7:43:26 PM','Ongoing'),
 (1356,50,'20200117-0011','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ICE','Jan / 17 / 2020 / 7:59:14 PM','Ongoing'),
 (1357,50,'20200117-0012','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 8:6:53 PM','Ongoing'),
 (1358,50,'20200117-0013','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Head of ITSU','Jan / 17 / 2020 / 8:6:58 PM','Ongoing');
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1359,50,'20200127-0014','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:3:13 PM','Ongoing'),
 (1360,50,'20200127-0015','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:5:47 PM','Ongoing'),
 (1361,50,'20200127-0016','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Journal and Publication Office','Jan / 27 / 2020 / 9:6:13 PM','Ongoing'),
 (1362,50,'20200127-0017','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Journal and Publication Office','Jan / 27 / 2020 / 9:6:35 PM','Ongoing'),
 (1363,50,'20200127-0018','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','President of DOSCST Alumni Association','Jan / 27 / 2020 / 9:7:11 PM','Ongoing'),
 (1364,50,'20200127-0019','BSIT Faculty','Jonathan Cabrera','Leave Form','Please type text','For approval','Office of ITSU','Jan / 27 / 2020 / 9:8:25 PM','Ongoing');
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1365,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:13:14 PM','Ongoing'),
 (1366,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Director for Administration Services','Jan / 27 / 2020 / 9:18:39 PM','Received'),
 (1367,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Budget Office','Jan / 27 / 2020 / 9:19:19 PM','Forwarded'),
 (1368,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Budget Office','Jan / 27 / 2020 / 9:20:43 PM','Received'),
 (1369,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Internal Control Unit','Jan / 27 / 2020 / 9:21:13 PM','Forwarded'),
 (1370,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Office of Internal Control Unit','Jan / 27 / 2020 / 9:22:33 PM','Received');
INSERT INTO `viewdetails` (`viewdetail_ID`,`userID`,`tracking_data`,`from_data`,`by_data`,`documenttype_data`,`details_data`,`purpose_data`,`to_data`,`postedtime_data`,`status`) VALUES 
 (1371,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Procurement Office','Jan / 27 / 2020 / 9:22:56 PM','Forwarded'),
 (1372,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Procurement Office','Jan / 27 / 2020 / 9:24:30 PM','Received'),
 (1373,50,'20200127-0020','BSIT Faculty','Jonathan Cabrera','Purchase Request','1 set of computer','For approval','Diego Tan','Jan / 27 / 2020 / 9:24:54 PM','Done'),
 (1374,50,'20200210-0021','BSIT Faculty','Jonathan Cabrera','Utang','Mangutang kog 1000','For approval','Head of ICE','Feb / 10 / 2020 / 10:46:22 PM','Ongoing'),
 (1375,50,'20200222-0022','BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 10:32:17 AM','Ongoing'),
 (1376,50,'20200222-0023','BSIT Faculty','Jonathan Cabrera','Leave Form','pina taka','For approval','Head of ICE','Feb / 22 / 2020 / 1:26:55 PM','Ongoing');
/*!40000 ALTER TABLE `viewdetails` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
