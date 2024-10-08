package pe.edu.cibertec.sw_examen_t2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_examen_t2.dto.AlumnoDto;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlumnoConvert {

    public AlumnoDto convertirAlumnoAAlumnoDto(Alumno alumno) {
        return AlumnoDto.builder()
                .idalumno(alumno.getIdalumno())
                .nombre(alumno.getNombre())
                .apellido(alumno.getApellido())
                .dni(alumno.getDni())
                .fechanacimiento(alumno.getFechanacimiento())
                .build();
    }

    public Alumno convertirAlumnoDtoAAlumno(AlumnoDto alumnoDto) {
        Alumno alumno = new Alumno();
        alumno.setIdalumno(alumnoDto.getIdalumno());
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setDni(alumnoDto.getDni());
        alumno.setFechanacimiento(alumnoDto.getFechanacimiento());
        return alumno;
    }

    public List<AlumnoDto> convertirListaAlumnoAListaAlumnoDto(List<Alumno> alumnos) {
        return alumnos.stream()
                .map(this::convertirAlumnoAAlumnoDto)
                .collect(Collectors.toList());
    }
}