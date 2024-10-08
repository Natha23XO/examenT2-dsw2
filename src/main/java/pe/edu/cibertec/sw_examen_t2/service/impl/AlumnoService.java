package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t2.dto.AlumnoDto;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;
import pe.edu.cibertec.sw_examen_t2.repository.AlumnoRepository;
import pe.edu.cibertec.sw_examen_t2.service.IAlumnoService;
import pe.edu.cibertec.sw_examen_t2.util.convert.AlumnoConvert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AlumnoService implements IAlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoConvert alumnoConvert;

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public List<AlumnoDto> obtenerAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnoConvert.convertirListaAlumnoAListaAlumnoDto(alumnos);
    }

    @Override
    public Optional<AlumnoDto> obtenerAlumno(Integer id) {
        return alumnoRepository.findById(id)
                .map(alumnoConvert::convertirAlumnoAAlumnoDto);
    }

    @Override
    public Optional<AlumnoDto> obtenerAlumnoXdni(String dni) {
        return alumnoRepository.findByDni(dni)
                .map(alumnoConvert::convertirAlumnoAAlumnoDto);
    }

    @Override
    public List<AlumnoDto> obtenerAlumnosXfechanacimiento(String fechanacimiento) {
        List<Alumno> alumnos = alumnoRepository.findByFechanacimiento(fechanacimiento);
        return alumnoConvert.convertirListaAlumnoAListaAlumnoDto(alumnos);
    }
}