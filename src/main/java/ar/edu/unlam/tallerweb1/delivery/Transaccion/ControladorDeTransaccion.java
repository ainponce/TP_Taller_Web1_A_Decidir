package ar.edu.unlam.tallerweb1.delivery.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorDeTransaccion {

    private ServicioDeTransaccion servicioDeTransaccion;

    @Autowired
    public ControladorDeTransaccion(ServicioDeTransaccion servicioDeTransaccion){
        this.servicioDeTransaccion=servicioDeTransaccion;
    }
    @RequestMapping(path="/establecerTransaccion", method = RequestMethod.GET)
    public ModelAndView crearTransaccion() {
        ModelMap map= new ModelMap();
        map.put("datosTransaccion", new Transaccion());
        return new ModelAndView("establecerTransaccion", map);
    }

    @RequestMapping(path="/establecerTransaccion", method = RequestMethod.POST)
    public ModelAndView registrarUnaTransaccion(@ModelAttribute("datosTransaccion") Transaccion transaccion) {
        servicioDeTransaccion.registrarTransaccion(transaccion.getMonto(), transaccion.getDetalle(), transaccion.getFecha(), transaccion.getMoneda(), transaccion.getConcepto(), transaccion.getCategoria());
        ModelMap map= new ModelMap();
        map.put("msg", "Transaccion exitosa");
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(path="/home", method = RequestMethod.GET)
    public ModelAndView listarUnaTransaccion() {
        ModelMap map= new ModelMap();
        List<Transaccion> transacciones = servicioDeTransaccion.listarTransacciones();
        map.put("transacciones", transacciones);
        map.put("datosTransaccion", new Transaccion());
        return new ModelAndView("home", map);
    }

   /* @RequestMapping(path="/listarCategorias", method = RequestMethod.GET)
    public ModelAndView listarCategorias(){
       ModelMap map= new ModelMap();
    // Obtener los valores del enum Categoria
    Categoria[] categorias = Categoria.values();

    // Generar las opciones dinámicamente para el HTML
    //StringBuilder opciones = new StringBuilder();

    //for(Categoria categoria:categorias) {
      //  opciones.append("<option value=\"" + categoria.name() + "\">" + categoria.name() + "</option>");
    //}

        map.put("categorias", categorias);
    //request.setAttribute("opciones", opciones.toString());

        //String opcionesReturn = opciones.toString();
    return new ModelAndView("listarCategorias", map);
        // return new ModelAndView("listarCategorias", map);
    }

   @RequestMapping(path = "filtrar", method = RequestMethod.GET)
    public ModelAndView filtrarTransaccionPorCategoria(@RequestParam(value = "categoriaTransaccion", required = false) Categoria categoria){
       ModelMap map= new ModelMap();
       List<Transaccion> transacciones = null;
       if(categoria == categoria.Ocio || categoria == categoria.Compras || categoria == categoria.Salidas || categoria == categoria.Servicios){
           transacciones = servicioDeTransaccion.filtrarTransaccionesPorCategoria(categoria);
       }else {
           transacciones = servicioDeTransaccion.listarTransacciones();
       }
       map.put("transacciones", transacciones);
       return new ModelAndView("home", map);
   } */
}
