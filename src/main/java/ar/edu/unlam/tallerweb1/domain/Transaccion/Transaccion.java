package ar.edu.unlam.tallerweb1.domain.Transaccion;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Usuarios.Usuario;

import javax.persistence.*;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="categoriaId")
    private Categoria categoriaDeLaTransaccion;

    @ManyToOne
    @JoinColumn(name="usuarioId")
    private Usuario usuarioDeLaTransaccion; //id del usuario que crea la transaccion

    private Concepto concepto;
    private Double monto;
    private String detalle;
    private String fecha;
    private Moneda moneda;

    public Transaccion(){};
    public Transaccion (Categoria categoriaDeLaTransaccion, Concepto concepto, Double monto, String detalle,Moneda moneda) {
        this.categoriaDeLaTransaccion = categoriaDeLaTransaccion;
        this.concepto = concepto;
        this.monto = monto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.moneda = moneda;
    }


}


