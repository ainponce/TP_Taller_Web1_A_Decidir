package ar.edu.unlam.tallerweb1.infrastructure.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("repositorioPresupuesto")
public class RepositorioPresupuestoImpl implements RepositorioPresupuesto {

    private SessionFactory sessionFactory;

    public RepositorioPresupuestoImpl(){}

    @Autowired
    public RepositorioPresupuestoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Presupuesto buscarPresupuestoPorMoneda(Moneda moneda) {
        // Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
        // de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
        // uniqueResult da error si se encuentran mas de un resultado en la busqueda.
        return (Presupuesto) this.sessionFactory.getCurrentSession().createCriteria(Presupuesto.class)
                .add(Restrictions.eq("moneda", moneda))
                .list();

    }

    @Override
    public Boolean guardar(Presupuesto presupuesto) {
        sessionFactory.getCurrentSession().save(presupuesto);
        return true;
    }

    @Override

    public List<Presupuesto> buscarPorFecha(LocalDate fechaDesde, LocalDate fechaHasta) {
        return  this.sessionFactory.getCurrentSession().createCriteria(Presupuesto.class)
                .add(Restrictions.eq("fechaDesde", fechaDesde))
                .add(Restrictions.eq("fechaHasta", fechaHasta))
                .list();

    }

    @Override
    public void modificar(Presupuesto presupuesto) {
        sessionFactory.getCurrentSession().update(presupuesto);
    }

    @Override
    public void modificarMonto(double montoNuevo) {
        sessionFactory.getCurrentSession().update(montoNuevo);
    }

    @Override
    public Presupuesto buscarPresupuestoPorId(Long id) {
        return this.sessionFactory.getCurrentSession().get(Presupuesto.class, id);
    }
    @Override
    public Presupuesto buscarPresupuestoPorCategoria(Categoria categoria) {
        final Session session = sessionFactory.getCurrentSession();
        return (Presupuesto) session.createCriteria(Presupuesto.class)
                .add(Restrictions.eq("categoria", categoria))
                .uniqueResult();
    }

    @Override
    public List<Presupuesto> listarPresupuesto() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Presupuesto>) session.createCriteria(Presupuesto.class).list();
    }

    @Override
    public Presupuesto buscarPresupuestoPorIdParaEliminar(Long id) {
        return this.sessionFactory.getCurrentSession().get(Presupuesto.class, id);
    }

    @Override
    public void eliminarTransaccion(Presupuesto presupuestoAEliminar) {
        sessionFactory.getCurrentSession().delete(presupuestoAEliminar);
    }

    @Override
    public List<Presupuesto> listarTransaccion() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Presupuesto>) session.createCriteria(Presupuesto.class).list();
    }

}
