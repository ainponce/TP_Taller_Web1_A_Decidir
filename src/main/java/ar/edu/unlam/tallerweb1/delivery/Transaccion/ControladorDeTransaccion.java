package ar.edu.unlam.tallerweb1.delivery.Transaccion;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
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

    private final ServicioDeCategoria servicioDeCategoria;
    private ServicioDeTransaccion servicioDeTransaccion;

    @Autowired
    public ControladorDeTransaccion(ServicioDeTransaccion servicioDeTransaccion, ServicioDeCategoria servicioDeCategoria){
        this.servicioDeTransaccion=servicioDeTransaccion;
        this.servicioDeCategoria= servicioDeCategoria;
    }
    @RequestMapping(path="/establecerTransaccion", method = RequestMethod.GET)
    public ModelAndView crearTransaccion() {
        ModelMap map= new ModelMap();
        map.put("datosTransaccion", new Transaccion());
        List<Categoria> categorias = servicioDeTransaccion.listarCategorias();
        map.put("categorias", categorias);
        return new ModelAndView("establecerTransaccion", map);
    }

    @RequestMapping(path="/establecerTransaccion", method = RequestMethod.POST)
    public ModelAndView registrarUnaTransaccion(@RequestParam("monto") double monto, @RequestParam("detalle") String detalle,
                                                @RequestParam("fecha") String fecha, @RequestParam("moneda") Moneda moneda , @RequestParam("concepto") Concepto concepto, @RequestParam("categoria") long categoria) {
        Categoria cat =servicioDeCategoria.buscarCategoriaPorId(categoria);
        servicioDeTransaccion.registrarTransaccion(monto, detalle, fecha, moneda, concepto, cat);
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

    @RequestMapping(path="/listarCategorias", method = RequestMethod.GET)
    public ModelAndView listarCategorias(){
       ModelMap map= new ModelMap();
    // Llamo a la lista de categorias
    List<Categoria> categorias = servicioDeTransaccion.listarCategorias();
    map.put("categorias", categorias);

    return new ModelAndView("listarCategorias", map);
    }

   /*@RequestMapping(path = "filtrar", method = RequestMethod.GET)
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
