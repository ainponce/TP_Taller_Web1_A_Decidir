
package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ElMontoEstaPorLlegarASuLimite;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



public class ServicioDeTransiccionesTest extends SpringTest{

    @Autowired
    private RepositorioTransaccion repo;

    @Autowired
    private ServicioDeTransaccion service;
    @Autowired
    private ServicioDePresupuesto servicePresupuesto;

    @Test
    public void listarCategoria(){
        List<Categoria> cat = service.listarCategorias();
        queSeanLaMismaCantidad(cat);
    }
    @Test
    public void queSeBusqueElMontoDePresupuestoPorCategoria(){
        Categoria cat = new Categoria("compras");
       // Transaccion transaccion = new Transaccion(120.)
        Presupuesto p1 = new Presupuesto(1000.0, "1/04/2023", "30/04/2023", cat);
        servicePresupuesto.listarPresupuestos().add(p1);
        Double presupuestoDeCategoria = servicePresupuesto.buscarMontoPresupuestoPorCategoria(cat);
        assertThat(presupuestoDeCategoria).isEqualTo(0.0);
    }
    @Test (expected = MontoMenorACero.class)
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
        service.registrarTransaccion(t.getMonto(), null, t.getDetalle(), t.getFecha(), t.getConcepto(), t.getCategoria());
    }

    private Transaccion dadoQueExisteUnaTransaccion() {
        return new Transaccion(-12.0,"me compre papas", "01/06/2023", Concepto.Gasto, new Categoria("compras"));
    }


    private void queSeanLaMismaCantidad(List<Categoria> categorias) {
        assertThat(categorias.size()).isEqualTo(2);
    }



}

