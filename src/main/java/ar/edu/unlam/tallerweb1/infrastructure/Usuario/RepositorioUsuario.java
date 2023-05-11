package ar.edu.unlam.tallerweb1.infrastructure.Usuario;

import ar.edu.unlam.tallerweb1.domain.Usuarios.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardar(Usuario usuario);
    Usuario buscar(String email);
	void modificar(Usuario usuario);
	Usuario buscarUsuarioPorId(Long id);

}
