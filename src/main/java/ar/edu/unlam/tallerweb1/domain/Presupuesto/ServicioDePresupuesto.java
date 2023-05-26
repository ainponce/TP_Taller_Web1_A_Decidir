package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import java.util.List;

public interface ServicioDePresupuesto {


    public Boolean establecerPresupuesto(Double monto, String fechaDesde, String fechaHasta, Moneda moneda, Categoria categoria);

    List<Presupuesto> listarPresupuestos();
}
