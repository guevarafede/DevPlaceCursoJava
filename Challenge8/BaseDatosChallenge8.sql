-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NULL AUTO_INCREMENT,
  `nombreCliente` VARCHAR(45) NULL,
  `apellidoCliente` VARCHAR(45) NULL,
  `direccionCliente` VARCHAR(45) NULL,
  `fechaNacCliente` DATE NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Producto` (
  `idProducto` INT NULL AUTO_INCREMENT,
  `codigoProducto` INT NULL,
  `precioUnitario` DOUBLE NULL,
  `cantidad` INT NULL,
  `stockMinimo` INT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vendedor` (
  `idVendedor` INT NULL AUTO_INCREMENT,
  `nombreVendedor` VARCHAR(45) NULL,
  `apellidoVendedor` VARCHAR(45) NULL,
  `direccionVendedor` VARCHAR(45) NULL,
  `fechaNacVendedor` DATE NULL,
  PRIMARY KEY (`idVendedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Facturacion` (
  `idFacturacion` INT NULL,
  `numeroFactura` INT NULL AUTO_INCREMENT,
  `fechaCompra` DATE NULL,
  `detalle` VARCHAR(45) NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Vendedor_idVendedor` INT NOT NULL,
  PRIMARY KEY (`idFacturacion`),
  UNIQUE INDEX `numeroFactura_UNIQUE` (`numeroFactura` ASC) VISIBLE,
  INDEX `fk_Factura_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Factura_Vendedor1_idx` (`Vendedor_idVendedor` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Vendedor1`
    FOREIGN KEY (`Vendedor_idVendedor`)
    REFERENCES `mydb`.`Vendedor` (`idVendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto_has_Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Producto_has_Factura` (
  `Producto_idProducto` INT NOT NULL,
  `Factura_idFactura` INT NOT NULL,
  PRIMARY KEY (`Producto_idProducto`, `Factura_idFactura`),
  INDEX `fk_Producto_has_Factura_Factura1_idx` (`Factura_idFactura` ASC) VISIBLE,
  INDEX `fk_Producto_has_Factura_Producto_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Factura_Producto`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Factura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `mydb`.`Facturacion` (`idFacturacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
