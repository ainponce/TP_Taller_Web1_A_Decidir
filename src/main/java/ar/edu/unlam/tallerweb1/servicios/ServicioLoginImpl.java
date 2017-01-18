package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.LoginDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service @Transactional
public class ServicioLoginImpl implements ServicioLogin {

	@Inject
	private LoginDao servicioDao;

	@Override
	public void registrarUsuario(Usuario usuario) {
		servicioDao.registrarUsuario(usuario);
		
		
	}
	
	


}
