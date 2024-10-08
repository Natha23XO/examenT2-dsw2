package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "asignaciondocente")
public class AsignacionDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idasignacion;

    @ManyToOne
    @JoinColumn(name = "iddocente")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Sede sede;

    private Date fechaasignacion;
}