-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.26-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema retobackend
--

CREATE DATABASE IF NOT EXISTS retobackend;
USE retobackend;

--
-- Definition of table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
CREATE TABLE `catalogo` (
  `n_codcat` int(11) NOT NULL default '0',
  `n_coddet` int(11) NOT NULL default '0',
  `c_descri` varchar(50) NOT NULL,
  `c_estado` varchar(1) NOT NULL,
  PRIMARY KEY  (`n_codcat`,`n_coddet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catalogo`
--

/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
INSERT INTO `catalogo` (`n_codcat`,`n_coddet`,`c_descri`,`c_estado`) VALUES 
 (1,1,'DNI','S'),
 (1,6,'RUC','S'),
 (2,1,'AHORRO','S'),
 (2,2,'CORRIENTE','S'),
 (2,3,'CTS','S'),
 (2,4,'DPF','S'),
 (3,1,'GANADORA','S'),
 (3,2,'SUELDO','S'),
 (3,3,'FÁCIL','S'),
 (3,4,'INDEPENDIENTE','S'),
 (4,1,'SOLES','S'),
 (4,2,'DÓLARES','S'),
 (5,1,'RETIRO','S'),
 (5,2,'DEPÓSITO','S'),
 (5,3,'TRANSFERENCIA','S');
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;


--
-- Definition of table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE `cuenta` (
  `n_codcue` int(10) unsigned NOT NULL auto_increment,
  `c_numcue` varchar(20) NOT NULL,
  `n_tipcue` int(11) NOT NULL,
  `n_codpro` int(11) NOT NULL,
  `n_saldos` double NOT NULL,
  `n_codmon` int(11) NOT NULL,
  `n_salmin` double default NULL,
  `n_codper` int(10) unsigned NOT NULL,
  `c_estado` varchar(1) NOT NULL,
  PRIMARY KEY  USING BTREE (`n_codcue`),
  KEY `FK_CUENTA_PERSONA_01` (`n_codper`),
  CONSTRAINT `FK_CUENTA_PERSONA_01` FOREIGN KEY (`n_codper`) REFERENCES `persona` (`n_codper`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cuenta`
--

/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` (`n_codcue`,`c_numcue`,`n_tipcue`,`n_codpro`,`n_saldos`,`n_codmon`,`n_salmin`,`n_codper`,`c_estado`) VALUES 
 (1,'0011-0480-0100208286',1,2,110,1,500,1,'S'),
 (2,'0011-0480-0200208455',1,3,100,2,300,1,'S'),
 (3,'0011-0560-0100208286',2,4,600,1,300,1,'S'),
 (4,'0011-0480-0100205555',1,1,900,1,300,2,'S');
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;


--
-- Definition of table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
CREATE TABLE `movimiento` (
  `n_codmov` int(11) NOT NULL auto_increment,
  `n_monmov` double NOT NULL,
  `d_fecpro` date NOT NULL,
  `n_cueori` int(10) unsigned NOT NULL,
  `n_cuedes` int(10) unsigned NOT NULL,
  `n_tipmov` int(11) NOT NULL,
  `n_codmon` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`n_codmov`),
  KEY `FK_MOVIMIENTO_CUENTA_01` (`n_cueori`),
  KEY `FK_MOVIMIENTO_CUENTA_02` (`n_cuedes`),
  CONSTRAINT `FK_MOVIMIENTO_CUENTA_02` FOREIGN KEY (`n_cuedes`) REFERENCES `cuenta` (`n_codcue`),
  CONSTRAINT `FK_MOVIMIENTO_CUENTA_01` FOREIGN KEY (`n_cueori`) REFERENCES `cuenta` (`n_codcue`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movimiento`
--

/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` (`n_codmov`,`n_monmov`,`d_fecpro`,`n_cueori`,`n_cuedes`,`n_tipmov`,`n_codmon`) VALUES 
 (1,100,'2018-04-09',1,4,3,1),
 (2,100,'2018-04-09',3,4,3,1),
 (3,100,'2018-04-09',1,4,3,1),
 (4,800,'2018-04-09',1,4,3,1),
 (5,700,'2018-04-09',2,4,3,1),
 (6,700,'2018-04-09',3,4,3,1),
 (7,700,'2018-04-09',1,4,3,1),
 (8,700,'2018-04-09',2,4,3,1),
 (9,800,'2018-04-09',3,4,3,1),
 (10,790,'2018-04-09',1,4,3,1),
 (11,800,'2018-04-09',2,4,3,1),
 (12,100,'2018-04-09',3,4,3,1),
 (13,200,'2018-04-09',3,4,3,1);
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;


--
-- Definition of table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `n_codper` int(10) unsigned NOT NULL auto_increment,
  `n_tipdoc` int(11) NOT NULL,
  `c_numdoc` varchar(11) NOT NULL,
  `c_nombre` varchar(50) NOT NULL,
  `c_estado` varchar(1) NOT NULL,
  `c_emaele` varchar(50) default NULL,
  PRIMARY KEY  USING BTREE (`n_codper`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persona`
--

/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`n_codper`,`n_tipdoc`,`c_numdoc`,`c_nombre`,`c_estado`,`c_emaele`) VALUES 
 (1,1,'44556677','JUAN PEREZ RODRIGUEZ','S','javier.meza.1627@gmail.com'),
 (2,1,'12345678','ROSA SÁNCHEZ','S',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
