package ar.edu.unlam.tallerweb1.domain.Transaccion;

public class MontoMenorACero extends RuntimeException {
    public MontoMenorACero(){
        super("El monto debe ser mayor a cero");
    }
}
