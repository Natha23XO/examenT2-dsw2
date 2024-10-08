package pe.edu.cibertec.sw_examen_t2.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class NotasDto {
    private Integer idnota;
    private Integer idalumno;
    private String nombrealumno;
    private Integer idcurso;
    private BigDecimal nota;
}
