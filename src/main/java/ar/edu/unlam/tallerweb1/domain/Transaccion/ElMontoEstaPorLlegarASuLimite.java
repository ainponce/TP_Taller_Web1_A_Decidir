package ar.edu.unlam.tallerweb1.domain.Transaccion;

public class ElMontoEstaPorLlegarASuLimite extends RuntimeException {
    public ElMontoEstaPorLlegarASuLimite(){
        super("El monto del presupuesto esta por llegar a su limite");
    }
}
