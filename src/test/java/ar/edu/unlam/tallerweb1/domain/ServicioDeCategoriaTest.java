package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.Categoria.ControladorDeCategoria;
import ar.edu.unlam.tallerweb1.delivery.Presupuesto.ControladorDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.CategoriaDuplicadaEx;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoriaImpl;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.*;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoriaImp;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioDeCategoriaTest {

    private ServicioDeCategoria servicioDeCategoria;
    private RepositorioCategoria repositorioCategoria;
    private ControladorDeCategoria controladorDeCategoria;
    private ModelAndView model;
    @Before
    public void init(){
        servicioDeCategoria = mock(ServicioDeCategoria.class);
        repositorioCategoria = mock(RepositorioCategoria.class);
        controladorDeCategoria = mock(ControladorDeCategoria.class);
        model = mock(ModelAndView.class);

    }

    @Test (expected = CategoriaDuplicadaEx.class)
    public void queLanceUnaExcepcionSiSeQuiereCrearUnaCategoriaDuplicada(){
        Categoria c = queCreeUnaCategoria();
        Categoria creada = new Categoria("Compras");
        queLanceUnaExcpecionPorCategoriaDuplicada(creada);
        queLanceUnaExcpecionPorCategoriaDuplicada(c);
    }

    private Categoria queCreeUnaCategoria() {
        return new Categoria("Compras");
    }

    private void queLanceUnaExcpecionPorCategoriaDuplicada(Categoria categoria) {
        when(servicioDeCategoria.regsitrarCategoria(categoria.getNombre())).thenThrow(CategoriaDuplicadaEx.class);
    }

}