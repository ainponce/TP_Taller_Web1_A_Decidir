package ar.edu.unlam.tallerweb1.domain.Transaccion;
import ar.edu.unlam.tallerweb1.delivery.Concepto;
import ar.edu.unlam.tallerweb1.delivery.Moneda;
import ar.edu.unlam.tallerweb1.domain.categorias.Categoria;

import javax.persistence.*;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="categoriaId")
    private Categoria categoriaDeLaTransaccion;

    private Concepto concepto;
    private Double monto;
    private String detalle;
    private String fecha;
    private Moneda moneda;

    public Transaccion(){};
    public Transaccion (Long id, Categoria categoriaDeLaTransaccion, Concepto concepto, Double monto, String detalle,Moneda moneda) {
        this.id = id;
        this.categoriaDeLaTransaccion = categoriaDeLaTransaccion;
        this.concepto = concepto;
        this.monto = monto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.moneda = moneda;
    }


}


