package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLogin {

	void registrarUsuario(Usuario usuario);
	
	Usuario consultarUsuario(Usuario usuario);
}
