package pe.edu.cibertec.sw_examen_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t2.dto.NotasDto;
import pe.edu.cibertec.sw_examen_t2.model.Notas;
import pe.edu.cibertec.sw_examen_t2.repository.NotasRepository;
import pe.edu.cibertec.sw_examen_t2.service.INotasService;
import pe.edu.cibertec.sw_examen_t2.util.convert.NotasConvert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NotasService implements INotasService {
    private final NotasRepository notasRepository;
    private final NotasConvert notasConvert;

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
}
