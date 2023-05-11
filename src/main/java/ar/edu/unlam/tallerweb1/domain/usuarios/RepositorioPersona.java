package ar.edu.unlam.tallerweb1.domain.usuarios;

// Interface que define los metodos del Repositorio de Persona.
public interface RepositorioPersona {
	
	Persona buscarPersona(String nombre);
	void guardar(Persona persona);
    Persona buscar(String email);
	void modificar(Persona persona);
	Persona buscarPersonaPorId(Long id);
}
