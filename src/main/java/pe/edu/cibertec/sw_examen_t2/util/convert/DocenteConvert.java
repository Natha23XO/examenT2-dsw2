package pe.edu.cibertec.sw_examen_t2.util.convert;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_examen_t2.dto.DocenteDTO;
import pe.edu.cibertec.sw_examen_t2.model.Docente;


@Component
public class DocenteConvert {

    public DocenteDTO mapToDTO(Docente docente) {
        int cursos = docente.getCursos() != null ? (int) docente.getCursos().size() : 0;
        return new DocenteDTO(
                docente.getIddocente(),
                docente.getNombre(),
                docente.getApellido(),
                docente.getEspecialidad(),
                cursos
        );
    }

}
