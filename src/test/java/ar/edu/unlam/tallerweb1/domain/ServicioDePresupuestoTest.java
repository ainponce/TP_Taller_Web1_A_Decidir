package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ServicioDePresupuestoTest {

    private ServicioDePresupuesto servicePresupuesto;
    private RepositorioPresupuesto repoPresupuesto;

   /* @Test
    @Transactional
    @Rollback
    public void queTireUnaAlarmaDePresupuestoPorAlcanzar(){
        List<Presupuesto> pres = repoPresupuesto.buscarPorCategoria(Categoria.Salidas);
        compararPresupuestosDeCategoriaYTransaccion(pres);
    }*/

    private void compararPresupuestosDeCategoriaYTransaccion(List<Presupuesto> pres) {
    }


}
