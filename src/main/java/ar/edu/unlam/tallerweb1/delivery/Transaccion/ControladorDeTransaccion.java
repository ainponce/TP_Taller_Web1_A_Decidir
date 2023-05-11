package ar.edu.unlam.tallerweb1.delivery.Transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccionImpl;
import org.springframework.stereotype.Controller;

public class ControladorDeTransaccion {
    private ServicioDeTransaccion servicioDeTransaccion;

    @Autowired
    public ControladorDeTransaccion(ServicioDeTransaccion servicioDeTransaccion){

    }
}
