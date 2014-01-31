/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : test01

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2014-01-23 22:30:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for categoria_platillo
-- ----------------------------
DROP TABLE IF EXISTS `categoria_platillo`;
CREATE TABLE `categoria_platillo` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_padre` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`),
  KEY `categoria_padre` (`categoria_padre`),
  CONSTRAINT `categoria_platillo_ibfk_1` FOREIGN KEY (`categoria_padre`) REFERENCES `categoria_platillo` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of categoria_platillo
-- ----------------------------
INSERT INTO `categoria_platillo` VALUES ('1', null, 'Bebidas');
INSERT INTO `categoria_platillo` VALUES ('2', null, 'Refrescos');
INSERT INTO `categoria_platillo` VALUES ('4', '1', 'Malteadas');

-- ----------------------------
-- Table structure for corte
-- ----------------------------
DROP TABLE IF EXISTS `corte`;
CREATE TABLE `corte` (
  `ID` int(11) NOT NULL,
  `TOTAL` double NOT NULL,
  `CANTIDAD_TICKETS` int(11) NOT NULL,
  `FECHA` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of corte
-- ----------------------------
INSERT INTO `corte` VALUES ('1', '1000', '1', '2014-01-23 01:34:31');

-- ----------------------------
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `tipo_emp` int(11) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empleado
-- ----------------------------
INSERT INTO `empleado` VALUES ('1', 'Jesus', 'Tecalco', '1', '1', 'jast', 'x0leg/TgQNkHngRCNsgP5Q==');
INSERT INTO `empleado` VALUES ('2', 'Jesus', 'Tecalco', '1', '1', 'aaaaaa', 'wVDjyg8weAalTf3TKxb09A==');
INSERT INTO `empleado` VALUES ('4', 'Misael', 'Carrera', '1', '3', 'misa', 'ex9lZ4m/FYWaDrz3ZPihvw==');

-- ----------------------------
-- Table structure for info_empleado
-- ----------------------------
DROP TABLE IF EXISTS `info_empleado`;
CREATE TABLE `info_empleado` (
  `id_empleado` int(11) NOT NULL DEFAULT '0',
  `ciudad` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  CONSTRAINT `info_empleado_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of info_empleado
-- ----------------------------
INSERT INTO `info_empleado` VALUES ('2', 'Huatusco', 'Calle 9 sur', '@chux', '2731005605');
INSERT INTO `info_empleado` VALUES ('4', 'Cordoba', 'X', 'misaaa', '145434282');

-- ----------------------------
-- Table structure for linea_orden
-- ----------------------------
DROP TABLE IF EXISTS `linea_orden`;
CREATE TABLE `linea_orden` (
  `no_orden` int(11) NOT NULL DEFAULT '0',
  `ticket` int(11) DEFAULT NULL,
  `no_mesa` int(11) DEFAULT NULL,
  `cant_platillo` int(11) DEFAULT NULL,
  `id_platillo` int(11) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `COBRADO` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`no_orden`),
  KEY `ticket` (`ticket`),
  KEY `no_mesa` (`no_mesa`),
  KEY `id_platillo` (`id_platillo`),
  CONSTRAINT `linea_orden_ibfk_1` FOREIGN KEY (`ticket`) REFERENCES `ticket` (`ticket`),
  CONSTRAINT `linea_orden_ibfk_2` FOREIGN KEY (`no_mesa`) REFERENCES `mesa` (`no_mesa`),
  CONSTRAINT `linea_orden_ibfk_3` FOREIGN KEY (`id_platillo`) REFERENCES `platillo` (`id_platillo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of linea_orden
-- ----------------------------
INSERT INTO `linea_orden` VALUES ('1', '1', '1', '4', '1', 'Algo', '0');
INSERT INTO `linea_orden` VALUES ('2', '1', '1', '1', '1', 'Algo 2', '0');

-- ----------------------------
-- Table structure for mesa
-- ----------------------------
DROP TABLE IF EXISTS `mesa`;
CREATE TABLE `mesa` (
  `no_mesa` int(11) NOT NULL AUTO_INCREMENT,
  `disponible` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`no_mesa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mesa
-- ----------------------------
INSERT INTO `mesa` VALUES ('1', '1');
INSERT INTO `mesa` VALUES ('2', '0');

-- ----------------------------
-- Table structure for platillo
-- ----------------------------
DROP TABLE IF EXISTS `platillo`;
CREATE TABLE `platillo` (
  `id_platillo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_platillo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of platillo
-- ----------------------------
INSERT INTO `platillo` VALUES ('1', 'xxx', '20', '1');
INSERT INTO `platillo` VALUES ('2', 'yyyy', '15', '2');
INSERT INTO `platillo` VALUES ('3', 'zzzz', '12.5', '4');

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `nombre` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of restaurant
-- ----------------------------
INSERT INTO `restaurant` VALUES ('Chuchosaurio', 'ZZZ', 'YYY', 'AAA');

-- ----------------------------
-- Table structure for secuencias
-- ----------------------------
DROP TABLE IF EXISTS `secuencias`;
CREATE TABLE `secuencias` (
  `NOMBRE_TABLA` varchar(255) NOT NULL,
  `VALOR` int(11) DEFAULT '0',
  PRIMARY KEY (`NOMBRE_TABLA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of secuencias
-- ----------------------------
INSERT INTO `secuencias` VALUES ('CATEGORIA_PLATILLO', '0');
INSERT INTO `secuencias` VALUES ('CORTE', '1');
INSERT INTO `secuencias` VALUES ('EMPLEADO', '5');
INSERT INTO `secuencias` VALUES ('LINEA_ORDEN', '2');
INSERT INTO `secuencias` VALUES ('MESA', '2');
INSERT INTO `secuencias` VALUES ('PLATILLO', '3');
INSERT INTO `secuencias` VALUES ('TICKET', '3');

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticket` int(11) NOT NULL DEFAULT '0',
  `id_empleado` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fecha_reg` datetime DEFAULT NULL,
  `cobrado` tinyint(1) DEFAULT NULL,
  `fecha_pagado` datetime DEFAULT NULL,
  `recibio` double DEFAULT NULL,
  `cambio` double DEFAULT NULL,
  `cortado` tinyint(1) DEFAULT NULL,
  `fechaCorte` datetime DEFAULT NULL,
  PRIMARY KEY (`ticket`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('1', '1', '1000', '2014-01-23 01:01:44', '0', '2014-01-23 01:01:44', '2000', '1600', '1', '2014-01-23 01:34:31');

-- ----------------------------
-- View structure for informe_corte_caja
-- ----------------------------
DROP VIEW IF EXISTS `informe_corte_caja`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `informe_corte_caja` AS SELECT
t.ticket AS ID_TICKET,
t.total AS TOTAL,
t.recibio AS RECIBIO,
t.cambio AS CAMBIO,
e.nombre AS EMPLEADO,
t.fecha_pagado AS FECHA_PAGO

FROM
		ticket AS t
	INNER JOIN empleado AS e ON t.id_empleado = e.id_empleado
WHERE t.cortado = true ;

-- ----------------------------
-- View structure for informe_mesero
-- ----------------------------
DROP VIEW IF EXISTS `informe_mesero`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `informe_mesero` AS (SELECT
e.id_empleado AS ID_EMPLEADO,
e.nombre AS NOMBRE,
t.ticket AS TICKET,
t.total AS TOTAL,
t.fecha_pagado AS FECHA_PAGO,
t.fechaCorte AS FECHA_CORTE
FROM
empleado AS e
INNER JOIN ticket AS t ON t.id_empleado = e.id_empleado
WHERE t.cortado = true) ;

-- ----------------------------
-- View structure for ticket_impreso
-- ----------------------------
DROP VIEW IF EXISTS `ticket_impreso`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `ticket_impreso` AS SELECT
lo.ticket AS TICKET,
lo.cant_platillo AS CANTIDAD,
p.descripcion AS PLATILLO,
p.precio AS PRECIO,
lo.cant_platillo * p.precio AS SUBTOTAL,
m.no_mesa AS MESA,
ticket.fecha_pagado AS FECHA
FROM
linea_orden AS lo
INNER JOIN platillo AS p ON lo.id_platillo = p.id_platillo
INNER JOIN mesa AS m ON lo.no_mesa = m.no_mesa
INNER JOIN ticket ON lo.ticket = ticket.ticket ;

-- ----------------------------
-- Procedure structure for AUMENTAR_SECUENCIA
-- ----------------------------
DROP PROCEDURE IF EXISTS `AUMENTAR_SECUENCIA`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AUMENTAR_SECUENCIA`(IN TABLA varchar(255))
BEGIN
	UPDATE SECUENCIAS SET VALOR = VALOR + 1 WHERE NOMBRE_TABLA = TABLA;
	SELECT VALOR FROM SECUENCIAS WHERE NOMBRE_TABLA = TABLA;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for DISMINUIR_SECUENCIA
-- ----------------------------
DROP PROCEDURE IF EXISTS `DISMINUIR_SECUENCIA`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DISMINUIR_SECUENCIA`(IN TABLA varchar(255))
BEGIN
	UPDATE SECUENCIAS SET VALOR = VALOR - 1 WHERE NOMBRE_TABLA = TABLA;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `ACTUALIZAR_TICKETS_CORTADOS`;
DELIMITER ;;
CREATE TRIGGER `ACTUALIZAR_TICKETS_CORTADOS` AFTER INSERT ON `corte` FOR EACH ROW BEGIN
UPDATE TICKET SET CORTADO = TRUE, FECHACORTE = NEW.FECHA;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `ACTUALIZAR_LINEA_TICKET`;
DELIMITER ;;
CREATE TRIGGER `ACTUALIZAR_LINEA_TICKET` AFTER UPDATE ON `ticket` FOR EACH ROW BEGIN
UPDATE LINEA_ORDEN SET COBRADO = TRUE WHERE TICKET = OLD.TICKET;
END
;;
DELIMITER ;
