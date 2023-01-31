package reto_java.domain.exception.movimiento;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(Long id){
        super(String.format("Lo sentimos, el saldo en la cuenta %d es insuficiente para realizar la transacción",id));
    }
}
