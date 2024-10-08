package pe.edu.cibertec.sw_examen_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_examen_t2.model.Matricula;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    @Query(value = "SELECT m FROM Matricula m JOIN m.alumno a JOIN m.curso c " +
            "WHERE a.idalumno = :idalumno")
    List<Matricula> findMatriculaByAlumno(@Param("idalumno") Integer idalumno);


    @Query("SELECT COUNT(m) FROM Matricula m WHERE m.curso.idcurso = :idcurso")
    int countMatriculaByCurso(@Param("idcurso") Integer idcurso);



}
