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
  `idaccion` INT(11) NOT NULL AUTO_INCREMENT,
  `nomAccion` VARCHAR(45) NOT NULL,
  `movDatos` CHAR(1) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `activo` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idaccion`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`grupodato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`grupodato` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`grupodato` (
  `idgrupoDato` INT(11) NOT NULL AUTO_INCREMENT,
  `nomGD` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `activo` TINYINT(4) NOT NULL,
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
  `tipoCapDes` VARCHAR(250) NOT NULL,
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
  `idproyecto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomProy` VARCHAR(60) NULL,
  `anioProy` VARCHAR(4) NULL,
  `operProy` TINYINT(4) NULL,
  `duraProy` DECIMAL(9,2) NULL,
  `esfuTotProy` DECIMAL(9,2) NULL,
  `esfuPlaneProy` DECIMAL(9,2) NULL,
  `esfuEsReqProy` DECIMAL(9,2) NULL,
  `esfuAnaDisProy` DECIMAL(9,2) NULL,
  `esfuConstProy` DECIMAL(9,2) NULL,
  `esfuPrueProy` DECIMAL(9,2) NULL,
  `esfuImpleDesProy` DECIMAL(9,2) NULL,
  `costTotProy` DECIMAL(9,2) NULL,
  `costEsReqProy` DECIMAL(9,2) NULL,
  `costAnaDisProy` DECIMAL(9,2) NULL,
  `costConstProy` DECIMAL(9,2) NULL,
  `costPrueProy` DECIMAL(9,2) NULL,
  `costImpleDesProy` DECIMAL(9,2) NULL,
  `tamFunProy` DECIMAL(9,2) NULL,
  `fpAjusProy` DECIMAL(9,2) NULL,
  `medidorCertProy` TINYINT(4) NULL,
  `expeMedMetProy` INT(11) NULL,
  `usoCase` TINYINT(4) NULL,
  `certModelo` TINYINT(4) NULL,
  `comCertModelo` VARCHAR(250) NULL,
  `costPlanProy` DECIMAL(11,2) NULL,
  `idconfInfo` INT NULL,
  `idarqProyecto` INT NULL,
  `idmetDesarrollo` INT NULL,
  `idmetMedicion` INT NULL,
  `idsisOpe` INT NULL,
  `idTipoDesarrollo` INT NULL,
  `idlenguaje` INT NULL,
  `idmodCalidad` INT NULL,
  `idbaseDatos` INT NULL,
  `idsectorOrganizacion` INT NULL,
  `estatus` TINYINT(4) NULL,
  `idtipoOrganizacion` INT NULL,
  `idtipoCapDes` INT NULL,
  `idtamOrgDes` INT NULL,
  `tamOrgUsa` INT NULL,
  `idmarcoPosUsa` INT NULL,
  `idescala` INT NULL,
  `proposito` VARCHAR(250) NULL,
  `alcance` VARCHAR(250) NULL,
  `estimacionCosto` DECIMAL(9,2) NULL,
  `estimacionEsfuerzo` DECIMAL(9,2) NULL,
  `estimacionDuracion` DECIMAL(9,2) NULL,
  `idescalaEstimacionDuracion` INT NULL,
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
  INDEX `idescalaEstimacionDuracion_fk_idx` (`idescalaEstimacionDuracion` ASC),
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
    ON UPDATE NO ACTION,
  CONSTRAINT `idescalaEstimacionDuracion_fk`
    FOREIGN KEY (`idescalaEstimacionDuracion`)
    REFERENCES `SGPF`.`escala` (`idescala`)
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
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nomUsuario` VARCHAR(45) NOT NULL,
  `pwdUsuario` VARCHAR(45) NOT NULL,
  `usuTipo1` TINYINT(4) NULL DEFAULT NULL,
  `usuTipo2` TINYINT(4) NULL DEFAULT NULL,
  `usuTipo3` TINYINT(4) NULL DEFAULT NULL,
  `activo` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SGPF`.`interup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`interUP` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`interUP` (
  `idinterUP` INT(11) NOT NULL AUTO_INCREMENT,
  `idusuario` INT(11) NOT NULL,
  `idproyecto` INT(11) NOT NULL,
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
  `idprocesoFuncional` INT(11) NOT NULL AUTO_INCREMENT,
  `nomPF` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `eventoDes` VARCHAR(250) NOT NULL,
  `idproyecto` INT(11) NOT NULL,
  `tamPF` INT(11) NOT NULL,
  `activo` TINYINT(4) NOT NULL,
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
  `idusuarioFuncional` INT(11) NOT NULL AUTO_INCREMENT,
  `nomUF` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `activo` TINYINT(4) NOT NULL,
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
  `idsubProceso` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(250) NOT NULL,
  `idusuarioFuncional` INT(11) NOT NULL,
  `idaccion` INT(11) NOT NULL,
  `idgrupoDato` INT(11) NOT NULL,
  `idprocesoFuncional` INT(11) NOT NULL,
  `actividad` VARCHAR(45) NOT NULL,
  `indice` INT(11) NOT NULL,
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


-- -----------------------------------------------------
-- Table `SGPF`.`historico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`historico` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`historico` (
  `idhistorico` INT NOT NULL,
  `idProy` INT NOT NULL,
  `nombreProy` VARCHAR(250) NOT NULL,
  `alcanceProy` VARCHAR(250) NOT NULL,
  `nombrePF` VARCHAR(250) NOT NULL,
  `descripcionPF` VARCHAR(250) NOT NULL,
  `tamanio` INT NOT NULL,
  `eventoDesPF` VARCHAR(250) NOT NULL,
  `descripcionSP` VARCHAR(250) NOT NULL,
  `fecha` DATE NOT NULL,
  `nombreGD` VARCHAR(250) NOT NULL,
  `proposito` VARCHAR(250) NOT NULL,
  `descripcionGD` VARCHAR(250) NOT NULL,
  `nombreUF` VARCHAR(250) NOT NULL,
  `descripcionUF` VARCHAR(250) NOT NULL,
  `usuarioSistemaUF` TINYINT NOT NULL,
  `nombreAccion` VARCHAR(250) NOT NULL,
  `movDatos` CHAR(1) NOT NULL,
  PRIMARY KEY (`idhistorico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`subprocesoGrupoDato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`subprocesoGrupoDato` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`subprocesoGrupoDato` (
  `idsubprocesoGrupoDato` INT NOT NULL AUTO_INCREMENT,
  `idGrupoDato` INT NOT NULL,
  `idSubProceso` INT NOT NULL,
  PRIMARY KEY (`idsubprocesoGrupoDato`),
  INDEX `SubProceso_GrupoDato_Fk_idx` (`idGrupoDato` ASC),
  INDEX `subProceso_SubProceso_fk_idx` (`idSubProceso` ASC),
  CONSTRAINT `SubProceso_GrupoDato_Fk`
    FOREIGN KEY (`idGrupoDato`)
    REFERENCES `SGPF`.`grupodato` (`idgrupoDato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `subProceso_SubProceso_fk`
    FOREIGN KEY (`idSubProceso`)
    REFERENCES `SGPF`.`subproceso` (`idsubProceso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`flujoAlterno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`flujoAlterno` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`flujoAlterno` (
  `idflujoAlterno` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(250) NOT NULL,
  `idusuarioFuncional` INT(11) NULL,
  `idaccion` INT(11) NULL,
  `idgrupoDato` INT(11) NULL,
  `idsubProceso` INT(11) NULL,
  `actividad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idflujoAlterno`),
  INDEX `FA_idusuarioFuncional_fk_idx` (`idusuarioFuncional` ASC),
  INDEX `FA_idaccion_fk_idx` (`idaccion` ASC),
  INDEX `FA_idgrupoDato_fk_idx` (`idgrupoDato` ASC),
  INDEX `FA_idsubProceso_fk_idx` (`idsubProceso` ASC),
  CONSTRAINT `FA_idusuarioFuncional_fk`
    FOREIGN KEY (`idusuarioFuncional`)
    REFERENCES `SGPF`.`usuariofuncional` (`idusuarioFuncional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FA_idaccion_fk`
    FOREIGN KEY (`idaccion`)
    REFERENCES `SGPF`.`accion` (`idaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FA_idgrupoDato_fk`
    FOREIGN KEY (`idgrupoDato`)
    REFERENCES `SGPF`.`grupodato` (`idgrupoDato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FA_idsubProceso_fk`
    FOREIGN KEY (`idsubProceso`)
    REFERENCES `SGPF`.`subProceso` (`idsubProceso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO TipodeDesarrollo(TipodeDesarrollo) VALUES("Nuevo Desarrollo"),("Mejora/Mantenimiento Correctivo"),
("Mejora/Mantenimiento Preventivo"),("Rediseño (Re­development)"),("Otro");

INSERT INTO sectorOrganizacion(sectorOrganizacion) VALUES("Gobierno Federal"),("Gobierno Estatal"),("Gobierno Local"),
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

INSERT INTO `usuario` VALUES (1,'Olga','pass',1,NULL,NULL,1),(2,'Juan','pass',NULL,1,NULL,1),(3,'Pancho','pass',NULL,NULL,1,1);

INSERT INTO `proyecto` VALUES (1,'C-Reg','1993',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,0,1,1,'foo',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'Propósito','Alcance',10.21,11.33,14.26,1),
                              (2,'SGPF','1993',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,0,1,1,'foo',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'Propósito','Alcance',10.21,11.33,14.26,1),
                              (3,'Olgasss','2015',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,0,1,1,'Olgasss',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'Propósito','Alcance',10.21,11.33,14.26,1),
                              (4,'C-Reg691ffeaafe23','2015',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,0,1,1,'C-Reg69123',12.00,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'Propósito','Alcance',10.21,11.33,14.26,1);

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

INSERT INTO `subproceso` VALUES (1,'los datos de',2,1,1,2,'Inicio de PF',1,1),(2,'los datos de',2,1,1,2,'Inicio de PF',2,1),(3,'los datos de',2,1,1,2,'Valida',1,1),(4,'los datos de',2,1,1,2,'Valida',2,1),(5,'canjlewnlk',1,1,2,5,'Inicio de Proceso Funcional',1,1),(6,'caenew',1,1,2,5,'Inicio de Proceso Funcional',2,1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
COMMIT;