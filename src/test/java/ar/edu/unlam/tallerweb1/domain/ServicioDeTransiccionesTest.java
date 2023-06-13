package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



public class ServicioDeTransiccionesTest extends SpringTest {

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
        Categoria cat = new Categoria("compras", true);
       // Transaccion transaccion = new Transaccion(120.)
        Presupuesto p1 = new Presupuesto(1000.0, "1/04/2023", "30/04/2023", Moneda.Peso, cat);
        servicePresupuesto.listarPresupuestos().add(p1);
        Double presupuestoDeCategoria = servicePresupuesto.buscarMontoPresupuestoPorCategoria(cat);
        assertThat(presupuestoDeCategoria).isEqualTo(0.0);
    }

    private void queSeanLaMismaCantidad(List<Categoria> categorias) {
        assertThat(categorias.size()).isEqualTo(2);
    }

    @Test
    public void sumarElMontoPorCategoria() {

    }

    private void validarMonto(Double montoTotal) {
        assertThat(montoTotal).isEqualTo(15000.0);
    }


    /*private List<Transaccion> listoTransaccionesPorCategoria() {
        return repo.buscarTransaccionPorCategoria(Categoria.Salidas);
    }*/

}
