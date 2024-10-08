package pe.edu.cibertec.sw_examen_t2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_examen_t2.dto.MatriculaDTO;
import pe.edu.cibertec.sw_examen_t2.model.Matricula;

@Component
public class MatriculaConvert {

    public MatriculaDTO MatriculaToDTO(Matricula matricula) {
        MatriculaDTO dto = new MatriculaDTO();
        dto.setIdmatricula( matricula.getIdmatricula());
        dto.setAlumno(matricula.getAlumno().getNombre());
        dto.setCurso(matricula.getCurso().getNombrecurso());
        dto.setSemestre(matricula.getSemestre());
        dto.setFechamatricula( matricula.getFechamatricula());

        return dto;
    }

}
