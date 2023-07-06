package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuestoImpl;
import ar.edu.unlam.tallerweb1.domain.Registro.ServicioDeRegistro;
import ar.edu.unlam.tallerweb1.domain.Registro.ServicioDeRegistroImpl;
import ar.edu.unlam.tallerweb1.infrastructure.Categoria.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.infrastructure.Presupuesto.RepositorioPresupuesto;
import ar.edu.unlam.tallerweb1.infrastructure.Usuario.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.infrastructure.Usuario.RepositorioUsuarioImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ServicioDeRegistroTest {

    private ServicioDeRegistro servicioRegistracion;
    private RepositorioUsuario repoUsuario;
    private String mail;
    private String clave;

    @Before
    public void init() {
        repoUsuario = mock(RepositorioUsuarioImpl.class);
        servicioRegistracion = new ServicioDeRegistroImpl(repoUsuario);
        this.mail="login@login.com";
       this.clave = "Clave123";

    }
    @Test
    public void alIngresarUnCorreoValidoMeDevuelveVerdadero(){
        Boolean esValido= servicioRegistracion.validarEmail("test@gmail.com");
        entoncesMiCorreo(esValido);
    }

    @Test
    public void alIngresarCredencialesValidasMePuedoRegistrarExitosamente(){
        dadoQueTengroCredencialesValidas();
        Boolean registroExitoso= cuandoMeRegistro(this.mail, this.clave);
        entoncesMiCorreo(registroExitoso);
    }

    private Boolean cuandoMeRegistro(String mail, String clave) {
        return servicioRegistracion. registrarUsuario(mail, clave);
    }

    private void dadoQueTengroCredencialesValidas() {
        this.mail= "test@gmail.com";
        this.clave="Rolon1234";
    }

    private void entoncesMiCorreo(Boolean esValido) {
        assertThat(esValido).isTrue();
    }

}
