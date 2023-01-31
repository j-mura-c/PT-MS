package reto_java.domain.service.usecase;

import org.springframework.stereotype.Service;
import reto_java.domain.entity.Cuenta;
import reto_java.domain.entity.Movimiento;
import reto_java.domain.exception.movimiento.SaldoInsuficienteException;
import reto_java.domain.repository.MovimientoRepository;
import reto_java.domain.service.CuentaService;
import reto_java.domain.service.MovimientoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private MovimientoRepository movimientoRepository;

    private CuentaService cuentaService;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaService cuentaService) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaService = cuentaService;
    }

    public Movimiento realizarMovimiento(Long cantidad, Long numeroCuenta){
        Movimiento movimiento = new Movimiento();
        String tipoMovimiento = cantidad > 0 ? "Deposito" : "Retiro";
        Long saldoActual = cuentaService.obtenerCuenta(numeroCuenta).getSaldo();
        if(saldoActual < Math.abs(cantidad) && tipoMovimiento.equals("Retiro")){
            throw new SaldoInsuficienteException(numeroCuenta);
        } else {
            Long saldo = saldoActual + cantidad;
            cuentaService.actualizarSaldoCuenta(saldo, numeroCuenta);
            Cuenta cuenta = new Cuenta(numeroCuenta,null,null,null,null);
            movimiento.setCuenta(cuenta);
            movimiento.setValor(cantidad);
            movimiento.setSaldo(saldo);
            movimiento.setFecha(LocalDate.now());
            movimiento.setHora(LocalTime.now());
            return movimientoRepository.save(movimiento);
        }
    }

    public List<Movimiento> listarMovimientos(LocalDate desde, LocalDate hasta, String clienteId){
        return movimientoRepository.findMovimientosByUsername(desde,
                hasta,
                LocalTime.of(0,0),
                LocalTime.now(),
                clienteId);
    }
}
