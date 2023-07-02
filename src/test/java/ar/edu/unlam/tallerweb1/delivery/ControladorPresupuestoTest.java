
package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.Categoria.ControladorDeCategoria;
import ar.edu.unlam.tallerweb1.delivery.Presupuesto.ControladorDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mock.*;

public class ControladorPresupuestoTest {
    private ServicioDePresupuesto servicioDePresupuesto;
    private ControladorDePresupuesto controladorDePresupuesto;
    private ServicioDeCategoria servicioDeCategoria;
    private ControladorDeCategoria controladorDeCategoria;
    private ModelAndView model;

    @Before
    public void init() {
        servicioDePresupuesto = mock(ServicioDePresupuesto.class);
        servicioDeCategoria = mock(ServicioDeCategoria.class);
        controladorDeCategoria = mock(ControladorDeCategoria.class);
        model= mock(ModelAndView.class);
        controladorDePresupuesto = new ControladorDePresupuesto(this.servicioDePresupuesto, this.servicioDeCategoria);
    }

    @Test
    public void dadoQueTengoDatosDeUnPresupuestoValidosQueMeCreeUnPresupuesto() {
        Presupuesto presupuesto = dadoQueTengoDatosDePresupuestoValidos();
        ModelAndView vista = cuandoquieroValidarElPresupuesto(presupuesto);
        entoncesMeDevuelveLaVistaCorrecta(vista);
    }


    private Presupuesto dadoQueTengoDatosDePresupuestoValidos() {
        Presupuesto presupuesto = new Presupuesto();
        Double montoPresupuesto = 1200.0;
        String fechaDesde = "12/04/2023";
        String fechaHasta = "30/04/2023";
        Categoria cat = new Categoria("ocio");
        presupuesto.setMontoPresupuesto(montoPresupuesto);
        presupuesto.setFechaDesde(fechaDesde);
        presupuesto.setFechaHasta(fechaHasta);
        presupuesto.setCategoria(cat);
        presupuesto.getCategoria().setId(8L);
        return presupuesto;
    }


    //Dado
    private ModelAndView cuandoquieroValidarElPresupuesto(Presupuesto presupuesto) {
        when(servicioDeCategoria.buscarCategoriaPorId(presupuesto.getCategoria().getId())).thenReturn(presupuesto.getCategoria());
        when(servicioDePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria())).thenReturn(true);
        when(model.getViewName()).thenReturn("establecerPresupuesto");
        return controladorDePresupuesto.registrarUnPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria().getId());
    }

    //Entonces
    private static void entoncesMeDevuelveLaVistaCorrecta(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("establecerPresupuesto");
    }





}

