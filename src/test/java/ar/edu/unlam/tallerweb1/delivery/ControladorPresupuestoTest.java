
package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.Categoria.ControladorDeCategoria;
import ar.edu.unlam.tallerweb1.delivery.Presupuesto.ControladorDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;

import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;

import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import org.junit.Before;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;

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
        model = mock(ModelAndView.class);
        controladorDePresupuesto = new ControladorDePresupuesto(this.servicioDePresupuesto, this.servicioDeCategoria);
    }

    @Test
        public void dadoQueTengoDatosDeUnPresupuestoValidosQueMeCreeUnPresupuesto() {
            Presupuesto presupuesto = dadoQueTengoDatosDePresupuestoValidos();
            ModelAndView vista = cuandoquieroValidarElPresupuesto(presupuesto);
            entoncesMeDevuelveLaVistaCorrecta(vista);
        }

    @Test
    public void dadoQueTengoDatosDeUnPresupuestoValidosQueMeCreeUnPresupuestoYQuieroEditarlo() {
        Presupuesto presupuesto = dadoQueTengoDatosDePresupuestoValidos();
        Presupuesto presupuestoNuevo = dadoQueTengoDatosDePresupuestoNuevosValidos();
        ModelAndView vista = cuandoquieroValidarElPresupuestoEditado(presupuesto,presupuestoNuevo);
        entoncesMeDevuelveLaVistaCorrectaDelPresupuestoEditado(vista);
    }




    private Presupuesto dadoQueTengoDatosDePresupuestoNuevosValidos() {
        Presupuesto presupuesto = new Presupuesto();
        Double montoPresupuesto = 2200.0;
        LocalDate fechaDesde = LocalDate.of(2023, 4, 01);
        LocalDate fechaHasta = LocalDate.of(2023, 4, 30);
        Categoria cat = new Categoria("ocio");
        presupuesto.setId(1L);
        presupuesto.setMontoPresupuesto(montoPresupuesto);
        presupuesto.setFechaDesde(fechaDesde);
        presupuesto.setFechaHasta(fechaHasta);
        presupuesto.setCategoria(cat);
        presupuesto.getCategoria().setId(8L);

        return presupuesto;
    }


    private Presupuesto dadoQueTengoDatosDePresupuestoValidos () {
            Presupuesto presupuesto = new Presupuesto();
            Double montoPresupuesto = 1200.0;
        LocalDate fechaDesde = LocalDate.of(2023, 4, 01);
        LocalDate fechaHasta = LocalDate.of(2023, 4, 30);
            Categoria cat = new Categoria("ocio");
            presupuesto.setId(1L);
            presupuesto.setMontoPresupuesto(montoPresupuesto);
            presupuesto.setFechaDesde(fechaDesde);
            presupuesto.setFechaHasta(fechaHasta);
            presupuesto.setCategoria(cat);
            presupuesto.getCategoria().setId(8L);
            return presupuesto;
        }


        //Dado
        private ModelAndView cuandoquieroValidarElPresupuesto (Presupuesto presupuesto){
            when(servicioDeCategoria.buscarCategoriaPorId(presupuesto.getCategoria().getId())).thenReturn(presupuesto.getCategoria());
            when(servicioDePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria())).thenReturn(true);
            when(model.getViewName()).thenReturn("redirect:/establecerPresupuesto");
            return controladorDePresupuesto.registrarUnPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria().getId());
        }

    private ModelAndView cuandoquieroValidarElPresupuestoEditado(Presupuesto presupuesto, Presupuesto presupuestoNuevo) {
        when(servicioDeCategoria.buscarCategoriaPorId(presupuesto.getCategoria().getId())).thenReturn(presupuesto.getCategoria());
        when(servicioDePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria())).thenReturn(true);
        return controladorDePresupuesto.editarUnPresupuesto(presupuestoNuevo.getId(),presupuestoNuevo.getMontoPresupuesto(),presupuestoNuevo.getFechaDesde(),presupuestoNuevo.getFechaHasta(),presupuestoNuevo.getCategoria().getId());
    }

        //Entonces
        private static void entoncesMeDevuelveLaVistaCorrecta (ModelAndView vista){
            assertThat(vista.getViewName()).isEqualTo("redirect:/establecerPresupuesto");

        }

    private void entoncesMeDevuelveLaVistaCorrectaDelPresupuestoEditado(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("redirect:/establecerPresupuesto");
    }
    }




