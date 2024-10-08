package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t2.dto.DocenteDTO;
import pe.edu.cibertec.sw_examen_t2.model.Docente;
import pe.edu.cibertec.sw_examen_t2.repository.DocenteRepository;
import pe.edu.cibertec.sw_examen_t2.service.IDocenteService;
import pe.edu.cibertec.sw_examen_t2.util.convert.DocenteConvert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteService implements IDocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteConvert docenteConvert;

    @Override
    public List<DocenteDTO> findDocentesByEspecialidad(String especialidad) {
        List<Docente> docenteList = this.docenteRepository.findDocenteByEspecialidad(especialidad);

        return docenteList.stream()
                .map(docenteConvert::mapToDTO)
                .toList();
    }


    @Override
    public List<DocenteDTO> countCursosByDocente() {
        List<Docente> docenteList = this.docenteRepository.countCursosByDocente();

        return docenteList.stream()
                .map(docenteConvert::mapToDTO)
                .toList();
    }

}
