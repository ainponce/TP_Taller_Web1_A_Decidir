package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioCategoriaTest extends SpringTest {
    @Autowired
    private RepositorioCategoria repo;

    @Autowired
    private ServicioDeTransaccion service;

    @Test
    @Transactional @Rollback
    public void queTraigaLaListaDeCategorias() {
        List<Categoria> categorias = listoCategorias();
        QueSeanLaMismaCantidad(categorias);
    }

    private void QueSeanLaMismaCantidad(List<Categoria> categorias) {
        assertThat(categorias.size()).isEqualTo(2);
    }

    private List<Categoria> listoCategorias() {
        return repo.listarCategoriaParaPresupuestos();
    }
}
