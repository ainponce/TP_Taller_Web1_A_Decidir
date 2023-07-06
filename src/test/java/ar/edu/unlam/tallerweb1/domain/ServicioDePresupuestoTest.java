package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.Categoria.ControladorDeCategoria;
import ar.edu.unlam.tallerweb1.delivery.Presupuesto.ControladorDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoriaImpl;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.*;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoriaImp;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioDePresupuestoTest {

    private ServicioDePresupuesto servicePresupuesto;

    private RepositorioPresupuesto repoPresupuesto;
    private RepositorioCategoria repositorioCategoria;
    private ServicioDeCategoria serviceCategoria;
    private ControladorDeCategoria controladorDeCategoria;
    private ModelAndView model;
    @Before
    public void init() {
        serviceCategoria = mock(ServicioDeCategoria.class);
        repoPresupuesto = mock(RepositorioPresupuesto.class);
        repositorioCategoria = mock(RepositorioCategoria.class);
        model= mock(ModelAndView.class);
        servicePresupuesto = new ServicioDePresupuestoImpl(repoPresupuesto, repositorioCategoria);

    }
    @Test (expected = MontoMenorACero.class)
    public void queLanceUnaExcepcionSiElMontoDelPresupuestoEsMenorACero(){
        Presupuesto presupuesto = dadoQueExisteUnPresupuesto();
        queLanceUnaExcepcionPorMontoMenorACero(presupuesto);
    }
    @Test (expected = PresupuestoExistenteEnEseRangoDeFechas.class)
    public void queLanceUnaExcepcionSiSequiereCrearUnPresupuestoDeunaCategoriaEnUnRangoDeFechasExistente(){
        Presupuesto presupuesto = dadoQueExisteUnPresupuestoCorrecto();
        Presupuesto presupuesto1 = dadoQueExisteUnPresupuestoRepetido();
       // queAgregueUnPresupuesto(presupuesto);
        queLanceUnaExcpecionPorPresupuestoExistenteEnEseRango(presupuesto1, presupuesto);

    }

    private void queAgregueUnPresupuesto(Presupuesto presupuesto) {
      when(repoPresupuesto.guardar(presupuesto)).thenReturn(true);
    }

    private void queLanceUnaExcpecionPorPresupuestoExistenteEnEseRango(Presupuesto presupuesto1, Presupuesto presupuesto) {
        when(servicePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria())).thenReturn(true);
        when(servicePresupuesto.establecerPresupuesto(presupuesto1.getMontoPresupuesto(), presupuesto1.getFechaDesde(), presupuesto1.getFechaHasta(), presupuesto1.getCategoria())).thenThrow(PresupuestoExistenteEnEseRangoDeFechas.class);
    }

    private Presupuesto dadoQueExisteUnPresupuestoCorrecto() {
        Presupuesto presupuesto = new Presupuesto(12.0, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 04, 30), new Categoria("servicios"));
        return presupuesto;
    }

    private Presupuesto dadoQueExisteUnPresupuestoRepetido() {
        Presupuesto presupuesto = new Presupuesto(12.0, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 04, 30), new Categoria("servicios"));
        return presupuesto;
    }

    private void queLanceUnaExcepcionPorMontoMenorACero(Presupuesto presupuesto) {
        when(servicePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria())).thenThrow(MontoMenorACero.class);
    }

    private Presupuesto dadoQueExisteUnPresupuesto() {Presupuesto presupuesto = new Presupuesto(-12.0, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 04, 30), new Categoria("servicios"));
    return presupuesto;
    }


    @Test (expected = CategoriaEnUso.class)
    public void queLanceUnaExcpecionSiLaCategoriaEstaEnUso(){
        Categoria cat = repositorioCategoria.traerCategoriaPorId(2);
        servicePresupuesto.establecerPresupuesto(122.00, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 04, 30), cat);
    }


}
