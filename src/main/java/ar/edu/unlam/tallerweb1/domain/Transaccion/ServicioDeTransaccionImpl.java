package ar.edu.unlam.tallerweb1.domain.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("servicioDeTransaccion")
@Transactional
public class ServicioDeTransaccionImpl implements ServicioDeTransaccion {
    private RepositorioTransaccion servicioTransaccionDao;

    @Autowired
    public ServicioDeTransaccionImpl(RepositorioTransaccion servicioTransaccionDaoDao){
        this.servicioTransaccionDao = servicioTransaccionDao;
    }
    public ServicioDeTransaccionImpl(){
    }


    @Override
    public Boolean registrarTransaccion(Categoria categoria, Concepto concepto, Double monto, String detalle, String fecha, Moneda moneda) {
        Boolean seRegistro = false;

        if (monto > 0 && !categoria.getNombreCategoria().isBlank() && !concepto.name().isBlank() && !fecha.isBlank() && !moneda.name().isBlank()) {
            Transaccion transaccion = new Transaccion(categoria,concepto, monto, detalle, moneda);
            servicioTransaccionDao.guardar(transaccion);
            seRegistro = true;
            return null;
    }



    @Override
    public Transaccion buscarTransaccionPorDetalle(String detalle) {
        return null;
    }
}