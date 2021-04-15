package ar.edu.unlam.tallerweb1;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CajaFuerteTest {

    public static final int CODIGO_DE_APERTURA = 4561;

    @Test
    public void alCrearUnaCajaFuerteDeberiaEstarAbierta(){

        CajaFuerte caja = whenCreoUnaCajaFuerte();

        thenLaCajaFuerteEstaAbierta(caja);
    }

    @Test
    public void alCerrarDeberiaEstarCerrada(){
        CajaFuerte caja = givenExisteUnaCajaFuerte();

        whenCierroLaCajaFuerte(caja);

        thenLaCajaFuerteEstaCerrada(caja);
    }

    @Test
    public void alAbrirLaCajaFuerteConElCodigoDeCierreDeberiaEstarAbierta(){
        CajaFuerte caja = givenExisteUnaCajaFuerte();
        givenCierroLaCajaFuerte(caja, CODIGO_DE_APERTURA);

        whenAbroLaCajaFuerte(caja, CODIGO_DE_APERTURA);

        thenLaCajaFuerteEstaAbierta(caja);
    }

    @Test
    public void alAbrirLaCajaFuerteConUnCodigoErroneoNoDeberiaAbrirse(){
        CajaFuerte caja = givenExisteUnaCajaFuerte();
        givenCierroLaCajaFuerte(caja, CODIGO_DE_APERTURA);

        whenAbroLaCajaFuerte(caja, CODIGO_DE_APERTURA + 8);

        thenLaCajaFuerteEstaCerrada(caja);
    }

    private void whenAbroLaCajaFuerte(CajaFuerte caja, int codigoDeApertura) {
        caja.abrir(codigoDeApertura);
    }

    private void givenCierroLaCajaFuerte(CajaFuerte caja, int codigoDeApertura) {
        caja.cerrar(codigoDeApertura);
    }

    private void thenLaCajaFuerteEstaCerrada(CajaFuerte caja) {
        assertThat(caja.estaAbierta()).isFalse();
    }

    private void whenCierroLaCajaFuerte(CajaFuerte caja) {
        caja.cerrar();
    }

    private CajaFuerte givenExisteUnaCajaFuerte() {
        return new CajaFuerte();
    }

    private CajaFuerte whenCreoUnaCajaFuerte() {
        return new CajaFuerte();
    }

    private void thenLaCajaFuerteEstaAbierta(CajaFuerte caja) {
        assertThat(caja.estaAbierta()).isTrue();
    }
}
