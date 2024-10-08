package pe.edu.cibertec.sw_examen_t2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
public class AlumnoDto {
    private Integer idalumno;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechanacimiento;
}