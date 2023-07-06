package ar.edu.unlam.tallerweb1.domain.Ahorro;

public class CalculoDeAhorro {

    private Ahorro ahorro;
    private double ahorroPorDia;

    private double ahorroPorSemana;


    public CalculoDeAhorro(Ahorro ahorro, double ahorroPorDia, double ahorroPorSemana) {
        this.ahorro = ahorro;
        this.ahorroPorDia = ahorroPorDia;
        this.ahorroPorSemana = ahorroPorSemana;



    }

    public Ahorro getAhorro() {
        return ahorro;
    }

    public void setAhorro(Ahorro ahorro) {
        this.ahorro = ahorro;
    }

    public double getAhorroPorDia() {
        return ahorroPorDia;
    }

    public void setAhorroPorDia(double ahorroPorDia) {
        this.ahorroPorDia = ahorroPorDia;
    }

    public double getAhorroPorSemana() {
        return ahorroPorSemana;
    }

    public void setAhorroPorSemana(double ahorroPorSemana) {
        this.ahorroPorSemana = ahorroPorSemana;
    }


}
