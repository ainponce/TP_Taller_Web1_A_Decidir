package ar.edu.unlam.tallerweb1.infrastructure.Moneda;

import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("RepositorioMoneda")
@Transactional
public class RepositorioMonedaImp  implements RepositorioMoneda{

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioMonedaImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Moneda> listarMonedas() {
        final Session session = sessionFactory.getCurrentSession();

        return (List<Moneda>) session.createCriteria(Moneda.class).list();
    }

    @Override
    public Moneda buscarMonedaPorId(long id) {
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Moneda.class, id);
    }

}
