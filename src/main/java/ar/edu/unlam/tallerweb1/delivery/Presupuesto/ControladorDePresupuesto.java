package ar.edu.unlam.tallerweb1.delivery.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorDePresupuesto {

    private final ServicioDePresupuesto servicioDePresupuesto;

    private final ServicioDeCategoria servicioDeCategoria;

    @Autowired
    public ControladorDePresupuesto(ServicioDePresupuesto servicioDePresupuesto, ServicioDeCategoria servicioDeCategoria ){
        this.servicioDePresupuesto = servicioDePresupuesto;
        this.servicioDeCategoria= servicioDeCategoria;
    }


    @RequestMapping(path = "/agregarPresupuesto", method = RequestMethod.POST)
    public ModelAndView registrarUnPresupuesto(@RequestParam("montoPresupuesto") double montoPresupuesto, @RequestParam("fechaDesde") String fechaDesde,
                                               @RequestParam("fechaHasta") String fechaHasta, @RequestParam("moneda") Moneda moneda , @RequestParam("categoria") long categoria ){
        Categoria cat =servicioDeCategoria.buscarCategoriaPorId(categoria);
        servicioDePresupuesto.establecerPresupuesto(montoPresupuesto,fechaDesde, fechaHasta, moneda, cat );
        ModelMap map = new ModelMap();
        map.put("establecerPresupuesto", new Presupuesto());
        map.put("msg", "Prespuesto creado");
        return new ModelAndView("redirect:/establecerPresupuesto");
    }


    @RequestMapping(path="/establecerPresupuesto", method = RequestMethod.GET)
    public ModelAndView crearUnPresupuesto() {
        ModelMap map= new ModelMap();
        List<Presupuesto> presupuestos = servicioDePresupuesto.listarPresupuestos();
        map.put("presupuestos", presupuestos);
        map.put("establecerPresupuesto", new Presupuesto());
        List<Categoria> categorias = servicioDeCategoria.listarCategoriaParaPresupuestos();
        map.put("categorias", categorias);
        return new ModelAndView("establecerPresupuesto", map);
    }
}
