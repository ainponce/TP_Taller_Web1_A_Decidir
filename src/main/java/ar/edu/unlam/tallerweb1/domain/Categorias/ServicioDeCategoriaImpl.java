package ar.edu.unlam.tallerweb1.domain.Categorias;

import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioDeCategoriaImpl implements ServicioDeCategoria {
    private final RepositorioCategoria repositorioCategoria;

    @Autowired
    public ServicioDeCategoriaImpl( RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria=repositorioCategoria;
    }


    @Override
    public List<Categoria> listarCategorias() {
        return repositorioCategoria.listarCategorias();
    }

    @Override
    public List<Categoria> listarCategoriaParaPresupuestos() {
        return repositorioCategoria.listarCategorias();
    }

    @Override
    public Categoria buscarCategoriaPorId(long id){
        return repositorioCategoria.traerCategoriaPorId(id);
    }





}
