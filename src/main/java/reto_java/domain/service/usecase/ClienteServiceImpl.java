package reto_java.domain.service.usecase;

import org.springframework.stereotype.Service;
import reto_java.domain.entity.Cliente;
import reto_java.domain.exception.cliente.ClienteNotFoundException;
import reto_java.domain.exception.cliente.ClienteUpdateException;
import reto_java.domain.repository.ClienteRepository;
import reto_java.domain.service.ClienteService;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente obtenerCliente(Integer clienteId) {
        return clienteRepository.findById(clienteId).
                orElseThrow(() -> new ClienteNotFoundException(clienteId));
    }

    @Override
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizaCliente(Cliente cliente, String clienteId) {
        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ClienteUpdateException(clienteId)));

        if(clienteOptional.isPresent()) {
            Cliente clienteActualizar = clienteOptional.get();
            clienteActualizar.setGenero(cliente.getGenero());
            clienteActualizar.setEdad(cliente.getEdad());
            clienteActualizar.setClienteId(cliente.getClienteId());
            clienteActualizar.setIdentificacion(cliente.getIdentificacion());
            clienteActualizar.setDireccion(cliente.getDireccion());
            clienteActualizar.setTelefono(cliente.getTelefono());
            clienteActualizar.setContrasena(cliente.getContrasena());
            clienteActualizar.setEstado(cliente.getEstado());
            return clienteRepository.save(clienteActualizar);
        } else {
            return clienteRepository.save(cliente);
        }
    }

    @Override
    public Cliente cambiaDireccion(String clienteId, String nuevaDireccion){
        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ClienteUpdateException(clienteId)));

        if(clienteOptional.isPresent() && !clienteOptional.get().getDireccion().equals(nuevaDireccion)) {
            Cliente clienteActualizar = clienteOptional.get();
            clienteActualizar.setDireccion(nuevaDireccion);
            return clienteRepository.save(clienteActualizar);
        } else {
            throw new ClienteUpdateException(clienteId);
        }
    }

    @Override
    public Integer eliminaCliente(String clienteId) {
        return clienteRepository.deleteByClienteId(clienteId);
    }
}
