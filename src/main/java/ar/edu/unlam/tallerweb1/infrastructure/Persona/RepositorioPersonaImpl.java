package ar.edu.unlam.tallerweb1.infrastructure.Persona;

import ar.edu.unlam.tallerweb1.domain.Persona.Persona;
import ar.edu.unlam.tallerweb1.infrastructure.Persona.RepositorioPersona;
import org.springframework.stereotype.Repository;
@Repository("repositorioPersona")
public class RepositorioPersonaImpl implements RepositorioPersona {


    @Override
    public Persona buscarPersona(String nombre) {
        return null;
    }

    @Override
    public void guardar(Persona persona) {

    }

    @Override
    public Persona buscar(String email) {
        return null;
    }

    @Override
    public void modificar(Persona persona) {

    }

    @Override
    public Persona buscarPersonaPorId(Long id) {
        return null;
    }
}
