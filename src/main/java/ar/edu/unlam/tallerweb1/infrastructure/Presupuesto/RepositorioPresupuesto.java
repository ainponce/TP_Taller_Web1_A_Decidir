package ar.edu.unlam.tallerweb1.infrastructure.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public interface RepositorioPresupuesto {

    Presupuesto buscarPresupuestoPorMoneda(Moneda moneda);

    void guardar(Presupuesto presupuesto);

    List<Presupuesto> buscarPorFecha(String fechaDesde, String fechaHasta);

    void modificar(Presupuesto presupuesto);

    void modificarMonto(double montoNuevo);

    Presupuesto buscarPresupuestoPorId(Long id);

    public Presupuesto buscarPresupuestoPorCategoria(Categoria cat);

    List<Presupuesto> listarPresupuesto();


    Presupuesto buscarPresupuestoPorIdParaEliminar(Long id);

    void eliminarTransaccion(Presupuesto presupuestoAEliminar);

    <E> List<E> listarTransaccion();
}
