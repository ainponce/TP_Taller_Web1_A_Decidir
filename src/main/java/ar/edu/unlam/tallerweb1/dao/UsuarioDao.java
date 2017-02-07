package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {
	
	void registrarUsuario (Usuario usuario); 
	List <Usuario> consultarUsuario (Usuario usuario);

}
