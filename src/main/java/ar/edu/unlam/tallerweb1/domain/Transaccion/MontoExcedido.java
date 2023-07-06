package ar.edu.unlam.tallerweb1.domain.Transaccion;

public class MontoExcedido extends RuntimeException {

    public MontoExcedido(){
        super("¡Error al ingresar la nueva transaccion!. El monto del presupuesto excedio el limite");
    }
}
