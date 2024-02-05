package com.app.web.entidad;

import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import javax.persistence.*;

@Entity
@Table(name="estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name="apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name="email", nullable = false, length = 50, unique = true)
    private String email;

//    @Column(name="create_time", nullable = false, length = 50, unique = true)
//    private String create_time;

    public Estudiante(){

    }

    public Estudiante( String nombre, String apellido, String email) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;

    }

    public Estudiante(Long id, String nombre, String apellido, String email) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void getCreate_time(String create_time){ this.create_time = create_time;}
//
//    public String getCreate_time() {
//        return create_time;
//    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
//                ", create_time='" + create_time + '\'' +
                '}';
    }
}
