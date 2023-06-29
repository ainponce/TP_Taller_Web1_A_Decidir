package ar.edu.unlam.tallerweb1.domain.Moneda;

import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

import javax.persistence.*;

@Entity
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double valor;
    public Moneda(){}

    public Moneda(Long id, String nombre, Double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;

    }

    public Moneda(String nombre, Double valor) {
        this.nombre=nombre;
        this.valor=valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
