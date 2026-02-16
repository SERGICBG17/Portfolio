-- Script de inicialización para H2
-- IMPORTANTE: Este archivo debe estar en codificación UTF-8

-- Limpiar datos existentes
DELETE FROM proyecto_lenguaje WHERE 1=1;
DELETE FROM proyectos WHERE 1=1;
DELETE FROM lenguajes WHERE 1=1;
DELETE FROM experiencia WHERE 1=1;
DELETE FROM estudios WHERE 1=1;
DELETE FROM info WHERE 1=1;
DELETE FROM usuarios WHERE 1=1;

-- Insertar información personal
INSERT INTO info (id, nombre, descripcion, foto_url, email, telefono, linkedin, github) VALUES
(1, 'Sergio Casín Hermoso',
 'Apasionado por la programación, con iniciativa y ganas de aprender. Perfil técnico, estructurado y resolutivo.',
 '/images/foto.jpg',
 'sergiocasin5@gmail.com',
 NULL,
 'https://es.linkedin.com/in/sergio-cas%C3%ADn-ba556825a',
 'https://github.com/SERGICBG17');

-- Insertar estudios (usar PARSEDATETIME para fechas en H2)
INSERT INTO estudios (id, titulo, institucion, descripcion, fecha_inicio, fecha_fin) VALUES
(1, 'Técnico Superior en Desarrollo de Aplicaciones Multiplataforma (DAM)', 'IES Luis Vives', NULL, PARSEDATETIME('2024-09-08', 'yyyy-MM-dd'), NULL),
(2, 'Técnico en Sistemas Microinformáticos y Redes (SMR)', 'IES Laguna de Joaztel', NULL, PARSEDATETIME('2022-09-08', 'yyyy-MM-dd'), PARSEDATETIME('2024-06-13', 'yyyy-MM-dd')),
(3, 'Educación Secundaria Obligatoria (ESO)', 'IES Altair', NULL, PARSEDATETIME('2018-09-08', 'yyyy-MM-dd'), PARSEDATETIME('2022-06-14', 'yyyy-MM-dd'));

-- Insertar experiencia laboral
INSERT INTO experiencia (id, puesto, empresa, descripcion, fecha_inicio, fecha_fin) VALUES
(1, 'Junior Backend Developer', 'Lyma Getafe S.A.M', 'Desarrollo de aplicaciones', PARSEDATETIME('2025-05-12', 'yyyy-MM-dd'), PARSEDATETIME('2025-05-30', 'yyyy-MM-dd')),
(2, 'TIC Informático', 'Lyma Getafe S.A.M', 'Soporte informático, gestión de incidencias y mantenimiento.', PARSEDATETIME('2024-04-02', 'yyyy-MM-dd'), PARSEDATETIME('2024-06-20', 'yyyy-MM-dd')),
(3, 'Profesor Particular de Java', '', 'Clases particulares de Java (orientación a POO)', PARSEDATETIME('2025-06-01', 'yyyy-MM-dd'), PARSEDATETIME('2025-07-31', 'yyyy-MM-dd')),
(4, 'Profesor Particular de Excel', ' ', 'Clases particulares de Excel a nivel básico e intermedio.', PARSEDATETIME('2024-06-01', 'yyyy-MM-dd'), PARSEDATETIME('2025-06-30', 'yyyy-MM-dd')),
(5, 'Árbitro Oficial de Mesa de Baloncesto', '', 'Control de marcador, actas y tiempos en partidos oficiales.', PARSEDATETIME('2026-01-01', 'yyyy-MM-dd'), PARSEDATETIME('2023-05-31', 'yyyy-MM-dd'));

-- Insertar lenguajes/tecnologías
INSERT INTO lenguajes (id, nombre, icono_url) VALUES
(1, 'C#', '/images/csharp.png'),
(2, 'Java', '/images/java.png'),
(3, 'JavaScript', '/images/javascript.png'),
(4, 'Python', '/images/python.png'),
(5, 'Unity', '/images/unity.png'),
(6, 'Windows Forms', '/images/winforms.png'),
(7, 'WPF', '/images/wpf.png'),
(8, 'Spring Boot', '/images/springboot.png'),
(9, '.NET MAUI', '/images/maui.png'),
(10, 'MySQL', '/images/mysql.png'),
(11, 'PostgreSQL', '/images/postgresql.png'),
(12, 'MongoDB', '/images/mongodb.png'),
(13, 'Docker', '/images/docker.png'),
(14, 'AWS', '/images/aws.png'),
(15, 'Azure', '/images/azure.png'),
(16, 'Git', '/images/git.png'),
(17, 'HTML', '/images/html.png'),
(18, 'CSS', '/images/css.png'),
(19, 'Kotlin', '/images/kotlin.png'),
(20, 'Power BI', '/images/powerbi.png'),
(22, 'Odoo', '/images/odoo.png'),
(23, 'Office 365', '/images/office.png');

-- Insertar proyectos
INSERT INTO proyectos (id, nombre, github_url, imagen_url, fecha, descripcion) VALUES
(1, 'Monitorizacion de Sensores', 'https://github.com/SERGICBG17/MonitorizacionDeSensores', '', PARSEDATETIME('2025-12-09', 'yyyy-MM-dd'),
 'Sistema de monitorización distribuido desarrollado en Java.'),
(2, 'Estacionamiento Inteligente', 'https://github.com/SERGICBG17/EstacionamientoInteligente', '', NULL,
 'Simulación avanzada de gestión de estacionamiento basada en programación multihilo (Threads).'),
(4, 'PokeApi', 'https://github.com/SERGICBG17/PokeApi', '', PARSEDATETIME('2025-11-12', 'yyyy-MM-dd'),
 'Desarrollo de una aplicación móvil nativa en Android Studio utilizando Kotlin.'),
(5, 'Portfolio', 'https://github.com/SERGICBG17/Portfolio', '', PARSEDATETIME('2026-01-18', 'yyyy-MM-dd'),
 'Plataforma dinámica de marca personal construida con Spring Boot 3 y Thymeleaf.'),
(6, 'App Gestión de Empleados', 'https://github.com/SERGICBG17/AppGestionDeEmpleados', '', PARSEDATETIME('2026-01-24', 'yyyy-MM-dd'),
 'Gestor de Empleados Corporativo (WPF/C#) diseñado bajo el patrón MVVM.');

-- Insertar usuario administrador (contraseña: admin123)
INSERT INTO usuarios (id, email, enabled, password, role, username) VALUES
(1, 'admin@admin.com', TRUE, '$2a$10$ZUhkWQla13RaBJPoz7WInOqkE8FUHBF4RktGNfqtYQKQK8Jn.m6r6', 'ROLE_USER', 'admin');