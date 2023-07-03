package ar.edu.unlam.tallerweb1.domain.Presupuesto;

public class NoExistePresupuesto extends RuntimeException{

    public NoExistePresupuesto() { super("No existe el presupuesto");
    }
}
