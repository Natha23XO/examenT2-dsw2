package pe.edu.cibertec.sw_examen_t2.dto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GenericResponseDto<T> {
    //T va a recibir un objeto de cualquier tipo
    private boolean correcto;
    private String mensaje;
    private T respuesta;
    private String erorcode;
}

