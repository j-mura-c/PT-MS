package reto_java.domain.exception.cliente;

public class ClienteUpdateException extends RuntimeException{
    public ClienteUpdateException(String s){
        super(String.format("Error actualizando cliente con clienteId %s", s));
    }
}
