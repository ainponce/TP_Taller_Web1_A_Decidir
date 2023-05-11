package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;


public interface ServicioDeTransaccion {

    public Boolean registrarTransaccion(Categoria categoria, Concepto concepto, Double monto, String detalle, String fecha, Moneda moneda);

    public Transaccion buscarTransaccionPorDetalle(String detalle);
}
