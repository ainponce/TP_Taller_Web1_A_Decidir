
package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.Transaccion.ControladorDeTransaccion;
import ar.edu.unlam.tallerweb1.delivery.Transaccion.DatosTransaccion;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Moneda.ServicioDeMoneda;
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
        ModelAndView mav= CuandoIngresoUnaTransaccion();
        entoncesMeMuestraLaTransaccionIngresada(mav);

    }

    private void entoncesMeMuestraLaTransaccionIngresada(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("/redirect:home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Transaccion existosa");
    }

    private ModelAndView CuandoIngresoUnaTransaccion() {
        return controladorDeTransaccion.registrarUnaTransaccion(120.0, "compras", "02/03/2023", Concepto.Gasto,2L);
    }


}

