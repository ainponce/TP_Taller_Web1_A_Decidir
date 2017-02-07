package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ServicioLogin {

	void registrarUsuario(Usuario usuario);
	
	List <Usuario> consultarUsuario (Usuario usuario);
	Boolean validarLogin(List<Usuario> usuariosValidos, String email, String password);
	
}
