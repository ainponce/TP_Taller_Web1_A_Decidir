package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import javax.persistence.*;

@Entity
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaDesde;
    private String fechaHasta;
    private double montoPresupuesto;
    private Moneda moneda;
    private boolean estaActivo;

    @OneToOne
    private Categoria categoriaDelPresupuesto;

    public Presupuesto(){}

    public Presupuesto(Double monto, String fechaDesde, String fechaHasta, Moneda moneda, Categoria categoria) {
        this.montoPresupuesto = monto;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.moneda = moneda;
        this.categoriaDelPresupuesto = categoria;
        this.estaActivo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public double getMontoPresupuesto() {
        return montoPresupuesto;
    }

    public void setMontoPresupuesto(double montoPresupuesto) {
        this.montoPresupuesto = montoPresupuesto;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Categoria getCategoriaDelPresupuesto() {
       return categoriaDelPresupuesto;
    }

    public void setCategoriaDelPresupuesto(Categoria categoriaDelPresupuesto) {
        this.categoriaDelPresupuesto = categoriaDelPresupuesto;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}
