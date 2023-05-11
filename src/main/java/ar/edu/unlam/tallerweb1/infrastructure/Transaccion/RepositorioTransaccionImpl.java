package ar.edu.unlam.tallerweb1.infrastructure.Transaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.springframework.stereotype.Repository;

@Repository("repositorioTransaccion")
public class RepositorioTransaccionImpl implements RepositorioTransaccion {


    @Override
    public void guardarTransaccion(Transaccion transaccion) {

    }

    @Override
    public void modificar(Transaccion transaccion) {

    }
}
