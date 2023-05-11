package ar.edu.unlam.tallerweb1.domain.Login;

import ar.edu.unlam.tallerweb1.domain.Usuarios.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);
}
