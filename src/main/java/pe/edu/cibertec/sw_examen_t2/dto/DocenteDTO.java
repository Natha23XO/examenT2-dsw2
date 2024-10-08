package pe.edu.cibertec.sw_examen_t2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTO {
    private Integer iddocente;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String dni;
    private int cursos;

    public DocenteDTO(Integer iddocente, String nombre, String apellido, String especialidad, int cursos) {
        this.iddocente = iddocente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.cursos = cursos;
    }
}
