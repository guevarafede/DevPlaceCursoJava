/*drop database Challenge8;*/

create database Challenge8;  /* BASE DE DATOS CRADA PARA CHALLENGE 8
                                Y REUTILIZADA PARA CHALLENGE 9 */

use Challenge8;

create table Producto(
idProducto int primary key auto_increment, 
codigoProducto int,
precioUnitario double,
cantidad int,
stockMinimo int
);

create table Cliente (
idCliente int primary key auto_increment, 
nombreCliente varchar(45),
apellidoCliente varchar(45),
direccionCliente varchar(45),
fechaNacCliente date
);

create table Vendedor (
idVendedor int primary key auto_increment, 
nombreVendedor varchar(45),
apellidoVendedor varchar(45),
direccionVendedor varchar(45),
fechaNacVendedor date
);

create table Facturacion (
idFacturacion int primary key auto_increment, 
numeroFactura int unique,
fechaCompra date,
detalle varchar(45),
idCliente int,
idVendedor int,
constraint fk_Factura_Cliente foreign key (idCliente) references Cliente(idCliente),
constraint fk_Factura_Vendedor foreign key (idVendedor) references Vendedor(idVendedor)
);

create table Producto_has_Facturacion (
Producto_idProducto INT NOT NULL,
Facturacion_idFacturacion INT NOT NULL,
PRIMARY KEY (Producto_idProducto, Facturacion_idFacturacion),
CONSTRAINT fk_Producto_has_Facturacion_Producto FOREIGN KEY (Producto_idProducto) references Producto(idProducto),
CONSTRAINT fk_Producto_has_Facturacion_Facturacion FOREIGN KEY (Facturacion_idFacturacion) references Facturacion(idFacturacion)
);

/* 1) Ingrese 10 productos en la tabla de productos creadas. */
insert into Producto values(idProducto, 1004, 500, 3, 15); /*TECLADO*/
insert into Producto values(idProducto, 1033, 320, 4, 5); /*MOUSE*/
insert into Producto values(idProducto, 1076, 120, 2, 10); /*MONITOR*/
insert into Producto values(idProducto, 1029, 890, 3, 20); /*CPU*/
insert into Producto values(idProducto, 1022, 570, 9, 8); /*MEMORIA*/
insert into Producto values(idProducto, 1025, 500, 3, 5); /*DISCO*/
insert into Producto values(idProducto, 1032, 230, 3, 1); /*MOTHER*/
insert into Producto values(idProducto, 1087, 800, 8, 12); /*RED*/
insert into Producto values(idProducto, 1088, 780, 2, 20); /*ROUTER*/
insert into Producto values(idProducto, 1064, 700, 7, 60); /*TONNER*/
insert into Producto values(idProducto, 1098, 700, 5, 95); /*HOJAS*/


/* 2) Ingrese 5 Vendedores. */
insert into Vendedor values(idVendedor,"Juan", "Manuel", "Gascon 5237", "1990-09-15");
insert into Vendedor values(idVendedor,"Martin", "Palermo", "Mitre 1230", "1998-09-11");
insert into Vendedor values(idVendedor,"Roman", "Riquelme", "Garay 7887", "1967-10-28");
insert into Vendedor values(idVendedor,"Guillermo", "Schelotto", "San lorenzo 2237", "1987-03-21");
insert into Vendedor values(idVendedor,"Mauricio", "Serna", "Luro 3238", "1980-09-13");

/* 3) Ingrese 5 clientes. */
insert into Cliente values(idCliente,"Federico", "Guevara", "Italia 3533", "1989-08-15");
insert into Cliente values(idCliente,"Facundo", "Guevara", "Italia 3533", "1985-04-29");
insert into Cliente values(idCliente,"Alfredo", "Martinez", "Juncal 2287", "1984-10-02");
insert into Cliente values(idCliente,"Fabian", "Garcia", "Gascon 4625", "1988-11-11");
insert into Cliente values(idCliente,"Erik", "Dell", "Juan B Justo 4332", "1988-10-03");

/* 4) Ingrese 3 ventas por cada cliente registrado y que sus ventas tengan como mínimo dos productos de compras. */
insert into Facturacion values(idFacturacion, 0001, '2022-04-10', "Insumos", 1, 1);
insert into Facturacion values(idFacturacion, 0002, '2022-04-11', "Insumos", 1, 1);
insert into Facturacion values(idFacturacion, 0003, '2022-04-03', "Repuestos", 1, 2);

insert into Facturacion values(idFacturacion, 0004, '2022-04-12', "Repuestos", 2, 3);
insert into Facturacion values(idFacturacion, 0005, '2022-04-12', "Insumos", 2, 1);
insert into Facturacion values(idFacturacion, 0006, '2022-04-05', "Equipo red", 2, 4);

insert into Facturacion values(idFacturacion, 0007, '2022-04-12', "Perifericos", 3, 3);
insert into Facturacion values(idFacturacion, 0008, '2022-04-12', "Insumos", 3, 1);
insert into Facturacion values(idFacturacion, 0009, '2022-04-05', "Equipo red", 3, 4);

insert into Facturacion values(idFacturacion, 0010, '2022-04-12', "Perifericos", 4, 3);
insert into Facturacion values(idFacturacion, 0011, '2022-04-12', "Insumos", 4, 1);
insert into Facturacion values(idFacturacion, 0012, '2022-04-05', "Perifericos", 4, 4);

insert into Facturacion values(idFacturacion, 0013, '2022-04-12', "Perifericos", 5, 3);
insert into Facturacion values(idFacturacion, 0014,' 2022-04-12', "Repuestos", 5, 1);
insert into Facturacion values(idFacturacion, 0015,' 2022-04-05', "Perifericos", 5, 4);

insert into Producto_has_Facturacion values (1064, 0001);
insert into Producto_has_Facturacion values (1098, 0001);

insert into Producto_has_Facturacion values (1064, 0002);
insert into Producto_has_Facturacion values (1098, 0002);

insert into Producto_has_Facturacion values (1022, 0003);
insert into Producto_has_Facturacion values (1025, 0003);

insert into Producto_has_Facturacion values (1025, 0004);
insert into Producto_has_Facturacion values (1032, 0004);

insert into Producto_has_Facturacion values (1098, 0005);
insert into Producto_has_Facturacion values (1064, 0005);

insert into Producto_has_Facturacion values (1088, 0006);
insert into Producto_has_Facturacion values (1087, 0006);

insert into Producto_has_Facturacion values (1033, 0007);
insert into Producto_has_Facturacion values (1004, 0007);

insert into Producto_has_Facturacion values (1064, 0008);
insert into Producto_has_Facturacion values (1098, 0008);

insert into Producto_has_Facturacion values (1088, 0009);
insert into Producto_has_Facturacion values (1087, 0009);

insert into Producto_has_Facturacion values (1029, 0010);
insert into Producto_has_Facturacion values (1076, 0010);

insert into Producto_has_Facturacion values (1064, 0011);
insert into Producto_has_Facturacion values (1098, 0011);

insert into Producto_has_Facturacion values (1004, 0012);
insert into Producto_has_Facturacion values (1076, 0012);

insert into Producto_has_Facturacion values (1076, 0013);
insert into Producto_has_Facturacion values (1029, 0013);

insert into Producto_has_Facturacion values (1032, 0014);
insert into Producto_has_Facturacion values (1025, 0014);

insert into Producto_has_Facturacion values (1033, 0015);
insert into Producto_has_Facturacion values (1029, 0015);

/* 5) FILTRE TODAS LAS VENTAS DE UN CLIENTE DONDE SU NOMBRE CONTENGA LA LETRA 'A' */
SELECT F.numeroFactura, C.nombreCliente FROM Facturacion F
INNER JOIN Cliente C
ON F.IdCliente = C.IdCliente
WHERE C.nombreCliente LIKE '%a%';  
                 /*OTRA MANERA DE RESOLVER LO MISMO*/
SELECT F.numeroFactura, C.nombreCliente FROM Facturacion F, Cliente C
WHERE F.IdCliente = C.IdCliente
AND C.nombreCliente LIKE '%a%';  


/* 6) Filtre todos los productos que se vendieron. */



/* 7) Filtre todas las ventas por vendedor mostrando solo los datos del vendedor y el total vendido. */
SELECT * FROM Vendedor V
INNER JOIN Facturacion F
ON F.idVendedor = V.idVendedor
ORDER BY V.idVendedor ASC;

/* 8) Cree un Trigger, que permite modificar el valor de la cantidad de los productos al momento 
      de realizar una venta.*/ 
      
      


/* 9) Filtre todas las ventas por una fecha. */
/* Busco todos los datos de las facturas realizadas por las ventas que se hicieron el 12/04/2022 */
SELECT * FROM Facturacion
WHERE fechaCompra = '2022-04-12';



/*SENTENCIAS PARA AUXILIARES*/
select * from Vendedor;
select * from Cliente;
select * from Producto;
select * from Facturacion;
select * from Producto_has_Facturacion;

/*EJERCICIO DE LA TARDE DIA9*/
DELIMITER $$
CREATE TRIGGER eliminaCliente
BEFORE DELETE ON Cliente
FOR EACH ROW
BEGIN
delete from facturacion
where idCliente = idCliente;
end; $$
delimiter ;

delete from facturacion where idFacturacion=1;

SET SQL_SAFE_UPDATES=0;
select * from Facturacion;