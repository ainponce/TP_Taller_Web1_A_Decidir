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

    private void queLanceUnaExcepcionPorMontoMenorACero(Presupuesto presupuesto) {
        when(servicePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getCategoria())).thenThrow(MontoMenorACero.class);
    }

    private Presupuesto dadoQueExisteUnPresupuesto() {Presupuesto presupuesto = new Presupuesto(-12.0, "12/04/2023", "30/04/2023", new Categoria("servicios"));
    return presupuesto;
    }


    @Test (expected = CategoriaEnUso.class)
    public void queLanceUnaExcpecionSiLaCategoriaEstaEnUso(){
        Categoria cat = repositorioCategoria.traerCategoriaPorId(2);
        servicePresupuesto.establecerPresupuesto(122.00, "15-06-2023", "30-06-2023", cat);
    }




}
