package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public List<Usuario> consultarUsuario(Usuario usuario) {

		final Session session = sessionFactory.openSession();
		List usuarios = session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.list();
				
		return usuarios;
	}

}
