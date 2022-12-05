package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ControladorLoginTest {

    @Mock
    private ServicioLogin servicioLogin;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession sesion;

    private ControladorLogin controladorLogin;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(request.getSession()).thenReturn(sesion);
        controladorLogin = new ControladorLogin(this.servicioLogin);
    }

    @Test
    public void dadoUnUsuarioExistenteQueSePuedaIniciarSesion() {

        String ROL = "admin";

        DatosLogin datosLogin = new DatosLogin();
        Usuario usuarioEsperado = new Usuario();
        usuarioEsperado.setRol(ROL);

        when(servicioLogin.consultarUsuario(any(), any())).thenReturn(usuarioEsperado);
        ModelAndView vista = controladorLogin.validarLogin(datosLogin, request);

        assertThat(vista.getViewName()).isEqualTo("redirect:/home");
    }
}
