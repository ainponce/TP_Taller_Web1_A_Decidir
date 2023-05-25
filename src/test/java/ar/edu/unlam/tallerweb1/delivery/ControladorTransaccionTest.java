package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.Transaccion.ControladorDeTransaccion;
import ar.edu.unlam.tallerweb1.delivery.Transaccion.DatosTransaccion;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccionImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorTransaccionTest {

    private ServicioDeTransaccion servicioDeTransaccion;
    private ControladorDeTransaccion controladorDeTransaccion;
    private Transaccion transaccion;
    private DatosTransaccion datosInvalidos;

    @Before
    public void init(){
        this.servicioDeTransaccion= mock(ServicioDeTransaccionImpl.class);
        this.controladorDeTransaccion= new ControladorDeTransaccion(this.servicioDeTransaccion);
        this.transaccion= new Transaccion(1500.0, "Inversión", "123", Moneda.Peso, Concepto.Gasto, Categoria.Compras);
        this.datosInvalidos= new DatosTransaccion(-10.0, "gastos");
    }



    @Test
    public void AlIngresarUnaTransaccionMeMuestraLaMisma(){
        ModelAndView mav= CuandoIngresoUnaTransaccion();
        entoncesMeMuestraLaTransaccionIngresada(mav);

    }

    private void entoncesMeMuestraLaTransaccionIngresada(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Transaccion existe");
    }

    private ModelAndView CuandoIngresoUnaTransaccion() {
        return controladorDeTransaccion.registrarUnaTransaccion(transaccion);
    }

}
