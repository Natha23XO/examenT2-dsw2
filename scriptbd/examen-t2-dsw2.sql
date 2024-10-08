create database bd_examen_t2;
use bd_examen_t2;

create table alumno (
    idalumno int auto_increment primary key,
    nombre varchar(100),
    apellido varchar(100),
    dni varchar(10) unique,
    fechanacimiento date
);

create table docente (
    iddocente int auto_increment primary key,
    nombre varchar(100),
    apellido varchar(100),
    especialidad varchar(100),
    dni varchar(10) unique
);

create table sede (
    idsede int auto_increment primary key,
    nombresede varchar(100),
    direccion varchar(255)
);

create table asignaciondocente (
    idasignacion int auto_increment primary key,
    iddocente int,
    idsede int,
    fechaasignacion date,
    foreign key (iddocente) references docente(iddocente),
    foreign key (idsede) references sede(idsede)
);

create table curso (
    idcurso int auto_increment primary key,
    nombrecurso varchar(100),
    descripcion varchar(255),
    creditos int,
    iddocente int, 
    foreign key (iddocente) references docente(iddocente)
);

create table notas (
    idnota int auto_increment primary key,
    idalumno int,
    idcurso int,
    nota decimal(4, 2),
    foreign key (idalumno) references alumno(idalumno),
    foreign key (idcurso) references curso(idcurso)
);

create table matricula (
    idmatricula int auto_increment primary key,
    idalumno int,
    idcurso int,
    semestre varchar(10),
    fechamatricula date,
    foreign key (idalumno) references alumno(idalumno),
    foreign key (idcurso) references curso(idcurso)
);

-- Insertar datos en la tabla Alumno
INSERT INTO alumno (nombre, apellido, dni, fechanacimiento) 
VALUES 
('Juan', 'Perez', '12345678', '2000-05-10'),
('Maria', 'Lopez', '87654321', '1999-08-22'),
('Carlos', 'Ramirez', '13579246', '2001-01-15');

-- Insertar datos en la tabla Docente
INSERT INTO docente (nombre, apellido, especialidad, dni) 
VALUES 
('Ana', 'Garcia', 'Matemáticas', '98765432'),
('Pedro', 'Fernandez', 'Física', '65432198'),
('Laura', 'Mendoza', 'Química', '45678912');

-- Insertar datos en la tabla Sede
INSERT INTO sede (nombresede, direccion) 
VALUES 
('Sede Central', 'Av. Principal 123, Lima'),
('Sede Norte', 'Calle Los Pinos 234, Trujillo'),
('Sede Sur', 'Av. Sur 456, Arequipa');

-- Insertar datos en la tabla AsignacionDocente
INSERT INTO asignaciondocente (iddocente, idsede, fechaasignacion) 
VALUES 
(1, 1, '2023-03-01'),
(2, 2, '2023-04-01'),
(3, 3, '2023-05-01');

-- Insertar datos en la tabla Curso
INSERT INTO curso (nombrecurso, descripcion, creditos, iddocente) 
VALUES 
('Calculo I', 'Curso matemáticas avanzado', 4, 1),
('Desarrollo de Aplicaciones Web 2', 'Backend Java', 5, 2),
('Plan de Negocios', 'Conceptos básicos de marketing', 2, 3);

-- Insertar datos en la tabla Notas
INSERT INTO notas (idalumno, idcurso, nota) 
VALUES 
(1, 1, 15.50),
(2, 2, 18.75),
(3, 3, 14.00);

-- Insertar datos en la tabla Matricula
INSERT INTO matricula (idalumno, idcurso, semestre, fechamatricula) 
VALUES 
(1, 1, '2023-1', '2023-02-15'),
(2, 2, '2023-1', '2023-02-20'),
(3, 3, '2023-1', '2023-02-25');

SELECT * FROM asignaciondocente;
SELECT * FROM docente;
SELECT * FROM sede;
SELECT * FROM matricula;
SELECT * FROM notas;