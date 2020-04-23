package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MiControlador {

// saludar/Seba o saludar/maria "path variables"
    @RequestMapping(path="/saludar", method = RequestMethod.GET)
    public ModelAndView saludar(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido){
        ModelMap model = new ModelMap();
        model.put("nombreParaMostrar", nombre.toUpperCase());
        model.put("apellidoParaMostrar", apellido.toUpperCase());
        //Hola ${paramostrar}!
        return new ModelAndView("saludo", model);
    }


}
