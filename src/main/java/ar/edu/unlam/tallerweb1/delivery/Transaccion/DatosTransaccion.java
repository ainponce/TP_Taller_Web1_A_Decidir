package ar.edu.unlam.tallerweb1.delivery.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;

public class DatosTransaccion {

    private Concepto concepto;
    private Double monto;


    public DatosTransaccion(){
    }

    public DatosTransaccion(Double monto, Concepto concepto){
        this.monto= monto;
        this.concepto= concepto;
    }
}
