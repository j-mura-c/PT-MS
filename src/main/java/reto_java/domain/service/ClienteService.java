package reto_java.domain.service;

import reto_java.domain.entity.Cliente;

import java.util.Optional;

public interface ClienteService {
    public Cliente obtenerCliente(Integer clienteId);
    public Cliente guardarCliente(Cliente cliente);
    public Cliente actualizaCliente(Cliente cliente, String clienteId);
    public Cliente cambiaDireccion(String clienteId, String direccionNueva);
    public Integer eliminaCliente(String clienteId);
}
