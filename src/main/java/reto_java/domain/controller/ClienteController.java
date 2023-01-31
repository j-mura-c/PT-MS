package reto_java.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto_java.domain.entity.Cliente;
import reto_java.domain.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    private ResponseEntity<Cliente> obtenerCliente(@RequestParam Integer clienteId) {
        return new ResponseEntity(clienteService.obtenerCliente(clienteId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        return new ResponseEntity(clienteService.guardarCliente(cliente),HttpStatus.CREATED);
    }

    @PutMapping("{clienteId}")
    private ResponseEntity<Cliente> putCliente(@RequestBody Cliente cliente, @PathVariable String clienteId) {
        return new ResponseEntity<>(clienteService.actualizaCliente(cliente, clienteId),HttpStatus.OK);
    }

    @PatchMapping("{clienteId}/{nuevaDireccion}")
    private ResponseEntity<Cliente> putCliente(@PathVariable String clienteId, @PathVariable String nuevaDireccion) {
        return new ResponseEntity<>(clienteService.cambiaDireccion(clienteId, nuevaDireccion),HttpStatus.OK);
    }

    @DeleteMapping("{clienteId}")
    private ResponseEntity<HttpStatus> eliminarCliente(@PathVariable String clienteId){

        return clienteService.eliminaCliente(clienteId) == 1 ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
