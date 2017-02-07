package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	@Inject
	private UsuarioDao servicioLoginDao;

	@Override
	public void registrarUsuario(Usuario usuario) {
		servicioLoginDao.registrarUsuario(usuario);
	}

	
	@Override
	public Boolean validarLogin(List<Usuario> usuariosValidos, String email,
			String password) {
		
		for (Usuario usuarios : usuariosValidos) {
			
			if ( usuarios.getEmail().equals(email)&& usuarios.getPassword().equals(password)) {
				return true;
				
			}
				
				
			
		}
		return false;
				
	}


	@Override
	public List <Usuario> consultarUsuario (Usuario usuario) {
		// TODO Auto-generated method stub
//		
//		System.out.println("entro a consultar usuario servicios impl");
//	   
//		for (Usuario usuarioenservicios :  servicioLoginDao.consultarUsuario(usuario) )
//		{
//			System.out.println("entro for de servicios " + usuarioenservicios.getEmail());
//	
//		}
		return  servicioLoginDao.consultarUsuario(usuario);
	}

}
