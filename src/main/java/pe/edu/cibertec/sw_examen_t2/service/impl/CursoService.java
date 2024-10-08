package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t2.dto.CursoDto;
import pe.edu.cibertec.sw_examen_t2.model.Curso;
import pe.edu.cibertec.sw_examen_t2.repository.CursoRepository;
import pe.edu.cibertec.sw_examen_t2.service.ICursoService;
import pe.edu.cibertec.sw_examen_t2.util.convert.CursoConvert;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CursoService implements ICursoService {

    private final CursoRepository cursoRepository;
    private final CursoConvert cursoConvert;

    @Override
    public List<CursoDto> findByNombrecursoContaining(String nombre) {
        List<CursoDto> cursoDto = new ArrayList<>();
        for(Curso curso : cursoRepository.findByNombrecursoContaining(nombre)){
            cursoDto.add(cursoConvert.convertirCursoADto(curso));
        }
        return cursoDto;
    }

    @Override
    public List<CursoDto> findByCreditos(Integer creditos) {
        List<CursoDto> cursoDto = new ArrayList<>();
        for(Curso curso : cursoRepository.findByCreditos(creditos)){
            cursoDto.add(cursoConvert.convertirCursoADto(curso));
        }
        return cursoDto;
    }
}
