CREATE DATABASE IF NOT EXISTS `gestion_de_nominas`;
USE `gestion_de_nominas`;

CREATE TABLE IF NOT EXISTS `empleados` (
  `nombre` varchar(50) DEFAULT NULL,
  `dni` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `categoria` int(11) DEFAULT 1,
  `antiguedad` int(11) DEFAULT 0,
  PRIMARY KEY (`dni`),
  CONSTRAINT `CONSTRAINT_1` CHECK (`sexo` IN ('m','f')),
  CONSTRAINT `CONSTRAINT_2` CHECK (`categoria` BETWEEN 1 AND 10),
  CONSTRAINT `CONSTRAINT_3` CHECK (`antiguedad` >= 0)
)

CREATE TABLE IF NOT EXISTS `nominas` (
  `dni` varchar(50) NOT NULL,
  `sueldo` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `nominas_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleados` (`dni`) ON DELETE CASCADE
)

DELIMITER //
CREATE TRIGGER `nominas_after_insert` AFTER INSERT ON `empleados` 
FOR EACH ROW 
BEGIN
  DECLARE sueldo_calculado INT;
  SET sueldo_calculado = 30000 + NEW.categoria * 20000 + NEW.antiguedad * 5000;
  INSERT INTO `nominas` (dni, sueldo) VALUES (NEW.dni, sueldo_calculado);
END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER `empleados_after_update` AFTER UPDATE ON `empleados` 
FOR EACH ROW 
BEGIN
  DECLARE sueldo_calculado INT;
  SET sueldo_calculado = 30000 + NEW.categoria * 20000 + NEW.antiguedad * 5000;
  UPDATE `nominas` SET sueldo = sueldo_calculado WHERE dni = NEW.dni;
END//
DELIMITER ;

INSERT INTO `empleados` (`nombre`, `dni`, `sexo`, `categoria`, `antiguedad`) VALUES
	('Sandro', '01573844R', 'M', 2, 2),
	('Antonio', '12345678A', 'M', 1, 0),
	('Ada Lovelace', '32000031R', 'F', 4, 8),
	('James Gosling', '32000032G', 'M', 4, 7),
	('David', '32494423C', 'M', 1, 5),
	('Carmen', '87654321Z', 'F', 3, 7);
