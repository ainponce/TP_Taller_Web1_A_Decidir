package ar.edu.unlam.tallerweb1.domain.Transaccion;

public class NoExisteTransaccion  extends RuntimeException{

    public NoExisteTransaccion() { super("No existe el transaccion");
    }
}
