package reto_java.domain.service.usecase;

import org.springframework.stereotype.Service;
import reto_java.domain.entity.Cuenta;
import reto_java.domain.exception.cuenta.CuentaNotFoundException;
import reto_java.domain.repository.CuentaRepository;
import reto_java.domain.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta obtenerCuenta(Long numeroCuenta){
        return cuentaRepository.findByNumero(numeroCuenta)
                .orElseThrow(() -> new CuentaNotFoundException(numeroCuenta));
    }

    @Override
    public Cuenta agregarNuevaCuenta(Cuenta nuevaCuenta) {
        return cuentaRepository.save(nuevaCuenta);
    }

    @Override
    public Integer actualizarSaldoCuenta(Long movimiento, Long numeroCta){
        Integer result = cuentaRepository.actualizarSaldoCuenta(movimiento, numeroCta);
        return result;
    }
}
