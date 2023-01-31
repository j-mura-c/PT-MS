package reto_java.domain.service;

import reto_java.domain.entity.Cuenta;

public interface CuentaService {
    public Cuenta obtenerCuenta(Long numeroCuenta);
    public Cuenta agregarNuevaCuenta(Cuenta nuevaCuenta);
    public Integer actualizarSaldoCuenta(Long movimiento, Long numeroCta);
}
