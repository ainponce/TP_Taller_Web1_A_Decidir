package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
    public Boolean establecerPresupuesto(Double monto, LocalDate fechaDesde, LocalDate fechaHasta, Categoria categoria) {
        Boolean seRegistro = false;
        Presupuesto presupuesto = repositorioPresupuesto.buscarPresupuestoPorCategoria(categoria);
        if(rangoDeFechaPresupuestoNoDisponible(presupuesto, categoria, fechaDesde, fechaHasta)){
            throw new PresupuestoExistenteEnEseRangoDeFechas();
        }
            else {
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

    private Boolean rangoDeFechaPresupuestoNoDisponible(Presupuesto presupuesto, Categoria categoria, LocalDate fechaDesde, LocalDate fechaHasta) {
       boolean variable= false;
        if(presupuesto!=null && presupuesto.getCategoria().getId().equals(categoria.getId())){
            if((fechaDesde.isBefore(presupuesto.getFechaDesde()) || fechaHasta.isAfter(presupuesto.getFechaHasta()))){
                variable= true;
            }
        }
        return variable;
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
           // throw new ElPresupuestoEsNulo();
        }
        return montoPresupuesto;
    }

    @Override
    public Presupuesto buscarPresupuestoPorId(long idPresupuesto) {
        return repositorioPresupuesto.buscarPresupuestoPorId(idPresupuesto);
    }

    @Override
    public void editarPresupuesto(long id, double montoPresupuesto, LocalDate fechaDesde, LocalDate fechaHasta, Categoria categoria) {
        List <Presupuesto> listaPresupuestos= repositorioPresupuesto.listarPresupuesto();
        Presupuesto p = repositorioPresupuesto.buscarPresupuestoPorId(id);
        boolean categoriaDelPresupuesto = false;

            for (Presupuesto presupuesto : listaPresupuestos) {
                if (presupuesto.getCategoria().getId().equals(categoria.getId())) {
                    categoriaDelPresupuesto = true;
                    break;  // Si encuentras una categoría igual, sales del bucle
                }
            }
            if(rangoDeFechaPresupuestoNoDisponible(p, categoria, fechaDesde, fechaHasta)){
            throw new PresupuestoExistenteEnEseRangoDeFechas();}
            else {
                if (categoriaDelPresupuesto && montoPresupuesto >= 0) {
                    Presupuesto presupuestoExistente = repositorioPresupuesto.buscarPresupuestoPorId(id);
                    presupuestoExistente.setMontoPresupuesto(montoPresupuesto);
                    presupuestoExistente.setFechaDesde(fechaDesde);
                    presupuestoExistente.setFechaHasta(fechaHasta);
                    repositorioPresupuesto.modificar(presupuestoExistente);
                }else {
                    throw new MontoMenorACero();  // Lanzas la excepción si el monto es menor a cero
                }
            }
    }

    @Override
    public Presupuesto buscarPresupuestoPorIdParaEliminar(Long id) {
        return repositorioPresupuesto.buscarPresupuestoPorIdParaEliminar(id);
    }

    @Override
    public void eliminarPresupuesto(Presupuesto presupuestoAEliminar) {
        repositorioPresupuesto.eliminarTransaccion(presupuestoAEliminar);
        repositorioPresupuesto.listarTransaccion().remove(presupuestoAEliminar);
    }

    @Override
    public Presupuesto buscarPresupuestoPorCategoria(Categoria cat){
        return repositorioPresupuesto.buscarPresupuestoPorCategoria(cat);
    }



}
