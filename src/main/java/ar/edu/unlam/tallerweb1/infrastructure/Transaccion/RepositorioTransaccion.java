package ar.edu.unlam.tallerweb1.infrastructure.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

import java.util.List;

public interface RepositorioTransaccion {

    Transaccion buscarTransaccionPorDetalle(String detalle);
    void guardarTransaccion(Transaccion transaccion);
    void modificar(Transaccion transaccion);

}