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


    private final RepositorioTransaccion RepoTransaccionDao;
    private final RepositorioCategoria repositorioCategoria;

    @Autowired
    public ServicioDeTransaccionImpl(RepositorioTransaccion servicioTransaccionDao, RepositorioCategoria repositorioCategoria) {
        this.RepoTransaccionDao = servicioTransaccionDao;
        this.repositorioCategoria = repositorioCategoria;
    }

    @Override
    public Boolean registrarTransaccionDetalle(Double monto, String detalle) {
        Boolean seRegistro = false;

        if (monto > 0) {
            Transaccion transaccion = new Transaccion(monto, detalle);
            RepoTransaccionDao.guardarTransaccion(transaccion);
            seRegistro = true;
        }else {
            throw new MontoMenorACero();
        }
        return seRegistro;
    }

    @Override
    public Boolean registrarTransaccion(double monto, Double presupuestoDeCategoria, String detalle, String fecha, Concepto concepto, Categoria categoria) {
        Boolean seRegistro = false;
        List<Transaccion> validacionDeCategoria = RepoTransaccionDao.listarTransaccion();
        List<Transaccion> transacciones = filtrarTransaccionesPorCategoria(categoria);
        //un if de metodo registroexitoso
        if(registroTransaccionExitoso(transacciones,presupuestoDeCategoria,monto)){
            if (monto > 0) {
                Transaccion transaccion = new Transaccion(monto, detalle, fecha, concepto, categoria);
                RepoTransaccionDao.guardarTransaccion(transaccion);
                seRegistro = true;
            } else {
                throw new MontoMenorACero();
            }
        }
        return seRegistro;
    }


    @Override
    public List<Transaccion> buscarTransaccionPorDetalle(String detalle) {
        return RepoTransaccionDao.buscarTransaccionPorDetalle(detalle);
    }


    @Override
    public List<Transaccion> listarTransacciones() {
        return RepoTransaccionDao.listarTransaccion();
    }

    @Override
    public List<Categoria> listarCategorias() {
        return repositorioCategoria.listarCategorias();
    }

    @Override
    public Double sumarMontoDeTransaccionesPorCategoria(List<Transaccion> trans) {
        double montoTotal = 0.0;
        for (Transaccion transaccion : trans) {
            montoTotal += transaccion.getMonto();
        }
        return montoTotal;
    }

    @Override
    public Double convertirMontoTransaccion(Double monto) {
        return null;
    }

    @Override
    public List<Transaccion> filtrarTransaccionesPorCategoria(Categoria categoria) {
        return RepoTransaccionDao.buscarTransaccionPorCategoria(categoria);
    }

    @Override
    public Boolean registroTransaccionExitoso(List<Transaccion> transaccion, Double presupuestoDeCategoria, Double monto) {
        Double diferencia = 0.0;
        Double montoTransacciones = 0.0;
        Double montoTransaccionesTotal = 0.0;
        final Double montoEstimadoANoSobrepasar = 1000.0;
        for (Transaccion tran : transaccion) {
            montoTransacciones += tran.getMonto();
            montoTransaccionesTotal = montoTransacciones + monto;
        }
        diferencia = presupuestoDeCategoria - montoTransaccionesTotal;
        if (diferencia < montoEstimadoANoSobrepasar) {
            throw new ElMontoEstaPorLlegarASuLimite();
        }

        return true;
    }

    @Override
    public List<Transaccion> filtrarTransaccionesPorConcepto(Concepto concepto) {
        return RepoTransaccionDao.buscarTransaccionPorConcepto(concepto);
    }


    @Override
    public void eliminarTransaccion(Transaccion tranAEliminar) {
        RepoTransaccionDao.eliminarTransaccion(tranAEliminar);
        RepoTransaccionDao.listarTransaccion().remove(tranAEliminar);
    }

    @Override
    public Transaccion buscarTransaccionPorIdParaEliminar(Long id) {
        return RepoTransaccionDao.buscarTransaccionPorIdParaEliminar(id);
    }



    public List<Transaccion> convertirMontoEnMonedaSeleccionada(Moneda moneda) {
        List<Transaccion> transacciones = RepoTransaccionDao.listarTransaccion();
        List<Transaccion> transaccionesNuevoMonto = new ArrayList<>();
        Double tipoMoneda = moneda.getValor();
        Double montoFinal = 0.0;
        for (Transaccion transaccion : transacciones) {
            montoFinal = transaccion.getMonto() / tipoMoneda;
            transaccionesNuevoMonto.add(new Transaccion(montoFinal, transaccion.getDetalle(), transaccion.getFecha(), transaccion.getConcepto(), transaccion.getCategoria()));
        }
        return transaccionesNuevoMonto;
    }
}
