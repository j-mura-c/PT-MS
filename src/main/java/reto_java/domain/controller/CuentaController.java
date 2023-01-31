package reto_java.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto_java.domain.entity.Cuenta;
import reto_java.domain.service.CuentaService;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    private ResponseEntity<Cuenta> obtenerCuenta(@RequestParam Long numeroCta){
        return new ResponseEntity<>(cuentaService.obtenerCuenta(numeroCta),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta nuevaCuenta){
        return new ResponseEntity<>(cuentaService.agregarNuevaCuenta(nuevaCuenta), HttpStatus.CREATED);
    }

}
