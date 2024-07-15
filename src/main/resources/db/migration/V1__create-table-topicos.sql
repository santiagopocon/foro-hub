create table usuarios(

idUsuario bigint not null auto_increment,
nombre varchar(100) not null,
email varchar(100) not null,
contrasenia varchar(500) not null,

primary key(idUsuario)

);