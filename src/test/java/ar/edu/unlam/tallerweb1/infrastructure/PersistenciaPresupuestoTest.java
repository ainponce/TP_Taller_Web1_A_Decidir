package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

public class PersistenciaPresupuestoTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardarUnaCategoria(){
        Presupuesto presupuesto = dadoQueExisteUnPresupuesto();
        Long id = cuandoGuardoUnaPresupuesto(presupuesto);
        entoncesLoPuedoBuscarPorSuID(id);
    }

    private void entoncesLoPuedoBuscarPorSuID(Long id) {
        Presupuesto presupuestoBuscado = session().get(Presupuesto.class, id);
        assertThat(presupuestoBuscado).isNotNull();
    }

    private Long cuandoGuardoUnaPresupuesto(Presupuesto presupuesto) {
        session().save(presupuesto);
        return presupuesto.getId();
    }

    private Presupuesto dadoQueExisteUnPresupuesto() {
        Presupuesto presupuesto = new Presupuesto();
        presupuesto.setId(1L);
        return presupuesto;
    }

}
