package ar.edu.unlam.tallerweb1.delivery.Ahorro;

import ar.edu.unlam.tallerweb1.domain.Ahorro.Ahorro;
import ar.edu.unlam.tallerweb1.domain.Ahorro.CalculoDeAhorro;
import ar.edu.unlam.tallerweb1.domain.Ahorro.ServicioDeAhorro;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
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
public class ControladorAhorro {

    private final ServicioDePresupuesto servicioDePresupuesto;
    private final ServicioDeAhorro servicioDeAhorro;

    @Autowired
    public ControladorAhorro(ServicioDePresupuesto servicioDePresupuesto, ServicioDeAhorro servicioDeAhorro) {
        this.servicioDePresupuesto = servicioDePresupuesto;
        this.servicioDeAhorro = servicioDeAhorro;
    }

    @RequestMapping(path = "/calculadoraDeAhorro", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDeCalculadoraDeAhorro(){
        ModelMap map = new ModelMap();
        List<Presupuesto> prespuesto = servicioDePresupuesto.listarPresupuestos();
        map.put("listaDePresupuesto", prespuesto);
        map.put("ListarAhorroPordia", new Ahorro());
        return new ModelAndView("calculadoraDeAhorro", map);
    }

    @RequestMapping( path="/calculadoraDeAhorro", method = RequestMethod.POST)
    public ModelAndView calcularAhorro(@RequestParam("nombreAhorro")String nombreAhorro,
                                       @RequestParam("montoAhorro")double montoAhorro,
                                       @RequestParam("montoDePresupuesto")double montoDelPrespuesto){
        ModelMap map = new ModelMap();
        List<Presupuesto> prespuesto = servicioDePresupuesto.listarPresupuestos();
        map.put("listaDePresupuesto", prespuesto);
        map.put("ListarAhorroPordia", new Ahorro());
        Ahorro ahorro= new Ahorro(nombreAhorro, montoAhorro, montoDelPrespuesto);
        double ahorroPorDia =servicioDeAhorro.calcularAhorroPorDia(montoDelPrespuesto, montoAhorro);
        double ahorroPorSemana =servicioDeAhorro.calcularAhorroPorSemana(montoDelPrespuesto, montoAhorro);
        CalculoDeAhorro calculoDeAhorro= new CalculoDeAhorro(ahorro, ahorroPorDia, ahorroPorSemana);
        map.put("ahorros", calculoDeAhorro);
        return new ModelAndView("calculadoraDeAhorro", map);
    }
}
