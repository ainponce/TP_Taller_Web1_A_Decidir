package ar.edu.unlam.tallerweb1.domain.Deuda;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Persona.Persona;

public class Deuda {
private double montoDeLaDeuda;
    private Categoria categoriaDeLaDeuda;
    private String detalle;
    private String fecha;
    private boolean yoDebo;
    private Persona deudorOPrestamista;
    private Moneda moneda;

    public Deuda(double montoDeLaDeuda, Categoria categoriaDeLaDeuda, String detalle, String fecha, boolean yoDebo, Persona deudorOPrestamista, Moneda moneda) {
        this.montoDeLaDeuda = montoDeLaDeuda;
        this.categoriaDeLaDeuda = categoriaDeLaDeuda;
        this.detalle = detalle;
        this.fecha = fecha;
        this.yoDebo = yoDebo;
        this.deudorOPrestamista = deudorOPrestamista;
        this.moneda = moneda;
    }

    public double getMontoDeLaDeuda() {
        return montoDeLaDeuda;
    }

    public void setMontoDeLaDeuda(double montoDeLaDeuda) {
        this.montoDeLaDeuda = montoDeLaDeuda;
    }

    public Categoria getCategoriaDeLaDeuda() {
        return categoriaDeLaDeuda;
    }

    public void setCategoriaDeLaDeuda(Categoria categoriaDeLaDeuda) {
        this.categoriaDeLaDeuda = categoriaDeLaDeuda;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isYoDebo() {
        return yoDebo;
    }

    public void setYoDebo(boolean yoDebo) {
        this.yoDebo = yoDebo;
    }

    public Persona getDeudorOPrestamista() {
        return deudorOPrestamista;
    }

    public void setDeudorOPrestamista(Persona deudorOPrestamista) {
        this.deudorOPrestamista = deudorOPrestamista;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}
