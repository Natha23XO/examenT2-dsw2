package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_examen_t2.dto.CountMatriculasDTO;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;
import pe.edu.cibertec.sw_examen_t2.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_examen_t2.model.Alumno;
import pe.edu.cibertec.sw_examen_t2.model.Curso;
import pe.edu.cibertec.sw_examen_t2.model.Matricula;
import pe.edu.cibertec.sw_examen_t2.repository.AlumnoRepository;
import pe.edu.cibertec.sw_examen_t2.repository.CursoRepository;
import pe.edu.cibertec.sw_examen_t2.repository.MatriculaRepository;
import pe.edu.cibertec.sw_examen_t2.service.IMatriculaService;
import pe.edu.cibertec.sw_examen_t2.util.convert.MatriculaConvert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;
    private final MatriculaConvert matriculaConvert;

    @Override
    public List<MatriculaDTO> findMatriculasByAlumno(Integer idalumno) {
        List<Matricula> matriculaList = this.matriculaRepository.findMatriculaByAlumno(idalumno);

        return matriculaList.stream()
                .map(matriculaConvert::MatriculaToDTO)
                .toList();
    }

    @Override
    public CountMatriculasDTO countMatriculasByCurso(Integer idcurso) {
        int count = this.matriculaRepository.countMatriculaByCurso(idcurso);

        return new CountMatriculasDTO(count);
    }


    @Transactional
    public MatriculaDTO registrarMatricula(MatriculaDTO matriculaDTO) {
        Alumno alumno = alumnoRepository.findById(Integer.parseInt(matriculaDTO.getAlumno()))
                .orElseThrow(() -> new ResourceNotFoundException("El alumno no existe"));
        Curso curso = cursoRepository.findById(Integer.parseInt(matriculaDTO.getCurso()))
                .orElseThrow(() -> new ResourceNotFoundException("El curso no existe"));
        Matricula matricula = new Matricula();
        matricula.setAlumno(alumno);
        matricula.setCurso(curso);
        matricula.setSemestre(matriculaDTO.getSemestre());
        matricula.setFechamatricula(matriculaDTO.getFechamatricula());
        Matricula savedMatricula = matriculaRepository.save(matricula);
        return matriculaConvert.MatriculaToDTO(savedMatricula);
    }
}