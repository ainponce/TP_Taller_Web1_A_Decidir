package ar.edu.unlam.tallerweb1.infrastructure.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

public interface RepositorioTransaccion {

    //buscarTransaccion - por qué criterio?
    void guardarTransaccion(Transaccion transaccion);
    void modificar(Transaccion transaccion);

}
