package pe.edu.cibertec.sw_examen_t2.service;

import pe.edu.cibertec.sw_examen_t2.dto.CursoDto;
import pe.edu.cibertec.sw_examen_t2.model.Curso;

import java.util.List;

public interface ICursoService {
    List<CursoDto> findByNombrecursoContaining(String nombre);
    List<CursoDto> findByCreditos(Integer creditos);

}
