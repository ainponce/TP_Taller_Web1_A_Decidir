package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class LoginDaoImpl implements LoginDao{

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void registrarUsuario(Usuario usuario) {
		
		final Session session = sessionFactory.openSession();
		
		session.save(usuario);
		
		
	}

}
