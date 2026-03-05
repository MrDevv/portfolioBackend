create table desarrolladores(
	desarrollador_id bigint generated always as identity,
	nombres varchar(100) not null,
	apellidos varchar(100) not null,
	correo varchar(200) not null unique,
	github_url text not null,
	linkedin_url text not null,
	cv_url text not null,
	prefijo_telefono varchar not null,
	telefono varchar not null,
	biografia text not null,
	puesto varchar not null,
	primary key(desarrollador_id)
);

create table roles(
    rol_id bigint generated always as identity,
    descripcion varchar(100) not null,
    primary key(rol_id)
);

create table usuarios(
    usuario_id bigint generated always as identity,
    username varchar(20) not null,
    password varchar(255) not null,
    estado smallint not null,
    desarrollador_id bigint not null,
    rol_id bigint not null,
    token_acceso_front text,
    primary key(usuario_id),
    foreign key(desarrollador_id) references desarrolladores(desarrollador_id),
    foreign key(rol_id) references roles(rol_id)
);