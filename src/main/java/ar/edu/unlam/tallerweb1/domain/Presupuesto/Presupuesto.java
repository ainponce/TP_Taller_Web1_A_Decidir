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

    private boolean estaActivo;

    @OneToOne
    private Categoria categoria;

    public Presupuesto(){}

    public Presupuesto(Double monto, String fechaDesde, String fechaHasta, Categoria categoria) {
        this.montoPresupuesto = monto;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.categoria = categoria;
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


    public Categoria getCategoria() {
       return categoria;
    }

    public void setCategoria(Categoria cat) {
        this.categoria= cat;
    }


}
