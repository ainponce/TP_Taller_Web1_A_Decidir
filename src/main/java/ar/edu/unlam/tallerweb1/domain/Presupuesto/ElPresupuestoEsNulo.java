package ar.edu.unlam.tallerweb1.domain.Presupuesto;

public class ElPresupuestoEsNulo extends RuntimeException {
    public ElPresupuestoEsNulo(){
        super("El presupuesto es nulo");
    }
}
