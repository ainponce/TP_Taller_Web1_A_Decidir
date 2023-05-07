package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import ar.edu.unlam.tallerweb1.domain.categorias.Categoria;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
public class ControladorPresupuestoTest {

    @Test
    public void queSeCreeUnPresupuesto(){
    Categoria categoriaDelPresupuesto = new Categoria(23, "Salidas");
        Presupuesto presupuesto = new Presupuesto("01/01/2023", "01/02/2023", 10000.50, Moneda.Peso, categoriaDelPresupuesto);

        assertThat(presupuesto.getFechaDesde().equals("01/01/2023"));
        assertThat(presupuesto.getFechaHasta().equals("01/02/2023"));
        assertThat(presupuesto.getMontoPresupuesto()).isEqualTo(10000.50);
        assertThat(presupuesto.getMoneda().equals(Moneda.Peso));
        assertThat(presupuesto.getCategoriaDelPresupuesto()).isEqualTo(categoriaDelPresupuesto);
    }
}
