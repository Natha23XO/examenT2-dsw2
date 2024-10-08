package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_examen_t2.dto.NotasDto;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;
import pe.edu.cibertec.sw_examen_t2.model.Curso;
import pe.edu.cibertec.sw_examen_t2.model.Notas;
import pe.edu.cibertec.sw_examen_t2.repository.AlumnoRepository;
import pe.edu.cibertec.sw_examen_t2.repository.CursoRepository;
import pe.edu.cibertec.sw_examen_t2.repository.NotasRepository;
import pe.edu.cibertec.sw_examen_t2.service.INotasService;
import pe.edu.cibertec.sw_examen_t2.util.convert.NotasConvert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NotasService implements INotasService {
    private final NotasRepository notasRepository;
    private final NotasConvert notasConvert;
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;


    @Override
    public List<NotasDto> findByNotaGreaterThan(BigDecimal notaMinima) {
        List<NotasDto> notasDtos = new ArrayList<>();
        for(Notas notas : notasRepository.findByNotaGreaterThan(notaMinima)){
            notasDtos.add(notasConvert.convertirNotasADto(notas));
        }
        return notasDtos;
    }

    @Override
    public List<NotasDto> findByNotaBetween(BigDecimal minNota, BigDecimal maxNota) {
        List<NotasDto> notasDtos = new ArrayList<>();
        for(Notas notas : notasRepository.findByNotaBetween(minNota,maxNota)){
            notasDtos.add(notasConvert.convertirNotasADto(notas));
        }
        return notasDtos;
    }


    @Transactional
    public NotasDto saveNota(NotasDto notasDto) {
        Optional<Alumno> alumnoOptional = this.alumnoRepository.findById(notasDto.getIdalumno());
        Optional<Curso> cursoOptional = this.cursoRepository.findById(notasDto.getIdcurso());

        if (alumnoOptional.isEmpty()) {
            throw new ResourceNotFoundException("El alumno no existe");
        }

        if (cursoOptional.isEmpty()) {
            throw new ResourceNotFoundException("El curso no existe");
        }

        Alumno alumno = alumnoOptional.get();
        Curso curso = cursoOptional.get();

        Notas nota = new Notas();
        nota.setAlumno(alumno);
        nota.setCurso(curso);
        nota.setNota(notasDto.getNota());

        Notas save = notasRepository.save(nota);

        return notasConvert.convertirNotasADto(save);
    }


}
