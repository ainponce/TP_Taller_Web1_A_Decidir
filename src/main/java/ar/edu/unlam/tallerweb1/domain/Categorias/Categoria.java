package ar.edu.unlam.tallerweb1.domain.Categorias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean estaActiva;
    public Categoria(){}

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.estaActiva = true;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(Boolean estaActiva) {
        this.estaActiva = estaActiva;
    }


}
