package reto_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import reto_java.domain.entity.Movimiento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MovimientoRepository  extends JpaRepository<Movimiento, Integer> {

    @Query("SELECT m from Movimiento m where m.fecha>=?1 and m.fecha<=?2 and m.hora>?3 and m.hora<?4 "+
           "and m.cuenta.cliente.clienteId=?5")
    List<Movimiento> findMovimientosByUsername(LocalDate desde, LocalDate hasta, LocalTime hrIni, LocalTime hrFin,
                                               String clienteId);

}
