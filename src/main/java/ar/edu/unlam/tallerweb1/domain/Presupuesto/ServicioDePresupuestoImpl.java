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
        boolean categoriaEnUso = false;

        for (Presupuesto presupuesto : validacionDeCategoria) {
            if (presupuesto.getCategoria().GetId().equals(categoria.GetId())) {
                categoriaEnUso = true;
                break;  // Si encuentras una categoría igual, sales del bucle
            }
        }

        if (categoriaEnUso) {
            throw new CategoriaEnUso();  // Lanzas la excepción si la categoría ya está en uso
        } else {
            if (monto > 0) {
                Presupuesto presupuestoNuevo = new Presupuesto(monto, fechaDesde, fechaHasta, categoria);
                repositorioPresupuesto.guardar(presupuestoNuevo);
                seRegistro = true;
            } else {
                throw new MontoMenorACero();  // Lanzas la excepción si el monto es menor a cero
            }
        }
        return seRegistro;
    }

    @Override
    public List<Presupuesto> listarPresupuestos() {
        return repositorioPresupuesto.listarPresupuesto();
    }
    @Override
    public List<Categoria> listarCategorias() {
        return repositorioCategoria.listarCategorias();
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
    public Presupuesto buscarPresupuestoPorId(long idPresupuesto) {
        return repositorioPresupuesto.buscarPresupuestoPorId(idPresupuesto);
    }

    @Override
    public void editarPresupuesto(long id, double montoPresupuesto, String fechaDesde, String fechaHasta, Categoria categoria) {
        List <Presupuesto> listaPresupuestos= repositorioPresupuesto.listarPresupuesto();
        boolean categoriaDelPresupuesto = false;

            for (Presupuesto presupuesto : listaPresupuestos) {
                if (presupuesto.getCategoria().GetId() == categoria.GetId()) {
                    categoriaDelPresupuesto = true;
                    break;  // Si encuentras una categoría igual, sales del bucle
                }
            }

            if (categoriaDelPresupuesto && montoPresupuesto <= 0) {
                Presupuesto presupuestoExistente = repositorioPresupuesto.buscarPresupuestoPorId(id);
                presupuestoExistente.setMontoPresupuesto(montoPresupuesto);
                presupuestoExistente.setFechaDesde(fechaDesde);
                presupuestoExistente.setFechaHasta(fechaHasta);
                repositorioPresupuesto.modificar(presupuestoExistente);
            }else {
                throw new MontoMenorACero();  // Lanzas la excepción si el monto es menor a cero
            }
    }

    @Override
    public Presupuesto buscarPresupuestoPorCategoria(Categoria cat){
        return repositorioPresupuesto.buscarPresupuestoPorCategoria(cat);
    }



}
