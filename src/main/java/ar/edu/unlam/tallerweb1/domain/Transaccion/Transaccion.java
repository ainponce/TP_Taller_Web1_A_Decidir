package ar.edu.unlam.tallerweb1.domain.Transaccion;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Usuarios.Usuario;

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
    private Moneda moneda;

    public Transaccion(){};
    public Transaccion (Double monto, String detalle, String fecha, Moneda moneda) {
        this.monto = monto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.moneda = moneda;
    }

    public Transaccion(Double monto, Concepto concepto){
        this.monto= monto;
        this.concepto= concepto;
    };

}


