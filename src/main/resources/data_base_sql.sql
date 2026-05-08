CREATE TABLE profesionales (
    profesional_id NUMBER GENERATED ALWAYS AS IDENTITY,
    profesional_uuid VARCHAR2(36) NOT NULL UNIQUE,
    nombres VARCHAR2(100) NOT NULL,
    apellidos VARCHAR2(100) NOT NULL,
    correo_contacto VARCHAR2(200),
    github_url VARCHAR2(500),
    linkedin_url VARCHAR2(500),
    cv_url VARCHAR2(500),
    logo_url VARCHAR2(500),
    prefijo_telefono VARCHAR2(10),
    telefono VARCHAR2(20),
    biografia VARCHAR2(4000),
    puesto VARCHAR2(100),
    CONSTRAINT pk_profesionales
        PRIMARY KEY (profesional_id)
);

CREATE TABLE roles (
    rol_id NUMBER GENERATED ALWAYS AS IDENTITY,
    rol_uuid VARCHAR2(36) NOT NULL UNIQUE,
    descripcion VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_roles
        PRIMARY KEY (rol_id)
);

CREATE TABLE usuarios (
    usuario_id NUMBER GENERATED ALWAYS AS IDENTITY,
    usuario_uuid VARCHAR2(36) NOT NULL UNIQUE,
    email VARCHAR2(100) NOT NULL UNIQUE,
    password VARCHAR2(255) NOT NULL,
    estado NUMBER(1) DEFAULT 1 NOT NULL,
    profesional_id NUMBER NOT NULL,
    rol_id NUMBER NOT NULL,
    api_key VARCHAR2(100),
    origen_permitido VARCHAR2(300),
    estado_origen NUMBER(1) DEFAULT 0 NOT NULL,
    CONSTRAINT pk_usuarios
        PRIMARY KEY (usuario_id),
    CONSTRAINT fk_usuario_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesionales(profesional_id),
    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (rol_id) REFERENCES roles(rol_id)
);

CREATE TABLE tipos_proyectos (
    tipo_proyecto_id NUMBER GENERATED ALWAYS AS IDENTITY,
    tipo_proyecto_uuid VARCHAR2(36) NOT NULL UNIQUE,
    descripcion VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_tipos_proyectos
        PRIMARY KEY (tipo_proyecto_id)
);

CREATE TABLE tipos_tecnologias (
    tipo_tecnologia_id NUMBER GENERATED ALWAYS AS IDENTITY,
    tipo_tecnologia_uuid VARCHAR2(36) NOT NULL UNIQUE,
    descripcion VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_tipo_tecnologia
        PRIMARY KEY (tipo_tecnologia_id)
);

CREATE TABLE tecnologias (
    tecnologia_id NUMBER GENERATED ALWAYS AS IDENTITY,
    tecnologia_uuid  VARCHAR2(36) NOT NULL UNIQUE,
    descripcion VARCHAR2(100) NOT NULL,
    logo_url VARCHAR2(500) NOT NULL,
    tipo_tecnologia_id NUMBER NOT NULL,
    CONSTRAINT pk_tecnologias
        PRIMARY KEY (tecnologia_id),
    CONSTRAINT fk_tecnologia_tipo
        FOREIGN KEY (tipo_tecnologia_id) REFERENCES tipos_tecnologias(tipo_tecnologia_id)
);

CREATE TABLE profesional_tecnologias (
    profesional_tecnologia_id NUMBER GENERATED ALWAYS AS IDENTITY,
    profesional_id NUMBER NOT NULL,
    tecnologia_id NUMBER NOT NULL,
    nivel VARCHAR2(20),
    CONSTRAINT pk_profesional_tecnologias
        PRIMARY KEY (profesional_tecnologia_id),
    CONSTRAINT fk_dt_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesionales(profesional_id),
    CONSTRAINT fk_dt_tecnologia
        FOREIGN KEY (tecnologia_id) REFERENCES tecnologias(tecnologia_id)
);

CREATE TABLE experiencias(
    experiencia_id NUMBER GENERATED ALWAYS AS IDENTITY,
    experiencia_uuid VARCHAR2(36) NOT NULL UNIQUE,
    descripcion VARCHAR2(1000) NOT NULL,
    titulo VARCHAR2(100) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    nombre_empresa VARCHAR2(60) NOT NULL,
    puesto VARCHAR2(60) NOT NULL,
    profesional_id NUMBER NOT NULL,
    CONSTRAINT pk_experiencia
        PRIMARY KEY (experiencia_id),
    CONSTRAINT fk_experiencia_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesionales(profesional_id)
);

CREATE TABLE proyectos(
    proyecto_id NUMBER GENERATED ALWAYS AS IDENTITY,
    proyecto_uuid VARCHAR2(36) NOT NULL UNIQUE,
    titulo VARCHAR2(200) NOT NULL,
    descripcion VARCHAR2(4000) NOT NULL,
    url_produccion VARCHAR2(1000),
    url_repositorio VARCHAR2(1000),
    url_imagen_presentacion VARCHAR2(500),
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
    etiqueta_uuid VARCHAR2(36) NOT NULL UNIQUE,
    descripcion VARCHAR2(50) NOT NULL,
    CONSTRAINT pk_etiqueta
        PRIMARY KEY (etiqueta_id)
);

CREATE TABLE proyecto_etiquetas(
    proyecto_id NUMBER NOT NULL,
    etiqueta_id NUMBER NOT NULL,
    CONSTRAINT pk_proyecto_etiqueta
        PRIMARY KEY (proyecto_id, etiqueta_id),
    CONSTRAINT fk_pe_proyecto
        FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id),
    CONSTRAINT fk_pe_etiqueta
        FOREIGN KEY (etiqueta_id) REFERENCES etiquetas(etiqueta_id)
);