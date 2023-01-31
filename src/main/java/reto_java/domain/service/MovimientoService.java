package reto_java.domain.service;

import reto_java.domain.entity.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoService {

    public List<Movimiento> listarMovimientos(LocalDate desde, LocalDate hasta, String clienteId);
    public Movimiento realizarMovimiento(Long valor, Long numeroCuenta);
}
