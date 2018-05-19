-- MySQL Script generated by MySQL Workbench
-- Tue May 15 13:34:21 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering
BEGIN;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema SGPF
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SGPF` ;

-- -----------------------------------------------------
-- Schema SGPF
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SGPF` DEFAULT CHARACTER SET utf8 ;
USE `SGPF` ;

-- -----------------------------------------------------
-- Table `SGPF`.`accion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`accion` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`accion` (
  `idaccion` INT NOT NULL AUTO_INCREMENT,
  `nomAccion` VARCHAR(45) NOT NULL,
  `movDatos` CHAR(1) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`idaccion`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`grupodato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`grupodato` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`grupodato` (
  `idgrupoDato` INT NOT NULL AUTO_INCREMENT,
  `nomGD` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`idgrupoDato`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`TipodeDesarrollo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`TipodeDesarrollo` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`TipodeDesarrollo` (
  `idTipodeDesarrollo` INT NOT NULL AUTO_INCREMENT,
  `TipodeDesarrollo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipodeDesarrollo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`sectorOrganizacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`sectorOrganizacion` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`sectorOrganizacion` (
  `idsectorOrganizacion` INT NOT NULL AUTO_INCREMENT,
  `sectorOrganizacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsectorOrganizacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`tipoOrganizacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`tipoOrganizacion` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`tipoOrganizacion` (
  `idtipoOrganizacion` INT NOT NULL AUTO_INCREMENT,
  `tipoOrganizacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipoOrganizacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`tipoCapDes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`tipoCapDes` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`tipoCapDes` (
  `idtipoCapDes` INT NOT NULL AUTO_INCREMENT,
  `tipoCapDes` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idtipoCapDes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`tamOrg`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`tamOrg` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`tamOrg` (
  `idtamOrgDes` INT NOT NULL AUTO_INCREMENT,
  `tamOrgDes` VARCHAR(45) NULL,
  PRIMARY KEY (`idtamOrgDes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`arqProyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`arqProyecto` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`arqProyecto` (
  `idarqProyecto` INT NOT NULL AUTO_INCREMENT,
  `arqProyecto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idarqProyecto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`lenguaje`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`lenguaje` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`lenguaje` (
  `idlenguaje` INT NOT NULL AUTO_INCREMENT,
  `lenguaje` VARCHAR(45) NULL,
  PRIMARY KEY (`idlenguaje`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`sisOpe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`sisOpe` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`sisOpe` (
  `idsisOpe` INT NOT NULL AUTO_INCREMENT,
  `sisOpe` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsisOpe`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`baseDatos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`baseDatos` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`baseDatos` (
  `idbaseDatos` INT NOT NULL AUTO_INCREMENT,
  `baseDatos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idbaseDatos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`metDesarrollo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`metDesarrollo` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`metDesarrollo` (
  `idmetDesarrollo` INT NOT NULL AUTO_INCREMENT,
  `metDesarrollo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmetDesarrollo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`marcoPosUsa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`marcoPosUsa` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`marcoPosUsa` (
  `idmarcoPosUsa` INT NOT NULL AUTO_INCREMENT,
  `marcoPosUsa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmarcoPosUsa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`modCalidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`modCalidad` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`modCalidad` (
  `idmodCalidad` INT NOT NULL AUTO_INCREMENT,
  `modCalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmodCalidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`escala`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`escala` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`escala` (
  `idescala` INT NOT NULL AUTO_INCREMENT,
  `escala` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idescala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`metMedicion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`metMedicion` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`metMedicion` (
  `idmetMedicion` INT NOT NULL AUTO_INCREMENT,
  `metMedicion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmetMedicion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`confInfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`confInfo` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`confInfo` (
  `idconfInfo` INT NOT NULL AUTO_INCREMENT,
  `confInfo` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idconfInfo`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `SGPF`.`proyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`proyecto` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`proyecto` (
  `idproyecto` INT NOT NULL AUTO_INCREMENT,
  `nomProy` VARCHAR(60) NOT NULL,
  `anioProy` VARCHAR(4) NOT NULL,
  `operProy` TINYINT NOT NULL,
  `duraProy` DECIMAL(9,2) NOT NULL,
  `esfuTotProy` DECIMAL(9,2) NOT NULL,
  `esfuPlaneProy` DECIMAL(9,2) NOT NULL,
  `esfuEsReqProy` DECIMAL(9,2) NOT NULL,
  `esfuAnaDisProy` DECIMAL(9,2) NOT NULL,
  `esfuConstProy` DECIMAL(9,2) NOT NULL,
  `esfuPrueProy` DECIMAL(9,2) NOT NULL,
  `esfuImpleDesProy` DECIMAL(9,2) NOT NULL,
  `costTotProy` DECIMAL(9,2) NOT NULL,
  `costEsReqProy` DECIMAL(9,2) NOT NULL,
  `costAnaDisProy` DECIMAL(9,2) NOT NULL,
  `costConstProy` DECIMAL(9,2) NOT NULL,
  `costPrueProy` DECIMAL(9,2) NOT NULL,
  `costImpleDesProy` DECIMAL(9,2) NOT NULL,
  `tamFunProy` DECIMAL(9,2) NOT NULL,
  `fpAjusProy` DECIMAL(9,2) NOT NULL,
  `medidorCertProy` TINYINT NOT NULL,
  `expeMedMetProy` INT NOT NULL,
  `usoCase` TINYINT NOT NULL,
  `certModelo` TINYINT NOT NULL,
  `comCertModelo` VARCHAR(250) NOT NULL,
  `costPlanProy` DECIMAL(11,2) NOT NULL,
  `idconfInfo` INT NOT NULL,
  `idarqProyecto` INT NOT NULL,
  `idmetDesarrollo` INT NOT NULL,
  `idmetMedicion` INT NOT NULL,
  `idsisOpe` INT NOT NULL,
  `idTipoDesarrollo` INT NOT NULL,
  `idlenguaje` INT NOT NULL,
  `idmodCalidad` INT NOT NULL,
  `idbaseDatos` INT NOT NULL,
  `idsectorOrganizacion` INT NOT NULL,
  `estatus` TINYINT NOT NULL,
  `idtipoOrganizacion` INT NOT NULL,
  `idtipoCapDes` INT NOT NULL,
  `idtamOrgDes` INT NOT NULL,
  `tamOrgUsa` INT NOT NULL,
  `idmarcoPosUsa` INT NOT NULL,
  `idescala` INT NOT NULL,
  `proposito` VARCHAR(250) NOT NULL,
  `alcance` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idproyecto`),
  INDEX `idTipoDesarrollo_fk_idx` (`idTipoDesarrollo` ASC),
  INDEX `sectorOrganizacion_fk_idx` (`idsectorOrganizacion` ASC),
  INDEX `tipoOrganizacion_fk_idx` (`idtipoOrganizacion` ASC),
  INDEX `tipoCapOrg_fk_idx` (`idtipoCapDes` ASC),
  INDEX `tamOrgDes_fk_idx` (`idtamOrgDes` ASC),
  INDEX `tamOrgUsa_fk_idx` (`tamOrgUsa` ASC),
  INDEX `arqProyecto_fk_idx` (`idarqProyecto` ASC),
  INDEX `lenguaje_fk_idx` (`idlenguaje` ASC),
  INDEX `sisOpe_fk_idx` (`idsisOpe` ASC),
  INDEX `baseDatos_fk_idx` (`idbaseDatos` ASC),
  INDEX `metDesarrollo_fk_idx` (`idmetDesarrollo` ASC),
  INDEX `marcoPosUsa_fk_idx` (`idmarcoPosUsa` ASC),
  INDEX `modCalidad_fk_idx` (`idmodCalidad` ASC),
  INDEX `escala_fk_idx` (`idescala` ASC),
  INDEX `metMedicion_fk_idx` (`idmetMedicion` ASC),
  CONSTRAINT `TipoDesarrollo_fk`
    FOREIGN KEY (`idTipoDesarrollo`)
    REFERENCES `SGPF`.`TipodeDesarrollo` (`idTipodeDesarrollo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sectorOrganizacion_fk`
    FOREIGN KEY (`idsectorOrganizacion`)
    REFERENCES `SGPF`.`sectorOrganizacion` (`idsectorOrganizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipoOrganizacion_fk`
    FOREIGN KEY (`idtipoOrganizacion`)
    REFERENCES `SGPF`.`tipoOrganizacion` (`idtipoOrganizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipoCapDes_fk`
    FOREIGN KEY (`idtipoCapDes`)
    REFERENCES `SGPF`.`tipoCapDes` (`idtipoCapDes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `confInfo_fk`
    FOREIGN KEY (`idconfInfo`)
    REFERENCES `SGPF`.`confInfo` (`idconfInfo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tamOrgDes_fk`
    FOREIGN KEY (`idtamOrgDes`)
    REFERENCES `SGPF`.`tamOrg` (`idtamOrgDes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tamOrgUsa_fk`
    FOREIGN KEY (`tamOrgUsa`)
    REFERENCES `SGPF`.`tamOrg` (`idtamOrgDes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `arqProyecto_fk`
    FOREIGN KEY (`idarqProyecto`)
    REFERENCES `SGPF`.`arqProyecto` (`idarqProyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lenguaje_fk`
    FOREIGN KEY (`idlenguaje`)
    REFERENCES `SGPF`.`lenguaje` (`idlenguaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sisOpe_fk`
    FOREIGN KEY (`idsisOpe`)
    REFERENCES `SGPF`.`sisOpe` (`idsisOpe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `baseDatos_fk`
    FOREIGN KEY (`idbaseDatos`)
    REFERENCES `SGPF`.`baseDatos` (`idbaseDatos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `metDesarrollo_fk`
    FOREIGN KEY (`idmetDesarrollo`)
    REFERENCES `SGPF`.`metDesarrollo` (`idmetDesarrollo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `marcoPosUsa_fk`
    FOREIGN KEY (`idmarcoPosUsa`)
    REFERENCES `SGPF`.`marcoPosUsa` (`idmarcoPosUsa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `modCalidad_fk`
    FOREIGN KEY (`idmodCalidad`)
    REFERENCES `SGPF`.`modCalidad` (`idmodCalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `escala_fk`
    FOREIGN KEY (`idescala`)
    REFERENCES `SGPF`.`escala` (`idescala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `metMedicion_fk`
    FOREIGN KEY (`idmetMedicion`)
    REFERENCES `SGPF`.`metMedicion` (`idmetMedicion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`usuario` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nomUsuario` VARCHAR(45) NOT NULL,
  `pwdUsuario` VARCHAR(45) NOT NULL,
  `usuTipo1` TINYINT NULL DEFAULT NULL,
  `usuTipo2` TINYINT NULL DEFAULT NULL,
  `usuTipo3` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`interup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`interUP` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`interUP` (
  `idinterUP` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `idproyecto` INT NOT NULL,
  PRIMARY KEY (`idinterUP`),
  INDEX `idusuario_idx` (`idusuario` ASC),
  INDEX `idproyecto_idx` (`idproyecto` ASC),
  UNIQUE INDEX `USUARIO-PROY` (`idusuario` ASC, `idproyecto` ASC),
  CONSTRAINT `idproyecto1`
    FOREIGN KEY (`idproyecto`)
    REFERENCES `SGPF`.`proyecto` (`idproyecto`),
  CONSTRAINT `idusuario1`
    FOREIGN KEY (`idusuario`)
    REFERENCES `SGPF`.`usuario` (`idusuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`procesofuncional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`procesofuncional` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`procesofuncional` (
  `idprocesoFuncional` INT NOT NULL AUTO_INCREMENT,
  `nomPF` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `eventoDes` VARCHAR(250) NOT NULL,
  `idproyecto` INT NOT NULL,
  `tamPF` INT NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`idprocesoFuncional`),
  INDEX `idproyecto_idx` (`idproyecto` ASC),
  CONSTRAINT `idproyecto`
    FOREIGN KEY (`idproyecto`)
    REFERENCES `SGPF`.`proyecto` (`idproyecto`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`usuariofuncional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`usuariofuncional` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`usuariofuncional` (
  `idusuarioFuncional` INT NOT NULL AUTO_INCREMENT,
  `nomUF` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `activo` TINYINT NOT NULL,
  `usuarioSistema` TINYINT NOT NULL,
  PRIMARY KEY (`idusuarioFuncional`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`subproceso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`subproceso` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`subproceso` (
  `idsubProceso` INT NOT NULL AUTO_INCREMENT,
  `flujoAl` TINYINT NULL DEFAULT NULL,
  `descripcion` VARCHAR(250) NULL DEFAULT NULL,
  `idusuarioFuncional` INT NOT NULL,
  `idaccion` INT NOT NULL,
  `idgrupoDato` INT NOT NULL,
  `idprocesoFuncional` INT NOT NULL,
  `actividad` VARCHAR(45) NOT NULL,
  `indice` INT NOT NULL,
  `indiceActividad` INT NOT NULL,
  PRIMARY KEY (`idsubProceso`),
  INDEX `idusuarioFuncional_idx` (`idusuarioFuncional` ASC),
  INDEX `idaccion_idx` (`idaccion` ASC),
  INDEX `idgrupoDato_idx` (`idgrupoDato` ASC),
  INDEX `idprocesoFuncional_idx` (`idprocesoFuncional` ASC),
  CONSTRAINT `idaccion`
    FOREIGN KEY (`idaccion`)
    REFERENCES `SGPF`.`accion` (`idaccion`),
  CONSTRAINT `idgrupoDato`
    FOREIGN KEY (`idgrupoDato`)
    REFERENCES `SGPF`.`grupodato` (`idgrupoDato`),
  CONSTRAINT `idprocesoFuncional`
    FOREIGN KEY (`idprocesoFuncional`)
    REFERENCES `SGPF`.`procesofuncional` (`idprocesoFuncional`),
  CONSTRAINT `idusuarioFuncional`
    FOREIGN KEY (`idusuarioFuncional`)
    REFERENCES `SGPF`.`usuariofuncional` (`idusuarioFuncional`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `SGPF`.`historico` (
  `idhistorico` INT NOT NULL AUTO_INCREMENT,
  `idProy` INT NOT NULL,
  `nombreProy` VARCHAR(45) NOT NULL,
  `alcanceProy` VARCHAR(45) NOT NULL,
  `nombrePF` VARCHAR(45) NOT NULL,
  `descripcionPF` VARCHAR(45) NOT NULL,
  `tamanioPF` INT NOT NULL,
  `eventoDesPF` VARCHAR(45) NOT NULL,
  `descripcionSP` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  `nombreGD` VARCHAR(45) NOT NULL,
  `descripcionGD` VARCHAR(45) NOT NULL,
  `nombreUF` VARCHAR(45) NOT NULL,
  `descripcionUF` VARCHAR(45) NOT NULL,
  `usuarioSistemaUF` VARCHAR(45) NOT NULL,
  `nombreAccion` VARCHAR(45) NOT NULL,
  `movDatos` VARCHAR(45) NOT NULL,
  `proposito` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idhistorico`))
ENGINE = InnoDB 
AUTO_INCREMENT = 9 
DEFAULT CHARACTER SET = utf8;

INSERT INTO TipodeDesarrollo(TipodeDesarrollo) VALUES("Nuevo Desarrollo"),("Mejora/Mantenimiento Correctivo"),
("Mejora/Mantenimiento Preventivo"),("Rediseño (Re­development)"),("Otro");

INSERT INTO sectorOrganizacion(sectorOrganizacion) VALUES("Gobierno Federa"),("Gobierno Estatal"),("Gobierno Local"),
("Privado"),("Otro");

INSERT INTO tipoOrganizacion(tipoOrganizacion) VALUES("Energía"),("Banca"),("Seguros"),("Software y Computación"),
("Automotriz"),("Aeroespacial"),("Telecomunicaciones"),("Salud"),("Educación"),("Otro");

INSERT INTO tipoCapDes(tipoCapDes) VALUES("Capacidad Propia (Área Interna de Sistemas)"),
("Outsourcing de Personal (Una sola empresa)"),("Outsourcing de Personal (Varias empresas al mimso tiempo)"),
("Proyecto llave en mano (Costo fijo)"),("Otro");

INSERT INTO tamOrg(tamOrgDes) VALUES("1-25 Empleados"),("26 - 50 Empleados"),("51 - 75 Empleados"),("76 - 100 Empleados"),
("101 - 500 Empleados"),("> 500  Empleados");

INSERT INTO arqProyecto(arqProyecto) VALUES("Multicapas"),("Standalone"),("Dispositivos Móviles"),("Desarrollo Web"),
("Data Warehouse (DWH)"),("Enterprise Resource Planning (ERP)"),("Otro");

INSERT INTO lenguaje(lenguaje) VALUES("JAVA/J2EE"),("C#"),("C++"),("ASP.NET"),("ADA"),("Cobol"),("PHP"),("JavaScript"),
("PL"),("SAP/ABAP"),("Otro");

INSERT INTO sisOpe(sisOpe) VALUES("Linux"),("UNIX"),("Windows"),("Windows XP"),("Windows Vista"),("Windows 7/8"),("Windows 10"),
("IOS"),("Android"),("Windows Mobile"),("Windows NT"),("Android"),("IOS"),("Otro");

INSERT INTO baseDatos(baseDatos) VALUES("ORACLE"),("MySQL"),("SQLSERVER"),("DB2"),("ACCESS"),("SYBASE"),("INFORMIX"),("Otro");

INSERT INTO metDesarrollo(metDesarrollo) VALUES("CASCADA"),("ITERATIVO"),("ÁGIL"),("Otro");

INSERT INTO marcoPosUsa(marcoPosUsa) VALUES("MAAGTICSI"),("CMMI"),("RUP"),("Otro");

INSERT INTO modCalidad(modCalidad) VALUES("CMMI-DEV"),("NMX-MoProsoft"),("ISO/IEC 29110"),("ISO 9000"),("Otro");

INSERT INTO confInfo(confInfo) VALUES
("Tipo A: La información es completamente Confiable al 100%, incluso hay evidencias."),
("Tipo B: La información en muy confiable, al 75%, pero hay algunos aspectos que no son precisos."),
("Tipo C: La información con que se cuenta es confiable aproximadamente a la mitad (50%), hay varios datos imprecisos."),
("Tipo D: La información con que se cuenta es poco confiable, al 25%.");

INSERT INTO escala(escala) VALUES("Días"),("Semanas"),("Meses"),("Años");

INSERT INTO metMedicion(metMedicion) VALUES("COSMIC ISO 19761"),("IFPUG ISO 20926"),("MKII ISO 20698"),("NESMA ISO 24570"),
("FISMA ISO29881");

INSERT INTO `usuario` VALUES (1,'Olga','pass',1,NULL,NULL),(2,'Juan','pass',NULL,1,NULL),(3,'Pancho','pass',NULL,NULL,1);

INSERT INTO `proyecto` VALUES (1,'C-Reg','1993',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,10,1,0,'foo',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'abcdef','abcdefg'),
                              (2,'SGPF','1993',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,10,1,0,'foo',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'abcdef','abcdefg'),
                              (3,'Olgasss','2015',1,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,1,1,1,1,'Olgasss',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'abcdef','abcdefg'),
                              (4,'C-Reg691ffeaafe23','2015',1,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,1,1,1,1,'C-Reg69123',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'abcdef','abcdefg');

INSERT INTO `interUP` VALUES (1,1,1),(2,1,2),(3,2,2),(4,1,3),(5,2,1),(6,3,2),(7,3,1);

INSERT INTO `procesofuncional` VALUES (1,'cualquiera','descripcion','entrada desencadenante',2,0,1),
                              (2,'cualquiera','descripcion','entrada desencadenenante',2,0,0),(3,'Pancho','Nuevo','Genial',2,0,1),
                              (4,'Mi Proceso Funcional','Esta es una descripción para el proceso funcional.','Esta es una instancia de evento desencadenante',2,0,0),
                              (5,'Nuevo','hkjekj','nhjhkj',3,0,0);

INSERT INTO `accion` VALUES (1,'ingresaSz','M','entrada de datos',1),(2,'envia','X','envia de datos',0),
(3,'solicita','R','pide de datos',0),(4,'Prueba','X','This',1),(5,'Prueba2','E','22',1),(6,'Prueba','X','C',1),
(7,'Bombón','M','D',1),(8,'Prueba','E','This is the description',1);

INSERT INTO `grupodato` VALUES (1,'estudianteR','Estudiante del IIMAZ',0),(2,'Juano','Sisg',1),(3,'','',1),(4,'','',1),(5,'','',1),(6,'','',1),(7,'df','',1),(8,'fe','ef',1),(9,'Juano','Feith',1),(10,'Peio','kbjhb',1);

INSERT INTO `usuariofuncional` VALUES (1,'Registradores','Registrador del IIMAST',1,1),(2,'C-Reg','Sistema C-Reg',1,1),(3,'Registrador','Registrador C-Reg',1,1),(4,'Juano','FHKLI',1,1);

INSERT INTO `subproceso` VALUES (1,0,'los datos de',2,1,1,2,'Inicio de PF',1,1),(2,0,'los datos de',2,1,1,2,'Inicio de PF',2,1),(3,0,'los datos de',2,1,1,2,'Valida',1,1),(4,0,'los datos de',2,1,1,2,'Valida',2,1),(5,1,'canjlewnlk',1,1,2,5,'Inicio de Proceso Funcional',1,1),(6,1,'caenew',1,1,2,5,'Inicio de Proceso Funcional',2,1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

COMMIT;
