package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
