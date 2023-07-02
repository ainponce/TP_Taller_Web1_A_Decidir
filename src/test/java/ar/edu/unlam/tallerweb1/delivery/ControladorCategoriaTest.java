package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.Categoria.ControladorDeCategoria;
import ar.edu.unlam.tallerweb1.delivery.Presupuesto.ControladorDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorCategoriaTest {

    private ServicioDeCategoria servicioDeCategoria;
    private ControladorDeCategoria controladorDeCategoria;
    private ModelAndView model;

    @Before
    public void init() {
        servicioDeCategoria = mock(ServicioDeCategoria.class);
        controladorDeCategoria = new ControladorDeCategoria(this.servicioDeCategoria);
        model= mock(ModelAndView.class);
    }
    @Test
    public void dadoQueTengoUnaCategoriaValidaMeDevuelveUnaCategoria(){
        Categoria cat = dadoQueTengoUnaCategoriaValida();
        ModelAndView vista = cuandoQuieroValidarLaCategoria(cat);
        entoncesMeDevuelveLaVista(vista);
    }

    private void entoncesMeDevuelveLaVista(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("crearCategoria");
    }

    private ModelAndView cuandoQuieroValidarLaCategoria(Categoria cat) {
        when(servicioDeCategoria.regsitrarCategoria(cat.getNombre())).thenReturn(true);
        when(model.getViewName()).thenReturn("crearCategoria");
        return controladorDeCategoria.registrarCategoria(cat.getNombre());
    }

    private Categoria dadoQueTengoUnaCategoriaValida() {
        String nombre = "compras";
        Boolean estaActiva = true;
        Categoria cat = new Categoria();
        cat.setNombre(nombre);
        cat.setEstaActiva(estaActiva);
        return cat;
    }
}
