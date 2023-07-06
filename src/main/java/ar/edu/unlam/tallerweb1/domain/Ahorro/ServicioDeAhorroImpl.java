package ar.edu.unlam.tallerweb1.domain.Ahorro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class ServicioDeAhorroImpl implements ServicioDeAhorro {


    @Override
    public Double calcularAhorroPorDia(double montoPresupuesto, double montoAhorro) {
        LocalDate fechaActual = LocalDate.now();
        int cantidadDeDiasDelMes = fechaActual.lengthOfMonth();
        return montoPresupuesto - montoAhorro / cantidadDeDiasDelMes;
    }
}
