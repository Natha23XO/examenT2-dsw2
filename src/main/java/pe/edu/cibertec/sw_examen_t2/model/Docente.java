package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocente;

    private String nombre;
    private String apellido;
    private String especialidad;
    private String dni;

    @OneToMany(mappedBy = "docente")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "docente")
    private List<AsignacionDocente> asignaciones;
}