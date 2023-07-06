
package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuestoImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.*;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
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
    public void queLanceUnaExcepcionSiElMontoDeLaTransaccionEsMenorACero(){
        Transaccion t = dadoQueExisteUnaTransaccion();
        queNoSePuedaRegistrar(t);
    }
    @Test (expected = ElMontoEstaPorLlegarASuLimite.class)
    public void queLanceUnaExcepcionSiElMontoDelPresupestoEstaPorLlegarASuLimite(){
        Double montoPresu=0.0;
        Double monto=0.0;
        List<Transaccion> t = dadoQueExisteUnaListaDeTransacciones();
        monto=t.get(0).getMonto()+t.get(1).getMonto();
        montoPresu= servicePresupuesto.listarPresupuestos().get(0).getMontoPresupuesto();
        queNoSePuedaRegistrarPorPresupuesto(t, montoPresu, monto);

    }

    private List<Transaccion> dadoQueExisteUnaListaDeTransacciones() {
        return service.listarTransacciones();
    }

    private void queNoSePuedaRegistrarPorPresupuesto(List<Transaccion> t, Double montopresu, Double monto) {
        service.registroTransaccionExitoso(t, montopresu, monto);
    }

    private void queNoSePuedaRegistrar(Transaccion t) {
        when(service.registrarTransaccion(t.getMonto(), null, t.getDetalle(), t.getFecha(), t.getConcepto(), t.getCategoria())).thenThrow(MontoMenorACero.class);
    }

    private Transaccion dadoQueExisteUnaTransaccion() {
        return new Transaccion(0.0,"me compre papas", "01/06/2023", Concepto.Gasto, new Categoria("compras"));
    }






}

