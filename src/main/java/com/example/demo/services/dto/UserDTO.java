package com.example.demo.services.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */
public class UserDTO {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @Email
    @Size(min = 5, max = 100)
    private String email;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        return new EqualsBuilder()
                .append(nombre, userDTO.nombre)
                .append(apellidoPaterno, userDTO.apellidoPaterno)
                .append(apellidoMaterno, userDTO.apellidoMaterno)
                .append(email, userDTO.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(nombre)
                .append(apellidoPaterno)
                .append(apellidoMaterno)
                .append(email)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
