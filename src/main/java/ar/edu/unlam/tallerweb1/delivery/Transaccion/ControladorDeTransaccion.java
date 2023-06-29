package ar.edu.unlam.tallerweb1.delivery.Transaccion;


import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Categorias.ServicioDeCategoria;
import ar.edu.unlam.tallerweb1.domain.Concepto.Concepto;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Moneda.ServicioDeMoneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.ServicioDePresupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorDeTransaccion {

    private final ServicioDeCategoria servicioDeCategoria;
    private final ServicioDeTransaccion servicioDeTransaccion;
    private final ServicioDePresupuesto servicioDePresupuesto;
    private final ServicioDeMoneda servicioDeMoneda;

    @Autowired
    public ControladorDeTransaccion(ServicioDeTransaccion servicioDeTransaccion, ServicioDeCategoria servicioDeCategoria, ServicioDePresupuesto servicioDePresupuesto, ServicioDeMoneda servicioDeMoneda){
        this.servicioDeTransaccion=servicioDeTransaccion;
        this.servicioDeCategoria= servicioDeCategoria;
        this.servicioDePresupuesto=servicioDePresupuesto;
        this.servicioDeMoneda = servicioDeMoneda;
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
                                                @RequestParam("fecha") String fecha, @RequestParam("concepto") Concepto concepto,@RequestParam(value = "categoria", required=false) Long categoria) {
        Categoria cat =servicioDeCategoria.buscarCategoriaPorId(categoria);
        ModelMap map= new ModelMap();
        List<Transaccion> transacciones = servicioDeTransaccion.filtrarTransaccionesPorCategoria(cat);
        Double presupuestoDeCategoria = servicioDePresupuesto.buscarMontoPresupuestoPorCategoria(cat);
        Presupuesto presupuesto = servicioDePresupuesto.buscarPresupuestoPorCategoria(cat);
        if(presupuesto==null){
            map.put("errorPresu", "El presupuesto no existe");
            map.put("datosTransaccion", new Transaccion());
            List<Categoria> categorias = servicioDeTransaccion.listarCategorias();
            map.put("categorias", categorias);
            return new ModelAndView("establecerTransaccion", map);
        }
        Boolean registroTransaccionPosible = servicioDeTransaccion.registroTransaccionExitoso(transacciones, presupuestoDeCategoria, monto);
        if(registroTransaccionPosible){
            servicioDeTransaccion.registrarTransaccion(monto, detalle, fecha, concepto, cat);
             map.put("msg", "Transaccion exitosa");
             return new ModelAndView("redirect:/home");
        }else{

            map.put("error", "¡Error al ingresar la nueva transaccion!. El monto del presupuesto excedio el limite");
            map.put("datosTransaccion", new Transaccion());
            List<Categoria> categorias = servicioDeTransaccion.listarCategorias();
            map.put("categorias", categorias);
            return new ModelAndView("establecerTransaccion", map);
        }
    }

    @RequestMapping(path="/home", method = RequestMethod.GET)
    public ModelAndView listarUnaTransaccion() {
        ModelMap map= new ModelMap();
        List<Transaccion> transacciones = servicioDeTransaccion.listarTransacciones();
        List<Categoria> categorias = servicioDeCategoria.listarCategorias();
        List<Moneda> moneda = servicioDeMoneda.listarMonedas();
        map.put("datosTransaccion", new Transaccion());
        map.put("transacciones", transacciones);
        map.put("categorias", categorias);
        map.put("moneda", moneda);

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

   @RequestMapping(path = "filtrar", method = RequestMethod.GET)
    public ModelAndView filtrarTransaccionPorCategoria(@RequestParam(value = "categoriaTransaccion", required=false) Long categoria){
       ModelMap map= new ModelMap();
       Categoria cat =servicioDeCategoria.buscarCategoriaPorId(categoria);
       List<Transaccion> transacciones = null;
       List<Categoria> categorias = servicioDeTransaccion.listarCategorias();
       List<Moneda> moneda = servicioDeMoneda.listarMonedas();
           if(cat.GetId() != null) {
               transacciones = servicioDeTransaccion.filtrarTransaccionesPorCategoria(cat);
           }else {
               transacciones = servicioDeTransaccion.listarTransacciones();
           }
       map.put("transacciones", transacciones);
       map.put("categorias", categorias);
       map.put("moneda", moneda);
       return new ModelAndView("home", map);
   }

   @RequestMapping(path = "convertir", method = RequestMethod.GET)
    public ModelAndView cambiarMonedaDeTransacciones(@RequestParam(value = "moneda") Long  moneda, @RequestParam(value = "categoriaTransaccion", required=false) Long categoria){
       ModelMap map= new ModelMap();
       Moneda mon = servicioDeMoneda.buscarMonedaPorId(moneda);
       List<Transaccion> transacciones = servicioDeTransaccion.convertirMontoEnMonedaSeleccionada(mon);
       List<Categoria> categorias = servicioDeTransaccion.listarCategorias();
       List<Moneda> moneda1 = servicioDeMoneda.listarMonedas();
       map.put("categorias", categorias);
       map.put("moneda", moneda1);
       map.put("transacciones", transacciones);
       return new ModelAndView("home", map);
    }


    @RequestMapping(path="/delete", method = RequestMethod.POST)
    public ModelAndView eliminarUnaTransaccion(@RequestParam("id") Long id){
        ModelMap map= new ModelMap();
        Transaccion transaccionAEliminar = null;
        transaccionAEliminar =  servicioDeTransaccion.buscarTransaccionPorIdParaEliminar(id);
        if(transaccionAEliminar!=null){
            servicioDeTransaccion.eliminarTransaccion(transaccionAEliminar);
        }else{
            map.put("msg", "No existe la transaccion");
        }

        return new ModelAndView("redirect:/home", map);
    }


}
