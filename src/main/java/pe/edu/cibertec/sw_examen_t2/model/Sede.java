package pe.edu.cibertec.sw_examen_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsede;

    private String nombresede;
    private String direccion;

    @OneToMany(mappedBy = "sede")
    private List<AsignacionDocente> asignaciones;
}