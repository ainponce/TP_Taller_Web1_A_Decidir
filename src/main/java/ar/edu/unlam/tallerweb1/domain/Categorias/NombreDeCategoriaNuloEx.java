package ar.edu.unlam.tallerweb1.domain.Categorias;

public class NombreDeCategoriaNuloEx extends RuntimeException{

    public NombreDeCategoriaNuloEx(){
    super("La categoria debe tener un nombre para ser creada");
    }
}
