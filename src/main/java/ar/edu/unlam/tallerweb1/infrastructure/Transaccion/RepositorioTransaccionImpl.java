package ar.edu.unlam.tallerweb1.infrastructure.Transaccion;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioTransaccion")
public class RepositorioTransaccionImpl implements RepositorioTransaccion {
    private SessionFactory sessionFactory;

    public RepositorioTransaccionImpl(){};

    @Autowired
    public RepositorioTransaccionImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Transaccion buscarTransaccionPorDetalle(String detalle) {
        // Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
        // de busqueda de Transaccion donde el detalle sea igual al del objeto recibido como parametro
        return (Transaccion) this.sessionFactory.getCurrentSession().createCriteria(Transaccion.class)
                .add(Restrictions.eq("detalle", detalle))
                .uniqueResult();

    }

    @Override
    public void guardarTransaccion(Transaccion transaccion) {
        sessionFactory.getCurrentSession().save(transaccion);
    }

    @Override
    public void modificar(Transaccion transaccion) {
        sessionFactory.getCurrentSession().update(transaccion);
    }
}