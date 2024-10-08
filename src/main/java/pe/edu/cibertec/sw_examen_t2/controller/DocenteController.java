package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.dto.DocenteDTO;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Docente;
import pe.edu.cibertec.sw_examen_t2.service.impl.DocenteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/docente")
public class DocenteController {

    private final DocenteService docenteService;

    @GetMapping("/findDocentesByEspecialidad/{especialidad}")
    public ResponseEntity<List<DocenteDTO>> findDocentesByEspecialidad(@PathVariable String especialidad) {
        List<DocenteDTO> docentes = this.docenteService.findDocentesByEspecialidad(especialidad);

        if (docentes.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron docentes con la especialidad " + especialidad);
        }

        return new ResponseEntity<>(docentes, HttpStatus.OK);
    }


    @GetMapping("/contar")
    public ResponseEntity<List<DocenteDTO>> contarCursosPorDocente() {
        List<DocenteDTO> docente = this.docenteService.countCursosByDocente();

        if (docente.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron docentes para contar cursos.");
        }

        return new ResponseEntity<>(docente, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<GenericResponseDto<String>> asignarDocente(@RequestBody DocenteDTO docenteDTO) {
        try {
            docenteService.asignarDocente(docenteDTO);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true)
                    .mensaje("Docente asignado correctamente")
                    .build(), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false)
                    .mensaje("Error al asignar al docente")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
