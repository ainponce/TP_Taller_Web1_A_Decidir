package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioDePresupuestoImpl implements ServicioDePresupuesto {

    private final RepositorioPresupuesto repositorioPresupuesto;
    private final RepositorioCategoria repositorioCategoria;

    @Autowired
    public ServicioDePresupuestoImpl(RepositorioPresupuesto servicioPresupuestoDao, RepositorioCategoria repositorioCategoria) {
        this.repositorioPresupuesto = servicioPresupuestoDao;
        this.repositorioCategoria=repositorioCategoria;
    }


    @Override
    public Boolean establecerPresupuesto(Double monto, String fechaDesde, String fechaHasta, Categoria categoria) {
        Boolean seRegistro = false;
        List <Presupuesto> validacionDeCategoria= repositorioPresupuesto.listarPresupuesto();
        if (monto > 0){
            Presupuesto presupuesto = new Presupuesto(monto, fechaDesde, fechaHasta, categoria);
            repositorioPresupuesto.guardar(presupuesto);
            seRegistro = true;
        }else{
            throw new MontoMenorACero();
        }

        return seRegistro;
    }

    @Override
    public List<Presupuesto> listarPresupuestos() {
        return repositorioPresupuesto.listarPresupuesto();
    }
    @Override
    public List<Categoria> listarCategorias() {
        return repositorioCategoria.listarCategoriaParaPresupuestos();
    }

    @Override
    public Double buscarMontoPresupuestoPorCategoria(Categoria cat) {
        Double montoPresupuesto = 0.0;
        Presupuesto presupuesto = repositorioPresupuesto.buscarPresupuestoPorCategoria(cat);
        if(presupuesto!=null){
            montoPresupuesto=presupuesto.getMontoPresupuesto();
        }else{
            throw new ElPresupuestoEsNulo();
        }
        return montoPresupuesto;
    }
    @Override
    public Presupuesto buscarPresupuestoPorCategoria(Categoria cat){
        return repositorioPresupuesto.buscarPresupuestoPorCategoria(cat);
    }



}
