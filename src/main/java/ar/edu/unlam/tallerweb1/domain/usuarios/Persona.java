package ar.edu.unlam.tallerweb1.domain.usuarios;
import javax.persistence.*;
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name="usuarioId")
    private Usuario usuarioAlQueLePertenece; //usuario que "crea" la persona


    public Persona(){};
    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
