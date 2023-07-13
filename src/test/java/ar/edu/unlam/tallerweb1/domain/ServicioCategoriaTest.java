/*package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoriaImpl;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuestoImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccionImpl;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoriaImp;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccionImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class ServicioCategoriaTest {

    private RepositorioCategoria repositorioCategoria;
    private ServicioDeCategoria servicioDeCategoria;

    @Before
    public void init() {
        repositorioCategoria = mock(RepositorioCategoriaImp.class);
        servicioDeCategoria = new ServicioDeCategoriaImpl(repositorioCategoria);


    }

    @Test
    public void queSePuedaCrearUnaCategoria() {
        String nombreCategoria = dadoQueCreoLaCategoria();
        entoncesLaPuedoRegistrar(nombreCategoria);
    }

    private void entoncesLaPuedoRegistrar(String c) {
        when(servicioDeCategoria.regsitrarCategoria(c)).thenReturn(true);
    }

    private String dadoQueCreoLaCategoria() {
        Categoria cat = new Categoria("Salida");
        return cat.getNombre();
    }
}
*/