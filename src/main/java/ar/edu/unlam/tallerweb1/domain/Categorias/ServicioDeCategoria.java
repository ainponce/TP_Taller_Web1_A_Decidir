package ar.edu.unlam.tallerweb1.domain.Categorias;

import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;

import java.util.List;

public interface ServicioDeCategoria {

    public List<Categoria> listarCategorias();

    public Categoria buscarCategoriaPorId(long id);

    public List<Categoria> listarCategoriaParaPresupuestos();

    public Boolean regsitrarCategoria(String nombre);

    public Categoria buscarCategoriaPorNombre(String nombre);

   // List<Categoria> listarCategoriasPorID(Long id);
}
