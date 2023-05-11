package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.Registro.ControladorDeRegistro;
import ar.edu.unlam.tallerweb1.delivery.Registro.DatosRegistracion;
import ar.edu.unlam.tallerweb1.infrastructure.Registro.ServicioDeRegistro;
import ar.edu.unlam.tallerweb1.infrastructure.Registro.ServicioDeRegistroImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ControladorRegistroTest {

    private ServicioDeRegistro servicioRegistracion;
    private ControladorDeRegistro controladorDeRegistro;
    private DatosRegistracion datosRegistracion;
    private DatosRegistracion datosRegistracionInvalidos;

    @Before
    public void init(){
        this.datosRegistracion =  new DatosRegistracion("test@gmail.com", "1234");
        this.datosRegistracionInvalidos =  new DatosRegistracion("test1gmail", "12344");
        this.servicioRegistracion= mock(ServicioDeRegistroImpl.class);
        this.controladorDeRegistro= new ControladorDeRegistro(this.servicioRegistracion);
    }

    @Test
    public void alIngresarCredencialesCorrectasDeUnUsuarioQueNoExisteMeRegistraYLlevaAlLogin(){
        dadoQueNoExisteElUsuario();
        ModelAndView mav= cuandoMeRegistro(datosRegistracion);
        entoncesElRegistroEsExitoso(mav);
    }

    @Test
    public void alIngresarCredencialesInvalidasNoMePermiteRegistrarme(){
        dadoQueLasCredencialesSonInvalidas();
        ModelAndView mav= cuandoMeRegistro(datosRegistracion);
        entoncesElRegistroFalla(mav);
    }

    @Test
    public void alIngresarARegistrarmeMeMuestraLaPatantallaDeRegistro(){
        ModelAndView mav= cuandoMeQuieroRegistrar();
        entoncesMeLlevaALaPantallaDeRegistro(mav);
    }

    private void entoncesMeLlevaALaPantallaDeRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
    }

    private ModelAndView cuandoMeQuieroRegistrar() {
        return controladorDeRegistro.registrarme();
    }


    private void entoncesElRegistroFalla(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
        assertThat(mav.getModel().get("msg")).isEqualTo("registro fallido");
    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("registro exitoso");
    }

    private ModelAndView cuandoMeRegistro(DatosRegistracion datosRegistracion) {
        return controladorDeRegistro.registrarUsuario(datosRegistracion);
    }

    private void dadoQueLasCredencialesSonInvalidas(){
        when(servicioRegistracion.validarEmail(datosRegistracion.getCorreo())).thenReturn(false);
        when(this.servicioRegistracion.registrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave())).thenReturn(false);

    }

    private void dadoQueNoExisteElUsuario() {
        when(servicioRegistracion.validarEmail(datosRegistracion.getCorreo())).thenReturn(true);
        when(this.servicioRegistracion.registrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave())).thenReturn(true);
    }
}
