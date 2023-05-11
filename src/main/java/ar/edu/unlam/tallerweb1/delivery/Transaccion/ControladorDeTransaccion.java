package ar.edu.unlam.tallerweb1.delivery.Transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ControladorDeTransaccion {

    private ServicioDeTransaccion servicioDeTransaccion;

    @Autowired
    public ControladorDeTransaccion(ServicioDeTransaccion servicioDeTransaccion){

    }
    @RequestMapping(path="/home", method = RequestMethod.GET)
    public ModelAndView crearTransaccion() {
        ModelMap map= new ModelMap();
        map.put("datosTransaccion", new DatosTransaccion());

        return new ModelAndView("home", map);
    }

    @RequestMapping(path="/home", method = RequestMethod.POST)
    public ModelAndView registrarUnaTransaccion(@ModelAttribute("transacciones") DatosTransaccion datosTransaccion) {
        servicioDeTransaccion.registrarTransaccionDetalle(datosTransaccion.getMonto(), datosTransaccion.getDetalle());
        ModelMap map= new ModelMap();
        map.put("msg", "Transaccion existe");
        return new ModelAndView("home", map);
    }
}
