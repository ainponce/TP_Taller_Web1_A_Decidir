package ar.edu.unlam.tallerweb1.delivery.Presupuesto;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.*;
import ar.edu.unlam.tallerweb1.domain.Transaccion.MontoMenorACero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


    @RequestMapping(path = "/establecerPresupuesto", method = RequestMethod.POST)
    public ModelAndView registrarUnPresupuesto(@RequestParam("montoPresupuesto") double montoPresupuesto, @RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
                                               @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta, @RequestParam("categoria") long categoria){
        ModelMap map = new ModelMap();
        Categoria cat =servicioDeCategoria.buscarCategoriaPorId(categoria);
        List<Presupuesto> presupuestos = servicioDePresupuesto.listarPresupuestos();
        List<Categoria> categorias = servicioDeCategoria.listarCategoriaParaPresupuestos();
        map.put("establecerPresupuesto", new Presupuesto());
        map.put("presupuestos", presupuestos);
        map.put("categorias", categorias);

        try {
            servicioDePresupuesto.establecerPresupuesto(montoPresupuesto, fechaDesde, fechaHasta, cat);
            map.put("msg", "Presupuesto creado");
        } catch (PresupuestoExistenteEnEseRangoDeFechas e){
             map.put("Error", e.getMessage());
            return new ModelAndView("establecerPresupuesto", map);
        } catch (MontoMenorACero e) {
            map.put("Error", e.getMessage());
            return new ModelAndView("establecerPresupuesto", map);
        }

        return new ModelAndView("redirect:/establecerPresupuesto", map);
    }


    @RequestMapping(path="/establecerPresupuesto", method = RequestMethod.GET)
    public ModelAndView crearUnPresupuesto() {
        ModelMap map= new ModelMap();
        List<Presupuesto> presupuestos = servicioDePresupuesto.listarPresupuestos();
        List<Categoria> categorias = servicioDeCategoria.listarCategoriaParaPresupuestos();
        map.put("establecerPresupuesto", new Presupuesto());
        map.put("presupuestos", presupuestos);
        map.put("categorias", categorias);
        return new ModelAndView("establecerPresupuesto", map);
    }

    @RequestMapping(path="/editarPresupuesto", method = RequestMethod.GET)
    public ModelAndView editarUnPresupuesto(@RequestParam("id") long idPresupuesto){
        ModelMap map= new ModelMap();
        List<Categoria> categorias = servicioDeCategoria.listarCategoriaParaPresupuestos();
        List<Presupuesto> presupuestos = servicioDePresupuesto.listarPresupuestos();
        Presupuesto pres = servicioDePresupuesto.buscarPresupuestoPorId(idPresupuesto);
        map.put("presupuesto", pres);
        map.put("presupuestos", presupuestos);
        map.put("categorias", categorias);
        return new ModelAndView("editarPresupuesto", map);
    }

    @RequestMapping(path = "/editarPresupuesto", method = RequestMethod.POST)
    public ModelAndView editarUnPresupuesto(@RequestParam("id") long idPresupuesto, @RequestParam("montoPresupuesto") double montoPresupuesto, @RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
                                               @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta, @RequestParam("categoria") long categoria ){
        ModelMap map = new ModelMap();
        Categoria cat =servicioDeCategoria.buscarCategoriaPorId(categoria);
        List<Categoria> categorias = servicioDeCategoria.listarCategoriaParaPresupuestos();
        List<Presupuesto> presupuestos = servicioDePresupuesto.listarPresupuestos();
        try {
            servicioDePresupuesto.editarPresupuesto(idPresupuesto,montoPresupuesto, fechaDesde, fechaHasta, cat);
            map.put("msg", "Prespuesto creado");
        } catch (PresupuestoExistenteEnEseRangoDeFechas e){
            map.put("Error", e.getMessage());
        } catch (MontoMenorACero e) {
            map.put("Error", e.getMessage());
        }

        map.put("establecerPresupuesto", new Presupuesto());
        map.put("categorias", categorias);
        map.put("presupuestos", presupuestos);
        map.put("msg", "Prespuesto creado");
        return new ModelAndView("redirect:/establecerPresupuesto");
    }

    @RequestMapping(path="/deletePresupuesto", method = RequestMethod.POST)
    public ModelAndView eliminarUnPresupuesto(@RequestParam("id") Long id){
        ModelMap map= new ModelMap();
        Presupuesto presupuestoAEliminar = null;
        presupuestoAEliminar =  servicioDePresupuesto.buscarPresupuestoPorIdParaEliminar(id);
        if(presupuestoAEliminar!=null) {
            try {
                servicioDePresupuesto.eliminarPresupuesto(presupuestoAEliminar);
                map.put("msg", "Prespuesto eliminado");
            } catch (NoExistePresupuesto n) {
                map.put("msg", "No existe el presupuesto");
                map.put("Error", n.getMessage());
            }
        }

        return new ModelAndView("redirect:/establecerPresupuesto", map);
    }



}
