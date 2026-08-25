-- SISTEMA : CONTROL DE MULTIFUNCIONALES
-- BASE DE DATOS : MySQL
-- Estructura compatible con las entidades JPA del backend.

CREATE DATABASE IF NOT EXISTS seguimiento_egresados
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_unicode_ci;

USE seguimiento_egresados;

CREATE TABLE distrito_fiscal (
	id_distrito_fiscal INT AUTO_INCREMENT PRIMARY KEY,
	nombre_distrito VARCHAR(150) NOT NULL
);

CREATE TABLE tipo_personal (
	id_tipo_personal INT AUTO_INCREMENT PRIMARY KEY,
	nombre_tipo_personal VARCHAR(100) NOT NULL,
	descripcion VARCHAR(250)
);

CREATE TABLE marca (
	id_marca INT AUTO_INCREMENT PRIMARY KEY,
	nombre_marca VARCHAR(255) NOT NULL
);

CREATE TABLE clasificacion (
	id_clasificacion INT AUTO_INCREMENT PRIMARY KEY,
	nombre_clasificacion VARCHAR(100) NOT NULL,
	descripcion VARCHAR(250)
);

CREATE TABLE estado_equipo (
	id_estado_equipo INT AUTO_INCREMENT PRIMARY KEY,
	nombre_estado VARCHAR(50) NOT NULL,
	descripcion VARCHAR(250)
);

CREATE TABLE tipo_mantenimiento (
	id_tipo_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,
	nombre_tipo VARCHAR(50) NOT NULL,
	descripcion VARCHAR(250)
);

CREATE TABLE rol (
	id_rol INT AUTO_INCREMENT PRIMARY KEY,
	nombre_rol VARCHAR(50) NOT NULL
);

CREATE TABLE usuario (
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR(50) NOT NULL UNIQUE,
	contrasena VARCHAR(255) NOT NULL,
	nombre_completo VARCHAR(150) NOT NULL,
	correo_electronico VARCHAR(150),
	estado VARCHAR(20) DEFAULT 'ACTIVO',
	fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE sede (
	id_sede INT AUTO_INCREMENT PRIMARY KEY,
	id_distrito_fiscal INT NOT NULL,
	nombre_sede VARCHAR(150) NOT NULL,
	direccion VARCHAR(300),
	CONSTRAINT fk_sede_distrito
		FOREIGN KEY (id_distrito_fiscal)
		REFERENCES distrito_fiscal(id_distrito_fiscal)
);

CREATE TABLE modelo (
	id_modelo INT AUTO_INCREMENT PRIMARY KEY,
	id_marca INT NOT NULL,
	nombre_modelo VARCHAR(150) NOT NULL,
	descripcion VARCHAR(250),
	CONSTRAINT fk_marca_modelo
		FOREIGN KEY (id_marca)
		REFERENCES marca(id_marca)
);

CREATE TABLE personal (
	id_personal INT AUTO_INCREMENT PRIMARY KEY,
	id_tipo_personal INT NOT NULL,
	dni VARCHAR(8) UNIQUE,
	nombres VARCHAR(50),
	apellido_paterno VARCHAR(50),
	apellido_materno VARCHAR(50),
	correo VARCHAR(120),
	telefono VARCHAR(20),
	CONSTRAINT fk_personal_tipo
		FOREIGN KEY (id_tipo_personal)
		REFERENCES tipo_personal(id_tipo_personal)
);

CREATE TABLE despacho (
	id_despacho INT AUTO_INCREMENT PRIMARY KEY,
	id_sede INT NOT NULL,
	nombre_despacho VARCHAR(250) NOT NULL,
	tipo_proceso VARCHAR(100),
	CONSTRAINT fk_id_sede
		FOREIGN KEY (id_sede)
		REFERENCES sede(id_sede)
);

CREATE TABLE equipo (
	id_equipo INT AUTO_INCREMENT PRIMARY KEY,
	id_modelo INT NOT NULL,
	id_clasificacion INT NOT NULL,
	id_estado_equipo INT NOT NULL,
	codigo_patrimonial VARCHAR(50) NOT NULL UNIQUE,
	numero_serie VARCHAR(100) UNIQUE,
	observacion VARCHAR(500),
	fecha_adquisicion DATE,
	fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_equipo_modelo
		FOREIGN KEY (id_modelo)
		REFERENCES modelo(id_modelo),
	CONSTRAINT fk_equipo_clasificacion
		FOREIGN KEY (id_clasificacion)
		REFERENCES clasificacion(id_clasificacion),
	CONSTRAINT fk_equipo_estado
		FOREIGN KEY (id_estado_equipo)
		REFERENCES estado_equipo(id_estado_equipo)
);

CREATE TABLE asignacion_equipo (
	id_asignacion INT AUTO_INCREMENT PRIMARY KEY,
	id_equipo INT NOT NULL,
	id_despacho INT NOT NULL,
	id_personal INT NOT NULL,
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE,
	observacion VARCHAR(500),
	fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_asignacion_equipo
		FOREIGN KEY (id_equipo)
		REFERENCES equipo(id_equipo),
	CONSTRAINT fk_asignacion_despacho
		FOREIGN KEY (id_despacho)
		REFERENCES despacho(id_despacho),
	CONSTRAINT fk_asignacion_personal
		FOREIGN KEY (id_personal)
		REFERENCES personal(id_personal)
);

CREATE TABLE mantenimiento (
	id_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,
	id_equipo INT NOT NULL,
	id_tipo_mantenimiento INT NOT NULL,
	fecha_mantenimiento DATE NOT NULL,
	diagnostico TEXT,
	trabajo_realizado TEXT,
	repuesto TEXT,
	responsable_mantenimiento VARCHAR(150),
	observacion TEXT,
	fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_mantenimiento_equipo
		FOREIGN KEY (id_equipo)
		REFERENCES equipo(id_equipo),
	CONSTRAINT fk_mantenimiento_tipo
		FOREIGN KEY (id_tipo_mantenimiento)
		REFERENCES tipo_mantenimiento(id_tipo_mantenimiento)
);

CREATE TABLE usuario_rol (
	id_usuario_rol INT AUTO_INCREMENT PRIMARY KEY,
	id_usuario INT NOT NULL,
	id_rol INT NOT NULL,
	CONSTRAINT fk_usuario_rol_usuario
		FOREIGN KEY (id_usuario)
		REFERENCES usuario(id_usuario),
	CONSTRAINT fk_usuario_rol_rol
		FOREIGN KEY (id_rol)
		REFERENCES rol(id_rol),
	CONSTRAINT uq_usuario_rol
		UNIQUE (id_usuario, id_rol)
);
