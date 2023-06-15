package ar.edu.unlam.tallerweb1.infrastructure.Moneda;

import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import java.util.List;

public interface RepositorioMoneda {

    public List<Moneda> listarMonedas();

    public Moneda buscarMonedaPorId(long id);
}
