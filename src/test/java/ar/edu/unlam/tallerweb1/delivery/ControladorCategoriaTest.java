package ar.edu.unlam.tallerweb1.delivery;
import ar.edu.unlam.tallerweb1.domain.categorias.Categoria;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class ControladorCategoriaTest {


    @Test
    public void queSeCreeUnaCategoria(){
        Categoria categoria = new Categoria(1, "Comida");

        assertThat(categoria.getId()).isEqualTo(1);
        assertThat(categoria.getNombreCategoria().equals("Comida"));

    }
}
