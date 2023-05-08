package ar.edu.unlam.tallerweb1.domain.categorias;

public class Categoria {

    private int id;
    private String nombreCategoria;
    private boolean estaActivo;

    public Categoria(int id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        this.estaActivo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}
