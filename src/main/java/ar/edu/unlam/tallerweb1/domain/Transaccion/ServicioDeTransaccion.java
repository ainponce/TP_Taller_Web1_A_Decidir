package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;

import java.time.LocalDate;
import java.util.List;


public interface ServicioDeTransaccion {

    //public Boolean registrarTransaccion(Double monto, String detalle, String fecha, Concepto concepto, Categoria categoria);
    Boolean registrarTransaccion(double monto, Double presupuestoDeCategoria, String detalle, LocalDate fecha, Concepto concepto, Categoria cat);

    //Boolean registrarTransaccion(Double monto, Double presupuestoDeCategoria, String detalle, String fecha, Concepto concepto, Categoria categoria);

    public List<Transaccion> buscarTransaccionPorDetalle(String detalle);

    public Boolean registrarTransaccionDetalle(Double monto, String detalle);

    public List<Transaccion> listarTransacciones();
    public List<Categoria> listarCategorias();
    public List<Transaccion> convertirMontoEnMonedaSeleccionada(Moneda moneda);
    public Double sumarMontoDeTransaccionesPorCategoria(List<Transaccion> trans);

    public Double convertirMontoTransaccion(Double monto);

    public List<Transaccion> filtrarTransaccionesPorCategoria(Categoria categoria);

    Boolean registroTransaccionExitoso(List<Transaccion> transacciones, Double presupuestoDeCategoria, Double monto);

    List<Transaccion> filtrarTransaccionesPorConcepto(Concepto concepto);

    Transaccion buscarTransaccionPorIdParaEliminar(Long id);

    void eliminarTransaccion(Transaccion tranAEliminar);


}
