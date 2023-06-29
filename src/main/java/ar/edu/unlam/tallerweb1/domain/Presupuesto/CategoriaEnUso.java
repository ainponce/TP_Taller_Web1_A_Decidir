package ar.edu.unlam.tallerweb1.domain.Presupuesto;

public class CategoriaEnUso extends RuntimeException {
    public CategoriaEnUso(){
        super("Categoria en uso");
    }
}
