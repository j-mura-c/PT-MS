package reto_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import reto_java.domain.entity.Cuenta;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByNumero(Long numero);
    @Transactional
    @Modifying
    @Query("update Cuenta c set c.saldo=?1 where c.numero=?2")
    public Integer actualizarSaldoCuenta(Long movimiento, Long numeroCta);
}
