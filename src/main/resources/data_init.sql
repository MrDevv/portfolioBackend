-- INSERTAR ROLES
INSERT INTO roles(rol_uuid, descripcion) values ('2771fbb1-cc5c-4f30-9509-70c302dffea8','admin');
INSERT INTO roles(rol_uuid, descripcion) values('6dd6f503-c8a3-4d93-9a1e-8be9967218cc','user');

-- INSERTAR TIPOS DE PROYECTOS
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('50fac612-58c1-408a-8aed-f2247d65386d','backend');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('0c998429-4a3c-4456-b995-19debb249c2c', 'frontend');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('d6e5f3d6-18c4-4184-b813-0415d265e3e2', 'fullstack');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('2703f1b3-5c84-4744-b8d0-934dfa06d091', 'aplicación web');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('999f0c3b-5f93-4b16-acde-a23749aae829', 'aplicación móvil');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('94af2d23-18d9-441f-b085-016a4de6b1ee', 'ciencia de datos');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('1834ee98-1c72-4bfa-a61c-93d3f0c251e4', 'machine learning');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('2f05f5e1-41b1-451b-80bc-59d03f4056ab', 'big data');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('7c3ba08a-59b2-407a-b015-b9f4e426dab3', 'análisis de datos');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('cc0ea5b5-854f-465d-ab9e-3f15586c099d', 'aplicación de escritorio');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) values ('84f34ce8-d99d-45f0-ac72-a190920550e8', 'videojuego');

INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('8f6e6f24-db7d-4389-99fe-4cdf0a9a0c5e', 'IA generativa');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('72c1edd0-3059-4aac-a7f2-d4c7e372704c', 'ingeniería de datos');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('e0fb1630-9be3-40e0-ab04-d687899c6b11', 'inteligencia de negocios');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('12e7265f-2c6e-4219-8cfe-9f4ccb0998cc', 'base de datos');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('021e55fd-c7fd-4ece-9b74-e6c0110baf89', 'automatización');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('869662f7-c866-4473-856b-9c05c2f5f32e', 'bot conversacional');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('ad723066-ee48-43b3-8c72-b3a161c57cdc', 'integración de sistemas');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('784af18d-3e90-4ea6-af0b-651d9c2f54cf', 'infraestructura en la nube');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('9adcee91-14d0-4a4f-a4fa-300cf3b822b3', 'devops');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('3602f01b-b639-4c6d-adbb-fef000ea3b1a', 'ciberseguridad');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('0b31c6fe-dbda-4155-bb5d-293cffb1b641', 'internet de las cosas');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('e3c7a333-3258-4a7c-be6e-91c5e38f83d0', 'sistema embebido');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('5c173a29-5320-4998-869d-00a3dd7a32c9', 'realidad aumentada');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('23fdb745-a255-4cdb-b0d7-a94af9260f53', 'realidad virtual');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('87897cf9-84ed-4de9-bb94-63ed29b259f0', 'extensión de navegador');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('f21e17a2-d912-4c04-9363-72f9d77ff272', 'herramienta de línea de comandos');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('b3bf0af5-9dee-4c9f-ae11-3fd8223d2e56', 'biblioteca de software');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('d9145051-9f11-47f3-97f3-e930f0ac1767', 'diseño UI/UX');
INSERT INTO tipos_proyectos(tipo_proyecto_uuid, descripcion) VALUES ('8c743763-6efd-4668-a641-cc318c24094a', 'automatización de pruebas');

-- INSERTAR TIPOS DE TECNOLOGIAS
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('d631d8ee-74cc-4746-a49a-8d8e9aff8c5b', 'lenguajes');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('17896f48-b365-4a68-87c6-d549cd0acfe7', 'frontend');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('5fcebbaf-7e58-4703-aab9-0d15603d3b57', 'backend');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) VALUES ('3deb9fd4-b9b3-4e1c-83bb-0fc17d7b36a1', 'bases de datos');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) VALUES ('59dc470a-d4ab-4121-8bdb-baf9c58c8138', 'datos');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) VALUES ('7ea3bca9-f483-46c8-911d-a0f00e8bf08b', 'inteligencia artificial');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('414d3a0a-a393-492c-b4ab-06e314582642', 'herramientas');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) VALUES ('e4a9c520-0148-480b-b199-b492ef5fdaa9', 'infraestructura');

-- INSERTAR TECNOLOGIAS
--                   LENGUAJES
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a3adf43e-3b17-406e-8380-6624384fa88a', 'Java', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('69784151-85e4-44e5-b329-020b2ad58eb4', 'TypeScript', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/typescript/typescript-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('067ec740-1996-43fc-a132-496d8bc06da4', 'JavaScript', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/javascript/javascript-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('70da6a44-8488-4350-b542-830d4958ecfd', 'Python', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/python/python-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('9eaf3eb7-587e-4c8c-be16-3fa7ac23077a', 'C#', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/csharp/csharp-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('8990a24d-a477-46ba-98bb-ac4d76e67f57', 'C++', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/cplusplus/cplusplus-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('312da272-a04d-404f-9a5d-992d583a1f78', 'PHP', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/php/php-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('8cb3d5df-78a9-4c2f-b023-0d836d9d548e', 'Go', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/go/go-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('7b2712b1-0718-4b89-8884-b2ecc3dfbe43', 'Kotlin', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('d1b1488f-db2a-41ae-9336-10a0bc2ec0b6', 'C', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/c/c-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('9682b922-1916-46d0-8356-fb3fed73166c', 'Rust', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/rust/rust-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('b70f2a4f-e534-4c07-a284-7aa02b6a5416', 'Dart', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/dart/dart-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('206dd19d-3ab3-482b-84b5-52f0ea6ac8b0', 'Swift', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swift/swift-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('29cb1085-b4c6-42a3-85fc-4efd81c50eef', 'Ruby', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/ruby/ruby-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('800092fc-1b02-481e-be50-a6bf41d557e4', 'R', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/r/r-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('b7c4340b-76e4-45d8-a163-a835dae81e7a', 'SQL', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sql/sql-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('9bde21b5-f8b6-4fcc-b850-9228eb0b7bec', 'Scala', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/scala/scala-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('3fdf4d8c-b198-4263-9810-14ddbb615e1b', 'Bash', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/bash/bash-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('963ef103-d084-458a-88ac-b5c36ff84d47', 'PowerShell', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'lenguajes'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/powershell/powershell-original.svg');

--                  BACKEND
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f2e6da67-f88a-4b61-824d-10e38ba02f9b', 'Spring Boot', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('db6313cd-aa01-4c2a-b0c6-1b129c2ed23e', 'JWT', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('c074d76b-f77d-4143-9d34-01a0a9b027d3', 'Spring Security', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('57afe199-1196-420e-9418-61b757a1051f', 'Node.js', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/nodejs/nodejs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('bde28183-a8be-4c63-bd05-5e0e44da2113', 'Express.js', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/express/express-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('3bd1ebc0-207b-4364-bb1d-885351853a35', 'NestJS', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/nestjs/nestjs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('b8b1f43e-45fd-4ab3-8acf-c474db66847b', 'Django', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/django/django-plain.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f05ad849-f857-45c1-909b-9528d9548eb8', 'Flask', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/flask/flask-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('d3d21ee4-cc9e-4401-82ce-aeea549078df', 'Laravel', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/laravel/laravel-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('3e0b788d-36a3-4619-a346-c7616c35cff5', 'ASP.NET', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/dot-net/dot-net-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('51bc5cd1-e613-4973-b57a-7538ce5434f0', 'FastAPI', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/fastapi/fastapi-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('13024f06-d45d-4a29-85c6-6606472340d3', 'Quarkus', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/quarkus/quarkus-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('ac012424-3f5f-48e9-a8c4-32665f4d369c', 'Spring Data JPA', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('266957fa-4096-42cf-921a-057cbd216b61', 'Hibernate', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/hibernate/hibernate-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('bd3c5cf0-f8ec-4d83-833d-bab61eb7a8c2', 'Spring Cloud', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('02e769ff-dd5a-44b0-a5aa-0ac0368ad0b6', 'Spring Batch', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('cbec6c51-0f94-44c7-baaa-7e1b3df9ef35', 'Symfony', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/symfony/symfony-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('510d55f2-87c8-4bd0-9248-9f967e4573a4', 'Ruby on Rails', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/rails/rails-plain.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e71c3919-ab8b-4832-a317-d67b9db610a4', 'Fastify', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/fastify/fastify-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('6c72eedb-54be-49e1-bab2-0fd3a5d2e254', 'Prisma', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/prisma/prisma-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('98e00082-4e26-4d69-a000-cab3f3456646', 'Entity Framework Core', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/entityframeworkcore/entityframeworkcore-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('b04dafbc-7c2a-4bda-b07f-9a0b08f267a0', 'SQLAlchemy', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sqlalchemy/sqlalchemy-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('2b928698-78bd-4c09-b412-4075c621ec2b', 'RabbitMQ', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/rabbitmq/rabbitmq-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('484baa2d-9370-4cd3-8160-c581fefc9660', 'Apache Kafka', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/apachekafka/apachekafka-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('5b27ad45-d117-4f3c-9ade-481dc554ce0f', 'NATS', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/nats/nats-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('ae267ddf-7113-4978-9558-3caf889c19d4', 'Apache ActiveMQ', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('79bbd667-c940-4d2c-b9d6-f4cc7f77e8dd', 'Keycloak', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'backend'), '');
--                  FRONTEND
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('83c3051b-32e4-42d2-ae22-1d2b98b75aa0', 'Angular', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angular/angular-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('92046a2b-5b43-4d5c-95c8-b19ccc68f21f', 'CSS', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/css3/css3-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a59b72a4-37d8-45fb-a5e7-561126f1c8f2', 'React', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/react/react-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('8f5a8360-41b7-4b23-b963-212c2dc5ca18', 'Vue.js', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vuejs/vuejs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('12675b88-a6b1-44d1-9e57-3dccc87569db', 'Next.js', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/nextjs/nextjs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('1a29c1f1-b085-4509-8d66-d2682e8a28c8', 'Bootstrap', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/bootstrap/bootstrap-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e2b513be-fcc8-4276-b5fe-f947d1ce65e0', 'Tailwind', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/tailwindcss/tailwindcss-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('511cd55c-eea1-41ff-a3fe-77c9693cf070', 'jQuery', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jquery/jquery-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('80b47e13-58c8-4592-a676-68865e54186e', 'HTML', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/html5/html5-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('270412fc-0f1b-4da5-8e57-325130bf1c6f', 'Sass', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sass/sass-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('d07cd80e-9cd7-49e3-a22e-bdadbc7b65ab', 'Angular Material', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angularmaterial/angularmaterial-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('5b16bf38-a15f-4ea8-84c6-83a0036e6a07', 'PrimeNG', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/primeng/primeng-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('58b3e986-a605-4d9c-9a74-8510872581fd', 'RxJS', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/rxjs/rxjs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('ca7e2102-e150-4da0-b745-a716ab0cdd06', 'NgRx', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/ngrx/ngrx-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('bf5df67f-c0fb-4c71-b359-a14110ffb0ea', 'Svelte', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/svelte/svelte-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('35faa169-f08e-4f56-9726-d7adb53e3cc0', 'Nuxt', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/nuxt/nuxt-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('4e4ec157-3238-4a6b-a6c6-dce21d03a34d', 'Astro', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/astro/astro-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('6512e90d-e1e7-4632-9f75-fb708f998c81', 'Redux', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/redux/redux-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f0db0f7b-ffce-488a-843f-15718c0c3fa8', 'SweetAlert2', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('0d63a4e0-ee22-4f37-abd7-db9f783c3203', 'GSAP', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('0689786c-4327-43c6-88e5-04d63100b359', 'Three.js', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/threejs/threejs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('1c03e68b-a30c-48f1-93f1-4541e090d7b2', 'Flutter', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/flutter/flutter-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f7c1801c-d7d4-4ca0-88f4-fb6ab5ca413f', 'React Native', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/reactnative/reactnative-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('aec9b3d8-4727-48e1-9465-f043336ecd9b', 'Ionic', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/ionic/ionic-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('35b905d2-4363-4224-8a10-459d5c213d96', 'Capacitor', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/capacitor/capacitor-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('49ee2dd5-dba3-4ddc-9ec4-b72159762bb2', 'Jetpack Compose', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jetpackcompose/jetpackcompose-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('4d71c165-dd5b-4402-b9b4-0db6006da963', 'Kotlin Multiplatform', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('6519419b-0d45-441b-8a57-95c5d7d7ff84', 'Expo', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/expo/expo-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('62efec9d-e1f1-4660-bf0f-d92a93606871', 'Electron', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/electron/electron-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('fdef69f8-ac0c-45aa-a7e9-6e00b61dce26', 'Tauri', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/tauri/tauri-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('599896f0-c3cb-4d89-8536-bfee6d0fd38d', 'JavaFX', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'frontend'), '');


--                  BASES DE DATOS
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a3382e9b-847a-4a79-b7f0-c77bd4cd911d', 'Oracle Database', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/oracle/oracle-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('c068a48f-5581-4501-addf-36ddf06a0b38', 'PostgreSQL', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('8cb208c3-f7d0-4177-98b7-8e1dacfabccb', 'MongoDB', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mongodb/mongodb-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('421303ad-64d2-41d0-b357-86b35511871c', 'Redis', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/redis/redis-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('90ea6cb0-b166-46a3-9ac6-10f10c6d4e9a', 'MySQL', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('1b7a90cd-6c23-44ab-8b88-e6c3e5a03faf', 'MariaDB', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mariadb/mariadb-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('22264283-46a0-442c-99eb-b121a53f4057', 'SQL Server', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/microsoftsqlserver/microsoftsqlserver-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('8febfe0f-9ec1-4a6b-baa2-7fc04c9ff3c4', 'SQLite', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sqlite/sqlite-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('fd4e6861-d23f-4d2c-9b49-a7d5d94b63e7', 'Apache Cassandra', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/cassandra/cassandra-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('854d8460-3a07-4025-8a1a-e4c3748c9eb1', 'Neo4j', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/neo4j/neo4j-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('fd80869c-3d13-45a5-b0fa-e76a8ce60eaa', 'Elasticsearch', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'bases de datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/elasticsearch/elasticsearch-original.svg');

-- DATOS
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f16feb65-6bda-4eb3-bd20-c07f92030f86', 'pandas', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/pandas/pandas-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('6b82bcc3-8b25-482d-b1a5-36d677a72def', 'NumPy', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/numpy/numpy-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e55c2984-f56c-4d09-8aee-0cbbc161338c', 'Polars', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('c87c54ed-6304-4176-b7e2-fcd4d0fdbe90', 'Matplotlib', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/matplotlib/matplotlib-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('085a3050-53e5-409a-8c80-8534e517c494', 'Seaborn', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('3b2d20b8-e5b8-4122-9b09-e94f98c002e6', 'Power BI', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('66bedae7-a8c6-4f85-bd91-33de66ec6fdd', 'Tableau', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('aa50fdbd-b7b4-4f60-8864-d791a48a6da4', 'JupyterLab', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jupyter/jupyter-original-wordmark.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('c777a291-98b9-4a1c-8516-357c3f79b40e', 'Apache Spark', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/apachespark/apachespark-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('7e11e439-c9af-480a-a5e1-b1206d8a2e73', 'Apache Airflow', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'datos'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/apacheairflow/apacheairflow-original.svg');

-- INTELIGENCIA ARTIFICIAL
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('672d12c6-fe13-433a-9df9-1f72446835d3', 'TensorFlow', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'inteligencia artificial'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/tensorflow/tensorflow-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('d2af5aff-d000-40fb-8c56-ea062aeadaff', 'PyTorch', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'inteligencia artificial'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/pytorch/pytorch-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('9d0ec9ae-308e-4273-836e-32a1c8e31274', 'scikit-learn', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'inteligencia artificial'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/scikitlearn/scikitlearn-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('36f43d98-49a1-4728-917f-96f8f17e795f', 'Keras', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'inteligencia artificial'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/keras/keras-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a51ce097-8f62-49b5-89ad-0038893127bc', 'OpenCV', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'inteligencia artificial'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/opencv/opencv-original.svg');


-- HERRAMIENTAS
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f5ba2850-34a3-4d56-b095-4f3048944aaf', 'Postman', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f33e3433-a3d1-4583-b5c7-61698822ba48', 'Figma', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/figma/figma-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('294c0f89-bd9e-4059-a50e-3b386947e2f4', 'Git', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('cb189965-24c2-4f3d-b014-f3acc28ef217', 'GitHub', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('bcacde33-51e0-4ffd-89f0-d0a5213863af', 'Visual Studio Code', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vscode/vscode-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('2c9a5363-8990-4597-b70c-d6ecb048cf95', 'IntelliJ IDEA', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('23bd0b45-b9cf-416a-803c-bc8d9a57f028', 'GitLab', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gitlab/gitlab-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('d8027409-c6f4-4cb6-a90c-866953ebec82', 'Vite', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vitejs/vitejs-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('26002c70-2953-47c2-ac42-88b6ba96cca0', 'Webpack', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/webpack/webpack-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('24edbe17-a03f-4caa-9003-ad963e473ee7', 'DBeaver', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/dbeaver/dbeaver-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('b9d0ccf0-2c29-41bf-86b1-24f5738c76bf', 'pgAdmin', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('69e9dbcc-983c-494e-a35d-86259ea9d935', 'Insomnia', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/insomnia/insomnia-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('6f4f9319-c832-483c-b282-3880d34ca5bb', 'Swagger', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swagger/swagger-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('7f2b0de1-b914-40ba-ad3a-a614369856ea', 'Apache Maven', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original-wordmark.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('1176890b-b1ac-494c-9292-fd098e60c6b3', 'Gradle', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('79ebb609-8241-4702-95a9-5594cfe41586', 'npm', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/npm/npm-original-wordmark.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('bc7f70eb-a2c6-4250-98cb-bd9d5b4897ee', 'pnpm', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/pnpm/pnpm-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('457a5ea0-349d-4f49-99a4-00eb383155d3', 'Jira', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('eae7f8e1-870d-4d7f-bf14-3e2121333876', 'JUnit', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('668cdbf2-4b50-4018-8ca0-2959f2b9ce1f', 'Mockito', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('5dd93f4c-4962-411a-9481-55333641f013', 'Testcontainers', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('de70550f-7a0e-4fdb-808c-3a52fd91312c', 'Jest', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jest/jest-plain.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('8b92f78b-ff40-4f05-bb79-021b72ff2445', 'Vitest', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vitest/vitest-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('04d8b96c-ad35-4714-918e-0ea6da7dd6ea', 'Playwright', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/playwright/playwright-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('2cc92790-4a2d-4416-b508-b194c3dc65e6', 'Cypress', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/cypressio/cypressio-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('819ba659-8893-418d-ace9-1806022c6f93', 'Selenium', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/selenium/selenium-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('9b48acea-cdeb-4faa-9471-31d2a6c6b0a6', 'pytest', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/pytest/pytest-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a8ee5604-8860-480e-8564-f40233316b67', 'k6', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/k6/k6-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('c4b65c53-bea6-4c49-85b5-386bcdd94ff8', 'Unity', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/unity/unity-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('766b33b3-dc47-452e-a2a9-e2bc36c98302', 'Unreal Engine', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/unrealengine/unrealengine-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('087dbeed-79bc-49b7-8470-163ca0a9ad06', 'Godot', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'herramientas'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/godot/godot-original.svg');


-- INFRAESTRUCTURA
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('7e95c9fc-8221-4d73-8679-910353a443dc', 'Docker', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('3300a9d1-10e6-4ec7-a786-992332572e1b', 'Kubernetes', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kubernetes/kubernetes-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('b39b0139-542c-4010-b839-b87f3343417c', 'Jenkins', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('79a56e36-9231-4ac9-8097-dc1fa3446fda', 'Azure', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/azure/azure-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('180138e2-70b8-482b-b379-246835125095', 'AWS', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/amazonwebservices/amazonwebservices-original-wordmark.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a98698af-d791-4f66-94d8-e78ff1210ae2', 'Google Cloud Platform', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('bd5dae16-d72c-487e-9791-6c911f806cba', 'Apache HTTP Server', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/apache/apache-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('69387441-9f47-463b-a1b0-cada0dbebae4', 'Nginx', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/nginx/nginx-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('1f50ab41-0aed-4873-a24f-00c7f54386eb', 'Firebase', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/firebase/firebase-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('5d59a81c-c643-455b-ac8f-c64bea48e853', 'Docker Compose', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('f7acac64-079a-42f2-be30-b5d898442153', 'GitHub Actions', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/githubactions/githubactions-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e49950d1-c1dc-4569-b93c-f3f12a2c80ee', 'Terraform', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/terraform/terraform-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('870a9d32-01d4-4ef8-b975-5108e3ddb222', 'Podman', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/podman/podman-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('4ad00908-c2a4-4013-8228-5cebc2cf98f2', 'Prometheus', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/prometheus/prometheus-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('2f6a24c9-0c61-4931-a638-20319faca7ed', 'OpenTelemetry', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/opentelemetry/opentelemetry-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('a9fffcb4-00ee-43ce-acf1-ccc645afc7b5', 'Kibana', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kibana/kibana-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e7c752b3-5246-46b4-a094-f0539e8a0c44', 'Cloudflare', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/cloudflare/cloudflare-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('1dc19ae3-8680-4504-bfcb-a1f2444bd53e', 'Netlify', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/netlify/netlify-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e1016585-cede-4dde-ae82-b6a62434791c', 'Vercel', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vercel/vercel-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('4b96d4a0-9f01-4dc6-b01e-fb95aa742477', 'Render', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('157740ef-c69e-4a90-a8f4-d22c713c0feb', 'DigitalOcean', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/digitalocean/digitalocean-original.svg');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) VALUES ('e8a60e54-eeea-4cbe-bfd1-815fdb5aecd0', 'Supabase', (SELECT tipo_tecnologia_id FROM tipos_tecnologias WHERE descripcion = 'infraestructura'), 'https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/supabase/supabase-original.svg');

-- INSERTAR ETIQUETAS
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b', 'Angular');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c81fd03d-80f4-42dc-a448-f5673313a0b2', 'Spring Boot');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('40877212-b13e-4917-bb76-b4576189d4e4', 'JWT');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c16231be-9c65-4866-813f-05d6f63fdab5', 'Responsive Design');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('d3bdcad5-ce33-4ff9-9563-8c55a973595e', 'TypeScript');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('b051f5dc-07a9-4fd1-a56d-92294092be57', 'POO');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('e2619fee-d2ed-4b90-ba26-294609e54604', 'Tailwind');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('a31030cb-c2a9-47af-b887-2e570ddeeaee', 'N-Capas');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('305f40c3-3d9e-4d71-8847-48b355187073', 'Spring Security');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('4d9451e1-0441-4ae2-8360-e2d007ddd9bb', 'Python');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('d7f96db9-2df9-4507-af4a-cf7b6380c1a1', 'FastAPI');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c5a405c5-c080-47bb-b4ea-2f71919f9c93', 'Docker');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c53cc9ef-b52f-4218-acae-8e78a8bcc570', 'SweetAlert2');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('837103c4-c93c-49a1-a28b-0682cff207f6', 'Clean Architecture');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('952185d0-76a4-443d-8ea9-ea36b4d104b7', 'MVC');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('955740d1-f7b3-4ca1-a3ee-eb50952b13ed', 'PostgreSQL');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('30cf336a-342b-4e0b-81d7-eedef7e5181b', 'MongoDB');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('fd341a1f-0043-4de6-a725-d531516feb64', 'SQL Server');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('fc5e284c-0ab3-4336-be05-a8f9d3ada158', 'Firebase');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c44aaa6e-1504-4e51-adf2-e337d6461627', 'Express.js');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('666c1b35-a67d-4540-8c40-f2433f3f3f7e', 'NestJS');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('5bbe319e-41cd-43b9-a247-836f63749b60', 'Arquitectura Hexagonal');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('267d2e1e-2736-4f95-9899-dd668ca9dffa', 'Java');

INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('04d893f4-a9a4-4a33-9b11-f7aa47a0de65', 'JavaScript');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ae25d6fe-bdb5-4ca4-a279-a07520f08038', 'HTML5');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c9043e3a-4652-447b-ac6a-1fd417e8a097', 'CSS3');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9f3ac983-fd7e-41df-825b-d0c28b13b026', 'React');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('34e4cc85-53b5-4941-9cd6-5e40a3533968', 'Vue.js');

INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('0d1b42eb-cf91-4adc-8bea-9ed8dbb18453', 'Next.js');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('62d57cbc-b386-47e6-b9d5-6c0d8049e5c4', 'Node.js');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('a02bbff8-10a8-4a10-9f21-bed3f82a8b0c', 'Angular Material');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1d1852fb-3b0a-4981-aacf-00f80b321900', 'RxJS');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('81f3939e-ef6b-4608-bd67-14cf5a86df2d', 'Bootstrap');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8bef20fd-4da1-4636-b622-74060bcf33d6', 'Sass');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('df6fd911-108f-46ed-a756-230694d3ed9b', 'Spring Data JPA');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c3014186-3487-4f0e-819c-a3ae6364da00', 'Hibernate');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('a307ae7e-0cb9-4523-8489-95bec4a698eb', 'API REST');


INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4764b127-10a2-42ea-b7c2-0c21f85a18ef', 'GraphQL');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('6f3f3439-3a9e-4770-9d1b-28185f55bca1', 'WebSocket');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('d280be7a-caf2-4ad1-8471-aaf00ef16c1c', 'OAuth 2.0');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b9c1e561-76bf-4dd3-b014-7a6bd4a530d6', 'OpenAPI');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('0d7e9f61-fb39-462b-bcd0-24f36b570da7', 'Swagger');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4f6da706-1639-4a8e-9692-ffa7941223dc', 'MySQL');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('e2a18cc3-e40c-4ef6-9289-a2d358011bbf', 'Redis');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('122fd9b8-c955-46df-be86-30aa56f75e83', 'Flyway');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('651dabe2-46cf-4530-85e7-5695d0ab46bc', 'Git');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1a23f94c-27eb-4911-85c2-8d2b73882476', 'GitHub Actions');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8fd29fa8-423b-4460-85aa-d22772d6d474', 'CI/CD');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c590dbe3-3799-4fab-972c-4455ca0c93d0', 'Linux');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1e069adb-08cb-4606-a678-9e43fc132a1f', 'Nginx');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('0425f2a9-ecfa-4bf5-9a36-33f7735a83e0', 'Docker Compose');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('cf6e2043-07a7-4d9c-be2c-25edf173eca8', 'JUnit');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('69c3a7f3-2c6b-4648-bc90-05e06036f7ce', 'Mockito');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b9e0ade3-9990-4d75-9562-154dd32116d7', 'Testcontainers');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('cf9b43f8-35eb-470f-92d4-442382c5feac', 'Vitest');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f5224675-1b09-4f24-ba60-62e030b6fa12', 'Playwright');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('40572cac-1fff-4b52-8298-c7b6163a8764', 'Pruebas unitarias');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('6c26c907-14a6-4ca6-b9d8-e67f6b69ee13', 'Pruebas de integración');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('5f5beab8-1cce-435d-b0d4-02acfcdd71b1', 'SOLID');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4fdb6bcd-8f25-448c-a860-165858df3f95', 'Patrones de diseño');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2a5e44d2-e90b-4ba9-84ad-b47e5a5b61d5', 'Microservicios');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('a59a7961-5233-4504-a7f8-3aafe29549b6', 'Monolito modular');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2445a113-450b-4441-851d-775c2a55b8eb', 'Scrum');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c39cb98f-682b-4f93-a981-3deec2843bcd', 'Accesibilidad web');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('40146eb8-a64c-4ea2-83da-707716d8c571', 'SEO');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('554bf0e3-1860-49ec-9068-1ed8d81b1fb5', 'Diseño UI/UX');

-- Backend
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('55ac5734-2670-4696-bc38-b97725e3490b', 'PHP');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9b3fe2c3-8420-45ed-91b1-0a56ffdbadd8', 'Laravel');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('96644461-ecd2-490f-880b-4cc2a9e916f8', 'Symfony');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('64801d31-ff6a-47e4-bb10-55e52d6c35e8', 'Django');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9d108bf2-e9da-4720-b50a-80a014893287', 'Flask');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('769ae989-c62a-4985-85c1-1804d01f2a1b', 'Fastify');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('79d85890-f59b-4644-9d0d-d31f1efc1257', 'ASP.NET Core');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('24f99a03-e2f2-4c0c-954f-33a82173c3cd', '.NET');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('5670c7f0-23c4-44b9-88de-3a6bf50e1bcb', 'C#');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8607c30e-edfe-4336-87d1-fb4b0853adf6', 'Go');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7410a8ee-f065-4c88-a44d-7741598443a6', 'Rust');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('d9623324-03de-43c3-b66e-fc747f8883a9', 'Ruby');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('46afd8c3-4579-426b-9107-5ae290b91290', 'Ruby on Rails');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('bf3e114d-9b55-4679-919c-102a7e14beb5', 'Kotlin');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2ab99fc7-8089-4992-9620-09975976cdec', 'Quarkus');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2b6e69a7-25bc-40be-84eb-b0b06697645c', 'Micronaut');

-- Frontend
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('da8fa2d1-c89a-4159-b51b-61ac6e474829', 'Nuxt');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2d513019-3a3a-40db-a581-3e847d2a3396', 'Svelte');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('cd451215-33ad-4d3c-9d8b-56f9937c9508', 'SvelteKit');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4d700a43-b325-479c-a9d4-9b1b681ca524', 'Astro');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1a8e54d8-715d-4b85-b015-f8913d287e00', 'Remix');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('a179ca62-2765-4e3a-9174-b122656d8960', 'jQuery');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9c173a1d-834e-476c-9f69-2af63d3da5f4', 'Vite');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ce396b44-001a-40ac-9864-8d1cefe5e08c', 'Webpack');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b9ad2777-1f7c-47ab-8b0d-3f9a6bb9b209', 'GSAP');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('5977212a-c52d-4656-b829-3e8ea66bded6', 'Three.js');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('a6938091-3737-4a54-b8a9-b8364d46db3f', 'Web Components');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('533c7617-5996-4999-a7a9-2690d2c657dc', 'PWA');

-- Desarrollo móvil
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b224eb95-2f92-4a28-b1de-e0aec1f1076b', 'Flutter');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('65997386-8d0c-4ada-bccf-44a8dc9883b9', 'Dart');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7d221b93-1f96-4fae-adad-dabd7a27afb9', 'React Native');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('24cb1d31-0fa9-4711-bb2f-b68370f9229c', 'Ionic');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('aa24d298-e03c-4f0f-8803-c2270ba44281', 'Capacitor');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1f4d06d0-ef25-42f2-b20a-dcb1a4558cd5', 'Android');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('838b49f5-6a3c-4cc4-b027-5c98d62809a3', 'Jetpack Compose');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('03058e35-1d23-450b-8cba-45b094a27f51', 'Swift');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f08b2444-7a93-4c81-9de6-333cde881b88', 'SwiftUI');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f6f44acc-d978-4768-8e56-26551e965ea6', 'Kotlin Multiplatform');

-- Bases de datos y búsqueda
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4e6a979e-7dd3-4f8e-bfd6-e07279657ad5', 'MariaDB');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('de02daa4-8809-4c31-8ccc-dc5cfe5a34f9', 'SQLite');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('3242fb93-f42e-4a39-84a5-24927d3b61b9', 'Oracle Database');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8eef75cf-8632-4fcf-910e-26330069f0a8', 'Supabase');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('eba8b9cf-a13c-427d-9ebc-d7531e8e3eb7', 'DynamoDB');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('376c06ad-cd96-4a93-adc3-1611f0f7dc10', 'Cassandra');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b5a436e5-0ae2-4d8e-aa40-7e30a0d78ad0', 'Neo4j');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('99841b11-1425-485d-b500-601e67cf9e4f', 'Elasticsearch');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('afeb888c-1e90-4688-a884-c04652486614', 'OpenSearch');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b13b8f46-5144-4f1b-b324-652f9c0574ec', 'Firestore');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8daa7462-7731-42f7-b253-3e59e81c1c79', 'CouchDB');

-- Inteligencia artificial y machine learning
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c835a359-9d45-4f20-a4ef-3cae9e01f661', 'Machine Learning');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f15b508a-8593-4ea9-9d10-b4cf7dddf5f5', 'Deep Learning');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('62d6962e-ca01-4b6a-a4ca-32d4cb18814d', 'TensorFlow');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c3d002e2-bf8a-4ae0-a479-7eb3136a24a5', 'PyTorch');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('737ae72c-7a05-4a91-ae14-1dc05035feea', 'Scikit-learn');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9eb4a1e3-e9da-46c2-af4e-cf80c96bfd68', 'Keras');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('bd093cb0-ecbe-4038-8040-b94bf9ca5307', 'Hugging Face');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('650371d1-47bc-4130-bf2c-7258984e0026', 'Transformers');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1ea25a72-c6be-4cfa-8fd8-9ec42ae4e002', 'NLP');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('890752a6-d154-4d5e-b383-d9dab63af464', 'Visión por computadora');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f8902105-4bfb-4208-80bb-a0495be227c9', 'OpenCV');

-- Inteligencia artificial generativa
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f8e45177-2de2-4473-9d96-3068d956eb58', 'LLM');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ef899db9-7485-4b07-8fec-05874ea7645a', 'RAG');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c961e5e2-a0cc-47a1-aeb2-2781e91b8d26', 'Embeddings');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4399977c-f47c-488f-988c-98ce99ac852a', 'LangChain');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('511b69a9-4e73-4198-a464-3dc5649828da', 'LlamaIndex');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('71ff0f61-2fbf-4b09-9fc5-45ac9b2a0aab', 'Ollama');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('48ee91d2-4360-40cc-a33f-df06f73ee295', 'OpenAI API');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f8b7f8ab-091c-41ef-b1c3-4a5003d55a4b', 'Fine-tuning');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('73202f86-a7a2-4b3f-a99a-7ee61434fbcd', 'Bases de datos vectoriales');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('02be5210-4029-4ffe-b54b-3b12c0fc2495', 'pgvector');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('d5339607-c337-4a74-b8ac-e77ef8a39cfa', 'Qdrant');

-- Análisis de datos y business intelligence
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('607dc97a-b02b-4dc1-a68a-e137137a3842', 'SQL');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('88d6e9b5-c0a8-41b5-b46d-93c5b3e8e0cc', 'R');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('32cb1241-33a0-46b2-96a8-d03fd154b5c8', 'Pandas');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8cfb371a-7b72-44f8-b501-c70e67198ea8', 'NumPy');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('0144d630-52d6-428c-9c54-2aaee4881a19', 'SciPy');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('de26f39f-8e62-4cd6-b3d0-f6754cc62d18', 'Jupyter');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('454404d3-a1db-431e-9946-316296e018da', 'Matplotlib');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('86164620-68b1-456f-94a3-8b6eac1b03af', 'Seaborn');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b4e47978-31c7-4d9e-8c8d-0033b9444251', 'Plotly');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('fc6bbbd0-d047-499f-b56c-1a37c700c18e', 'Power BI');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4ca99ce1-db9c-466c-9299-916f804d87b0', 'Tableau');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c6f49cd5-e48a-4037-acaa-09bcd4dae45e', 'Looker Studio');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b8205088-df50-4386-9f13-7a6e31630781', 'Excel');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('da967fc7-a374-49b2-9de8-af3e11b613df', 'Análisis exploratorio de datos');

-- Ingeniería de datos
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('d73a3aba-d03b-41c4-a0d3-e1fd22a54b20', 'ETL');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7881e545-c30c-41cf-9b38-e6294f62cea5', 'ELT');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('03861a87-5dad-404b-9b33-ea20e242e91b', 'Apache Spark');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7948fb58-f60e-42fd-aee4-686b91a4cc95', 'Apache Airflow');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('cf5e9af5-5811-4e5a-9155-dd90d086fad9', 'dbt');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('32e5dfee-f623-428f-92c2-8b8282600cdb', 'Apache Kafka');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('230f589b-f863-4c7c-b87c-6d65e2f9b8be', 'Hadoop');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c673d68c-f44a-4696-827c-b99cf48817c6', 'Databricks');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('304e436b-5354-4d10-9ae8-a85dcd8deed0', 'Snowflake');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7a732cb2-71ee-4096-b375-0d11a1b393ca', 'BigQuery');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c2a13a0e-72fb-439e-b7b7-af0becd4614c', 'Data Warehouse');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4abbc26a-ab89-433e-a12c-5040673af021', 'Data Lake');

-- Nube
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('045df926-a78d-48ea-a524-98c9a743e025', 'AWS');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('24fd83c3-6cf0-4b4c-8a9c-c7f60798f2d0', 'Microsoft Azure');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b1519d9f-6316-41fc-a246-c7f599d4272f', 'Google Cloud');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('39a514c5-8536-48bc-abc6-5712aaa7efef', 'Cloudflare');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('40d1fde5-6131-46c0-9ce8-a18d341f7f27', 'Amazon EC2');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('edf4d212-f47b-4d2d-b770-6b274c062d74', 'Amazon S3');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f1e6a0b6-c325-48c4-861d-6522c0a9837f', 'AWS Lambda');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('063faca1-b264-467d-84e8-ce689623a0a0', 'Amazon RDS');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('da9ae738-436a-46bf-a595-e96bebdd9566', 'Azure Functions');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('4c3ceeaf-9796-48ae-ac04-4264cdcab087', 'Cloud Run');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('13b53303-30aa-42a3-81ad-8871a2bca0b0', 'Serverless');

-- DevOps e infraestructura
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('05e3085c-a3fb-42f3-bc8b-913b4eb8ec7f', 'Kubernetes');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('877b0d85-60d4-4004-97c8-641f13eafdfa', 'Helm');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('b4d36f09-40af-48ca-8360-e19539165696', 'Terraform');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1395e18f-f34d-4ed5-b824-8070c1c8b150', 'OpenTofu');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('5b8d0b0e-aed4-4054-85bd-a0a6cb8f27ac', 'Ansible');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('29bc0f3c-f0a0-4f1f-ad04-c3c31a2ab0ea', 'Jenkins');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ccda430c-c7f9-4dc1-9372-614794a72c86', 'GitLab CI/CD');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2958cead-2420-46e1-b6e9-c2591d970a46', 'Argo CD');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('909d85cd-7620-4f8b-bda4-0f642ebc7377', 'GitOps');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('1085d884-27ed-48af-b0fa-30e831e56b23', 'Pulumi');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('fc44f5d5-c357-4b92-9630-bd9a9e20f5cc', 'Bash');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('5da911c9-b631-434d-ac69-cf1302ac6eab', 'PowerShell');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('0850d121-ecbd-471c-96a1-dd4c7fc42507', 'Infraestructura como código');

-- Observabilidad
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f4d04041-3e23-405c-927c-25fd4ebe2fc1', 'Prometheus');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2b8a6791-0632-4547-a279-5aff21ffa5be', 'Grafana');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ceb6ceb2-7a8e-4c94-a051-0b736ed29143', 'OpenTelemetry');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c7cc6121-3a07-4b9c-8541-750a28dda657', 'Loki');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2dac9993-3ba2-4a95-ae2e-6b6a7201eaa7', 'Elastic Stack');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('05cc4b1b-9dda-496d-8eb6-8381cefbaf99', 'Sentry');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9969c238-7f26-4cfe-8846-2a8b84327084', 'Monitorización');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2d2334ca-f82c-4068-a10b-100ba6bc82f5', 'Trazabilidad distribuida');

-- Seguridad
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('0f532708-229f-427d-bdee-ab19e9bdb3e7', 'OpenID Connect');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('237ca6b8-8ad7-4b6d-869e-b81c89c6743a', 'RBAC');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('745b666e-c358-4b57-8fc5-3d7984febc6e', 'Autenticación multifactor');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ee431ecf-3225-4bfe-99f3-68af9ef590cb', 'OWASP');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('3d62bce9-3fe6-4c0e-9b41-7fc596a006e3', 'Gestión de secretos');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('134aab86-cddb-4d3f-b916-15f4c2c1200a', 'HashiCorp Vault');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7359ab9a-f364-4f1d-af52-9c07be568b89', 'Seguridad de APIs');

-- Pruebas y calidad
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('a0e0bb63-7164-43e0-8aa0-b7f0cc025c80', 'Jest');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('31ebc88e-6aa2-42e2-8fa5-ea29999b98c0', 'Cypress');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('55ad958d-cf41-4318-be8c-91069368e233', 'Selenium');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('82ffd8e9-d4d2-4d60-9c2f-f9d79879a633', 'Postman');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('81f2150a-2094-45ee-bbd3-5eecead73c17', 'REST Assured');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('9bbb4e62-d976-4df0-ac6b-07f5622ab6ec', 'k6');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('f75bab0f-881d-468e-84e4-485ccfa2e0c7', 'JMeter');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2fcc153c-801e-43bb-b58e-4c616614dc0a', 'SonarQube');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7539585c-4714-48ec-ab4c-cad70a25f8c5', 'Pruebas E2E');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('886aea7c-6788-41d4-a40c-dc738245e275', 'Pruebas de carga');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2b8d0b14-b489-432b-aaac-cde45804f9da', 'TDD');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('dc6f050e-3a99-43ae-8014-63a38ae73742', 'BDD');

-- Arquitectura e integración
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2a5f4693-62ae-4521-b559-f842f4891c97', 'DDD');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ac7a320e-1eae-4dfa-af65-faf2a8f8f995', 'CQRS');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('195c493b-2aa3-48c6-96b7-100891d17009', 'Event Sourcing');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('463419b0-e65d-4791-afb7-7526e0905f7a', 'Arquitectura orientada a eventos');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('cbfaf5e3-cd06-494c-b238-0ebc08d1751b', 'RabbitMQ');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('18c16540-8ee7-4809-9ac5-4892bc6cc17b', 'gRPC');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('10a38a28-f6bc-441c-bc34-2f838504bec6', 'SOAP');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('55797b63-f556-481f-848e-4dd688c249bd', 'Webhooks');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('654c9d0c-6517-4f97-9ec7-34dad290d2c9', 'Sistemas distribuidos');

-- Herramientas y despliegue
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2fc13fb9-923f-4d7e-9b5b-b3dd6272d20b', 'Maven');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('7738b028-a8d1-4db4-8b83-df1706a20f8a', 'Gradle');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c0987d50-feb3-4082-a2b6-cb96c310f530', 'npm');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('c93c9774-abea-40a9-a227-cd7be65d47c7', 'pnpm');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('36c25d50-be1d-49ac-b761-1616e14df77a', 'Yarn');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('ea13e345-953b-47de-b37e-9da233325fd9', 'Figma');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('087c2f70-e9b9-4343-9994-5e017d9c00f8', 'Jira');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('68897861-6763-4111-9913-649fa1bedeee', 'Netlify');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('2c8fd8e6-5b25-4cd1-a659-be31c3bbaf48', 'Vercel');
INSERT INTO etiquetas (etiqueta_uuid, descripcion) VALUES ('8ab62bfd-3c20-4056-859a-03f0c6d2e193', 'Render');