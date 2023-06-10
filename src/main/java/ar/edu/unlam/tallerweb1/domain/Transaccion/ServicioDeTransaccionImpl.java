package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("servicioDeTransaccion")
@Transactional
public class ServicioDeTransaccionImpl implements ServicioDeTransaccion {


    private final  RepositorioTransaccion servicioTransaccionDao;

    @Autowired
    public ServicioDeTransaccionImpl(RepositorioTransaccion servicioTransaccionDao){
        this.servicioTransaccionDao = servicioTransaccionDao;
    }

    @Override
    public Boolean registrarTransaccionDetalle(Double monto, String detalle) {
        Boolean seRegistro = false;

        if (monto > 0 ) {
            Transaccion transaccion = new Transaccion(monto, detalle);
            servicioTransaccionDao.guardarTransaccion(transaccion);
            seRegistro = true;
        }
        return seRegistro;
    }

    @Override
    public Boolean registrarTransaccion(Double monto, String detalle, String fecha, Moneda moneda, Concepto concepto, Categoria categoria) {
        Boolean seRegistro = false;
        if (monto > 0) {
            Transaccion transaccion = new Transaccion(monto, detalle, fecha, moneda, concepto, categoria);
            servicioTransaccionDao.guardarTransaccion(transaccion);
            seRegistro = true;
        }
        return seRegistro;
    }

    @Override
    public List<Transaccion> buscarTransaccionPorDetalle(String detalle) {
        return servicioTransaccionDao.buscarTransaccionPorDetalle(detalle);
    }


    @Override
    public List<Transaccion> listarTransacciones(){
        return servicioTransaccionDao.listarTransaccion();
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
    public List<Transaccion> filtrarTransaccionesPorCategoria(Categoria categoria){
        return null; //servicioTransaccionDao.buscarTransaccionPorCategoria(categoria);
    }
}