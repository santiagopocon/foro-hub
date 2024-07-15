create table topicos(

id_topico bigint not null auto_increment,
titulo varchar(100) not null,
mensaje varchar(500) not null,
nombre_curso varchar(50) not null,
id_usuario bigint not null,
status tinyint not null,

primary key(id_topico),

constraint fk_topicos_id_usuario foreign key(id_usuario) references usuarios(id_usuario)
);
