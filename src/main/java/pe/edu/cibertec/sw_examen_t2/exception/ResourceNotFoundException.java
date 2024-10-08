package pe.edu.cibertec.sw_examen_t2.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
