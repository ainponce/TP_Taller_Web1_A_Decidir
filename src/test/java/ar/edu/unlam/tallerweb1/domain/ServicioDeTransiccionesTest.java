package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
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

    @Test
    public void listarCategoria(){
        List<Categoria> cat = service.listarCategorias();
        queSeanLaMismaCantidad(cat);
    }

    private void queSeanLaMismaCantidad(List<Categoria> categorias) {
        assertThat(categorias.size()).isEqualTo(2);
    }

   /* @Test
    public void sumarElMontoPorCategoria() {
        List<Transaccion> trans = listoTransaccionesPorCategoria();
        Double montoTotal = service.sumarMontoDeTransaccionesPorCategoria(trans);
        validarMonto(montoTotal);
    }*/

    private void validarMonto(Double montoTotal) {
        assertThat(montoTotal).isEqualTo(15000.0);
    }


    /*private List<Transaccion> listoTransaccionesPorCategoria() {
        return repo.buscarTransaccionPorCategoria(Categoria.Salidas);
    }*/

}
