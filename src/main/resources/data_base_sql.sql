CREATE TABLE profesionales (
    profesional_id BIGINT GENERATED ALWAYS AS IDENTITY,
    profesional_uuid VARCHAR(36) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo_contacto VARCHAR(200),
    github_url VARCHAR(500),
    linkedin_url VARCHAR(500),
    cv_url VARCHAR(500),
    logo_url VARCHAR(500),
    prefijo_telefono VARCHAR(10),
    telefono VARCHAR(20),
    biografia VARCHAR(4000),
    puesto VARCHAR(100),
    CONSTRAINT pk_profesional
        PRIMARY KEY (profesional_id),
    CONSTRAINT uq_profesional_uuid
        UNIQUE (profesional_uuid)
    );

CREATE TABLE roles (
    rol_id BIGINT GENERATED ALWAYS AS IDENTITY,
    rol_uuid VARCHAR(36) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_rol
        PRIMARY KEY (rol_id),
    CONSTRAINT uq_rol_uuid
        UNIQUE (rol_uuid)
);

CREATE TABLE usuarios (
    usuario_id BIGINT GENERATED ALWAYS AS IDENTITY,
    usuario_uuid VARCHAR(36) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    estado BOOLEAN DEFAULT TRUE NOT NULL,
    profesional_id BIGINT NOT NULL,
    rol_id BIGINT NOT NULL,
    api_key VARCHAR(100),
    origen_permitido VARCHAR(300),
    estado_origen BOOLEAN DEFAULT FALSE NOT NULL,
    CONSTRAINT pk_usuarios
        PRIMARY KEY (usuario_id),
    CONSTRAINT uq_usuario_uuid
        UNIQUE (usuario_uuid),
    CONSTRAINT uq_usuario_email
        UNIQUE (email),
    CONSTRAINT fk_usuario_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesionales(profesional_id),
    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (rol_id) REFERENCES roles(rol_id)
);

CREATE TABLE tipos_proyectos (
    tipo_proyecto_id BIGINT GENERATED ALWAYS AS IDENTITY,
    tipo_proyecto_uuid VARCHAR(36) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_tipo_proyecto
        PRIMARY KEY (tipo_proyecto_id),
    CONSTRAINT uq_tipo_proyecto_uuid
        UNIQUE (tipo_proyecto_uuid)
);

CREATE TABLE tipos_tecnologias (
    tipo_tecnologia_id BIGINT GENERATED ALWAYS AS IDENTITY,
    tipo_tecnologia_uuid VARCHAR(36) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_tipo_tecnologia
        PRIMARY KEY (tipo_tecnologia_id),
    CONSTRAINT uq_tipo_tecnologia_uuid
        UNIQUE (tipo_tecnologia_uuid)
);

CREATE TABLE tecnologias (
    tecnologia_id BIGINT GENERATED ALWAYS AS IDENTITY,
    tecnologia_uuid VARCHAR(36) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    logo_url VARCHAR(500) NOT NULL,
    tipo_tecnologia_id BIGINT NOT NULL,
    CONSTRAINT pk_tecnologias
        PRIMARY KEY (tecnologia_id),
    CONSTRAINT fk_tecnologia_tipo
        FOREIGN KEY (tipo_tecnologia_id) REFERENCES tipos_tecnologias(tipo_tecnologia_id),
    CONSTRAINT uq_tecnologia_uuid
        UNIQUE (tecnologia_uuid)
    );

CREATE TABLE profesional_tecnologias (
    profesional_tecnologia_id BIGINT GENERATED ALWAYS AS IDENTITY,
    profesional_id BIGINT NOT NULL,
    tecnologia_id BIGINT NOT NULL,
    nivel VARCHAR(20),
    CONSTRAINT pk_profesional_tecnologias
         PRIMARY KEY (profesional_tecnologia_id),
    CONSTRAINT uq_profesional_tecnologia
         UNIQUE (profesional_id, tecnologia_id),
    CONSTRAINT fk_dt_profesional
         FOREIGN KEY (profesional_id) REFERENCES profesionales(profesional_id),
    CONSTRAINT fk_dt_tecnologia
         FOREIGN KEY (tecnologia_id) REFERENCES tecnologias(tecnologia_id)
);

CREATE TABLE experiencias(
    experiencia_id BIGINT GENERATED ALWAYS AS IDENTITY,
    experiencia_uuid VARCHAR(36) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    nombre_empresa VARCHAR(60) NOT NULL,
    puesto VARCHAR(60) NOT NULL,
    profesional_id BIGINT NOT NULL,
    CONSTRAINT pk_experiencia
        PRIMARY KEY (experiencia_id),
    CONSTRAINT fk_experiencia_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesionales(profesional_id),
    CONSTRAINT uq_experiencia_uuid
        UNIQUE (experiencia_uuid)
    );

CREATE TABLE proyectos(
    proyecto_id BIGINT GENERATED ALWAYS AS IDENTITY,
    proyecto_uuid VARCHAR(36) NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    descripcion VARCHAR(4000) NOT NULL,
    url_produccion VARCHAR(1000),
    url_repositorio VARCHAR(1000),
    url_imagen_presentacion VARCHAR(500),
    estado BOOLEAN DEFAULT TRUE NOT NULL,
    experiencia_id BIGINT NOT NULL,
    tipo_proyecto_id BIGINT NOT NULL,
    CONSTRAINT pk_proyecto
        PRIMARY KEY (proyecto_id),
    CONSTRAINT fk_proyecto_experiencia
        FOREIGN KEY (experiencia_id) REFERENCES experiencias(experiencia_id),
    CONSTRAINT fk_proyecto_tipo_proyecto
        FOREIGN KEY (tipo_proyecto_id) REFERENCES tipos_proyectos(tipo_proyecto_id),
    CONSTRAINT uq_proyecto_uuid
        UNIQUE (proyecto_uuid)
    );

CREATE TABLE etiquetas(
    etiqueta_id BIGINT GENERATED ALWAYS AS IDENTITY,
    etiqueta_uuid VARCHAR(36) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    CONSTRAINT pk_etiqueta
        PRIMARY KEY (etiqueta_id),
    CONSTRAINT uq_etiqueta_uuid
        UNIQUE (etiqueta_uuid)
    );

CREATE TABLE proyecto_etiquetas(
    proyecto_id BIGINT NOT NULL,
    etiqueta_id BIGINT NOT NULL,
    CONSTRAINT pk_proyecto_etiqueta
       PRIMARY KEY (proyecto_id, etiqueta_id),
    CONSTRAINT fk_pe_proyecto
       FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id),
    CONSTRAINT fk_pe_etiqueta
       FOREIGN KEY (etiqueta_id) REFERENCES etiquetas(etiqueta_id)
);