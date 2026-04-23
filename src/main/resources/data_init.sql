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

-- INSERTAR TIPOS DE TECNOLOGIAS
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('d631d8ee-74cc-4746-a49a-8d8e9aff8c5b', 'lenguajes');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('5fcebbaf-7e58-4703-aab9-0d15603d3b57', 'backend');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('17896f48-b365-4a68-87c6-d549cd0acfe7', 'frontend');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('414d3a0a-a393-492c-b4ab-06e314582642', 'herramientas');
INSERT INTO tipos_tecnologias(tipo_tecnologia_uuid, descripcion) values ('5ebe2f2d-ec1c-412d-b10f-da747d032184', 'devOps');

-- INSERTAR TECNOLOGIAS
--                   LENGUAJES
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('a3adf43e-3b17-406e-8380-6624384fa88a', 'Java', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776895987/java_lltcwe.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('69784151-85e4-44e5-b329-020b2ad58eb4', 'TypeScript', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896050/typescript_boavbe.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('067ec740-1996-43fc-a132-496d8bc06da4', 'JavaScript', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896119/javascript_vcicyj.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('70da6a44-8488-4350-b542-830d4958ecfd' ,'Python', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896154/python_kibnse.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('9eaf3eb7-587e-4c8c-be16-3fa7ac23077a', 'C#', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896250/Csharp_qskcvc.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('8990a24d-a477-46ba-98bb-ac4d76e67f57', 'C++', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896297/C_f4vzjv.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('312da272-a04d-404f-9a5d-992d583a1f78', 'PHP', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896332/php_ussvue.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('8cb3d5df-78a9-4c2f-b023-0d836d9d548e', 'Go', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1775687338/pngwing_oraeij.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('7b2712b1-0718-4b89-8884-b2ecc3dfbe43', 'Kotlin', 1, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896366/kotlin_cxtd1r.png');

--                  BACKEND
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('f2e6da67-f88a-4b61-824d-10e38ba02f9b', 'Spring Boot', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896419/spring-boot_swhswh.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('db6313cd-aa01-4c2a-b0c6-1b129c2ed23e', 'Oracle Database', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896469/oracle_database_zhchcg.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('c074d76b-f77d-4143-9d34-01a0a9b027d3', 'JWT', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896551/jwt_zgptoe.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('57afe199-1196-420e-9418-61b757a1051f', 'Spring Security', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896616/spring_security_vzrsxv.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('bde28183-a8be-4c63-bd05-5e0e44da2113', 'Node.js', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776896966/node_js_u0v702.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('3bd1ebc0-207b-4364-bb1d-885351853a35', 'Express.js', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897111/Expressjs_dn4s2s.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('b8b1f43e-45fd-4ab3-8acf-c474db66847b', 'NestJS', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897160/nestjs_hwkncy.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('f05ad849-f857-45c1-909b-9528d9548eb8', 'Django', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897211/Django-Logo_a8bfva.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('d3d21ee4-cc9e-4401-82ce-aeea549078df', 'Flask', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897321/flask_yxmqev.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('3e0b788d-36a3-4619-a346-c7616c35cff5', 'Laravel', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1775690604/laravel_x8n03o.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('51bc5cd1-e613-4973-b57a-7538ce5434f0', 'ASP.NET', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1775690703/asp_qvtled.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('13024f06-d45d-4a29-85c6-6606472340d3', 'FastAPI', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897382/FastAPI_atanxu.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('ac012424-3f5f-48e9-a8c4-32665f4d369c', 'Quarkus', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897555/Quarkus_t7lri3.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('266957fa-4096-42cf-921a-057cbd216b61', 'PostgreSQL', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897602/postgresql_sh08tg.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('bd3c5cf0-f8ec-4d83-833d-bab61eb7a8c2', 'MongoDB', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897743/mongodb_vqh7sr.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('02e769ff-dd5a-44b0-a5aa-0ac0368ad0b6', 'Firebase', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897789/firebase_mwduav.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('cbec6c51-0f94-44c7-baaa-7e1b3df9ef35', 'Redis', 2, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897877/redis_kjtvvz.webp');

--                  FRONTEND
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('83c3051b-32e4-42d2-ae22-1d2b98b75aa0', 'Angular', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776897959/angular_caemnz.webp');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('92046a2b-5b43-4d5c-95c8-b19ccc68f21f', 'CSS', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898081/css_cnc2kx.webp');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('a59b72a4-37d8-45fb-a5e7-561126f1c8f2', 'React', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898121/react_bo9nyk.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('8f5a8360-41b7-4b23-b963-212c2dc5ca18', 'Vue.js', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898222/Vue_vcshg0.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('12675b88-a6b1-44d1-9e57-3dccc87569db', 'Next.js', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898222/Vue_vcshg0.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('1a29c1f1-b085-4509-8d66-d2682e8a28c8', 'Bootstrap', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898318/Bootstrap_accb2t.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('e2b513be-fcc8-4276-b5fe-f947d1ce65e0', 'Tailwind', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898358/tailwind_kgwpdw.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('511cd55c-eea1-41ff-a3fe-77c9693cf070', 'JQuery', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898399/jquery_mnbchp.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('80b47e13-58c8-4592-a676-68865e54186e', 'Vite', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898429/vite_mub1m5.png');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('270412fc-0f1b-4da5-8e57-325130bf1c6f', 'Webpack', 3, 'https://res.cloudinary.com/dlkdwlkma/image/upload/v1776898465/webpack_spd5k0.png');


--                  HERRAMIENTAS
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('a3382e9b-847a-4a79-b7f0-c77bd4cd911d', 'Postman', 4, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('c068a48f-5581-4501-addf-36ddf06a0b38', 'Figma', 4, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('8cb208c3-f7d0-4177-98b7-8e1dacfabccb', 'Git', 4, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('421303ad-64d2-41d0-b357-86b35511871c', 'GitHub', 4, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('90ea6cb0-b166-46a3-9ac6-10f10c6d4e9a', 'Visual Studio Code', 4, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('1b7a90cd-6c23-44ab-8b88-e6c3e5a03faf', 'Intellij IDEA', 4, '');

--                  DEVOPS
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('e8a60e54-eeea-4cbe-bfd1-815fdb5aecd0', 'Docker', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('157740ef-c69e-4a90-a8f4-d22c713c0feb', 'Kubernetes', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('4b96d4a0-9f01-4dc6-b01e-fb95aa742477', 'Jenkins', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('e1016585-cede-4dde-ae82-b6a62434791c', 'GitLab', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('1dc19ae3-8680-4504-bfcb-a1f2444bd53e', 'Azure', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('e7c752b3-5246-46b4-a094-f0539e8a0c44', 'AWS', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('e1fbf033-a6bd-4979-ad15-b420ea4bed6d', 'Google Cloud Platform', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('a2a81b41-c05a-4fad-acc6-15d485e41284', 'Apache', 5, '');
INSERT INTO tecnologias(tecnologia_uuid, descripcion, tipo_tecnologia_id, logo_url) values ('edad9fb3-28d9-4d76-aaf0-bf47097c7513', 'Nginx', 5, '');

-- INSERTAR ETIQUETAS
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b', 'Angular');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c81fd03d-80f4-42dc-a448-f5673313a0b2', 'Spring Boot');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('40877212-b13e-4917-bb76-b4576189d4e4', 'JWT');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c16231be-9c65-4866-813f-05d6f63fdab5', 'Responsive Design');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('d3bdcad5-ce33-4ff9-9563-8c55a973595e', 'TypeScript');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('b051f5dc-07a9-4fd1-a56d-92294092be57', 'POO');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('e2619fee-d2ed-4b90-ba26-294609e54604', 'Tailwind');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('a31030cb-c2a9-47af-b887-2e570ddeeaee', 'N-Capas');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('305f40c3-3d9e-4d71-8847-48b355187073', 'Scring Security');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('4d9451e1-0441-4ae2-8360-e2d007ddd9bb', 'Python');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('d7f96db9-2df9-4507-af4a-cf7b6380c1a1', 'Fast API');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c5a405c5-c080-47bb-b4ea-2f71919f9c93', 'Docker');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c53cc9ef-b52f-4218-acae-8e78a8bcc570', 'SweetAlert2');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('837103c4-c93c-49a1-a28b-0682cff207f6', 'Clean Architecture');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('952185d0-76a4-443d-8ea9-ea36b4d104b7', 'MVC');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('955740d1-f7b3-4ca1-a3ee-eb50952b13ed', 'PostgreSQL');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('30cf336a-342b-4e0b-81d7-eedef7e5181b', 'MongoDB');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('fd341a1f-0043-4de6-a725-d531516feb64', 'SQL Server');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('fc5e284c-0ab3-4336-be05-a8f9d3ada158', 'FireBase');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('c44aaa6e-1504-4e51-adf2-e337d6461627', 'Express.js');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('666c1b35-a67d-4540-8c40-f2433f3f3f7e', 'NestJS');
INSERT INTO etiquetas(etiqueta_uuid, descripcion) values ('5bbe319e-41cd-43b9-a247-836f63749b60', 'Arquitectura Hexagonal');