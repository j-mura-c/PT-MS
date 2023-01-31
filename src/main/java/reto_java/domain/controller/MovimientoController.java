package reto_java.domain.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reto_java.domain.entity.Movimiento;
import reto_java.domain.service.MovimientoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    private MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping("{cantidad}/{numeroCuenta}")
    private ResponseEntity<Movimiento> realizarMovimiento(@PathVariable Long cantidad,
                                                          @PathVariable Long numeroCuenta){

        return new ResponseEntity<>(movimientoService.realizarMovimiento(cantidad, numeroCuenta), HttpStatus.OK);

    }

    @GetMapping("/listar/{fechaDesde}/{fechaHasta}/{clienteId}")
    private ResponseEntity<List<Movimiento>> listarMovimientos(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
                                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta,
                                                               @PathVariable String clienteId) {
        return new ResponseEntity<>(movimientoService.listarMovimientos(fechaDesde, fechaHasta, clienteId), HttpStatus.OK);
    }
}
