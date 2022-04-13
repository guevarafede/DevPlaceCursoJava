create database Challenge8;

use Challenge8;

create table Producto(
idProducto int auto_increment, 
codigoProducto int,
precioUnitario double,
cantidad int,
stockMinimo int,
constraint pk_idProducto primary key (idProducto));

create table Cliente (
idCliente int auto_increment, 
nombreCliente varchar(45),
apellidoCliente varchar(45),
direccionCliente varchar(45),
fechaNacCliente date,
constraint pk_idCliente primary key (idCliente));

create table Vendedor (
idVendedor int auto_increment, 
nombreVendedor varchar(45),
apellidoVendedor varchar(45),
direccionVendedor varchar(45),
fechaNacVendedor date,
constraint pk_idVendedor primary key (idVendedor));

create table Facturacion (
idFacturacion int auto_increment, 
numeroFactura int unique,
fechaCompra date,
detalle varchar(45),
idCliente int,
idVendedor int,
constraint pk_idFacturacion primary key (idFacturacion),
constraint fk_Cliente foreign key (idCliente) references Cliente(idCliente),
constraint fk_Vendedor foreign key (idVendedor) references Vendedor(idVendedor)
);
