
package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuestoImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.*;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;

import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoriaImp;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccionImpl;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioDeTransiccionesTest{


    private RepositorioTransaccion repositorioTransaccion;
    private ServicioDeTransaccion service;
    private RepositorioCategoria repositorioCategoria;
    private ModelAndView model;
    @Before
    public void init() {
        repositorioTransaccion = mock(RepositorioTransaccion.class);
        repositorioCategoria = mock(RepositorioCategoria.class);
        model= mock(ModelAndView.class);
        service = new ServicioDeTransaccionImpl(repositorioTransaccion);
    }

    @Test
    public void queLanceUnaExcepcionSiElMontoDeLaTransaccionEsMenorACero(){
        queNoSePuedaRegistrarUnaTransaccionConMontoMenorACero();
    }
    @Test
    public void queSePuedaRegistrarUnaTransaccion(){
        Transaccion t = dadoQueExisteUnaTransaccion();
        queSePuedaGuardar(t);
    }
    @Test
    public void queTraigaUnaListaDeTransaccionesPorCategoria(){
        Transaccion t = dadoQueExisteUnaTransaccion();
        Categoria cat = t.getCategoria();
        queSePuedaBuscarPorCategoria(t, cat);
    }

    private void queSePuedaBuscarPorCategoria(Transaccion t, Categoria cat) {
        List<Transaccion> lista = repositorioTransaccion.listarTransaccion();
        lista.add(t);
        when(repositorioTransaccion.buscarTransaccionPorCategoria(cat)).thenReturn(lista);
        assertThat(lista.size()).isEqualTo(1);
    }

    private void queSePuedaGuardar(Transaccion t) {
        when(repositorioTransaccion.guardarTransaccion(t)).thenReturn(true);
    }

    private void queNoSePuedaRegistrarUnaTransaccionConMontoMenorACero() {
        Categoria cat = new Categoria("Servicios");
        cat.setId(1L);
        when(service.registrarTransaccion(-12.0, 1200.0, "caja", "01/04/2023", Concepto.Fijo, cat)).thenThrow(MontoMenorACero.class);
    }

    private Transaccion dadoQueExisteUnaTransaccion() {
        Categoria cat = new Categoria("Servicios");
        cat.setId(1L);
        Transaccion transaccion = new Transaccion(1200.0, "chipa", "01/04/2023", Concepto.Fijo, cat);
        return transaccion;
    }

}

