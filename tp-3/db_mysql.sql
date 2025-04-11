CREATE DATABASE IF NOT EXISTS tp_3;
USE tp_3;

CREATE TABLE usuarios (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nombre VARCHAR(255),
  apellido VARCHAR(255),
  dni VARCHAR(255),
  email VARCHAR(255),
  fecha_creacion VARCHAR(255)
);

INSERT INTO usuarios(id_usuario,nombre,apellido,dni,email,fecha_creacion) VALUES ('1', 'Juan', 'Pérez', '12345678', 'juan.perez@email.com', '2025-03-25 15:37:49');
INSERT INTO usuarios(id_usuario,nombre,apellido,dni,email,fecha_creacion) VALUES ('2', 'María', 'Gómez', '23456789', 'maria.gomez@email.com', '2025-03-25 15:37:49');
INSERT INTO usuarios(id_usuario,nombre,apellido,dni,email,fecha_creacion) VALUES ('3', 'Carlos', 'López', '34567890', 'carlos.lopez@email.com', '2025-03-25 15:37:49');
INSERT INTO usuarios(id_usuario,nombre,apellido,dni,email,fecha_creacion) VALUES ('4', 'Ana', 'Martínez', '45678901', 'ana.martinez@email.com', '2025-03-25 15:37:49');
INSERT INTO usuarios(id_usuario,nombre,apellido,dni,email,fecha_creacion) VALUES ('5', 'Pedro', 'Fernández', '56789012', 'pedro.fernandez@email.com', '2025-03-25 15:37:49');

CREATE TABLE credenciales (
  id_credencial INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_usuario INT,
  username VARCHAR(255),
  pass VARCHAR(255),
  permiso VARCHAR(255),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

INSERT INTO credenciales(id_credencial, id_usuario, username, pass, permiso) VALUES ('1', '1', 'juanperez', '1234', 'CLIENTE');
INSERT INTO credenciales(id_credencial, id_usuario, username, pass, permiso) VALUES ('2', '2', 'mariagomez', '1234', 'ADMINISTRADOR');
INSERT INTO credenciales(id_credencial, id_usuario, username, pass, permiso) VALUES ('3', '3', 'carloslopez', '1234', 'GESTOR');
INSERT INTO credenciales(id_credencial, id_usuario, username, pass, permiso) VALUES ('4', '4', 'anamartinez', '1234', 'CLIENTE');
INSERT INTO credenciales(id_credencial, id_usuario, username, pass, permiso) VALUES ('5', '5', 'pedrofernandez', 'hashedpassword5', 'ADMINISTRADOR');

CREATE TABLE cuentas (
  id_cuenta INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_usuario INT,
  tipo VARCHAR(255),
  saldo DOUBLE,
  fecha_creacion VARCHAR(255),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

INSERT INTO cuentas(id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES ('1', '1', 'CAJA_AHORRO', '15000.5', '2025-03-25 15:37:49');
INSERT INTO cuentas(id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES ('2', '1', 'CUENTA_CORRIENTE', '5000.75', '2025-03-25 15:37:49');
INSERT INTO cuentas(id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES ('3', '2', 'CAJA_AHORRO', '30000.0', '2025-03-25 15:37:49');
INSERT INTO cuentas(id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES ('4', '3', 'CUENTA_CORRIENTE', '12000.2', '2025-03-25 15:37:49');
INSERT INTO cuentas(id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES ('5', '4', 'CAJA_AHORRO', '8000.9', '2025-03-25 15:37:49');
INSERT INTO cuentas(id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES ('6', '5', 'CUENTA_CORRIENTE', '25000.0', '2025-03-25 15:37:49');