package ar.edu.unlam.tallerweb1.infrastructure.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

import java.util.List;

public interface RepositorioTransaccion {

    public List<Transaccion> buscarTransaccionPorDetalle(String detalle) ;
    public boolean guardarTransaccion(Transaccion transaccion);
    public void modificar(Transaccion transaccion);

    public List<Transaccion> listarTransaccion();


    List<Transaccion> buscarTransaccionPorConcepto(Concepto concepto);
    public List<Transaccion> buscarTransaccionPorCategoria(Categoria categoria);
    public Double convertirMontoTransaccion(Double monto);

    void eliminarTransaccion(Transaccion transaccion);

    Transaccion buscarTransaccionPorIdParaEliminar(Long id);
}

