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
    estado NUMBER(1) DEFAULT 1 NOT NULL,
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

CREATE TABLE experiencias(
    experiencia_id NUMBER GENERATED ALWAYS AS IDENTITY,
    descripcion VARCHAR2(1000) NOT NULL,
    titulo VARCHAR2(100) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    nombre_empresa VARCHAR2(60) NOT NULL,
    desarrollador_id NUMBER NOT NULL,
    CONSTRAINT pk_experiencia
        PRIMARY KEY (experiencia_id),
    CONSTRAINT fk_experiencia_desarrollador
        FOREIGN KEY (desarrollador_id) REFERENCES desarrolladores(desarrollador_id)
);

CREATE TABLE proyectos(
    proyecto_id NUMBER GENERATED ALWAYS AS IDENTITY,
    titulo VARCHAR2(200) NOT NULL,
    descripcion VARCHAR2(4000) NOT NULL,
    url_produccion VARCHAR2(1000) NULL,
    url_repositorio VARCHAR2(1000) NOT NULL,
    estado NUMBER(1) DEFAULT 1 NOT NULL,
    experiencia_id NUMBER NOT NULL,
    tipo_proyecto_id NUMBER NOT NULL,
    CONSTRAINT pk_proyecto
        PRIMARY KEY (proyecto_id),
    CONSTRAINT fk_proyecto_experiencia
        FOREIGN KEY (experiencia_id) REFERENCES experiencias(experiencia_id),
    CONSTRAINT fk_proyecto_tipo_proyecto
        FOREIGN KEY (tipo_proyecto_id) REFERENCES tipos_proyectos(tipo_proyecto_id)
);

CREATE TABLE etiquetas(
    etiqueta_id NUMBER GENERATED ALWAYS AS IDENTITY,
    descripcion VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_etiqueta
        PRIMARY KEY (etiqueta_id)
);

CREATE TABLE proyecto_etiquestas(
    proyecto_id NUMBER NOT NULL,
    etiqueta_id NUMBER NOT NULL,
    CONSTRAINT pk_proyecto_etiqueta
        PRIMARY KEY (proyecto_id, etiqueta_id),
    CONSTRAINT fk_pe_proyecto
        FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id),
    CONSTRAINT fk_pe_etiqueta
        FOREIGN KEY (etiqueta_id) REFERENCES etiquetas(etiqueta_id)
);