package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Matricula;
import pe.edu.cibertec.sw_examen_t2.service.impl.MatriculaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @GetMapping("/alumno/{idalumno}")
    public ResponseEntity<GenericResponseDto<List<MatriculaDTO>>> findMatricularByAlumno(
            @PathVariable Integer idalumno) {
        List<MatriculaDTO> matriculas = matriculaService.findMatriculasByAlumno(idalumno);

        if (matriculas.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.<List<MatriculaDTO>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron matrículas para el alumno con id " + idalumno)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenericResponseDto.<List<MatriculaDTO>>builder()
                    .correcto(true)
                    .mensaje("Listado de matrículas para el alumno")
                    .respuesta(matriculas)
                    .build(), HttpStatus.OK);
        }
    }

    @GetMapping("/matriculasxcurso")
    public ResponseEntity<GenericResponseDto<List<MatriculaDTO>>> countMatriculasByCurso() {
        List<MatriculaDTO> matricula = matriculaService.countMatriculasByCurso();

        if (matricula.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.<List<MatriculaDTO>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron el n° de matrículas por curso.")
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenericResponseDto.<List<MatriculaDTO>>builder()
                    .correcto(true)
                    .mensaje("Número de matrículas por curso")
                    .respuesta(matricula)
                    .build(), HttpStatus.OK);
        }
    }
    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<MatriculaDTO>> registrarMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO nuevaMatricula = matriculaService.registrarMatricula(matriculaDTO);
        return new ResponseEntity<>(GenericResponseDto.<MatriculaDTO>builder()
                .correcto(true)
                .respuesta(nuevaMatricula)
                .mensaje("Matrícula registrada exitosamente")
                .build(), HttpStatus.CREATED);
    }
}

