package ar.edu.unlam.tallerweb1.domain.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

import java.time.LocalDate;
import java.util.List;

public interface ServicioDePresupuesto {


    public Boolean establecerPresupuesto(Double monto, LocalDate fechaDesde, LocalDate fechaHasta, Categoria categoria);

    List<Presupuesto> listarPresupuestos();
    public List<Categoria> listarCategorias();
    public Presupuesto buscarPresupuestoPorCategoria(Categoria cat);


    Double buscarMontoPresupuestoPorCategoria(Categoria cat);

    Presupuesto buscarPresupuestoPorId(long idPresupuesto);

    void editarPresupuesto(long id, double montoPresupuesto, LocalDate fechaDesde, LocalDate fechaHasta, Categoria cat);

    Presupuesto buscarPresupuestoPorIdParaEliminar(Long id);

    void eliminarPresupuesto(Presupuesto presupuestoAEliminar);
}
