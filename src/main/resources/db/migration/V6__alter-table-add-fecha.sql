alter table topicos add fecha_de_creacion datetime;
update topicos set fecha_de_creacion = now()