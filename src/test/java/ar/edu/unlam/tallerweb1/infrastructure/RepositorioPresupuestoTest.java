package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.RepositorioPresupuesto;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioPresupuestoTest extends SpringTest {

    private String fechaDesde="23/04/2023";
    private Moneda moneda= Moneda.Peso;

    @Autowired
    private RepositorioPresupuesto repositorio = new RepositorioPresupuestoImpl();

    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardarUnNuevoPresupuestoYQueSePuedaBuscarPorId(){
        Presupuesto presupuesto = dadoQueExisteUnPresupuesto(fechaDesde, moneda);
        Long id = cuandoGuardoUsuario(presupuesto);
        entoncesLoPuedoBuscar(id);
    }

    @Test
    @Transactional @Rollback
    public void buscarUnPresupuestoInexistenteYMeDevuelvaNull(){
        Presupuesto presupuesto = dadoQueExisteUnPresupuesto(fechaDesde, moneda);
        Long id = cuandoGuardoUsuario(presupuesto);
        Presupuesto presupuestoBuscado = buscarPresupuestoPorMoneda(Moneda.Dolar);
        entoncesNoPuedoEncontrar(presupuestoBuscado);
    }

    private void entoncesNoPuedoEncontrar(Presupuesto presupuestoBuscado) {
        assertThat(presupuestoBuscado).isNull();
    }

    private Presupuesto buscarPresupuestoPorMoneda(Moneda moneda) {
        return repositorio.buscarPresupuestoPorMoneda(moneda);
    }

    private void entoncesLoPuedoBuscar(Long id) {
        Presupuesto presupuestoBuscado = repositorio.buscarPresupuestoPorId(id);
        assertThat(presupuestoBuscado).isNotNull();
    }

    private Long cuandoGuardoUsuario(Presupuesto presupuesto) {
        repositorio.guardar(presupuesto);
        return presupuesto.getId();
    }

    public Presupuesto dadoQueExisteUnPresupuesto(String fechaDesde, Moneda moneda){
        Presupuesto presupuesto = new Presupuesto();
        presupuesto.setFechaDesde(fechaDesde);
        presupuesto.setMoneda(moneda);
        return presupuesto;
    }
}
