package ar.edu.unlam.tallerweb1.infrastructure.Categoria;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

import java.util.List;

public interface RepositorioCategoria {

    public List<Categoria> listarCategoriaPorTransaccion();

    public Categoria traerCategoriaPorId(long id);


    public List<Categoria> listarCategoriaParaPresupuestos();

    //List<Categoria> traerListaDeCategoriasPorId(Long );
}
