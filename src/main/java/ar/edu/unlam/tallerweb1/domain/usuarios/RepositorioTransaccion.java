package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

public interface RepositorioTransaccion {

    //buscarTransaccion
    void guardarTransaccion(Transaccion transaccion);
    void modificar(Transaccion transaccion);
    
}
