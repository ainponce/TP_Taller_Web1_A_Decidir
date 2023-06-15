package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("servicioDeTransaccion")
@Transactional
public class ServicioDeTransaccionImpl implements ServicioDeTransaccion {


    private final  RepositorioTransaccion repoTransaccion;
    private final RepositorioCategoria repositorioCategoria;

    @Autowired
    public ServicioDeTransaccionImpl(RepositorioTransaccion servicioTransaccionDao, RepositorioCategoria repositorioCategoria){
        this.repoTransaccion = servicioTransaccionDao;
        this.repositorioCategoria=repositorioCategoria;
    }

    @Override
    public Boolean registrarTransaccionDetalle(Double monto, String detalle) {
        Boolean seRegistro = false;

        if (monto > 0 ) {
            Transaccion transaccion = new Transaccion(monto, detalle);
            repoTransaccion.guardarTransaccion(transaccion);
            seRegistro = true;
        }
        return seRegistro;
    }

    @Override
    public Boolean registrarTransaccion(Double monto, String detalle, String fecha, Concepto concepto, Categoria categoria) {
        Boolean seRegistro = false;
        List <Transaccion> validacionDeCategoria= repoTransaccion.listarTransaccion();
        if (monto > 0) {
            Transaccion transaccion = new Transaccion(monto, detalle, fecha, concepto, categoria);
            repoTransaccion.guardarTransaccion(transaccion);
            seRegistro = true;
        }
        return seRegistro;
    }

    @Override
    public List<Transaccion> buscarTransaccionPorDetalle(String detalle) {
        return repoTransaccion.buscarTransaccionPorDetalle(detalle);
    }



    @Override
    public List<Transaccion> listarTransacciones(){
        return repoTransaccion.listarTransaccion();
    }

    @Override
    public List<Categoria> listarCategorias() {
        return repositorioCategoria.listarCategoriaPorTransaccion();
    }

    @Override
    public Double sumarMontoDeTransaccionesPorCategoria(List<Transaccion> trans) {
        double montoTotal = 0.0;
        for (Transaccion transaccion: trans) {
            montoTotal += transaccion.getMonto();
        }
        return montoTotal;
    }

    @Override
    public Double convertirMontoTransaccion(Double monto) {
        return null;
    }

    @Override
    public List<Transaccion> filtrarTransaccionesPorCategoria(Categoria categoria){
        return repoTransaccion.buscarTransaccionPorCategoria(categoria);
    }

    @Override
    public Boolean registroTransaccionExitoso(List<Transaccion> transaccion, Double presupuestoDeCategoria, Double monto) {
        Double diferencia=0.0;
        Double montoTransacciones=0.0;
        Double montoTransaccionesTotal=0.0;
        final Double montoEstimadoANoSobrepasar=1000.0;
        for (Transaccion tran: transaccion) {
            montoTransacciones += tran.getMonto();
            montoTransaccionesTotal= montoTransacciones+monto;
        }
        diferencia= presupuestoDeCategoria-montoTransaccionesTotal;
        if(diferencia<montoEstimadoANoSobrepasar){
            return false;
        }
        return true;
    }

    @Override
    public List<Transaccion> filtrarTransaccionesPorConcepto(Concepto concepto) {
        return repoTransaccion.buscarTransaccionPorConcepto(concepto);
}

    @Override
    public void eliminarTransaccion(Transaccion tranAEliminar) {
        repoTransaccion.eliminarTransaccion(tranAEliminar);
        repoTransaccion.listarTransaccion().remove(tranAEliminar);
    }

    @Override
    public Transaccion buscarTransaccionPorIdParaEliminar(Long id) {
        return repoTransaccion.buscarTransaccionPorIdParaEliminar(id);
    }


    public List<Transaccion> convertirMontoEnMonedaSeleccionada(Moneda moneda){
        List<Transaccion> transacciones = repoTransaccion.listarTransaccion();
        List<Transaccion> transaccionesNuevoMonto = new ArrayList<>();
        Double tipoMoneda = moneda.getValor();
        Double montoFinal = 0.0;
        for (Transaccion transaccion: transacciones) {
            montoFinal = transaccion.getMonto() / tipoMoneda;
            transaccionesNuevoMonto.add(new Transaccion(montoFinal, transaccion.getDetalle(), transaccion.getFecha(), transaccion.getConcepto(), transaccion.getCategoria()));
        }
        return transaccionesNuevoMonto;
    }

}
