package ar.edu.unlam.tallerweb1.domain.Ahorro;
import java.text.DecimalFormat;

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
        double resultado = (montoPresupuesto - montoAhorro) / cantidadDeDiasDelMes;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String resultadoFormateado = decimalFormat.format(resultado);
        resultadoFormateado = resultadoFormateado.replace(',', '.');


        return Double.parseDouble(resultadoFormateado);
    }

    @Override
    public double calcularAhorroPorSemana(double montoDelPresupuesto, double montoAhorro) {
        double resultado = (montoDelPresupuesto - montoAhorro) / 4;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String resultadoFormateado = decimalFormat.format(resultado);
        resultadoFormateado = resultadoFormateado.replace(',', '.');



        return Double.parseDouble(resultadoFormateado);
    }

}
