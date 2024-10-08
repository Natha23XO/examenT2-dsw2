package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;
import pe.edu.cibertec.sw_examen_t2.repository.AlumnoRepository;
import pe.edu.cibertec.sw_examen_t2.service.IAlumnoService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AlumnoService implements IAlumnoService {

    private final AlumnoRepository alumnoRepository;
    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
    @Override
    public List<Alumno> obtenerAlumnos() {
        return alumnoRepository.findAll();
    }
    @Override
    public Optional<Alumno> obtenerAlumno(Integer id) {
        return alumnoRepository.findById(id);
    }
    @Override
    public Optional<Alumno> obtenerAlumnoXdni(String dni) {
        return alumnoRepository.findByDni(dni);
    }
    @Override
    public List<Alumno> obtenerAlumnosXfechanacimiento(String fechanacimiento) {
        return alumnoRepository.findByFechanacimiento(fechanacimiento);
    }
}