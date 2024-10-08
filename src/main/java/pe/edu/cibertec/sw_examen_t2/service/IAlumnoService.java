package pe.edu.cibertec.sw_examen_t2.service;

import pe.edu.cibertec.sw_examen_t2.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface IAlumnoService {

    Alumno guardarAlumno(Alumno alumno);
    List<Alumno> obtenerAlumnos();
    Optional<Alumno> obtenerAlumno(Integer id);
    Optional<Alumno> obtenerAlumnoXdni(String dni);
    List<Alumno> obtenerAlumnosXfechanacimiento(String fechanacimiento);
}