package ar.edu.unlam.tallerweb1.delivery;
import ar.edu.unlam.tallerweb1.domain.Deuda.Deuda;
import ar.edu.unlam.tallerweb1.domain.categorias.Categoria;
import ar.edu.unlam.tallerweb1.domain.usuarios.Persona;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
public class ControladorDeudaTest {

    @Test
    public void queSeCreeUnaDeuda(){
        Categoria categoriaDeLaDeuda = new Categoria(1, "Salidas");
        Persona prestamista = new Persona(123, "Shushu");
        Deuda deuda = new Deuda(1000.50, categoriaDeLaDeuda, "Entrada Shushu cine", "01/01/2023", true, prestamista, Moneda.Peso);

        assertThat(deuda.getMontoDeLaDeuda()).isEqualTo(1000.50);
        assertThat(deuda.getCategoriaDeLaDeuda()).isEqualTo(categoriaDeLaDeuda);
        assertThat(deuda.getDetalle()).isEqualTo("Entrada Shushu cine");
        assertThat(deuda.getFecha()).isEqualTo("01/01/2023");
        assertThat(deuda.getMoneda()).isEqualTo(Moneda.Peso);
        assertThat(deuda.isYoDebo()).isEqualTo(true);
        assertThat(deuda.getDeudorOPrestamista()).isEqualTo(prestamista);

    }


}
