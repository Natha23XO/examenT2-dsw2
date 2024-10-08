package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sw_examen_t2.dto.CursoDto;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.service.ICursoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/curso")
public class CursoController {
    private final ICursoService cursoService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<List<CursoDto>>> BuscarCursosXNombreQueContenga(@Param("nombre") String nombre) {
        List<CursoDto> cursoDtoList = cursoService.findByNombrecursoContaining(nombre);
        if(cursoDtoList.isEmpty()){
            return ResponseEntity.ok(GenericResponseDto.<List<CursoDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron cursos con nombre "+nombre)
                    .build());
        }else{
            return ResponseEntity.ok(GenericResponseDto.<List<CursoDto>>builder()
                    .correcto(true)
                    .respuesta(cursoDtoList)
                    .mensaje("Cursos encontrados con nombre "+nombre)
                    .build());
        }
    }
    @GetMapping("/creditos")
    public ResponseEntity<GenericResponseDto<List<CursoDto>>> findByCreditos(@Param("creditos") Integer creditos) {
        List<CursoDto> cursoDtoList = cursoService.findByCreditos(creditos);
        if(cursoDtoList.isEmpty()){
            return ResponseEntity.ok(GenericResponseDto.<List<CursoDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron cursos con "+creditos+" creditos")
                    .build());
        }else{
            return ResponseEntity.ok(GenericResponseDto.<List<CursoDto>>builder()
                    .correcto(true)
                    .respuesta(cursoDtoList)
                    .mensaje("Cursos encontrados con "+creditos+" creditos")
                    .build());
        }
    }
}
