package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;

import java.util.List;

public interface ServicioDePresupuesto {


    public Boolean establecerPresupuesto(Double monto, String fechaDesde, String fechaHasta, Categoria categoria);

    List<Presupuesto> listarPresupuestos();
    public List<Categoria> listarCategorias();


    Double buscarMontoPresupuestoPorCategoria(Categoria cat);
}
