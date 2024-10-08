package pe.edu.cibertec.sw_examen_t2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_examen_t2.dto.CursoDto;
import pe.edu.cibertec.sw_examen_t2.model.Curso;

@Component
public class CursoConvert {
    public CursoDto convertirCursoADto(Curso curso){
        return CursoDto.builder()
                .idcurso(curso.getIdcurso())
                .nombrecurso(curso.getNombrecurso())
                .descripcion(curso.getDescripcion())
                .creditos(curso.getCreditos())
                .build();
    }
}
