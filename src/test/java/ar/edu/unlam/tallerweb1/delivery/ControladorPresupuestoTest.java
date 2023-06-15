
package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.Moneda.Moneda;
import ar.edu.unlam.tallerweb1.domain.Presupuesto.Presupuesto;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
public class ControladorPresupuestoTest {

    @Test
    public void queSeCreeUnPresupuestoConSusCorrectosAtributos(){
    Categoria categoriaDelPresupuesto = new Categoria("Compras", true);
    Presupuesto presupuesto = new Presupuesto(10000.50, "01/01/2023", "01/02/2023", categoriaDelPresupuesto);

        assertThat(presupuesto.getFechaDesde().equals("01/01/2023"));
        assertThat(presupuesto.getFechaHasta().equals("01/02/2023"));
        assertThat(presupuesto.getMontoPresupuesto()).isEqualTo(10000.50);
        assertThat(presupuesto.getCategoria()).isEqualTo(categoriaDelPresupuesto);
    }



}

