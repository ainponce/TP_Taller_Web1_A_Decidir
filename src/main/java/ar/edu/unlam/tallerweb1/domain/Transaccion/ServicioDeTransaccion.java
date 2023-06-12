package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import java.util.List;


public interface ServicioDeTransaccion {

    public Boolean registrarTransaccion(Double monto, String detalle, String fecha, Moneda moneda, Concepto concepto, Categoria categoria);

    public List<Transaccion> buscarTransaccionPorDetalle(String detalle);

    public Boolean registrarTransaccionDetalle(Double monto, String detalle);

    public List<Transaccion> listarTransacciones();
    public List<Categoria> listarCategorias();


    Double sumarMontoDeTransaccionesPorCategoria(List<Transaccion> trans);


    public List<Transaccion> filtrarTransaccionesPorCategoria(Categoria categoria);

    Boolean registroTransaccionExitoso(List<Transaccion> transacciones, Double presupuestoDeCategoria);
}
