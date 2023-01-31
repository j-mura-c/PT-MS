package reto_java.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"fecha","hora"})})
@Entity
public class Movimiento {

    public Movimiento(Integer id, LocalDate fecha, LocalTime hora, Long valor, Long saldo, Cuenta cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public Movimiento() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private LocalDate fecha;
    @Column
    private LocalTime hora;
    @Column
    private Long valor;
    @Column
    private Long saldo;
    @OneToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
