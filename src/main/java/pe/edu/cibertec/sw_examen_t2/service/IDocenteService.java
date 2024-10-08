package pe.edu.cibertec.sw_examen_t2.service;

import pe.edu.cibertec.sw_examen_t2.dto.DocenteDTO;

import java.util.List;

public interface IDocenteService {

    List<DocenteDTO> findDocentesByEspecialidad(String especialidad);
    List<DocenteDTO> countCursosByDocente();
    void asignarDocente(DocenteDTO docenteDTO);
}
