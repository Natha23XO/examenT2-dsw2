package pe.edu.cibertec.sw_examen_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.cibertec.sw_examen_t2.model.Docente;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

    @Query(value = "SELECT d FROM Docente d LEFT JOIN Curso c ON d.iddocente = c.docente.iddocente " +
            "WHERE d.especialidad = :especialidad")
    List<Docente> findDocenteByEspecialidad(@Param("especialidad") String especialidad);


    @Query(value = "SELECT d FROM Docente d LEFT JOIN Curso c ON d.iddocente = c.docente.iddocente " +
            "GROUP BY d.iddocente")
    List<Docente> countCursosByDocente();

    //Agregado para la pregunta 3 de transaccion (Hugo)
    Docente findByDni(String dni);

}
