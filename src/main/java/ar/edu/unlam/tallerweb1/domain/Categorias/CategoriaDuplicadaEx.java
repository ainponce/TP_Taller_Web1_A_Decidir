package ar.edu.unlam.tallerweb1.domain.Categorias;

public class CategoriaDuplicadaEx extends RuntimeException{
    public CategoriaDuplicadaEx(){
        super("Ya existe una categoria con ese nombre");
    }
}
