package reto_java.domain.exception.cuenta;

public class CuentaNotFoundException extends RuntimeException{
    public CuentaNotFoundException(Long id){
        super(String.format("La cuenta cuyo número es %d no ha sido encontrada",id));
    }
}
