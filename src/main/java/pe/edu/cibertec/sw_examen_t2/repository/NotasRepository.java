package pe.edu.cibertec.sw_examen_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_examen_t2.model.Notas;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface NotasRepository extends JpaRepository<Notas,Integer> {

    List<Notas> findByNotaGreaterThan(BigDecimal notaMinima);
    List<Notas> findByNotaBetween(BigDecimal minNota, BigDecimal maxNota);



}
