package ar.edu.unlam.tallerweb1.infrastructure.Categoria;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("repositorioCategoria")
@Transactional
public class RepositorioCategoriaImp implements RepositorioCategoria{
    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioCategoriaImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Categoria> listarCategoria() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Categoria>) session.createCriteria(Categoria.class).list();
    }
}
