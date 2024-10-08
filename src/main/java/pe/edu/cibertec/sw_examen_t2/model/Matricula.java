package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmatricula;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;

    private String semestre;
    private Date fechamatricula;
}