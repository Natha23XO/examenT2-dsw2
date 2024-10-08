package pe.edu.cibertec.sw_examen_t2.service;

import pe.edu.cibertec.sw_examen_t2.dto.NotasDto;
import pe.edu.cibertec.sw_examen_t2.model.Notas;

import java.math.BigDecimal;
import java.util.List;

public interface INotasService {

    List<NotasDto> findByNotaGreaterThan(BigDecimal notaMinima);
    List<NotasDto> findByNotaBetween(BigDecimal minNota, BigDecimal maxNota);
}
