package ar.edu.unlam.tallerweb1.domain;


import ar.edu.unlam.tallerweb1.domain.Registro.ServicioDeRegistroImpl;
import org.junit.Test;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.*;

public class ServicioDeRegistroTest {

    private ServicioDeRegistroImpl servicioRegistracion = new ServicioDeRegistroImpl();
    private String mail;
    private String clave;

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
