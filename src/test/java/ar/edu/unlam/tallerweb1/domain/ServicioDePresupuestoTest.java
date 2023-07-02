package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoriaImpl;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.CategoriaEnUso;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ElPresupuestoEsNulo;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoriaImp;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ServicioDePresupuestoTest {

    private ServicioDePresupuesto servicePresupuesto;

    private RepositorioPresupuesto repoPresupuesto;
    private RepositorioCategoria repositorioCategoria;
    private ServicioDeCategoria serviceCategoria;

    @Test (expected = ElPresupuestoEsNulo.class)
    public void queLanceUnaExcepcionSiElPresupuestoEsNulo(){
        Boolean esValido = serviceCategoria.regsitrarCategoria("servicio");
        assertThat(esValido).isTrue();
    }

    @Test (expected = CategoriaEnUso.class)
    public void queLanceUnaExcpecionSiLaCategoriaEstaEnUso(){
        Categoria cat = repositorioCategoria.traerCategoriaPorId(2);
        servicePresupuesto.establecerPresupuesto(122.00, "15-06-2023", "30-06-2023", cat);
    }



}
