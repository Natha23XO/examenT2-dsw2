package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.dto.AlumnoDto;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;
import pe.edu.cibertec.sw_examen_t2.service.IAlumnoService;
import pe.edu.cibertec.sw_examen_t2.util.convert.AlumnoConvert;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {
    private final IAlumnoService alumnoService;
    private final AlumnoConvert alumnoConvert;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<List<AlumnoDto>>> listarAlumnos() {
        List<Alumno> alumnoList = alumnoService.obtenerAlumnos();
        List<AlumnoDto> alumnoDtoList = alumnoList.stream()
                .map(alumnoConvert::convertirAlumnoAAlumnoDto)
                .collect(Collectors.toList());

        if (alumnoDtoList.isEmpty()) {
            return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron alumnos")
                    .build());
        }
        return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                .correcto(true)
                .respuesta(alumnoDtoList)
                .mensaje("Alumnos encontrados")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<AlumnoDto>> obtenerAlumnoXid(@PathVariable Integer id) {
        Alumno alumno = alumnoService.obtenerAlumno(id)
                .orElseThrow(() -> new ResourceNotFoundException("El alumno con el id " + id + " no existe"));
        AlumnoDto alumnoDto = alumnoConvert.convertirAlumnoAAlumnoDto(alumno);
        return ResponseEntity.ok(GenericResponseDto.<AlumnoDto>builder()
                .correcto(true)
                .respuesta(alumnoDto)
                .mensaje("Alumno encontrado")
                .build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<GenericResponseDto<AlumnoDto>> obtenerAlumnoXdni(@PathVariable String dni) {
        Alumno alumno = alumnoService.obtenerAlumnoXdni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("El alumno con el DNI " + dni + " no existe"));
        AlumnoDto alumnoDto = alumnoConvert.convertirAlumnoAAlumnoDto(alumno);
        return ResponseEntity.ok(GenericResponseDto.<AlumnoDto>builder()
                .correcto(true)
                .respuesta(alumnoDto)
                .mensaje("Alumno encontrado")
                .build());
    }

    @GetMapping("/fechanacimiento/{fechanacimiento}")
    public ResponseEntity<GenericResponseDto<List<AlumnoDto>>> obtenerAlumnosXfechanacimiento(@PathVariable String fechanacimiento) {
        List<Alumno> alumnos = alumnoService.obtenerAlumnosXfechanacimiento(fechanacimiento);
        List<AlumnoDto> alumnoDtoList = alumnos.stream()
                .map(alumnoConvert::convertirAlumnoAAlumnoDto)
                .collect(Collectors.toList());

        if (alumnoDtoList.isEmpty()) {
            return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron alumnos con fecha de nacimiento " + fechanacimiento)
                    .build());
        }
        return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                .correcto(true)
                .respuesta(alumnoDtoList)
                .mensaje("Alumnos encontrados con fecha de nacimiento " + fechanacimiento)
                .build());
    }
}