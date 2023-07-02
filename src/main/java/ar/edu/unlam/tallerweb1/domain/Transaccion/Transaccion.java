package ar.edu.unlam.tallerweb1.domain.Transaccion;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import javax.persistence.*;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Concepto concepto;
    private Double monto;
    private String detalle;
    private String fecha;

    @ManyToOne
    private Categoria categoria;


    public Transaccion(){};
    public Transaccion (Double monto, String detalle, String fecha, Concepto concepto, Categoria categoria) {
        this.monto = monto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.concepto=concepto;
        this.categoria=categoria;
    }

    public Transaccion(Double monto, String detalle){
        this.monto= monto;
        this.detalle = detalle;
    };

<<<<<<< HEAD
=======

>>>>>>> Shushu
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

=======
>>>>>>> Shushu
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

<<<<<<< HEAD
    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
=======
    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
>>>>>>> Shushu
    }
}


