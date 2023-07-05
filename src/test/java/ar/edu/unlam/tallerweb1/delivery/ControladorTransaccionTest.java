
package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.Categoria.ControladorDeCategoria;
import ar.edu.unlam.tallerweb1.delivery.Transaccion.ControladorDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoriaImpl;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.ServicioDeMoneda;
import ar.edu.unlam.tallerweb1.domain.Moneda.ServicioDeMonedaImpl;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuestoImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccionImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorTransaccionTest extends SpringTest {
@Autowired
    private ServicioDeTransaccion servicioDeTransaccion;
    @Autowired
    private ControladorDeTransaccion controladorDeTransaccion;

    @Autowired
    private ServicioDeCategoria servicioDeCategoria;
    @Autowired
    private ServicioDePresupuesto servicioDePresupuesto;

    @Autowired
    private ServicioDeMoneda servicioDeMoneda;

    private ControladorDeCategoria controladorDeCategoria;
    private ModelAndView model;

    @Before
    public void init(){
        this.servicioDeTransaccion= mock(ServicioDeTransaccionImpl.class);
        this.servicioDeCategoria = mock(ServicioDeCategoriaImpl.class);
        this.servicioDePresupuesto = mock(ServicioDePresupuestoImpl.class);
        this.controladorDeCategoria = mock(ControladorDeCategoria.class);
        this.servicioDeMoneda = mock(ServicioDeMonedaImpl.class);
        model = mock(ModelAndView.class);
        this.controladorDeTransaccion= new ControladorDeTransaccion(this.servicioDeTransaccion, this.servicioDeCategoria, this.servicioDePresupuesto, this.servicioDeMoneda);

    }

    @Test
    public void cuandoQuieroRegistrarUnaTransaccionExitosa(){
        Transaccion transaccion1 = cuandoIngresoUnaTransaccion();
        Presupuesto p = cuandoIngresoUnPresupuestoParaLaTransaccion();
        ModelAndView mav = cuandoQuieroRegistrarUnaTransaccion(transaccion1, p);
        entoncesMeMuestraLaTransaccionIngresada(mav);

    }

    private Presupuesto cuandoIngresoUnPresupuestoParaLaTransaccion() {
        Presupuesto presupuesto = new Presupuesto();
        Double montoPresupuesto = 1200.0;
        LocalDate fechaDesde = LocalDate.of(2023, 4, 01);
        LocalDate fechaHasta = LocalDate.of(2023, 4, 30);
        Categoria cat = new Categoria("bebidas");
        presupuesto.setId(1L);
        presupuesto.setMontoPresupuesto(montoPresupuesto);
        presupuesto.setFechaDesde(fechaDesde);
        presupuesto.setFechaHasta(fechaHasta);
        presupuesto.setCategoria(cat);
        presupuesto.getCategoria().setId(5L);
        return presupuesto;
    }

    private ModelAndView cuandoQuieroRegistrarUnaTransaccion(Transaccion t, Presupuesto p) {
        when(servicioDeCategoria.buscarCategoriaPorId(t.getCategoria().getId())).thenReturn(t.getCategoria());
        when(servicioDeCategoria.buscarCategoriaPorId(p.getCategoria().getId())).thenReturn(p.getCategoria());
        when(servicioDePresupuesto.establecerPresupuesto(p.getMontoPresupuesto(),p.getFechaDesde(),p.getFechaHasta(),p.getCategoria())).thenReturn(true);
        when(servicioDeTransaccion.registrarTransaccion(t.getMonto(),p.getMontoPresupuesto(),t.getDetalle(),t.getFecha(),t.getConcepto(),t.getCategoria())).thenReturn(true);
        when(model.getViewName()).thenReturn("/redirect:home");
        return controladorDeTransaccion.registrarUnaTransaccion(t.getMonto(),t.getDetalle(),t.getFecha(),t.getConcepto(),t.getCategoria().getId());
    }

    private void entoncesMeMuestraLaTransaccionIngresada(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("/redirect:home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Transaccion existosa");
    }

    private Transaccion cuandoIngresoUnaTransaccion() {
        Categoria cat = new Categoria("bebidas");
       Transaccion transaccionNueva = new Transaccion(120.0, "compras", "12/04/2023", Concepto.Gasto,cat);
        transaccionNueva.setId(1L);
       transaccionNueva.getCategoria().setId(5L);
       return transaccionNueva;
    }


}

