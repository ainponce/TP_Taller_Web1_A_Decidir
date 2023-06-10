package ar.edu.unlam.tallerweb1.delivery.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorDePresupuesto {

    private final ServicioDePresupuesto servicioDePresupuesto;

    @Autowired
    public ControladorDePresupuesto(ServicioDePresupuesto servicioDePresupuesto){
        this.servicioDePresupuesto = servicioDePresupuesto;
    }

   @RequestMapping(path = "/agregarPresupuesto", method = RequestMethod.GET)
    public ModelAndView crearPrespuesto(){
        ModelMap map = new ModelMap();
       map.put("establecerPresupuesto", new Presupuesto());
       List<Categoria> categorias = servicioDePresupuesto.listarCategorias();
       map.put("categorias", categorias);
        return new ModelAndView("establecerPresupuesto", map);
    }

    @RequestMapping(path = "/agregarPresupuesto", method = RequestMethod.POST)
    public ModelAndView registrarUnPresupuesto(@ModelAttribute("establecerPresupuesto") Presupuesto presupuesto){
        servicioDePresupuesto.establecerPresupuesto(presupuesto.getMontoPresupuesto(), presupuesto.getFechaDesde(), presupuesto.getFechaHasta(), presupuesto.getMoneda(), presupuesto.getCategoria());
        ModelMap map = new ModelMap();
        map.put("establecerPresupuesto", new Presupuesto());
        map.put("msg", "Prespuesto creado");
        return new ModelAndView("redirect:/establecerPresupuesto");
    }


    @RequestMapping(path="/establecerPresupuesto", method = RequestMethod.GET)
    public ModelAndView listarUnPresupuestos() {
        ModelMap map= new ModelMap();
        List<Presupuesto> presupuestos = servicioDePresupuesto.listarPresupuestos();
        map.put("presupuestos", presupuestos);
        map.put("establecerPresupuesto", new Presupuesto());

        return new ModelAndView("establecerPresupuesto", map);
    }
}
