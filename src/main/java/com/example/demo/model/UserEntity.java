package com.example.demo.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */

@Entity
@Table(name = "user")
public class UserEntity implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Column(name="apellido_materno")
    private String apellidoMaterno;

    private String email;

    @Column(name="fecha_alta")
    private Date fechaAlta;

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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(nombre, that.nombre)
                .append(apellidoPaterno, that.apellidoPaterno)
                .append(apellidoMaterno, that.apellidoMaterno)
                .append(email, that.email)
                .append(fechaAlta, that.fechaAlta)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(nombre)
                .append(apellidoPaterno)
                .append(apellidoMaterno)
                .append(email)
                .append(fechaAlta)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", email='" + email + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
