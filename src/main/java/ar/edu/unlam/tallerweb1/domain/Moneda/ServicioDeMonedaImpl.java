package ar.edu.unlam.tallerweb1.domain.Moneda;

import ar.edu.unlam.tallerweb1.infrastructure.Moneda.RepositorioMoneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ServicioDeMonedaImpl implements ServicioDeMoneda{

    private final RepositorioMoneda repositorioMoneda;
    @Autowired
    public ServicioDeMonedaImpl(RepositorioMoneda repositorioMoneda) {
        this.repositorioMoneda = repositorioMoneda;
    }

    @Override
    public List<Moneda> listarMonedas() {
        return repositorioMoneda.listarMonedas();
    }

    @Override
    public Moneda buscarMonedaPorId(long id) {
        return repositorioMoneda.buscarMonedaPorId(id);
    }
}
