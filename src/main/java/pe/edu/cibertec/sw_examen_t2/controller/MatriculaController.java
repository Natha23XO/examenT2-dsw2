package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.dto.DocenteDTO;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Matricula;
import pe.edu.cibertec.sw_examen_t2.service.IMatriculaService;
import pe.edu.cibertec.sw_examen_t2.service.impl.MatriculaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final IMatriculaService iMatriculaService;

    @GetMapping("/alumno/{idalumno}")
    public ResponseEntity<List<MatriculaDTO>> findMatricularByAlumno(@PathVariable Integer idalumno) {
        List<MatriculaDTO> matriculas = matriculaService.findMatriculasByAlumno(idalumno);

        if (matriculas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron matrículas por el alumno con id " + idalumno);
        }

        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }


    @GetMapping("/matriculasxcurso")
    public ResponseEntity<List<MatriculaDTO>> countMatriculasByCurso() {
        List<MatriculaDTO> matricula = matriculaService.countMatriculasByCurso();

        if (matricula.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron el n° de matriculas por curso.");
        }

        return new ResponseEntity<>(matricula, HttpStatus.OK);
    }


    @PostMapping("/registrar")
    public ResponseEntity<Matricula> registrarMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        Matricula nuevaMatricula = matriculaService.registrarMatricula(matriculaDTO);
        return new ResponseEntity<>(nuevaMatricula, HttpStatus.CREATED);
    }

    /*@PostMapping("/")
    public ResponseEntity<GenericResponseDto<String>> crear(@RequestBody MatriculaDTO matriculaDTO) {
        try {
            iMatriculaService.registrarMatricula(matriculaDTO);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true)
                    .mensaje("matricula creada correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false)
                    .mensaje("Error al crear matricula")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}




