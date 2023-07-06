package ar.edu.unlam.tallerweb1.domain.Ahorro;

public class Ahorro {

    private String nombre;
    private Double montoAhorro;
    private Double montoDePresupuesto;


    public Ahorro() {
    }

    public Ahorro(String nombre, Double montoAhorro, Double montoDePresupuesto) {
        this.nombre = nombre;
        this.montoAhorro = montoAhorro;
        this.montoDePresupuesto = montoDePresupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMontoAhorro() {
        return montoAhorro;
    }

    public void setMontoAhorro(Double montoAhorro) {
        this.montoAhorro = montoAhorro;
    }

    public Double getMontoDePresupuesto() {
        return montoDePresupuesto;
    }

    public void setMontoDePresupuesto(Double montoDePresupuesto) {
        this.montoDePresupuesto = montoDePresupuesto;
    }
}
