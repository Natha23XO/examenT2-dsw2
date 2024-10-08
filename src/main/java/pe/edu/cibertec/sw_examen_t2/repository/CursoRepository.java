package pe.edu.cibertec.sw_examen_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_examen_t2.model.Curso;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {

    List<Curso> findByNombrecursoContaining(String nombre);
    List<Curso> findByCreditos(Integer creditos);

}
