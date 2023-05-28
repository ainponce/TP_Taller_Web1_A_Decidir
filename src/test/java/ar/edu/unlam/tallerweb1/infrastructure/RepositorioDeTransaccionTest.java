package ar.edu.unlam.tallerweb1.infrastructure;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccion;
import ar.edu.unlam.tallerweb1.domain.Transaccion.ServicioDeTransaccionImpl;
import ar.edu.unlam.tallerweb1.domain.Transaccion.Transaccion;
import ar.edu.unlam.tallerweb1.infrastructure.Transaccion.RepositorioTransaccion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class RepositorioDeTransaccionTest extends SpringTest {

    @Autowired
    private RepositorioTransaccion repo;
    
    @Autowired
    private ServicioDeTransaccion service;

    @Test
    public void queTraigaLaListaDeTransacciones() {
        List<Transaccion> trans = listoTransacciones();
        QueSeanLaMismaCantidad(trans);

    }

    private void QueSeanLaMismaCantidad(List<Transaccion> trans) {
        assertThat(trans.size()).isEqualTo(2);
    }

    private List<Transaccion> listoTransacciones() {

        return repo.buscarTransaccionPorDetalle("pago");
        // return  repo.listarTransaccion();
    }


}
