-- ==========================================
-- PROYECTO FINAL: EduStream LMS
-- Base de Datos Relacional y Datos de Prueba
-- ==========================================

CREATE DATABASE IF NOT EXISTS edustream_db;
USE edustream_db;

-- 1. Tabla Base: Usuarios (Alineada a la clase abstracta Usuario)
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    tipo_usuario ENUM('ESTUDIANTE', 'PROFESOR') NOT NULL
);

-- 2. Tabla Subclase: Estudiantes
CREATE TABLE IF NOT EXISTS estudiantes (
    id_usuario INT PRIMARY KEY,
    carnet VARCHAR(20) UNIQUE NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

-- 3. Tabla Subclase: Profesores
CREATE TABLE IF NOT EXISTS profesores (
    id_usuario INT PRIMARY KEY,
    especialidad VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

-- 4. Tabla: Cursos (Modelo Curso)
CREATE TABLE IF NOT EXISTS cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    id_profesor INT NOT NULL,
    FOREIGN KEY (id_profesor) REFERENCES profesores(id_usuario) ON DELETE CASCADE
);

-- 5. Tabla Relacional: Inscripciones (Estudiante <-> Curso)
CREATE TABLE IF NOT EXISTS inscripciones (
    id_inscripcion INT AUTO_INCREMENT PRIMARY KEY,
    id_estudiante INT NOT NULL,
    id_curso INT NOT NULL,
    fecha_inscripcion DATE NOT NULL,
    estado VARCHAR(20) DEFAULT 'ACTIVO',
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso) ON DELETE CASCADE
);

-- ==========================================
-- REGISTROS DE PRUEBA (DML)
-- ==========================================

-- Insertar Usuarios (Profesores y Estudiantes)
INSERT INTO usuarios (nombre, correo, contrasena, tipo_usuario) VALUES
('Pablo Cordero', 'pcordero@utc.ac.cr', '1234', 'PROFESOR'),
('Dilan Araya', 'dilan@edustream.com', '1234', 'ESTUDIANTE'),
('Maikel Guerra', 'maikel@edustream.com', '1234', 'ESTUDIANTE');

-- Insertar Detalles de Profesores
INSERT INTO profesores (id_usuario, especialidad) VALUES
(1, 'Ingeniería de Software / Java');

-- Insertar Detalles de Estudiantes
INSERT INTO estudiantes (id_usuario, carnet, carrera) VALUES
(2, 'EST-2026-01', 'Ingeniería en Sistemas'),
(3, 'EST-2026-02', 'Ingeniería en Sistemas');

-- Insertar Cursos
INSERT INTO cursos (nombre, descripcion, id_profesor) VALUES
('Programación 2', 'Java SE, JDBC y Arquitectura de Software', 1),
('Bases de Datos I', 'Diseño relacional, SQL y MySQL', 1);

-- Insertar Inscripciones de prueba
INSERT INTO inscripciones (id_estudiante, id_curso, fecha_inscripcion, estado) VALUES
(2, 1, '2026-11-01', 'ACTIVO'),
(3, 1, '2026-11-01', 'ACTIVO'),
(2, 2, '2026-11-02', 'ACTIVO');