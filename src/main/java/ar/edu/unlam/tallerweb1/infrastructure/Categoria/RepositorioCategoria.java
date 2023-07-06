package ar.edu.unlam.tallerweb1.infrastructure.Categoria;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;

import java.util.List;

public interface RepositorioCategoria {

    public List<Categoria> listarCategorias();

    public Categoria traerCategoriaPorId(long id);

    public void crearCategoria(Categoria categoria);


    public Categoria traerCategoriaPorNombre(String nombre);
}
