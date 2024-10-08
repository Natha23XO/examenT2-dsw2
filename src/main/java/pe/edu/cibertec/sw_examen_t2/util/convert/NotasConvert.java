package pe.edu.cibertec.sw_examen_t2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_examen_t2.dto.NotasDto;
import pe.edu.cibertec.sw_examen_t2.model.Notas;

@Component
public class NotasConvert {
    public NotasDto convertirNotasADto(Notas notas){
        return NotasDto.builder()
                .idnota(notas.getIdnota())
                .idalumno(notas.getAlumno().getIdalumno())
                .nombrealumno(notas.getAlumno().getNombre())
                .idcurso(notas.getCurso().getIdcurso())
                .nota(notas.getNota())
                .build();
    }
}
