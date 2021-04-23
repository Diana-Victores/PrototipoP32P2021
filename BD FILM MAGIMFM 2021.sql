CREATE SCHEMA IF NOT EXISTS `LaboratorioFM2021P2` DEFAULT CHARACTER SET utf8 ;
USE `LaboratorioFM2021P2` ;

CREATE TABLE IF NOT EXISTS `LaboratorioFM2021P2`.`tbl_usuario` (
  `PK_id_usuario` VARCHAR(25) NOT NULL,
  `nombre_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `apellido_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `username_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `password_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `correo_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `cambio_password` TINYINT NULL DEFAULT NULL,
  `estado_usuario` TINYINT NULL DEFAULT NULL,
  `ultima_conexion` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `LaboratorioFM2021P2`.`tbl_usuario` (`PK_id_usuario`, `nombre_usuario`, `apellido_usuario`, `username_usuario`, `password_usuario`, `correo_usuario`, `cambio_password`, `estado_usuario`, `ultima_conexion`) VALUES ('1', 'prueba1', 'prueba2', 'prueba', '12345', 'prueba@gmail.com', '1', '1', '2021-03-23 23:59:59');

/*-------------------------------------------------------------------------------------*/

CREATE TABLE IF NOT EXISTS `LaboratorioFM2021P2`.`tbl_cliente` (
  `PK_id_cliente` INT NOT NULL ,
  `nombre_cliente` VARCHAR(45)NOT NULL,
   `apellido_cliente` VARCHAR(45)NOT NULL,
  `edad_cliente` VARCHAR(200) NOT NULL,
  `CodigoCorreo_cliente` VARCHAR(200) NOT NULL,
  `CodigoDireccion_cliente` VARCHAR(200) NOT NULL,
   `CodigoTelefono_cliente` VARCHAR(200) NOT NULL,
  `DPI_cliente` VARCHAR(200) NOT NULL,
 PRIMARY KEY (`PK_id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


/*----------------------------------------------------------*/

CREATE TABLE IF NOT EXISTS `LaboratorioFM2021P2`.`tbl_Registrosatrasados` 
(

ID INT NOT NULL, 
Nombre VARCHAR (60) NOT NULL , 
Apellido Varchar (60) NOT NULL ,
DPI VARCHAR (45) NOT NULL,
Tipo VARCHAR (10) NOT NULL,
Genero varchar (45)NOT NULL,
FechaAlquiler VARCHAR (10) NOT NULL,
FechaCaducidad VARCHAR (10) NOT NULL,
 FechaTarde VARCHAR (10) NOT NULL,
 ImporteCargo VARCHAR (10) NOT NULL,
 Total VARCHAR (10) NOT NULL,
 PRIMARY KEY (`ID`)
)ENGINE = InnoDB DEFAULT 
CHARSET = latin1;


/*--------------------------------------------------------*/
create table `LaboratorioFM2021P2`.`tbl_registro_productovideos`
(
  `PK_id_registrovideo` INT NOT NULL ,
  `nombre_registro` VARCHAR(45)NOT NULL,
   `Codigo_registro` VARCHAR(45)NOT NULL,
  `Clasificacion` VARCHAR(200) NOT NULL,
  `Valor_registro` VARCHAR(200) NOT NULL,

 PRIMARY KEY (`PK_id_registrovideo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


/*

create table `LaboratorioFM2021P2`.`tbl.registroproductodvd`
(
`PK_id_registroproductodvd` INT NOT NULL,
`Nombre_registro` varchar (40) NOT NULL,
`Codigo_registro` varchar (40) NOT NULL,
`Valor_registro` varchar (10) NOT NULL,
 PRIMARY KEY (`PK_id_registroproductodvd`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
*/
