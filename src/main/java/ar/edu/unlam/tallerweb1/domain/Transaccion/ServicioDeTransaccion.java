package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;


public interface ServicioDeTransaccion {

    public Boolean registrarTransaccion(Double monto, String detalle, String fecha, Moneda moneda);

    public Transaccion buscarTransaccionPorDetalle(String detalle);
}
