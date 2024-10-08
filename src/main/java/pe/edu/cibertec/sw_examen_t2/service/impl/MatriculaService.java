package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;
import pe.edu.cibertec.sw_examen_t2.model.Matricula;
import pe.edu.cibertec.sw_examen_t2.repository.MatriculaRepository;
import pe.edu.cibertec.sw_examen_t2.service.IMatriculaService;
import pe.edu.cibertec.sw_examen_t2.util.convert.MatriculaConvert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final MatriculaConvert matriculaConvert;

    @Override
    public List<MatriculaDTO> findMatriculasByAlumno(Integer idalumno) {
        List<Matricula> matriculaList = this.matriculaRepository.findMatriculaByAlumno(idalumno);

        return matriculaList.stream()
                .map(matriculaConvert::MatriculaToDTO)
                .toList();
    }


    @Override
    public List<MatriculaDTO> countMatriculasByCurso() {
        List<Matricula> matriculaList = this.matriculaRepository.countMatriculaByCurso();

        return matriculaList.stream()
                .map(matriculaConvert::MatriculaToDTO)
                .toList();
    }

}
