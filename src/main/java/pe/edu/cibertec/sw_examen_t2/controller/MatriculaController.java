package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.service.impl.MatriculaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @GetMapping("/alumno/{idalumno}")
    public ResponseEntity<List<MatriculaDTO>> findMatricularByAlumno(@PathVariable Integer idalumno) {
        List<MatriculaDTO> matriculas = matriculaService.findMatriculasByAlumno(idalumno);

        if (matriculas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron matrículas para el alumno con id " + idalumno);
        }

        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }


    @GetMapping("/matricularxcurso")
    public ResponseEntity<List<MatriculaDTO>> countMatriculasByCurso() {
        List<MatriculaDTO> matricula = matriculaService.countMatriculasByCurso();

        if (matricula.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron matrículas para contar por curso.");
        }

        return new ResponseEntity<>(matricula, HttpStatus.OK);
    }

}

