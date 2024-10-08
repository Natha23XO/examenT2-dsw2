package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;
import pe.edu.cibertec.sw_examen_t2.service.IAlumnoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {
    private final IAlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarAlumnos() {
        List<Alumno> alumnoList = alumnoService.obtenerAlumnos();
        if (alumnoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoXid(@PathVariable Integer id) {
        Alumno alumno = alumnoService.obtenerAlumno(id)
                .orElseThrow(() -> new ResourceNotFoundException("El alumno con el id " + id + " no existe"));
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Alumno> obtenerAlumnoXdni(@PathVariable String dni) {
        Alumno alumno = alumnoService.obtenerAlumnoXdni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("El alumno con el DNI " + dni + " no existe"));
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @GetMapping("/fechanacimiento/{fechanacimiento}")
    public ResponseEntity<List<Alumno>> obtenerAlumnosXfechanacimiento(@PathVariable String fechanacimiento) {
        List<Alumno> alumnos = alumnoService.obtenerAlumnosXfechanacimiento(fechanacimiento);
        if (alumnos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
}