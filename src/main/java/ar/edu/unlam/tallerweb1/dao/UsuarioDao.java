package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {
	
	void registrarUsuario (Usuario usuario); 
	Usuario consultarUsuario (Usuario usuario);

}
