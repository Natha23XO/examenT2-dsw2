package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.dto.AlumnoDto;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.service.IAlumnoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {
    private final IAlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<List<AlumnoDto>>> listarAlumnos() {
        List<AlumnoDto> alumnoDtoList = alumnoService.obtenerAlumnos();

        if (alumnoDtoList.isEmpty()) {
            return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron alumnos")
                    .build());
        } else {
            return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                    .correcto(true)
                    .respuesta(alumnoDtoList)
                    .mensaje("Alumnos encontrados")
                    .build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<AlumnoDto>> obtenerAlumnoXid(@PathVariable Integer id) {
        try {
            AlumnoDto alumnoDto = alumnoService.obtenerAlumno(id)
                    .orElseThrow(() -> new ResourceNotFoundException("El alumno con el id " + id + " no existe"));
            return ResponseEntity.ok(GenericResponseDto.<AlumnoDto>builder()
                    .correcto(true)
                    .respuesta(alumnoDto)
                    .mensaje("Alumno encontrado")
                    .build());
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.ok(GenericResponseDto.<AlumnoDto>builder()
                    .correcto(false)
                    .mensaje("Alumno no encontrado")
                    .build());
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<GenericResponseDto<AlumnoDto>> obtenerAlumnoXdni(@PathVariable String dni) {
        try {
            AlumnoDto alumnoDto = alumnoService.obtenerAlumnoXdni(dni)
                    .orElseThrow(() -> new ResourceNotFoundException("El alumno con el DNI " + dni + " no existe"));
            return ResponseEntity.ok(GenericResponseDto.<AlumnoDto>builder()
                    .correcto(true)
                    .respuesta(alumnoDto)
                    .mensaje("Alumno encontrado")
                    .build());
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.ok(GenericResponseDto.<AlumnoDto>builder()
                    .correcto(false)
                    .mensaje("Alumno no encontrado")
                    .build());
        }
    }

    @GetMapping("/fechanacimiento/{fechanacimiento}")
    public ResponseEntity<GenericResponseDto<List<AlumnoDto>>> obtenerAlumnosXfechanacimiento(@PathVariable String fechanacimiento) {
        List<AlumnoDto> alumnoDtoList = alumnoService.obtenerAlumnosXfechanacimiento(fechanacimiento);

        if (alumnoDtoList.isEmpty()) {
            return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron alumnos con fecha de nacimiento " + fechanacimiento)
                    .build());
        } else {
            return ResponseEntity.ok(GenericResponseDto.<List<AlumnoDto>>builder()
                    .correcto(true)
                    .respuesta(alumnoDtoList)
                    .mensaje("Alumnos encontrados con fecha de nacimiento " + fechanacimiento)
                    .build());
        }
    }
}