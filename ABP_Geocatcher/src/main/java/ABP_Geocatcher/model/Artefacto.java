package ABP_Geocatcher.model;

import jakarta.persistence.*;


@Entity
@Table(name = "artefacto")



public class Artefacto {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_ubicacion", nullable = false)
    private Ubicacion id_ubicacion;
    @Column
    private int estado;

    public Artefacto(int id, String nombre, String descripcion, Ubicacion id_ubicacion, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_ubicacion = id_ubicacion;
        this.estado = estado;
    }

    public Artefacto(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ubicacion getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Ubicacion id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Artefacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", id_ubicacion=" + id_ubicacion +
                ", estado=" + estado +
                '}';
    }




}
