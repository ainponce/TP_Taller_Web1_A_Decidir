
package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.Transaccion.ControladorDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.ServicioDeMoneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccionImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorTransaccionTest extends SpringTest {
@Autowired
    private ServicioDeTransaccion servicioDeTransaccion;
    @Autowired
    private ControladorDeTransaccion controladorDeTransaccion;

    private Transaccion transaccion;

    @Autowired
    private ServicioDeCategoria servicioDeCategoria;
    @Autowired
    private ServicioDePresupuesto servicioDePresupuesto;

    @Autowired
    private ServicioDeMoneda servicioDeMoneda;


    @Before
    public void init(){
        this.servicioDeTransaccion= mock(ServicioDeTransaccionImpl.class);
        this.controladorDeTransaccion= new ControladorDeTransaccion(this.servicioDeTransaccion, this.servicioDeCategoria, this.servicioDePresupuesto, this.servicioDeMoneda);
        this.transaccion= new Transaccion(1500.0, "Inversión", "123", Concepto.Gasto, new Categoria());
    }

   @Test
    public void AlIngresarUnaTransaccionMeMuestraLaMisma(){
      Transaccion transaccion1 = cuandoIngresoUnaTransaccion();
      Presupuesto p = cuandoIngresoUnPresupuestoParaLaTransaccion();
        ModelAndView mav = cuandoQuieroRegistrarUnaTransaccion(transaccion1, p);
        entoncesMeMuestraLaTransaccionIngresada(mav);

    }

    private Presupuesto cuandoIngresoUnPresupuestoParaLaTransaccion() {
        Presupuesto presupuesto = new Presupuesto();
        Double montoPresupuesto = 1200.0;
        String fechaDesde = "12/04/2023";
        String fechaHasta = "30/04/2023";
        Categoria cat = new Categoria("bebidas");
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
        when(servicioDePresupuesto.establecerPresupuesto(p.getMontoPresupuesto(), p.getFechaDesde(), p.getFechaHasta(), p.getCategoria())).thenReturn(true);
        when(servicioDeTransaccion.registrarTransaccion(t.getMonto(),t.getDetalle(),t.getFecha(),t.getConcepto(),t.getCategoria())).thenReturn(true);
        return controladorDeTransaccion.registrarUnaTransaccion(t.getMonto(),t.getDetalle(),t.getFecha(),t.getConcepto(),t.getCategoria().getId());
    }

    private void entoncesMeMuestraLaTransaccionIngresada(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("/redirect:home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Transaccion existosa");
    }

    private Transaccion cuandoIngresoUnaTransaccion() {
        Categoria cat = new Categoria("bebidas");
       Transaccion transaccionNueva = new Transaccion(120.0, "compras", "12/04/2023", Concepto.Gasto,cat);
       return transaccionNueva;
    }


}

