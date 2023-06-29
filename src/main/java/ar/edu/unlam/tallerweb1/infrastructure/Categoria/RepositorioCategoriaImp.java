package ar.edu.unlam.tallerweb1.infrastructure.Categoria;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("repositorioCategoria")
@Transactional
public class RepositorioCategoriaImp implements RepositorioCategoria {
    private final SessionFactory sessionFactory;
    private RepositorioPresupuesto repositorioPresupuesto;
    private RepositorioTransaccion repositorioTransaccion;

    @Autowired
    public RepositorioCategoriaImp(SessionFactory sessionFactory,RepositorioPresupuesto repositorioPresupuesto, RepositorioTransaccion repositorioTransaccion){
        this.sessionFactory = sessionFactory;
        this.repositorioPresupuesto=repositorioPresupuesto;
        this.repositorioTransaccion=repositorioTransaccion;
    }

    @Override
    public List<Categoria> listarCategorias() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Categoria>) session.createCriteria(Categoria.class).list();
    }



        @Override
    public Categoria traerCategoriaPorId(long id){
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Categoria.class, id);

    }

    @Override
    public void crearCategoria(Categoria categoria) {
        sessionFactory.getCurrentSession().save(categoria);
    }
}
