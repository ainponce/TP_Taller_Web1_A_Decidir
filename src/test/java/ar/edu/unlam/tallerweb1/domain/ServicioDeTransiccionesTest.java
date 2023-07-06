
package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
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
        service = new ServicioDeTransaccionImpl(repositorioTransaccion, repositorioCategoria);
    }

    @Test (expected = MontoMenorACero.class)
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

    @Test (expected = ElMontoEstaPorLlegarASuLimite.class)
    public void queLanceUnaExcepcionSiElMontoDelPresupestoEstaPorLlegarASuLimite(){
       /* Double montoPresu=0.0;
        Double monto=0.0;
        List<Transaccion> t = dadoQueExisteUnaListaDeTransacciones();
        monto=t.get(0).getMonto()+t.get(1).getMonto();
        montoPresu= servicePresupuesto.listarPresupuestos().get(0).getMontoPresupuesto();
        queNoSePuedaRegistrarPorPresupuesto(t, montoPresu, monto);*/
    }





}

