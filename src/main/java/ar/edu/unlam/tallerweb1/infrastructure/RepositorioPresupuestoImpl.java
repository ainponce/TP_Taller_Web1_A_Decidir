package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.delivery.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.RepositorioPresupuesto;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        this.sessionFactory.getCurrentSession().createCriteria(Presupuesto.class)
                .add(Restrictions.eq("moneda", moneda))
                .list();
                return null;
    }

    @Override
    public void guardar(Presupuesto presupuesto) {
        sessionFactory.getCurrentSession().save(presupuesto);
    }

    @Override
    public Presupuesto buscarPorFecha(String fechaDesde, String fechaHasta) {
        this.sessionFactory.getCurrentSession().createCriteria(Presupuesto.class)
                .add(Restrictions.eq("fechaDesde", fechaDesde))
                .add(Restrictions.eq("fechaHasta", fechaHasta))
                .list();
        return null;
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
}
