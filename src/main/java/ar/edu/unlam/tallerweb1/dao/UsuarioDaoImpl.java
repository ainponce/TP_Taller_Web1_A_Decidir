package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;

@Service("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void registrarUsuario(Usuario usuario) {
		
		final Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}

}
