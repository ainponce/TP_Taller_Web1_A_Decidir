package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.Assert.*;

public class RepositorioUsuarioTest extends SpringTest {
    private String email="can@gmail.com";
    private String clave="can123";
    @Autowired
    private RepositorioUsuario repositorio = new RepositorioUsuarioImpl();

    @Test
    @Transactional @Rollback
    public void queSePuedaGuardarUnNuevoUsuarioYQueSePuedaBuscarPorId(){
        Usuario u = dadoQueExisteUnUsuario(email, clave);
        Long id = cuandoGuardoUsuario(u);
        entoncesLoPuedoBuscar(id);
    }

    @Test
    @Transactional @Rollback
    public void buscarUnUsuarioInexistenteYMeDevuelvaNull(){
        Usuario u = dadoQueExisteUnUsuario(email, clave);
        Long id = cuandoGuardoUsuario(u);
        Usuario usuarioBuscado = cuandoBuscoPorEmail("rocio@hola.com");
        entoncesNoPuedoEncontrar(usuarioBuscado);
    }

    private Usuario cuandoBuscoPorEmail(String email) {
        return repositorio.buscar(email);
    }

    private void entoncesLoPuedoBuscar(Long id) {
        Usuario usuarioBuscado = repositorio.buscarUsuarioPorId(id);
        assertThat(usuarioBuscado).isNotNull();
    }
    private void entoncesNoPuedoEncontrar(Usuario usuarioBuscado) {
        assertThat(usuarioBuscado).isNull();
    }

    private Long cuandoGuardoUsuario(Usuario u) {
        repositorio.guardar(u);
        return u.getId();
    }

    public Usuario dadoQueExisteUnUsuario(String email, String clave){
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setPassword(clave);
        return u;
    }


}
