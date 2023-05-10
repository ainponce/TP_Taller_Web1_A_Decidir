package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioDeRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorDeRegistro {


    private ServicioDeRegistro servicioRegistracion;

    @Autowired
    public ControladorDeRegistro(ServicioDeRegistro servicioRegistracion){
        this.servicioRegistracion = servicioRegistracion;
    }

    @RequestMapping(path="/registrar-usuario", method = RequestMethod.GET)
    public ModelAndView registrarme() {
        ModelMap map= new ModelMap();
        map.put("datosRegistro", new DatosRegistracion());

        return new ModelAndView("registro-usuario", map);
    }

    @RequestMapping(path="/registrar-usuario", method = RequestMethod.POST)
    public ModelAndView registrarUsuario(@ModelAttribute DatosRegistracion datosRegistracion){
        ModelMap model= new ModelMap();
        String viewName="registro-usuario";
        if(this.servicioRegistracion.registrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave())) {
            viewName="home";
            model.put("datosLogin", new DatosLogin());

            model.put("msg", "registo exitoso");

        }else{
            model.put("datosRegistro", new DatosRegistracion());

            model.put("error", "Datos incorrectos, por favor vuelta a intentarlo");

            model.put("msg", "registro fallido");

        }
        return new ModelAndView(viewName, model);
    }



}
