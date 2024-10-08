package pe.edu.cibertec.sw_examen_t2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoDto {

    private Integer idcurso;
    private String nombrecurso;
    private String descripcion;
    private Integer creditos;

}
