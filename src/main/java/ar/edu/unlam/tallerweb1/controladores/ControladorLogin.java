package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;

	// TODO moveria este metodo cerca del post de login
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);

	}

	@RequestMapping("/registrar")
	// TODO sismael camel case nombre del metodo
	public ModelAndView iraRegistrar() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registroUsuario", modelo);

	}

	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(
			@ModelAttribute("usuario") Usuario usuario) {
		servicioLogin.registrarUsuario(usuario);
		// TODO ver camel case. yo iria a la pantalla de login
		return new ModelAndView("registrousuariocorrecto");

	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(
			@ModelAttribute("usuario") Usuario usuario,
			HttpServletRequest request) {
		// TODO indent de los parametyros
		ModelMap error = new ModelMap();
		String mensaje = "";
		// TODO por que hay 2 servicios??? yo buscaria por usuario y password directamente.
		List<Usuario> usuarioValido = servicioLogin.consultarUsuario(usuario);

		if (servicioLogin.validarLogin(usuarioValido, usuario.getEmail(),
				usuario.getPassword()) && !usuario.getEmail().isEmpty()) {
			request.getSession().setAttribute("idSesion", usuario.getId());
			// TODO camel case
			return new ModelAndView("pantallaprincipal");

		} else {

			if (usuario.getEmail().isEmpty()) {
				mensaje = " el email no puede estar vacio";

			} else {
				// TODO encoding
				mensaje = " contrase�a incorrecta o el mail ingresado no existe ";

			}

		}
		// TODO haria un redirect a /login
		error.put("error", mensaje);
		return new ModelAndView("errorlogin", error);
	}
}
