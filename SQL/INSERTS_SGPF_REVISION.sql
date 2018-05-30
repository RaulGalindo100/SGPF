-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: SGPF
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accion`
--

DROP TABLE IF EXISTS `accion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accion` (
  `idaccion` int(11) NOT NULL AUTO_INCREMENT,
  `nomAccion` varchar(45) NOT NULL,
  `movDatos` char(1) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accion`
--

LOCK TABLES `accion` WRITE;
/*!40000 ALTER TABLE `accion` DISABLE KEYS */;
INSERT INTO `accion` VALUES (1,'Mensaje de error','S','Mensaje de error',1),(2,'Seleccionar Cat├ílogo factor','E','Solicita informaci├│n ',1),(3,'Consultar factores','R','Solicita los factores registrados',1),(4,'Desplegar en pantalla','X','Se despliega informaci├│n en pantalla',1),(5,'Ingresar informaci├│n','E','Ingresa la informaci├│n solicitada en el formulario',1),(6,'Consultar Tipo de factor','E','Solicita los tipos de factores registrados',1),(7,'Validar de datos','R','Se realiza una validaci├│n de datos en sistema',1),(8,'Guardar registro','W','Se guarda el registro en base de datos',1),(9,'Guardar registro en bit├ícora','W','Se guarda el movimiento en bit├ícora',1),(10,'Modificar informaci├│n','E','Se modifica la informaci├│n en el formulario',1),(11,'Mensaje de error con datos','X','Mensaje de error con grupo de datos',1),(12,'Seleccionar eliminar factor','E','Selecciona eliminar el factor',1),(13,'Eliminar factor de BD','W','Se elimina el factor de base de datos',1),(14,'Registrar','E','R',1),(15,'Consultar','R','Cos',1),(16,'Mostrar','X','Mos',1),(17,'Guardar','W','Guar',1);
/*!40000 ALTER TABLE `accion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arqproyecto`
--

DROP TABLE IF EXISTS `arqproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `arqproyecto` (
  `idarqProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `arqProyecto` varchar(45) NOT NULL,
  PRIMARY KEY (`idarqProyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arqproyecto`
--

LOCK TABLES `arqproyecto` WRITE;
/*!40000 ALTER TABLE `arqproyecto` DISABLE KEYS */;
INSERT INTO `arqproyecto` VALUES (1,'Multicapas'),(2,'Standalone'),(3,'Dispositivos M├│viles'),(4,'Desarrollo Web'),(5,'Data Warehouse (DWH)'),(6,'Enterprise Resource Planning (ERP)'),(7,'Otro');
/*!40000 ALTER TABLE `arqproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basedatos`
--

DROP TABLE IF EXISTS `basedatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `basedatos` (
  `idbaseDatos` int(11) NOT NULL AUTO_INCREMENT,
  `baseDatos` varchar(45) NOT NULL,
  PRIMARY KEY (`idbaseDatos`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basedatos`
--

LOCK TABLES `basedatos` WRITE;
/*!40000 ALTER TABLE `basedatos` DISABLE KEYS */;
INSERT INTO `basedatos` VALUES (1,'ORACLE'),(2,'MySQL'),(3,'SQLSERVER'),(4,'DB2'),(5,'ACCESS'),(6,'SYBASE'),(7,'INFORMIX'),(8,'Otro');
/*!40000 ALTER TABLE `basedatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confinfo`
--

DROP TABLE IF EXISTS `confinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `confinfo` (
  `idconfInfo` int(11) NOT NULL AUTO_INCREMENT,
  `confInfo` varchar(250) NOT NULL,
  PRIMARY KEY (`idconfInfo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confinfo`
--

LOCK TABLES `confinfo` WRITE;
/*!40000 ALTER TABLE `confinfo` DISABLE KEYS */;
INSERT INTO `confinfo` VALUES (1,'Tipo A: La informaci├│n es completamente Confiable al 100%, incluso hay evidencias.'),(2,'Tipo B: La informaci├│n en muy confiable, al 75%, pero hay algunos aspectos que no son precisos.'),(3,'Tipo C: La informaci├│n con que se cuenta es confiable aproximadamente a la mitad (50%), hay varios datos imprecisos.'),(4,'Tipo D: La informaci├│n con que se cuenta es poco confiable, al 25%.');
/*!40000 ALTER TABLE `confinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escala`
--

DROP TABLE IF EXISTS `escala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `escala` (
  `idescala` int(11) NOT NULL AUTO_INCREMENT,
  `escala` varchar(45) NOT NULL,
  PRIMARY KEY (`idescala`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escala`
--

LOCK TABLES `escala` WRITE;
/*!40000 ALTER TABLE `escala` DISABLE KEYS */;
INSERT INTO `escala` VALUES (1,'D├¡as'),(2,'Semanas'),(3,'Meses'),(4,'A├▒os');
/*!40000 ALTER TABLE `escala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flujoalterno`
--

DROP TABLE IF EXISTS `flujoalterno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flujoalterno` (
  `idflujoAlterno` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(250) NOT NULL,
  `idusuarioFuncional` int(11) DEFAULT NULL,
  `idaccion` int(11) DEFAULT NULL,
  `idgrupoDato` int(11) DEFAULT NULL,
  `idsubProceso` int(11) DEFAULT NULL,
  `actividad` varchar(45) NOT NULL,
  PRIMARY KEY (`idflujoAlterno`),
  UNIQUE KEY `flujoAlternoGpoDato_idx` (`idsubProceso`,`idgrupoDato`),
  KEY `FA_idusuarioFuncional_fk_idx` (`idusuarioFuncional`),
  KEY `FA_idaccion_fk_idx` (`idaccion`),
  KEY `FA_idgrupoDato_fk_idx` (`idgrupoDato`),
  KEY `FA_idsubProceso_fk_idx` (`idsubProceso`),
  CONSTRAINT `FA_idaccion_fk` FOREIGN KEY (`idaccion`) REFERENCES `accion` (`idaccion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FA_idgrupoDato_fk` FOREIGN KEY (`idgrupoDato`) REFERENCES `grupodato` (`idgrupodato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FA_idsubProceso_fk` FOREIGN KEY (`idsubProceso`) REFERENCES `subproceso` (`idsubproceso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FA_idusuarioFuncional_fk` FOREIGN KEY (`idusuarioFuncional`) REFERENCES `usuariofuncional` (`idusuariofuncional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flujoalterno`
--

LOCK TABLES `flujoalterno` WRITE;
/*!40000 ALTER TABLE `flujoalterno` DISABLE KEYS */;
INSERT INTO `flujoalterno` VALUES (1,'Si en la consulta no hay factores registrados en el sistema, despliega un mensaje NO HAY FACTORES REGISTRADOS EN EL SISTEMA.',1,1,1,3,'Inicio de Proceso Funcional'),(2,'Si el campo validado est├í vac├¡o muestra el mensaje de error INFORMACI├ôN INCOMPLETA',1,1,1,2,'Inicio de Proceso Funcional'),(3,'Si el campo validado est├í vac├¡o muestra el mensaje de error INFORMACI├ôN INCOMPLETA',1,1,1,17,'Inicio de Proceso Funcional'),(5,'Si el empleado ya existe, manda un mensaje de error \"empleado existente\"',1,1,11,25,'Inicio de Proceso Funcional'),(6,'Mensaje de error \"no hay empleados\"',1,1,1,30,'Inicio de Proceso Funcional');
/*!40000 ALTER TABLE `flujoalterno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupodato`
--

DROP TABLE IF EXISTS `grupodato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupodato` (
  `idgrupoDato` int(11) NOT NULL AUTO_INCREMENT,
  `nomGD` varchar(45) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idgrupoDato`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupodato`
--

LOCK TABLES `grupodato` WRITE;
/*!40000 ALTER TABLE `grupodato` DISABLE KEYS */;
INSERT INTO `grupodato` VALUES (1,'N/A','N/A',1),(2,'Datos de factor','El objeto de inter├®s es Factor',1),(3,'Tipo de Factor','El objeto de inter├®s es Tipo de Factor',1),(4,'Datos de Bit├ícora','El objeto de inter├®s es Bit├ícora de movimientos',1),(5,'Comando','Comando para solicitar alguna informaci├│n',1),(11,'Empleado','Empleado',1);
/*!40000 ALTER TABLE `grupodato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico`
--

DROP TABLE IF EXISTS `historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historico` (
  `idhistorico` int(11) NOT NULL AUTO_INCREMENT,
  `idProy` int(11) NOT NULL,
  `nombreProy` varchar(250) NOT NULL,
  `alcanceProy` varchar(250) NOT NULL,
  `nombrePF` varchar(250) NOT NULL,
  `descripcionPF` varchar(250) NOT NULL,
  `tamanio` int(11) NOT NULL,
  `eventoDesPF` varchar(250) NOT NULL,
  `descripcionSP` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `nombreGD` varchar(250) NOT NULL,
  `proposito` varchar(250) NOT NULL,
  `descripcionGD` varchar(250) NOT NULL,
  `nombreUF` varchar(250) NOT NULL,
  `descripcionUF` varchar(250) NOT NULL,
  `usuarioSistemaUF` tinyint(4) NOT NULL,
  `nombreAccion` varchar(250) NOT NULL,
  `movDatos` char(1) NOT NULL,
  PRIMARY KEY (`idhistorico`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico`
--

LOCK TABLES `historico` WRITE;
/*!40000 ALTER TABLE `historico` DISABLE KEYS */;
INSERT INTO `historico` VALUES (1,1,'Ejemplo 1.02 Medici├│n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Administrador selecciona del men├║ Administrar la opci├│n Cat├ílogo Factor','2018-05-30','Comando','Determinar el tama├▒o funcional del cso de uso Administrar Factores','Comando para solicitar alguna informaci├│n','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Seleccionar Cat├ílogo factor','E'),(2,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Administrador selecciona del men├║ Administrar la opci├│n Cat├ílogo Factor','2018-05-30','Comando','Determinar el tama??o funcional del cso de uso Administrar Factores','Comando para solicitar alguna informaci├│n','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Seleccionar Cat├ílogo factor','E'),(3,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Sistema consulta los factores registrados en el sistema.','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Consultar factores','R'),(4,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Sistema despliega la pantalla Consultar factor, donde se muestra la tabla de consutla de factores registrados en el sistema','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Desplegar en pantalla','X'),(5,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Administrador ingresa la informaci├│n solicitada en el formulario y confirma guardar el registro','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Ingresar informaci├│n','E'),(6,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema consulta los Tipos de Factores registrados en el sistema','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Consultar Tipo de factor','E'),(7,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema muestra el formulario de captura con lista desplegable de Tipo.','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Desplegar en pantalla','X'),(8,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema realiza validaciones para: 1) Campo vac├¡o 2) Informaci├│n registrada previamente','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Validar de datos','R'),(9,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema guarda el registro en Base de datos y cierra la pantalla de captura','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Guardar registro','W'),(10,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema guarda el registro del movimiento en la bit├ícora en base de datos','2018-05-30','Datos de Bit├ícora','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Bit├ícora de movimientos','Sistema','Sistema Administrar Factores',1,'Guardar registro en bit├ícora','W'),(11,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos','2018-05-30','N/A','Determinar el tama??o funcional del cso de uso Administrar Factores','N/A','Sistema','Sistema Administrar Factores',1,'Mensaje de error','S'),(12,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Administrador modifica la informaci├│n que desea del formulario. Confirma guardar el registro','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Modificar informaci├│n','E'),(13,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema consulta los Tipos de Factores registrados en el sistema','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Consultar Tipo de factor','E'),(14,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema muestra el formulario de captura con lista desplegable de Tipo.','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Desplegar en pantalla','X'),(15,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema realiza validaciones para: 1) Campo vac├¡o 2) Informaci├│n registrada previamente','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Validar de datos','R'),(16,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema guarda el registro en Base de datos y cierra la pantalla de captura','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Guardar registro','W'),(17,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema guarda el registro del movimiento en la bit├ícora en base de datos','2018-05-30','Datos de Bit├ícora','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Bit├ícora de movimientos','Sistema','Sistema Administrar Factores',1,'Guardar registro en bit├ícora','W'),(18,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos','2018-05-30','N/A','Determinar el tama??o funcional del cso de uso Administrar Factores','N/A','Sistema','Sistema Administrar Factores',1,'Mensaje de error','S'),(19,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Usuario selecciona la opci├│n Eliminar factor','2018-05-30','Comando','Determinar el tama??o funcional del cso de uso Administrar Factores','Comando para solicitar alguna informaci├│n','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Seleccionar eliminar factor','E'),(20,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema despliega mensaje ┬┐Est├í seguro que desea eliminar el factor [Nombre]?','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Mensaje de error con datos','X'),(21,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema elimina el registro en base de datos','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Eliminar factor de BD','W'),(22,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema guarda el registro del movimiento en la bit├ícora en base de datos','2018-05-30','Datos de Bit├ícora','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Bit├ícora de movimientos','Sistema','Sistema Administrar Factores',1,'Guardar registro en bit├ícora','W'),(23,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos','2018-05-30','N/A','Determinar el tama??o funcional del cso de uso Administrar Factores','N/A','Sistema','Sistema Administrar Factores',1,'Mensaje de error','S'),(24,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Administrador selecciona del men├║ Administrar la opci├│n Cat├ílogo Factor','2018-05-30','Comando','Determinar el tama??o funcional del cso de uso Administrar Factores','Comando para solicitar alguna informaci├│n','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Seleccionar Cat├ílogo factor','E'),(25,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Sistema consulta los factores registrados en el sistema.','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Consultar factores','R'),(26,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Consultar factores','Consultar factores',4,'Usuario desea consultar los factores registrados en el sistema','Sistema despliega la pantalla Consultar factor, donde se muestra la tabla de consutla de factores registrados en el sistema','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Desplegar en pantalla','X'),(27,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Administrador ingresa la informaci├│n solicitada en el formulario y confirma guardar el registro','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Ingresar informaci├│n','E'),(28,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema consulta los Tipos de Factores registrados en el sistema','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Consultar Tipo de factor','E'),(29,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema muestra el formulario de captura con lista desplegable de Tipo.','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Desplegar en pantalla','X'),(30,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema realiza validaciones para: 1) Campo vac├¡o 2) Informaci├│n registrada previamente','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Validar de datos','R'),(31,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema guarda el registro en Base de datos y cierra la pantalla de captura','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Guardar registro','W'),(32,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema guarda el registro del movimiento en la bit├ícora en base de datos','2018-05-30','Datos de Bit├ícora','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Bit├ícora de movimientos','Sistema','Sistema Administrar Factores',1,'Guardar registro en bit├ícora','W'),(33,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Agregar factor','Agregar factor',7,'Usuario desea crear un factor','Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos','2018-05-30','N/A','Determinar el tama??o funcional del cso de uso Administrar Factores','N/A','Sistema','Sistema Administrar Factores',1,'Mensaje de error','S'),(34,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Administrador modifica la informaci├│n que desea del formulario. Confirma guardar el registro','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Modificar informaci├│n','E'),(35,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema consulta los Tipos de Factores registrados en el sistema','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Consultar Tipo de factor','E'),(36,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema muestra el formulario de captura con lista desplegable de Tipo.','2018-05-30','Tipo de Factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Tipo de Factor','Sistema','Sistema Administrar Factores',1,'Desplegar en pantalla','X'),(37,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema realiza validaciones para: 1) Campo vac├¡o 2) Informaci├│n registrada previamente','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Validar de datos','R'),(38,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema guarda el registro en Base de datos y cierra la pantalla de captura','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Guardar registro','W'),(39,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema guarda el registro del movimiento en la bit├ícora en base de datos','2018-05-30','Datos de Bit├ícora','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Bit├ícora de movimientos','Sistema','Sistema Administrar Factores',1,'Guardar registro en bit├ícora','W'),(40,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Modificar factor','Modificar factor',7,'Usuario desea modificar la informaci├│n de un factor','Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos','2018-05-30','N/A','Determinar el tama??o funcional del cso de uso Administrar Factores','N/A','Sistema','Sistema Administrar Factores',1,'Mensaje de error','S'),(41,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Usuario selecciona la opci├│n Eliminar factor','2018-05-30','Comando','Determinar el tama??o funcional del cso de uso Administrar Factores','Comando para solicitar alguna informaci├│n','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Seleccionar eliminar factor','E'),(42,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema despliega mensaje ┬┐Est├í seguro que desea eliminar el factor [Nombre]?','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Mensaje de error con datos','X'),(43,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema elimina el registro en base de datos','2018-05-30','Datos de factor','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Factor','Sistema','Sistema Administrar Factores',1,'Eliminar factor de BD','W'),(44,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema guarda el registro del movimiento en la bit├ícora en base de datos','2018-05-30','Datos de Bit├ícora','Determinar el tama??o funcional del cso de uso Administrar Factores','El objeto de inter├®s es Bit├ícora de movimientos','Sistema','Sistema Administrar Factores',1,'Guardar registro en bit├ícora','W'),(45,1,'Ejemplo 1.02 Medici??n','Global. Se considera toda la funcionalidad del caso de uso','Eliminar factor','Eliminar factor',5,'Usuario desea eliminar un factor','Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos','2018-05-30','N/A','Determinar el tama??o funcional del cso de uso Administrar Factores','N/A','Sistema','Sistema Administrar Factores',1,'Mensaje de error','S'),(46,5,'Recursos Humanos','demk','Alta de Empleado','Alta empleado ',0,'Llega un nuevo empleado','Registro de empleado','2018-05-30','Empleado','prop','Empleado','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Registrar','E'),(47,5,'Recursos Humanos','demk','Alta de Empleado','Alta empleado ',0,'Llega un nuevo empleado','El sistema valida que no exista el empleado','2018-05-30','Empleado','prop','Empleado','Sistemas','Sistema Administrar Factores',1,'Consultar','R'),(48,5,'Recursos Humanos','demk','Alta de Empleado','Alta empleado ',0,'Llega un nuevo empleado','Se guarda la info','2018-05-30','Empleado','prop','Empleado','Sistemas','Sistema Administrar Factores',1,'Guardar registro','W'),(49,5,'Recursos Humanos','demk','Alta de Empleado','Alta empleado ',0,'Llega un nuevo empleado','Envia mensaje \"empleado X registrado\"','2018-05-30','Empleado','prop','Empleado','Sistemas','Sistema Administrar Factores',1,'Mostrar','X'),(50,5,'Recursos Humanos','demk','Alta de Empleado','Alta empleado ',0,'Llega un nuevo empleado','Fin','2018-05-30','N/A','prop','N/A','Sistemas','Sistema Administrar Factores',1,'Mensaje de error','S'),(51,5,'Recursos Humanos','demk','Modificar Datos de Empleado','Modificar datos ',0,'El empleado cambio su informacion','Consultar empleado','2018-05-30','Empleado','prop','Empleado','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Consultar','R'),(52,5,'Recursos Humanos','demk','Modificar Datos de Empleado','Modificar datos ',0,'El empleado cambio su informacion','Se muestra el empleado','2018-05-30','Empleado','prop','Empleado','Sistemas','Sistema Administrar Factores',1,'Mostrar','X'),(53,5,'Recursos Humanos','demk','Modificar Datos de Empleado','Modificar datos ',0,'El empleado cambio su informacion','Lo que sea','2018-05-30','Empleado','prop','Empleado','Administrador','Adminstrador del sistema Adminsitrar Factores',0,'Registrar','E'),(54,5,'Recursos Humanos','demk','Modificar Datos de Empleado','Modificar datos ',0,'El empleado cambio su informacion','Registra datos en almacenamiento persistente','2018-05-30','Empleado','prop','Empleado','Sistemas','Sistema Administrar Factores',1,'Guardar','W'),(55,5,'Recursos Humanos','demk','Modificar Datos de Empleado','Modificar datos ',0,'El empleado cambio su informacion','Envia mensaje','2018-05-30','N/A','prop','N/A','Sistemas','Sistema Administrar Factores',1,'Mensaje de error','S'),(56,5,'Recursos Humanos','demk','Modificar Datos de Empleado','Modificar datos ',0,'El empleado cambio su informacion','Regresa a la pantalla inicial','2018-05-30','N/A','prop','N/A','Sistemas','Sistema Administrar Factores',1,'Mensaje de error','S');
/*!40000 ALTER TABLE `historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interup`
--

DROP TABLE IF EXISTS `interup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interup` (
  `idinterUP` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `idproyecto` int(11) NOT NULL,
  PRIMARY KEY (`idinterUP`),
  UNIQUE KEY `USUARIO-PROY` (`idusuario`,`idproyecto`),
  KEY `idusuario_idx` (`idusuario`),
  KEY `idproyecto_idx` (`idproyecto`),
  CONSTRAINT `idproyecto1` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`),
  CONSTRAINT `idusuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interup`
--

LOCK TABLES `interup` WRITE;
/*!40000 ALTER TABLE `interup` DISABLE KEYS */;
INSERT INTO `interup` VALUES (1,1,1),(9,1,5),(2,2,1),(3,3,1),(8,4,1);
/*!40000 ALTER TABLE `interup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lenguaje`
--

DROP TABLE IF EXISTS `lenguaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lenguaje` (
  `idlenguaje` int(11) NOT NULL AUTO_INCREMENT,
  `lenguaje` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idlenguaje`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lenguaje`
--

LOCK TABLES `lenguaje` WRITE;
/*!40000 ALTER TABLE `lenguaje` DISABLE KEYS */;
INSERT INTO `lenguaje` VALUES (1,'JAVA/J2EE'),(2,'C#'),(3,'C++'),(4,'ASP.NET'),(5,'ADA'),(6,'Cobol'),(7,'PHP'),(8,'JavaScript'),(9,'PL'),(10,'SAP/ABAP'),(11,'Otro');
/*!40000 ALTER TABLE `lenguaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcoposusa`
--

DROP TABLE IF EXISTS `marcoposusa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marcoposusa` (
  `idmarcoPosUsa` int(11) NOT NULL AUTO_INCREMENT,
  `marcoPosUsa` varchar(45) NOT NULL,
  PRIMARY KEY (`idmarcoPosUsa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcoposusa`
--

LOCK TABLES `marcoposusa` WRITE;
/*!40000 ALTER TABLE `marcoposusa` DISABLE KEYS */;
INSERT INTO `marcoposusa` VALUES (1,'MAAGTICSI'),(2,'CMMI'),(3,'RUP'),(4,'Otro');
/*!40000 ALTER TABLE `marcoposusa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metdesarrollo`
--

DROP TABLE IF EXISTS `metdesarrollo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `metdesarrollo` (
  `idmetDesarrollo` int(11) NOT NULL AUTO_INCREMENT,
  `metDesarrollo` varchar(45) NOT NULL,
  PRIMARY KEY (`idmetDesarrollo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metdesarrollo`
--

LOCK TABLES `metdesarrollo` WRITE;
/*!40000 ALTER TABLE `metdesarrollo` DISABLE KEYS */;
INSERT INTO `metdesarrollo` VALUES (1,'CASCADA'),(2,'ITERATIVO'),(3,'├üGIL'),(4,'Otro');
/*!40000 ALTER TABLE `metdesarrollo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metmedicion`
--

DROP TABLE IF EXISTS `metmedicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `metmedicion` (
  `idmetMedicion` int(11) NOT NULL AUTO_INCREMENT,
  `metMedicion` varchar(45) NOT NULL,
  PRIMARY KEY (`idmetMedicion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metmedicion`
--

LOCK TABLES `metmedicion` WRITE;
/*!40000 ALTER TABLE `metmedicion` DISABLE KEYS */;
INSERT INTO `metmedicion` VALUES (1,'COSMIC ISO 19761'),(2,'IFPUG ISO 20926'),(3,'MKII ISO 20698'),(4,'NESMA ISO 24570'),(5,'FISMA ISO29881');
/*!40000 ALTER TABLE `metmedicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modcalidad`
--

DROP TABLE IF EXISTS `modcalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `modcalidad` (
  `idmodCalidad` int(11) NOT NULL AUTO_INCREMENT,
  `modCalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idmodCalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modcalidad`
--

LOCK TABLES `modcalidad` WRITE;
/*!40000 ALTER TABLE `modcalidad` DISABLE KEYS */;
INSERT INTO `modcalidad` VALUES (1,'CMMI-DEV'),(2,'NMX-MoProsoft'),(3,'ISO/IEC 29110'),(4,'ISO 9000'),(5,'Otro');
/*!40000 ALTER TABLE `modcalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesofuncional`
--

DROP TABLE IF EXISTS `procesofuncional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `procesofuncional` (
  `idprocesoFuncional` int(11) NOT NULL AUTO_INCREMENT,
  `nomPF` varchar(45) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `eventoDes` varchar(250) NOT NULL,
  `idproyecto` int(11) NOT NULL,
  `tamPF` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idprocesoFuncional`),
  KEY `idproyecto_idx` (`idproyecto`),
  CONSTRAINT `idproyecto` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesofuncional`
--

LOCK TABLES `procesofuncional` WRITE;
/*!40000 ALTER TABLE `procesofuncional` DISABLE KEYS */;
INSERT INTO `procesofuncional` VALUES (1,'Consultar factores','Consultar factores','Usuario desea consultar los factores registrados en el sistema',1,4,1),(2,'Agregar factor','Agregar factor','Usuario desea crear un factor',1,7,1),(3,'Modificar factor','Modificar factor','Usuario desea modificar la informaci├│n de un factor',1,7,1),(4,'Eliminar factor','Eliminar factor','Usuario desea eliminar un factor',1,5,1),(8,'Mi Proceso Funcional','','Genial',5,0,0),(9,'Alta de Empleado','Alta empleado ','Llega un nuevo empleado',5,0,1),(10,'Modificar Datos de Empleado','Modificar datos ','El empleado cambio su informacion',5,0,1),(11,'Ultimo','Ultimo','Ultimo',5,0,0);
/*!40000 ALTER TABLE `procesofuncional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proyecto` (
  `idproyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nomProy` varchar(60) DEFAULT NULL,
  `anioProy` varchar(4) DEFAULT NULL,
  `operProy` tinyint(4) DEFAULT NULL,
  `duraProy` decimal(9,2) DEFAULT NULL,
  `esfuTotProy` decimal(9,2) DEFAULT NULL,
  `esfuPlaneProy` decimal(9,2) DEFAULT NULL,
  `esfuEsReqProy` decimal(9,2) DEFAULT NULL,
  `esfuAnaDisProy` decimal(9,2) DEFAULT NULL,
  `esfuConstProy` decimal(9,2) DEFAULT NULL,
  `esfuPrueProy` decimal(9,2) DEFAULT NULL,
  `esfuImpleDesProy` decimal(9,2) DEFAULT NULL,
  `costTotProy` decimal(9,2) DEFAULT NULL,
  `costEsReqProy` decimal(9,2) DEFAULT NULL,
  `costAnaDisProy` decimal(9,2) DEFAULT NULL,
  `costConstProy` decimal(9,2) DEFAULT NULL,
  `costPrueProy` decimal(9,2) DEFAULT NULL,
  `costImpleDesProy` decimal(9,2) DEFAULT NULL,
  `tamFunProy` decimal(9,2) DEFAULT NULL,
  `fpAjusProy` decimal(9,2) DEFAULT NULL,
  `medidorCertProy` tinyint(4) DEFAULT NULL,
  `expeMedMetProy` int(11) DEFAULT NULL,
  `usoCase` tinyint(4) DEFAULT NULL,
  `certModelo` tinyint(4) DEFAULT NULL,
  `comCertModelo` varchar(250) DEFAULT NULL,
  `costPlanProy` decimal(11,2) DEFAULT NULL,
  `idconfInfo` int(11) DEFAULT NULL,
  `idarqProyecto` int(11) DEFAULT NULL,
  `idmetDesarrollo` int(11) DEFAULT NULL,
  `idmetMedicion` int(11) DEFAULT NULL,
  `idsisOpe` int(11) DEFAULT NULL,
  `idTipoDesarrollo` int(11) DEFAULT NULL,
  `idlenguaje` int(11) DEFAULT NULL,
  `idmodCalidad` int(11) DEFAULT NULL,
  `idbaseDatos` int(11) DEFAULT NULL,
  `idsectorOrganizacion` int(11) DEFAULT NULL,
  `estatus` tinyint(4) DEFAULT NULL,
  `idtipoOrganizacion` int(11) DEFAULT NULL,
  `idtipoCapDes` int(11) DEFAULT NULL,
  `idtamOrgDes` int(11) DEFAULT NULL,
  `tamOrgUsa` int(11) DEFAULT NULL,
  `idmarcoPosUsa` int(11) DEFAULT NULL,
  `idescala` int(11) DEFAULT NULL,
  `proposito` varchar(250) DEFAULT NULL,
  `alcance` varchar(250) DEFAULT NULL,
  `estimacionCosto` decimal(9,2) DEFAULT NULL,
  `estimacionEsfuerzo` decimal(9,2) DEFAULT NULL,
  `estimacionDuracion` decimal(9,2) DEFAULT NULL,
  `idescalaEstimacionDuracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  KEY `idTipoDesarrollo_fk_idx` (`idTipoDesarrollo`),
  KEY `sectorOrganizacion_fk_idx` (`idsectorOrganizacion`),
  KEY `tipoOrganizacion_fk_idx` (`idtipoOrganizacion`),
  KEY `tipoCapOrg_fk_idx` (`idtipoCapDes`),
  KEY `tamOrgDes_fk_idx` (`idtamOrgDes`),
  KEY `tamOrgUsa_fk_idx` (`tamOrgUsa`),
  KEY `arqProyecto_fk_idx` (`idarqProyecto`),
  KEY `lenguaje_fk_idx` (`idlenguaje`),
  KEY `sisOpe_fk_idx` (`idsisOpe`),
  KEY `baseDatos_fk_idx` (`idbaseDatos`),
  KEY `metDesarrollo_fk_idx` (`idmetDesarrollo`),
  KEY `marcoPosUsa_fk_idx` (`idmarcoPosUsa`),
  KEY `modCalidad_fk_idx` (`idmodCalidad`),
  KEY `escala_fk_idx` (`idescala`),
  KEY `metMedicion_fk_idx` (`idmetMedicion`),
  KEY `idescalaEstimacionDuracion_fk_idx` (`idescalaEstimacionDuracion`),
  KEY `confInfo_fk` (`idconfInfo`),
  CONSTRAINT `TipoDesarrollo_fk` FOREIGN KEY (`idTipoDesarrollo`) REFERENCES `tipodedesarrollo` (`idtipodedesarrollo`),
  CONSTRAINT `arqProyecto_fk` FOREIGN KEY (`idarqProyecto`) REFERENCES `arqproyecto` (`idarqproyecto`),
  CONSTRAINT `baseDatos_fk` FOREIGN KEY (`idbaseDatos`) REFERENCES `basedatos` (`idbasedatos`),
  CONSTRAINT `confInfo_fk` FOREIGN KEY (`idconfInfo`) REFERENCES `confinfo` (`idconfinfo`),
  CONSTRAINT `escala_fk` FOREIGN KEY (`idescala`) REFERENCES `escala` (`idescala`),
  CONSTRAINT `idescalaEstimacionDuracion_fk` FOREIGN KEY (`idescalaEstimacionDuracion`) REFERENCES `escala` (`idescala`),
  CONSTRAINT `lenguaje_fk` FOREIGN KEY (`idlenguaje`) REFERENCES `lenguaje` (`idlenguaje`),
  CONSTRAINT `marcoPosUsa_fk` FOREIGN KEY (`idmarcoPosUsa`) REFERENCES `marcoposusa` (`idmarcoposusa`),
  CONSTRAINT `metDesarrollo_fk` FOREIGN KEY (`idmetDesarrollo`) REFERENCES `metdesarrollo` (`idmetdesarrollo`),
  CONSTRAINT `metMedicion_fk` FOREIGN KEY (`idmetMedicion`) REFERENCES `metmedicion` (`idmetmedicion`),
  CONSTRAINT `modCalidad_fk` FOREIGN KEY (`idmodCalidad`) REFERENCES `modcalidad` (`idmodcalidad`),
  CONSTRAINT `sectorOrganizacion_fk` FOREIGN KEY (`idsectorOrganizacion`) REFERENCES `sectororganizacion` (`idsectororganizacion`),
  CONSTRAINT `sisOpe_fk` FOREIGN KEY (`idsisOpe`) REFERENCES `sisope` (`idsisope`),
  CONSTRAINT `tamOrgDes_fk` FOREIGN KEY (`idtamOrgDes`) REFERENCES `tamorg` (`idtamorgdes`),
  CONSTRAINT `tamOrgUsa_fk` FOREIGN KEY (`tamOrgUsa`) REFERENCES `tamorg` (`idtamorgdes`),
  CONSTRAINT `tipoCapDes_fk` FOREIGN KEY (`idtipoCapDes`) REFERENCES `tipocapdes` (`idtipocapdes`),
  CONSTRAINT `tipoOrganizacion_fk` FOREIGN KEY (`idtipoOrganizacion`) REFERENCES `tipoorganizacion` (`idtipoorganizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'Ejemplo 1.02 Medici??n','2017',0,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,23.00,0.00,0,0,0,0,'Ning??n comentario',0.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'Determinar el tama??o funcional del cso de uso Administrar Factores','Global. Se considera toda la funcionalidad del caso de uso',0.00,0.00,0.00,1),(5,'Recursos Humanos','2018',0,12.00,1.00,323.00,234.00,34.00,34.00,43.00,45.00,32.00,767.00,45.00,2.00,56.00,23.00,12.00,220.00,0,1,1,1,'No se cuenta con certificación',54.00,4,1,1,1,1,1,1,1,1,4,1,10,1,1,1,1,1,'prop','demk',0.00,0.00,0.00,1);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sectororganizacion`
--

DROP TABLE IF EXISTS `sectororganizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sectororganizacion` (
  `idsectorOrganizacion` int(11) NOT NULL AUTO_INCREMENT,
  `sectorOrganizacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idsectorOrganizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sectororganizacion`
--

LOCK TABLES `sectororganizacion` WRITE;
/*!40000 ALTER TABLE `sectororganizacion` DISABLE KEYS */;
INSERT INTO `sectororganizacion` VALUES (1,'Gobierno Federal'),(2,'Gobierno Estatal'),(3,'Gobierno Local'),(4,'Privado'),(5,'Otro');
/*!40000 ALTER TABLE `sectororganizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sisope`
--

DROP TABLE IF EXISTS `sisope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sisope` (
  `idsisOpe` int(11) NOT NULL AUTO_INCREMENT,
  `sisOpe` varchar(45) NOT NULL,
  PRIMARY KEY (`idsisOpe`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sisope`
--

LOCK TABLES `sisope` WRITE;
/*!40000 ALTER TABLE `sisope` DISABLE KEYS */;
INSERT INTO `sisope` VALUES (1,'Linux'),(2,'UNIX'),(3,'Windows'),(4,'Windows XP'),(5,'Windows Vista'),(6,'Windows 7/8'),(7,'Windows 10'),(8,'IOS'),(9,'Android'),(10,'Windows Mobile'),(11,'Windows NT'),(12,'Android'),(13,'IOS'),(14,'Otro');
/*!40000 ALTER TABLE `sisope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subproceso`
--

DROP TABLE IF EXISTS `subproceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subproceso` (
  `idsubProceso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(250) NOT NULL,
  `idusuarioFuncional` int(11) NOT NULL,
  `idaccion` int(11) NOT NULL,
  `idgrupoDato` int(11) NOT NULL,
  `idprocesoFuncional` int(11) NOT NULL,
  `actividad` varchar(45) NOT NULL,
  `indice` int(11) NOT NULL,
  `indiceActividad` int(11) NOT NULL,
  PRIMARY KEY (`idsubProceso`),
  KEY `idusuarioFuncional_idx` (`idusuarioFuncional`),
  KEY `idaccion_idx` (`idaccion`),
  KEY `idgrupoDato_idx` (`idgrupoDato`),
  KEY `idprocesoFuncional_idx` (`idprocesoFuncional`),
  CONSTRAINT `idaccion` FOREIGN KEY (`idaccion`) REFERENCES `accion` (`idaccion`),
  CONSTRAINT `idgrupoDato` FOREIGN KEY (`idgrupoDato`) REFERENCES `grupodato` (`idgrupodato`),
  CONSTRAINT `idprocesoFuncional` FOREIGN KEY (`idprocesoFuncional`) REFERENCES `procesofuncional` (`idprocesofuncional`),
  CONSTRAINT `idusuarioFuncional` FOREIGN KEY (`idusuarioFuncional`) REFERENCES `usuariofuncional` (`idusuariofuncional`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subproceso`
--

LOCK TABLES `subproceso` WRITE;
/*!40000 ALTER TABLE `subproceso` DISABLE KEYS */;
INSERT INTO `subproceso` VALUES (1,'Administrador selecciona del men├║ Administrar la opci├│n Cat├ílogo Factor',2,2,5,1,'Inicio de Proceso Funcional',1,1),(2,'Sistema consulta los factores registrados en el sistema.',1,3,2,1,'Inicio de Proceso Funcional',2,1),(3,'Sistema despliega la pantalla Consultar factor, donde se muestra la tabla de consutla de factores registrados en el sistema',1,4,2,1,'Inicio de Proceso Funcional',3,1),(4,'Administrador ingresa la informaci├│n solicitada en el formulario y confirma guardar el registro',2,5,2,2,'Inicio de Proceso Funcional',1,1),(5,'Sistema consulta los Tipos de Factores registrados en el sistema',1,6,3,2,'Inicio de Proceso Funcional',2,1),(6,'Sistema muestra el formulario de captura con lista desplegable de Tipo.',1,4,3,2,'Inicio de Proceso Funcional',3,1),(7,'Sistema realiza validaciones para: 1) Campo vac├¡o 2) Informaci├│n registrada previamente',1,7,2,2,'Inicio de Proceso Funcional',4,1),(8,'Sistema guarda el registro en Base de datos y cierra la pantalla de captura',1,8,2,2,'Inicio de Proceso Funcional',5,1),(9,'Sistema guarda el registro del movimiento en la bit├ícora en base de datos',1,9,4,2,'Inicio de Proceso Funcional',6,1),(10,'Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos',1,1,1,2,'Inicio de Proceso Funcional',7,1),(11,'Administrador modifica la informaci├│n que desea del formulario. Confirma guardar el registro',2,10,2,3,'Inicio de Proceso Funcional',1,1),(12,'Sistema consulta los Tipos de Factores registrados en el sistema',1,6,3,3,'Inicio de Proceso Funcional',2,1),(13,'Sistema muestra el formulario de captura con lista desplegable de Tipo.',1,4,3,3,'Inicio de Proceso Funcional',3,1),(14,'Sistema realiza validaciones para: 1) Campo vac├¡o 2) Informaci├│n registrada previamente',1,7,2,3,'Inicio de Proceso Funcional',4,1),(15,'Sistema guarda el registro en Base de datos y cierra la pantalla de captura',1,8,2,3,'Inicio de Proceso Funcional',5,1),(16,'Sistema guarda el registro del movimiento en la bit├ícora en base de datos',1,9,4,3,'Inicio de Proceso Funcional',6,1),(17,'Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos',1,1,1,3,'Inicio de Proceso Funcional',7,1),(18,'Usuario selecciona la opci├│n Eliminar factor',2,12,5,4,'Inicio de Proceso Funcional',1,1),(19,'Sistema despliega mensaje ┬┐Est├í seguro que desea eliminar el factor [Nombre]?',1,11,2,4,'Inicio de Proceso Funcional',2,1),(20,'Sistema elimina el registro en base de datos',1,13,2,4,'Inicio de Proceso Funcional',3,1),(21,'Sistema guarda el registro del movimiento en la bit├ícora en base de datos',1,9,4,4,'Inicio de Proceso Funcional',4,1),(22,'Sistema muestra mensaje FACTOR GUARDADO CORRECTAMENTE o mensaje de error si no son v├ílidos',1,1,1,4,'Inicio de Proceso Funcional',5,1),(24,'Registro de empleado',2,14,11,9,'Inicio de Proceso Funcional',1,1),(25,'El sistema valida que no exista el empleado',1,15,11,9,'Inicio de Proceso Funcional',2,1),(26,'Se guarda la info',1,8,11,9,'Guardar informacion del empleado',1,2),(27,'Envia mensaje \"empleado X registrado\"',1,16,11,9,'Guardar informacion del empleado',2,2),(28,'Fin',1,1,1,9,'Fin de Proceso Funcional',1,3),(29,'Consultar empleado',2,15,11,10,'Inicio de Proceso Funcional',1,1),(30,'Se muestra el empleado',1,16,11,10,'Inicio de Proceso Funcional',2,1),(31,'Lo que sea',2,14,11,10,'Actualiza datos',1,2),(32,'Registra datos en almacenamiento persistente',1,17,11,10,'Actualiza datos',2,2),(33,'Envia mensaje',1,1,1,10,'Actualiza datos',3,2),(34,'Regresa a la pantalla inicial',1,1,1,10,'Fin de Proceso Funcional',1,3);
/*!40000 ALTER TABLE `subproceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprocesogrupodato`
--

DROP TABLE IF EXISTS `subprocesogrupodato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subprocesogrupodato` (
  `idsubprocesoGrupoDato` int(11) NOT NULL AUTO_INCREMENT,
  `idGrupoDato` int(11) NOT NULL,
  `idSubProceso` int(11) NOT NULL,
  PRIMARY KEY (`idsubprocesoGrupoDato`),
  UNIQUE KEY `subprocesoGrupoDato_idx` (`idGrupoDato`,`idSubProceso`),
  KEY `SubProceso_GrupoDato_Fk_idx` (`idGrupoDato`),
  KEY `subProceso_SubProceso_fk_idx` (`idSubProceso`),
  CONSTRAINT `SubProceso_GrupoDato_Fk` FOREIGN KEY (`idGrupoDato`) REFERENCES `grupodato` (`idgrupodato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subProceso_SubProceso_fk` FOREIGN KEY (`idSubProceso`) REFERENCES `subproceso` (`idsubproceso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprocesogrupodato`
--

LOCK TABLES `subprocesogrupodato` WRITE;
/*!40000 ALTER TABLE `subprocesogrupodato` DISABLE KEYS */;
INSERT INTO `subprocesogrupodato` VALUES (10,1,10),(17,1,17),(22,1,22),(29,1,28),(34,1,33),(35,1,34),(2,2,2),(3,2,3),(4,2,4),(7,2,7),(8,2,8),(11,2,11),(14,2,14),(15,2,15),(19,2,19),(20,2,20),(5,3,5),(6,3,6),(12,3,12),(13,3,13),(25,3,24),(9,4,9),(16,4,16),(21,4,21),(1,5,1),(18,5,18),(24,11,24),(26,11,25),(27,11,26),(28,11,27),(30,11,29),(31,11,30),(32,11,31),(33,11,32);
/*!40000 ALTER TABLE `subprocesogrupodato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tamorg`
--

DROP TABLE IF EXISTS `tamorg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tamorg` (
  `idtamOrgDes` int(11) NOT NULL AUTO_INCREMENT,
  `tamOrgDes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtamOrgDes`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tamorg`
--

LOCK TABLES `tamorg` WRITE;
/*!40000 ALTER TABLE `tamorg` DISABLE KEYS */;
INSERT INTO `tamorg` VALUES (1,'1-25 Empleados'),(2,'26 - 50 Empleados'),(3,'51 - 75 Empleados'),(4,'76 - 100 Empleados'),(5,'101 - 500 Empleados'),(6,'> 500  Empleados');
/*!40000 ALTER TABLE `tamorg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocapdes`
--

DROP TABLE IF EXISTS `tipocapdes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipocapdes` (
  `idtipoCapDes` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCapDes` varchar(250) NOT NULL,
  PRIMARY KEY (`idtipoCapDes`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocapdes`
--

LOCK TABLES `tipocapdes` WRITE;
/*!40000 ALTER TABLE `tipocapdes` DISABLE KEYS */;
INSERT INTO `tipocapdes` VALUES (1,'Capacidad Propia (├ürea Interna de Sistemas)'),(2,'Outsourcing de Personal (Una sola empresa)'),(3,'Outsourcing de Personal (Varias empresas al mimso tiempo)'),(4,'Proyecto llave en mano (Costo fijo)'),(5,'Otro');
/*!40000 ALTER TABLE `tipocapdes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodedesarrollo`
--

DROP TABLE IF EXISTS `tipodedesarrollo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipodedesarrollo` (
  `idTipodeDesarrollo` int(11) NOT NULL AUTO_INCREMENT,
  `TipodeDesarrollo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipodeDesarrollo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodedesarrollo`
--

LOCK TABLES `tipodedesarrollo` WRITE;
/*!40000 ALTER TABLE `tipodedesarrollo` DISABLE KEYS */;
INSERT INTO `tipodedesarrollo` VALUES (1,'Nuevo Desarrollo'),(2,'Mejora/Mantenimiento Correctivo'),(3,'Mejora/Mantenimiento Preventivo'),(4,'Redise├▒o (Re┬¡development)'),(5,'Otro');
/*!40000 ALTER TABLE `tipodedesarrollo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoorganizacion`
--

DROP TABLE IF EXISTS `tipoorganizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipoorganizacion` (
  `idtipoOrganizacion` int(11) NOT NULL AUTO_INCREMENT,
  `tipoOrganizacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipoOrganizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoorganizacion`
--

LOCK TABLES `tipoorganizacion` WRITE;
/*!40000 ALTER TABLE `tipoorganizacion` DISABLE KEYS */;
INSERT INTO `tipoorganizacion` VALUES (1,'Energ├¡a'),(2,'Banca'),(3,'Seguros'),(4,'Software y Computaci├│n'),(5,'Automotriz'),(6,'Aeroespacial'),(7,'Telecomunicaciones'),(8,'Salud'),(9,'Educaci├│n'),(10,'Otro');
/*!40000 ALTER TABLE `tipoorganizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomUsuario` varchar(45) NOT NULL,
  `pwdUsuario` varchar(45) NOT NULL,
  `usuTipo1` tinyint(4) DEFAULT NULL,
  `usuTipo2` tinyint(4) DEFAULT NULL,
  `usuTipo3` tinyint(4) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Olga','pass',1,NULL,NULL,1),(2,'Juan','pass',NULL,1,NULL,1),(3,'Pancho','pass',NULL,NULL,1,1),(4,'Nuevo Usuario','pass',NULL,1,NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariofuncional`
--

DROP TABLE IF EXISTS `usuariofuncional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuariofuncional` (
  `idusuarioFuncional` int(11) NOT NULL AUTO_INCREMENT,
  `nomUF` varchar(45) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `usuarioSistema` tinyint(4) NOT NULL,
  PRIMARY KEY (`idusuarioFuncional`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariofuncional`
--

LOCK TABLES `usuariofuncional` WRITE;
/*!40000 ALTER TABLE `usuariofuncional` DISABLE KEYS */;
INSERT INTO `usuariofuncional` VALUES (1,'Sistemas','Sistema Administrar Factores',1,1),(2,'Administrador','Adminstrador del sistema Adminsitrar Factores',1,0),(3,'Usuario AF','Usuario del sistema Administrar Factores',1,1);
/*!40000 ALTER TABLE `usuariofuncional` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-30 15:07:51
