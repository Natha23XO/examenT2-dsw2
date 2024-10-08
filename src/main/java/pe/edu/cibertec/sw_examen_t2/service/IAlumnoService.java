package pe.edu.cibertec.sw_examen_t2.service;

import pe.edu.cibertec.sw_examen_t2.dto.AlumnoDto;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface IAlumnoService {

    Alumno guardarAlumno(Alumno alumno);
    List<AlumnoDto> obtenerAlumnos();
    Optional<AlumnoDto> obtenerAlumno(Integer id);
    Optional<AlumnoDto> obtenerAlumnoXdni(String dni);
    List<AlumnoDto> obtenerAlumnosXfechanacimiento(String fechanacimiento);
}