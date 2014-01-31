create table restaurant(
	nombre varchar(255),
	ciudad varchar(255),
	direccion varchar(255),
	telefono varchar(255)
);

create table empleado(
	id_empleado int ,
	nombre varchar(255),
	apellidos varchar(255),
	activo boolean,
	tipo_emp int,
	usuario varchar(255),
	password varchar(255),
	primary key(id_empleado)
);

create table info_empleado(
	id_empleado int ,
	ciudad varchar(255),
	direccion varchar(255),
	correo varchar(255),
	telefono varchar(255),
	primary key(id_empleado),
	foreign key(id_empleado) references empleado(id_empleado)
);

create table platillo(
	id_platillo int ,
	descripcion varchar(255),
	precio double,
	categoria int,
	primary key(id_platillo)
);

create table categoria_platillo(
	id_categoria int, 
	id_platillo int,
	descripcion varchar(255),
	primary key(id_categoria),
	foreign key(id_platillo) references platillo(id_platillo)
);

create table ticket(
	ticket int, 
	id_empleado int,
	total double,
	fecha_hora datetime,
	primary key(ticket),
	foreign key(id_empleado) references empleado(id_empleado)
);

create table mesa(
	no_mesa int,
	disponible boolean,
	primary key(no_mesa)
);

create table linea_orden(
	no_orden int,
	ticket int,
	no_mesa int,
	cant_platillo int,
	id_platillo int,
	observacion varchar(255),
	primary key(no_orden),
	foreign key(ticket) references ticket(ticket),
	foreign key(no_mesa) references mesa(no_mesa),
	foreign key(id_platillo) references platillo(id_platillo)
);

create table orden_cobrada(
	no_orden int,
	cobrada boolean,
	foreign key(no_orden) references linea_orden(no_orden)
);