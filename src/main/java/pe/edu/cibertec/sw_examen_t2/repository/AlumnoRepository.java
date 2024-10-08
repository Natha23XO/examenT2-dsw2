package pe.edu.cibertec.sw_examen_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Query(value = "SELECT * FROM alumno WHERE dni = ?1", nativeQuery = true)
    Optional<Alumno> findByDni(String dni);

    @Query(value = "SELECT * FROM alumno WHERE fechanacimiento = ?1", nativeQuery = true)
    List<Alumno> findByFechanacimiento(String fechanacimiento);
}