package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_examen_t2.dto.DocenteDTO;
import pe.edu.cibertec.sw_examen_t2.model.AsignacionDocente;
import pe.edu.cibertec.sw_examen_t2.model.Docente;
import pe.edu.cibertec.sw_examen_t2.model.Sede;
import pe.edu.cibertec.sw_examen_t2.repository.AsignacionDocenteRepository;
import pe.edu.cibertec.sw_examen_t2.repository.DocenteRepository;
import pe.edu.cibertec.sw_examen_t2.repository.SedeRepository;
import pe.edu.cibertec.sw_examen_t2.service.IDocenteService;
import pe.edu.cibertec.sw_examen_t2.util.convert.DocenteConvert;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteService implements IDocenteService {

    private final DocenteRepository docenteRepository;
    private final SedeRepository sedeRepository;
    private final AsignacionDocenteRepository asignacionDocenteRepository;
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

    @Transactional
    @Override
    public void asignarDocente(DocenteDTO docenteDto) {
        Docente docenteExistente = docenteRepository.findByDni(docenteDto.getDni());
        Docente docente = new Docente();
        if (docenteExistente == null) {
            docente.setNombre(docenteDto.getNombre());
            docente.setApellido(docenteDto.getApellido());
            docente.setEspecialidad(docenteDto.getEspecialidad());
            docente.setDni(docenteDto.getDni());
            docenteRepository.save(docente);
        } else {
            docente = docenteExistente;
        }

        Sede sedeExistente = sedeRepository.findById(docenteDto.getIdsede()).orElse(null);
        Sede sede = new Sede();
        if (sedeExistente == null) {
            sede.setNombresede(sedeExistente.getNombresede());
            sede.setDireccion(sedeExistente.getDireccion());
            sedeRepository.save(sede);
        } else {
            sede = sedeExistente;
        }

        AsignacionDocente asignacion = new AsignacionDocente();
        asignacion.setDocente(docente);
        asignacion.setSede(sede);
        asignacion.setFechaasignacion(new Date());
        asignacionDocenteRepository.save(asignacion);
    }

}
