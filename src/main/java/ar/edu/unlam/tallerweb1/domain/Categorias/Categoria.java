package ar.edu.unlam.tallerweb1.domain.Categorias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

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
    public void setId(Long id){this.id=id;}

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
