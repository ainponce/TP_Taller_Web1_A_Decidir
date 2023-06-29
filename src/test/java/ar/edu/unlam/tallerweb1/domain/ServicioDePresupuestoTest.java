package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ServicioDePresupuestoTest extends SpringTest {
    @Autowired
    private ServicioDePresupuesto servicePresupuesto;
    @Autowired
    private RepositorioPresupuesto repoPresupuesto;
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Test //(expected = ElPresupuestoEsNulo.class)
    public void queLanceUnaExcepcionSiElPresupuestoEsNulo(){
        Categoria cat= repositorioCategoria.traerCategoriaPorId(3);
        servicePresupuesto.buscarMontoPresupuestoPorCategoria(cat);
    }


    /* @Test

    public void queTireUnaAlarmaDePresupuestoPorAlcanzar(){
        List<Presupuesto> pres = repoPresupuesto.buscarPorCategoria(Categoria.Salidas);
        compararPresupuestosDeCategoriaYTransaccion(pres);
    }*/

    private void compararPresupuestosDeCategoriaYTransaccion(List<Presupuesto> pres) {
    }


}
