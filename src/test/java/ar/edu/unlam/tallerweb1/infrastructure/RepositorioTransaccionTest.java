package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccionImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioTransaccionTest extends SpringTest {
    private Double monto = 1200.0;
    private String detalle = "Carga de nafta";

    @Autowired
    RepositorioTransaccion repositorio = new RepositorioTransaccionImpl();

    @Test
    @Transactional @Rollback
    public void queSePuedaGuardarUnaTransaccionYQueSePuedaBuscarPorDetalle(){
        dadoQueExisteTransaccion(monto, detalle);
        Transaccion transaccionBuscada = cuandoLoBuscoPorSuDetalle(monto, detalle);
        entoncesPuedoEncontrar(transaccionBuscada);
    }

    @Test
    @Transactional @Rollback
    public void buscarUnaTransaccionInexistenteYMeDevuelvaNull(){
        Transaccion t = dadoQueExisteTransaccion(monto, detalle);
        Transaccion t1 = dadoQueExisteTransaccion(111.0, "Carga");
        Transaccion transaccionBuscada = cuandoLoBuscoPorSuDetalle(monto,"Pago de servicios");
        entoncesNoExisteTransaccion(transaccionBuscada);
    }

    private void entoncesNoExisteTransaccion(Transaccion transaccionBuscada) {
        assertThat(transaccionBuscada).isNull();
    }

    private void entoncesPuedoEncontrar(Transaccion transaccionBuscada) {
        assertThat(transaccionBuscada).isNotNull();
        assertThat(transaccionBuscada.getDetalle()).isEqualTo("Carga de nafta");
    }

    private Transaccion cuandoLoBuscoPorSuDetalle(Double monto, String detalle) {
        return repositorio.buscarTransaccionPorDetalle(detalle);
    }

    private Transaccion dadoQueExisteTransaccion(Double monto, String detalle) {
        Transaccion t = new Transaccion(monto, detalle);
        t.setDetalle(detalle);
        t.setMonto(monto);
        repositorio.guardarTransaccion(t);

        return t;
    }


  

}
