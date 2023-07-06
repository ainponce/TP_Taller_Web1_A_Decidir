
package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuestoImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.*;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
<<<<<<< HEAD
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
=======
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoriaImp;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccionImpl;
import org.junit.Before;
import org.junit.Test;
>>>>>>> 89889376768752150dde3032e6dfc1755150c33a

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioDeTransiccionesTest{

<<<<<<< HEAD
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
=======

    private RepositorioTransaccion repo;

    private ServicioDeTransaccion service;

    private ServicioDePresupuesto servicePresupuesto;



    @Before
    public void init() {
        repo = mock(RepositorioTransaccionImpl.class);
        servicePresupuesto = mock(ServicioDePresupuestoImpl.class);
        service = new ServicioDeTransaccionImpl(repo);


    }

    @Test
    public void queSeBusqueElMontoDePresupuestoPorCategoria(){
        Categoria cat = new Categoria("compras");
       // Transaccion transaccion = new Transaccion(120.)
        Presupuesto p1 = new Presupuesto(1000.0, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 04, 30), cat);
        servicePresupuesto.listarPresupuestos().add(p1);
        Double presupuestoDeCategoria = servicePresupuesto.buscarMontoPresupuestoPorCategoria(cat);
        assertThat(presupuestoDeCategoria).isEqualTo(0.0);
    }
    @Test
>>>>>>> 89889376768752150dde3032e6dfc1755150c33a
    public void queLanceUnaExcepcionSiElMontoDeLaTransaccionEsMenorACero(){
        queNoSePuedaRegistrarUnaTransaccionConMontoMenorACero();
    }
    @Test
    public void queSePuedaRegistrarUnaTransaccion(){
        Transaccion t = dadoQueExisteUnaTransaccion();
        queSePuedaGuardar(t);
    }
<<<<<<< HEAD
    @Test
    public void queTraigaUnaListaDeTransaccionesPorCategoria(){
        Transaccion t = dadoQueExisteUnaTransaccion();
        Categoria cat = t.getCategoria();
        queSePuedaBuscarPorCategoria(t, cat);
=======
    @Test (expected = ElMontoEstaPorLlegarASuLimite.class)
    public void queLanceUnaExcepcionSiElMontoDelPresupestoEstaPorLlegarASuLimite(){
        Double montoPresu=0.0;
        Double monto=0.0;
        List<Transaccion> t = dadoQueExisteUnaListaDeTransacciones();
        monto=t.get(0).getMonto()+t.get(1).getMonto();
        montoPresu= servicePresupuesto.listarPresupuestos().get(0).getMontoPresupuesto();
        queNoSePuedaRegistrarPorPresupuesto(t, montoPresu, monto);

>>>>>>> 89889376768752150dde3032e6dfc1755150c33a
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

<<<<<<< HEAD

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
=======
    private void queNoSePuedaRegistrar(Transaccion t) {
        when(service.registrarTransaccion(t.getMonto(), null, t.getDetalle(), t.getFecha(), t.getConcepto(), t.getCategoria())).thenThrow(MontoMenorACero.class);
    }

    private Transaccion dadoQueExisteUnaTransaccion() {

        return new Transaccion(-12.0,"me compre papas", "01/06/2023", Concepto.Fijo, new Categoria("compras"));

    }



>>>>>>> 89889376768752150dde3032e6dfc1755150c33a





}

