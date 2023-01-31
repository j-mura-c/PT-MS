package reto_java.domain.entity;

import reto_java.domain.entity.enums.Estado;
import reto_java.domain.entity.enums.Tipo;

import javax.persistence.*;

@Entity
public class Cuenta {

    public Cuenta(Long numero, Tipo tipo, Long saldo, Estado estado, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Cuenta() {
    }

    @Id
    @Column
    private Long numero;
    @Enumerated(EnumType.STRING)
    @Column
    private Tipo tipo;
    @Column
    private Long saldo;
    @Enumerated(EnumType.STRING)
    @Column
    private Estado estado;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    Cliente cliente;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
