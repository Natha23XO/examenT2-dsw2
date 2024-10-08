package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;

    private String nombrecurso;
    private String descripcion;
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "iddocente")
    private Docente docente;

    @OneToMany(mappedBy = "curso")
    private List<Notas> notas;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;
}