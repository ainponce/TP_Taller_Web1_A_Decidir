package ar.edu.unlam.tallerweb1.infrastructure.Transaccion;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import org.springframework.transaction.annotation.Transactional;

>>>>>>> Shushu
import java.util.List;

@Repository("repositorioTransaccion")
@Transactional
public class RepositorioTransaccionImpl implements RepositorioTransaccion {
    private final SessionFactory sessionFactory;


    @Autowired
    public RepositorioTransaccionImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override

    public List<Transaccion> buscarTransaccionPorDetalle(String detalle) {
        // Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
        // de busqueda de Transaccion donde el detalle sea igual al del objeto recibido como parametro
<<<<<<< HEAD
        return (Transaccion) this.sessionFactory.getCurrentSession().createCriteria(Transaccion.class)
                .add(Restrictions.eq("detalle", detalle))
                .uniqueResult();

=======
        final Session session = sessionFactory.getCurrentSession();
        return (List<Transaccion>) session.createCriteria(Transaccion.class)
                .add(Restrictions.eq("detalle", detalle))
                .list();
>>>>>>> Shushu
    }

    @Override
    public void guardarTransaccion(Transaccion transaccion) {
        sessionFactory.getCurrentSession().save(transaccion);
    }

    @Override
    public void modificar(Transaccion transaccion) {
        sessionFactory.getCurrentSession().update(transaccion);
    }

    @Override
    public void eliminarTransaccion(Transaccion transaccion) {
        sessionFactory.getCurrentSession().delete(transaccion);
    }



    @Override
    public List<Transaccion> listarTransaccion(){
        final Session session = sessionFactory.getCurrentSession();
        return (List<Transaccion>) session.createCriteria(Transaccion.class).list();
    }

    @Override
    public List<Transaccion> buscarTransaccionPorCategoria(Categoria categoria) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Transaccion>) session.createCriteria(Transaccion.class)
                .add(Restrictions.eq("categoria", categoria))
                .list();
    }

    @Override
    public List<Transaccion> buscarTransaccionPorConcepto(Concepto concepto) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Transaccion>) session.createCriteria(Transaccion.class)
                .add(Restrictions.eq("concepto", concepto))
                .list();
}

    @Override
    public Double convertirMontoTransaccion(Double monto) {
        final Session session = sessionFactory.getCurrentSession();
        return null;
    }


    @Override
    public Transaccion buscarTransaccionPorIdParaEliminar(Long id) {
        return this.sessionFactory.getCurrentSession().get(Transaccion.class, id);
    }


}

