package ar.edu.unlam.tallerweb1.delivery.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;

public class DatosTransaccion {

    private String detalle;
    private Double monto;


    public DatosTransaccion(){
    }

    public DatosTransaccion(Double monto, String detalle){
        this.monto= monto;
        this.detalle= detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
