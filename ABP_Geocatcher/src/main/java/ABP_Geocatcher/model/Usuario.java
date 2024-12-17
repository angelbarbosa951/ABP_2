package ABP_Geocatcher.model;


import jakarta.persistence.*;

import java.sql.Blob;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String username;
    @Column
    private String pass;
    @Column
    private int rol;
    @Column
    private int estado;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private Blob foto_perfil;
    @Column
    private Date fecha_registro;
    @Column
    private String biografia;

    public Usuario(int id, String username, String pass, int rol, int estado, String nombre, String email,
                   Blob foto_perfil, Date fecha_registro, String biografia) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.rol = rol;
        this.estado = estado;
        this.nombre = nombre;
        this.email = email;
        this.foto_perfil = foto_perfil;
        this.fecha_registro = fecha_registro;
        this.biografia = biografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        rol = rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(Blob foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
