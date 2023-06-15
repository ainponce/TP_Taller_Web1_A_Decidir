package ar.edu.unlam.tallerweb1.domain.Moneda;

import java.util.List;

public interface ServicioDeMoneda {

    public List<Moneda> listarMonedas();

    public Moneda buscarMonedaPorId(long id);
}
