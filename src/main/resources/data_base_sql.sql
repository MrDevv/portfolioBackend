CREATE TABLE desarrolladores (
    desarrollador_id NUMBER GENERATED ALWAYS AS IDENTITY,
    nombres VARCHAR2(100) NOT NULL,
    apellidos VARCHAR2(100) NOT NULL,
    correo VARCHAR2(200) NOT NULL UNIQUE,
    github_url CLOB NOT NULL,
    linkedin_url CLOB NOT NULL,
    cv_url CLOB NOT NULL,
    prefijo_telefono VARCHAR2(10) NOT NULL,
    telefono VARCHAR2(20) NOT NULL,
    biografia CLOB NOT NULL,
    puesto VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_desarrolladores
        PRIMARY KEY (desarrollador_id)
);

CREATE TABLE roles (
    rol_id NUMBER GENERATED ALWAYS AS IDENTITY,
    descripcion VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_roles
        PRIMARY KEY (rol_id)
);

CREATE TABLE usuarios (
    usuario_id NUMBER GENERATED ALWAYS AS IDENTITY,
    username VARCHAR2(20) NOT NULL,
    password VARCHAR2(255) NOT NULL,
    estado NUMBER(1) NOT NULL,
    desarrollador_id NUMBER NOT NULL,
    rol_id NUMBER NOT NULL,
    api_key CLOB,
    CONSTRAINT pk_usuarios
        PRIMARY KEY (usuario_id),
    CONSTRAINT fk_usuario_desarrollador
        FOREIGN KEY (desarrollador_id) REFERENCES desarrolladores(desarrollador_id),
    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (rol_id) REFERENCES roles(rol_id)
);

CREATE TABLE tipos_proyectos (
    tipo_proyecto_id NUMBER GENERATED ALWAYS AS IDENTITY,
    descripcion VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_tipos_proyectos
        PRIMARY KEY (tipo_proyecto_id)
);

CREATE TABLE tecnologias (
    tecnologia_id NUMBER GENERATED ALWAYS AS IDENTITY,
    descripcion VARCHAR2(100) NOT NULL,
    tipo_tecnologia_id NUMBER NOT NULL,
    CONSTRAINT pk_tecnologias
        PRIMARY KEY (tecnologia_id),
    CONSTRAINT fk_tecnologia_tipo
        FOREIGN KEY (tipo_tecnologia_id) REFERENCES tipos_proyectos(tipo_proyecto_id)
);

CREATE TABLE desarrollador_tecnologias (
    desarrollador_id NUMBER NOT NULL,
    tecnologia_id NUMBER NOT NULL,
    CONSTRAINT pk_desarrollador_tecnologias
        PRIMARY KEY (desarrollador_id, tecnologia_id),
    CONSTRAINT fk_dt_desarrollador
        FOREIGN KEY (desarrollador_id) REFERENCES desarrolladores(desarrollador_id),
    CONSTRAINT fk_dt_tecnologia
        FOREIGN KEY (tecnologia_id) REFERENCES tecnologias(tecnologia_id)
);