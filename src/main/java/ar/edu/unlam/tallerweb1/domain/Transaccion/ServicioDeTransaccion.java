package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import java.util.List;


public interface ServicioDeTransaccion {

    public Boolean registrarTransaccion(Double monto, String detalle, String fecha, Concepto concepto, Categoria categoria);

    public List<Transaccion> buscarTransaccionPorDetalle(String detalle);

    public Boolean registrarTransaccionDetalle(Double monto, String detalle);

    public List<Transaccion> listarTransacciones();
    public List<Categoria> listarCategorias();
    public List<Transaccion> convertirMontoEnMonedaSeleccionada(Moneda moneda);
    public Double sumarMontoDeTransaccionesPorCategoria(List<Transaccion> trans);

    public Double convertirMontoTransaccion(Double monto);

    public List<Transaccion> filtrarTransaccionesPorCategoria(Categoria categoria);

    public Boolean registroTransaccionExitoso(List<Transaccion> transacciones, Double presupuestoDeCategoria, Double monto);
}
