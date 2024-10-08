package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalumno;

    private String nombre;
    private String apellido;
    private String dni;
    private Date fechanacimiento;

    @OneToMany(mappedBy = "alumno")
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "alumno")
    private List<Notas> notas;
}