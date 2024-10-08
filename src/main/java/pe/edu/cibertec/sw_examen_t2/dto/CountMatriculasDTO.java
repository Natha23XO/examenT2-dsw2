package pe.edu.cibertec.sw_examen_t2.dto;

import lombok.Data;

@Data
public class CountMatriculasDTO {
    private int count;

    public CountMatriculasDTO(int count) {
        this.count = count;
    }

}