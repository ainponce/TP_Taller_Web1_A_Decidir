package ar.edu.unlam.tallerweb1;

public class CajaFuerte {

    private Boolean estaAbierta;
    private int codigoCorrecto;

    public CajaFuerte() {
        estaAbierta = Boolean.TRUE;
    }

    public boolean estaAbierta() {
        return estaAbierta;
    }

    public void cerrar() {
        estaAbierta = Boolean.FALSE;
    }

    public void cerrar(int codigoDeApretura) {
        codigoCorrecto = codigoDeApretura;
        estaAbierta = Boolean.FALSE;
    }

    public void abrir(int codigoDeApretura){
        if(codigoDeApretura == codigoCorrecto)
            estaAbierta = Boolean.TRUE;
    }
}
