package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.delivery.Moneda;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface RepositorioPresupuesto {

    Presupuesto buscarPresupuestoPorMoneda(Moneda moneda);

    void guardar(Presupuesto presupuesto);

    Presupuesto buscarPorFecha(String fechaDesde, String fechaHasta);

    void modificar(Presupuesto presupuesto);

    void modificarMonto(double montoNuevo);

    Presupuesto buscarPresupuestoPorId(Long id);

}
