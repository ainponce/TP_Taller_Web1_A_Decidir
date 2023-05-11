package ar.edu.unlam.tallerweb1.domain.usuarios;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioTransaccion")
public class RepositorioTransaccionImpl implements RepositorioTransaccion{


    @Override
    public void guardarTransaccion(Transaccion transaccion) {

    }

    @Override
    public void modificar(Transaccion transaccion) {

    }
}
