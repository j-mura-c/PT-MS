package reto_java.domain.exception.cliente;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(Integer id){
        super(String.format("El cliente cuyo id es %d no ha sido encontrado",id));
    }
}
