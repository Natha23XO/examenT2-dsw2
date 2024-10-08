package pe.edu.cibertec.sw_examen_t2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {
    private Integer idmatricula;
    private String alumno;
    private String curso;
    private String semestre;
    private Date fechamatricula;


}
