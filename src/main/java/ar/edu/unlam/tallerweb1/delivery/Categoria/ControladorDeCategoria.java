package ar.edu.unlam.tallerweb1.delivery.Categoria;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.CategoriaDuplicadaEx;
import ar.edu.unlam.tallerweb1.domain.Categorias.NombreDeCategoriaNuloEx;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorDeCategoria {
    private final ServicioDeCategoria servicioDeCategoria;

    @Autowired
    public ControladorDeCategoria(ServicioDeCategoria servicioDeCategoria){
        this.servicioDeCategoria = servicioDeCategoria;
    }

    @RequestMapping(path="/crearCategoria", method = RequestMethod.GET)
    public ModelAndView crearCategoria(){
        ModelMap map = new ModelMap();
        List<Categoria> categorias = servicioDeCategoria.listarCategorias();
        map.put("datosCategoria", new Categoria());
        map.put("categorias", categorias);
        return new ModelAndView("crearCategoria", map);
    }

    @RequestMapping(path="crearCategoria", method= RequestMethod.POST)
    public ModelAndView registrarCategoria(@RequestParam("nombre") String nombreCategoria){
        ModelMap map = new ModelMap();
        try{
            servicioDeCategoria.regsitrarCategoria(nombreCategoria);
        } catch (NombreDeCategoriaNuloEx e){
            map.put("Error", e.getMessage());
        } catch (CategoriaDuplicadaEx e){
            map.put("Error", e.getMessage());
        }

        List<Categoria> categorias = servicioDeCategoria.listarCategorias();
        map.put("datosCategoria", new Categoria());
        map.put("categorias", categorias);
        return new ModelAndView("crearCategoria", map);
    }


}
