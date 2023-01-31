package reto_java.domain.entity;

import reto_java.domain.entity.enums.Estado;
import reto_java.domain.entity.enums.Genero;

import javax.persistence.*;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"contrasena"}))
@Entity
@PrimaryKeyJoinColumn(name = "personaId")
public class Cliente extends Persona{

    public Cliente(Integer id, String nombre, Genero genero, Integer edad, String identificacion, String direccion, Long telefono, String clienteId, String contrasena, Estado estado) {
        super(id, nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente(Integer id, String nombre, Genero genero, Integer edad, String identificacion, String direccion, Long telefono) {
        super(id, nombre, genero, edad, identificacion, direccion, telefono);
    }

    public Cliente(String clienteId, String contrasena, Estado estado) {
        this.clienteId = clienteId;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente() {
    }

    @Column
    private String clienteId;

    @Column
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column
    private Estado estado;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
