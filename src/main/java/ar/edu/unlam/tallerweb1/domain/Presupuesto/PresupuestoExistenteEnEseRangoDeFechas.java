package ar.edu.unlam.tallerweb1.domain.Presupuesto;

public class PresupuestoExistenteEnEseRangoDeFechas extends RuntimeException {
    public PresupuestoExistenteEnEseRangoDeFechas(){
        super("El presupuesto para esa categoria ya existe en ese rango de fechas");
    }

}
