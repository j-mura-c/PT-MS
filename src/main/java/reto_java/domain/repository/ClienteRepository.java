package reto_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import reto_java.domain.entity.Cliente;
import reto_java.domain.entity.enums.Estado;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByClienteId(String clienteId);

    @Transactional
    Integer deleteByClienteId(String clienteId);

}
