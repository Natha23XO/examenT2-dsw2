package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idnota;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;

    private BigDecimal nota;
}