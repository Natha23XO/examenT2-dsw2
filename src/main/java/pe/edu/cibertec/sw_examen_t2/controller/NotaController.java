package pe.edu.cibertec.sw_examen_t2.controller;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_examen_t2.dto.GenericResponseDto;
import pe.edu.cibertec.sw_examen_t2.dto.NotasDto;
import pe.edu.cibertec.sw_examen_t2.model.Notas;
import pe.edu.cibertec.sw_examen_t2.service.INotasService;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/nota")
public class NotaController {
    private final INotasService notasService;

    @GetMapping("/min")
    public ResponseEntity<GenericResponseDto<List<NotasDto>>> obtenerNotasMayoresA(@RequestParam("nota") BigDecimal nota) {
        List<NotasDto> notasDtoList = notasService.findByNotaGreaterThan(nota);
        if(notasDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<NotasDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron notas mayores a "+nota)
                    .build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.<List<NotasDto>>builder()
                    .correcto(true)
                    .respuesta(notasDtoList)
                    .mensaje("Notas mayores a "+nota)
                    .build(), org.springframework.http.HttpStatus.OK);
        }
    }


    @GetMapping("/between")
    public ResponseEntity<GenericResponseDto<List<NotasDto>>> obtenerNotasEntre(
            @RequestParam("minNota") BigDecimal minNota,
            @RequestParam("maxNota") BigDecimal maxNota)
    {
        List<NotasDto> notasDtoList = notasService.findByNotaBetween(minNota,maxNota);
        if(notasDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<NotasDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron notas entre "+minNota+" y "+maxNota)
                    .build(), org.springframework.http.HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.<List<NotasDto>>builder()
                    .correcto(true)
                    .respuesta(notasDtoList)
                    .mensaje("Notas entre "+minNota+" y "+maxNota)
                    .build(), org.springframework.http.HttpStatus.OK);
        }
    }


    @PostMapping("/crear")
    public ResponseEntity<GenericResponseDto<String>> registrarNota(@RequestBody NotasDto dto) {
        try {
            NotasDto nuevaNota = notasService.saveNota(dto);

            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true)
                    .mensaje("Nota registrada correctamente")
                    .build(), HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false)
                    .mensaje("Nota NO registrada: " + ex.getMessage())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


}
