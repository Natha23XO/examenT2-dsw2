package pe.edu.cibertec.sw_examen_t2.service;

import pe.edu.cibertec.sw_examen_t2.dto.CountMatriculasDTO;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;

import java.util.List;

public interface IMatriculaService {

    List<MatriculaDTO> findMatriculasByAlumno(Integer idalumno);
    CountMatriculasDTO countMatriculasByCurso(Integer idcurso);

}
